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
import entities.Level;
import entities.Model;
import entities.PuzzleLevel;
import generators.BaseLevelGenerator;

public class BuilderPuzzleLevelController implements IController, ILevelController{
	private BuilderPuzzleLevelView blv;
	private MainController mc;
	private IController back;
	private int level;
	Model model;
	
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
		this.model = model;
		init();
		
	}
	
	private void init(){
		blv = new BuilderPuzzleLevelView(((PuzzleLevel)model.getLevel(level)).getTotalMoves());
		blcont = new BlockController(new EmptyBlock(), this);
		bucont = new BullpenControler(model.getLevel(level).getBullpen(), blcont);
		bocont = new BoardController(model.getLevel(level).getBoard());
	}
	
	@Override
	public JPanel getRenderedView() {
		p = blv.render();
		
		blv.getBackButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				backButtonClicked();
			}	
		});
		
		blv.getSaveButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				saveButtonClicked();
			}
		});
		
		blv.getResetButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				resetButtonClicked();
			}

		});
		
		bucont.enableBuilderMode();
		blv.getLayeredPane().add(bocont.render(), new Integer(0), 0);
		blv.getLayeredPane().add(bucont.render(), new Integer(0), 0);
		bocont.enableBuilderMode();
		bucont.disablePress();
		
		
		return p;		
	}
	
	private void backButtonClicked() {
		model.reload();
		mc.requestSwap(back);
	}
	
	private void saveButtonClicked() {
		Level lvl = model.getLevel(level);
		((PuzzleLevel)lvl).setTotalMoves(blv.getMoves());
		lvl.getBullpen().replacePieceList(bucont.generatePieceList());
		lvl.saveToFile();
		model.reload();
		init();
		mc.requestSwap(this);
	}	
	

	private void resetButtonClicked() {
		model.setLevel(level, BaseLevelGenerator.makeBaseLevels().get(level-1));
		init();
		mc.requestSwap(this);
	}

	@Override
	public void piecePressed(JBlockPanel jBlockPanel) {
		
		
	}

	@Override
	public void pieceReleased(JBlockPanel jBlockPanel) {
		
		
	}

}
