package controllers.puzzle;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import boundary.JBlockPanel;
import boundary.puzzle.PuzzleLevelView;
import controllers.BlockController;
import controllers.BoardController;
import controllers.BullpenControler;
import controllers.IController;
import controllers.ILevelController;
import controllers.MainController;
import boundary.BaseLevelView;

import entities.Board;
import entities.Bullpen;
import entities.EmptyBlock;
import entities.IBlock;
import entities.Level;
import entities.Model;
import entities.Piece;
import entities.PuzzleLevel;
import entities.Tile;
import move.NonOverlayMove;
import entities.Block;
import entities.EmptyBlock;
import entities.Piece;

public class PuzzleLevelController implements IController, ILevelController{
	private PuzzleLevelView lv;
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
	
	public PuzzleLevelController(MainController mc, IController back, Model model, int level) {
		this.mc = mc;
		this.back = back;
		lv = new PuzzleLevelView(model.getLevel(level));
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
			PuzzleLevel lvl = (PuzzleLevel) model.getLevel(level);
			lvl.setRemaingMoves(lvl.getRemainingMoves() - 1);
			
		}
		
		mc.requestSwap(this);
	}
}
