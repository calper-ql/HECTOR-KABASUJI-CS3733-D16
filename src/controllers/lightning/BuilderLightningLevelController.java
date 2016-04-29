package controllers.lightning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JPanel;

import boundary.JBlockPanel;
import boundary.lightning.BuilderLightningLevelView;
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
import entities.LightningLevel;
import generators.BaseLevelGenerator;

public class BuilderLightningLevelController implements IController, ILevelController{
	/* Things we need */
	private MainController mainController;
	private IController back;
	private int levelNum;
	private Model model;
	
	/* Things we create */
	private BuilderLightningLevelView builderLightningLevelView;
	private BullpenControler bullpenController;
	private BoardController boardController;
	private BlockController blockController;
	private JPanel renderPanel;
	
	public BuilderLightningLevelController(MainController mainController, IController back, Model model, int levelNum) {
		this.mainController = mainController;
		this.back = back;
		this.levelNum = levelNum;
		this.model = model;
		init();
		
	}
	
	private void init(){
		builderLightningLevelView = new BuilderLightningLevelView(((LightningLevel)model.getLevel(levelNum)).getTotalTime());
		blockController = new BlockController(new EmptyBlock(), this);
		bullpenController = new BullpenControler(model.getLevel(levelNum).getBullpen(), blockController);
		boardController = new BoardController(model.getLevel(levelNum).getBoard());
	}
	
	@Override
	public JPanel getRenderedView() {
renderPanel = builderLightningLevelView.render();
		
		// Back button
		builderLightningLevelView.getBackButton().addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			backButtonClicked();
			}	
		});
		
		// Save button
		builderLightningLevelView.getSaveButton().addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			saveButtonClicked();
			}
		});
		
		// Reset button
		builderLightningLevelView.getResetButton().addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			resetButtonClicked();
			}

		});
		
		// Both the bull-pen and the board needs to be at the 0th layer.
		
		// Warning!!! 
		// bullpenController must be enabled for builder !BEFORE! the rendering.
		bullpenController.enableBuilderMode();
		builderLightningLevelView.getLayeredPane().add(bullpenController.render(), new Integer(0), 0);
		bullpenController.disablePress();
		
		// Warning!!! 
		// boardController must be enabled for builder !AFTER! the rendering.
		builderLightningLevelView.getLayeredPane().add(boardController.render(), new Integer(0), 0);
		boardController.enableBuilderMode();
		
		// return the renderPanel.
		return renderPanel;		
	}
	
	private void backButtonClicked() {
		model.reload();
		// send the request to re-render to the higher controller
		mainController.requestSwap(back);
	}
	
	private void saveButtonClicked() {
		// get level
		Level lvl = model.getLevel(levelNum);
				
		// set the total time
		((LightningLevel)lvl).setTotalTime(builderLightningLevelView.getSecondsLeft() + builderLightningLevelView.getMinutesLeft()*60);
				
		// set the remaining moves which is total moves
		((LightningLevel)lvl).setTimeRemaining(((LightningLevel)lvl).getTotalTime());
		
		// replace the piece list with the generated one
		lvl.getBullpen().replacePieceList(bullpenController.generatePieceList());
				
		// save to file
		lvl.saveToFile();
				
		// reload the model to update and reinitialize
		model.reload();
		init();
				
		// send the request to re-render
		mainController.requestSwap(this);
	}	
	

	private void resetButtonClicked() {
		// reset the level
		model.setLevel(levelNum, BaseLevelGenerator.makeBaseLevels().get(levelNum-1));
		init();
		// send the request to re-render
		mainController.requestSwap(this);
	}

	@Override
	public void piecePressed(JBlockPanel jBlockPanel) {}

	@Override
	public void pieceReleased(JBlockPanel jBlockPanel) {}

}
