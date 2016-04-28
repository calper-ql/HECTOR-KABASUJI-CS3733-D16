/**    	Builder Puzzle Controller
 * 		
 * 		This Class controls and links the entities to boundaries.
 * 		
 * 		Specifically it uses BuilderPuzzleLevelView to display the builder.
 * 		It handles things like button presses.
 * 
 * 		@author Can Alper - calper@wpi.edu
 */

package controllers.puzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JPanel;
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
	
	/* Things we need */
	private MainController mainController;
	private IController back;
	private int levelNum;
	private Model model;
	
	/* Things we create */
	private BuilderPuzzleLevelView builderPuzzleLevelView;
	private BullpenControler bullpenController;
	private BoardController boardController;
	private BlockController blockController;
	private JPanel renderPanel;
	
	/**
	 * Constructor for the class.
	 * mainController is for the rendering.
	 * back is the Controller that was the context before this one.
	 * model is the given model.
	 * levelNum is the current level number.
	 * 
	 * @param mainController
	 * @param back
	 * @param model
	 * @param levelNum
	 */
	public BuilderPuzzleLevelController(MainController mainController, IController back, Model model, int levelNum) {
		this.mainController = mainController;
		this.back = back;
		this.levelNum = levelNum;
		this.model = model;
		init();
		
	}
	
	/* 
	 * Initializes the Controllers and the view.
	 */
	private void init(){
		builderPuzzleLevelView = new BuilderPuzzleLevelView(((PuzzleLevel)model.getLevel(levelNum)).getTotalMoves());
		blockController = new BlockController(new EmptyBlock(), this);
		bullpenController = new BullpenControler(model.getLevel(levelNum).getBullpen(), blockController);
		boardController = new BoardController(model.getLevel(levelNum).getBoard());
	}
	
	/**
	 * This function adds the button listeners and renders the bullpen and board to the view.
	 * 
	 * @return panel
	 */
	@Override
	public JPanel getRenderedView() {
		renderPanel = builderPuzzleLevelView.render();
		
		// Back button
		builderPuzzleLevelView.getBackButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				backButtonClicked();
			}	
		});
		
		// Save button
		builderPuzzleLevelView.getSaveButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				saveButtonClicked();
			}
		});
		
		// Reset button
		builderPuzzleLevelView.getResetButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				resetButtonClicked();
			}

		});
		
		// Both the bullpen and the board needs to be at the 0th layer.
		
		// Warning!!! 
		// bullpenController must be enabled for builder !BEFORE! the rendering.
		bullpenController.enableBuilderMode();
		builderPuzzleLevelView.getLayeredPane().add(bullpenController.render(), new Integer(0), 0);
		bullpenController.disablePress();
		
		// Warning!!! 
		// boardController must be enabled for builder !AFTER! the rendering.
		builderPuzzleLevelView.getLayeredPane().add(boardController.render(), new Integer(0), 0);
		boardController.enableBuilderMode();
		
		// return the renderPanel.
		return renderPanel;		
	}
	
	// Reload the model before backing up.
	private void backButtonClicked() {
		model.reload();
		// send the request to re-render to the higher controller
		mainController.requestSwap(back);
	}
	
	// Save to file
	private void saveButtonClicked() {
		// get level
		Level lvl = model.getLevel(levelNum);
		
		// set the total moves
		((PuzzleLevel)lvl).setTotalMoves(builderPuzzleLevelView.getMovesLeft());
		
		// set the remaining moves which is total moves
		((PuzzleLevel)lvl).setRemaingMoves(builderPuzzleLevelView.getMovesLeft());
		
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

	// Rest is not used...
	
	@Override
	public void piecePressed(JBlockPanel jBlockPanel) {}

	@Override
	public void pieceReleased(JBlockPanel jBlockPanel) {}

}
