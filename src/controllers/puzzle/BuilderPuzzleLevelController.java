package controllers.puzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import boundary.BuilderBaseLevelView;
import boundary.JBlockPanel;
import boundary.puzzle.BuilderPuzzleLevelView;
import controllers.BlockController;
import controllers.BoardController;
import controllers.BullpenControler;
import controllers.IController;
import controllers.ILevelController;
import controllers.MainController;
import entities.EmptyBlock;
import entities.Model;

public class BuilderPuzzleLevelController implements IController, ILevelController{
	private BuilderPuzzleLevelView blv;
	private MainController mc;
	private IController back;
	private JButton backButton;
	private int level;
	
	LinkedList<JBlockPanel> blocks;
	BullpenControler bucont;
	BoardController bocont;
	BlockController blcont;
	JPanel p;
	LinkedList<JBlockPanel> currentList;
	
	public BuilderPuzzleLevelController(MainController mc, IController back, Model model, int level) {
		// TODO Auto-generated constructor stub
		this.mc = mc;
		this.back = back;
		this.level = level;
		blv = new BuilderPuzzleLevelView();
		blcont = new BlockController(new EmptyBlock(), this);
		bucont = new BullpenControler(model.getLevel(0).getBullpen(), blcont);
		bocont = new BoardController(model.getLevel(0).getBoard());
		
		
	}
	
	@Override
	public JPanel getRenderedView() {
		p = blv.render();
		
		backButton = blv.getBackButton();
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				backButtonClicked();
			}	
		});
		
		blv.getLayeredPane().add(bocont.render(), new Integer(0), 0);
		blv.getLayeredPane().add(bucont.render(), new Integer(0), 0);
		bocont.enableBuilderMode();
		bucont.disablePress();
		
		return p;		
	}
	
	private void backButtonClicked() {
		// TODO Auto-generated method stub
		mc.requestSwap(back);
	}

	@Override
	public void piecePressed(JBlockPanel jBlockPanel) {
		
		
	}

	@Override
	public void pieceReleased(JBlockPanel jBlockPanel) {
		
		
	}
}
