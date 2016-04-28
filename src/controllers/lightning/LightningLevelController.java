package controllers.lightning;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import boundary.JBlockPanel;
import boundary.lightning.LightningLevelView;
import controllers.BlockController;
import controllers.BoardController;
import controllers.BullpenControler;
import controllers.IController;
import controllers.ILevelController;
import controllers.MainController;
import entities.EmptyBlock;
import entities.IBlock;
import entities.Model;
import entities.LightningLevel;
import entities.Tile;
import move.NonOverlayMove;

public class LightningLevelController implements IController, ILevelController{
	private LightningLevelView lv;
	private MainController mc;
	private IController back;
	private JButton backButton;
	private Model model;
	int level;
	
	LinkedList<JBlockPanel> blocks;
	BullpenControler bucont;
	BoardController bocont;
	BlockController blcont;
	JPanel p;
	LinkedList<JBlockPanel> currentList ;
	
	public LightningLevelController(MainController mc, IController back, Model model, int level) {
		this.mc = mc;
		this.back = back;
		lv = new LightningLevelView(model.getLevel(level));
		blcont = new BlockController(new EmptyBlock(), this);
		bucont = new BullpenControler(model.getLevel(level).getBullpen(), blcont);
		bocont = new BoardController(model.getLevel(level).getBoard());
		currentList = null;
		this.model = model;
		this.level = level;
	}
	

	@Override
	public JPanel getRenderedView() {
		Point loc = mc.getMouseLocation();
		
		p = lv.render();
		
		backButton = lv.getBackButton();
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				backButtonClicked();
			}	
		});
		
		lv.getLayeredPane().add(bocont.render(), new Integer(0), 0);
		lv.getLayeredPane().add(bucont.render(), new Integer(0), 0);

		return p;
		
	}
	
	private void backButtonClicked() {
		model.reload();
		mc.requestSwap(back);
	}

	public void piecePressed(JBlockPanel jBlockPanel) {
		LinkedList<JBlockPanel> list = bucont.pop(jBlockPanel);
		currentList = list;
		try{
			if(list.isEmpty()) return;
		}catch(Exception e){
			return;
		}
		for(JBlockPanel item: list){
			try{
				p.add(item,new Integer(1), 0);
			}catch(Exception e){
						
			}
		}
	}


	public void pieceReleased(JBlockPanel jBlockPanel) {
		JLayeredPane layers = lv.getLayeredPane();
		layers = new JLayeredPane();
		// Check for the board
		// do the move
		LinkedList<Tile> tl = new LinkedList<>();
		LinkedList<IBlock> bl= new LinkedList<>();
		
		for(JBlockPanel jbp: currentList){
			try{
				Tile temp = bocont.getTileAtPoint(new Point(16+jbp.getLocation().x, 16+jbp.getLocation().y));
				bl.add(jbp.getBlock());
				tl.add(temp);
			} catch (Exception e){
	
			}
		}		
		
		if(tl.size() != 6){
			mc.requestSwap(this);
			return;
		}
		
		if(new NonOverlayMove(bl, tl).doMove()){
			try {
				model.getLevel(level).getBullpen().removePiece(bl.getFirst().getPiece());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LightningLevel lvl = (LightningLevel) model.getLevel(level);
			lvl.setTimeRemaining(lvl.getTimeRemaining() - 1);
			
		}
		
		mc.requestSwap(this);
	}
}

