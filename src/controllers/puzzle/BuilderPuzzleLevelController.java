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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
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

public class BuilderPuzzleLevelController implements IController, ILevelController {

	/* Things we need */
	private MainController mainController;
	private IController back;
	private int levelNum;
	private Model model;
	private boolean bullpenBuilderModeIsEnabled;

	/* Things we create */
	private BuilderPuzzleLevelView builderPuzzleLevelView;
	private BullpenControler bullpenController;
	private BoardController boardController;
	private BlockController blockController;
	private JPanel renderPanel;

	/**
	 * Constructor for the class. mainController is for the rendering. back is
	 * the Controller that was the context before this one. model is the given
	 * model. levelNum is the current level number.
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
		this.bullpenBuilderModeIsEnabled = false;
		init();

	}

	/*
	 * Initializes the Controllers and the view.
	 */
	private void init() {
		builderPuzzleLevelView = new BuilderPuzzleLevelView(((PuzzleLevel) model.getLevel(levelNum)).getTotalMoves());
		blockController = new BlockController(new EmptyBlock(), this);
		bullpenController = new BullpenControler(model.getLevel(levelNum).getBullpen(), blockController);
		boardController = new BoardController(model.getLevel(levelNum), this);
	}

	/**
	 * This function adds the button listeners and renders the bullpen and board
	 * to the view.
	 * 
	 * @return panel
	 */
	@Override
	public JPanel getRenderedView() {
		renderPanel = builderPuzzleLevelView.render();

		// Back button
		builderPuzzleLevelView.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backButtonClicked();
			}
		});

		// Save button
		builderPuzzleLevelView.getSaveButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveButtonClicked();
			}
		});

		// Reset button
		builderPuzzleLevelView.getResetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButtonClicked();
			}

		});

		// Preview Button
		builderPuzzleLevelView.getPreviewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previewButtonClicked();
			}

		});

		// Hint button
		builderPuzzleLevelView.getHintButton().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					boardController.disableBuilderMode();
					boardController.enableHintSelection();
				} else {
					boardController.disableHintSelection();
					boardController.enableBuilderMode();
				}

			}
		});

		// Both the bullpen and the board needs to be at the 0th layer.

		// Warning!!!
		// bullpenController must be enabled for builder !BEFORE! the rendering.
		if (!bullpenBuilderModeIsEnabled) {
			bullpenController.enableBuilderMode();
			bullpenBuilderModeIsEnabled = true;
		}
		builderPuzzleLevelView.getLayeredPane().add(bullpenController.render(), new Integer(0), 0);
		bullpenController.disablePress();

		// Warning!!!
		// boardController must be enabled for builder !AFTER! the rendering.
		builderPuzzleLevelView.getLayeredPane().add(boardController.render(), new Integer(0), 0);
		boardController.enableBuilderMode();

		// return the renderPanel.
		return renderPanel;
	}
	/*
	 * Controller to save the state of the level builder level then preview that level in the Kabasuji game and then return to the Level Builder screen
	 */
	private void previewButtonClicked() {
		model.getLevel(levelNum).saveToFile("temp");
		Level tempLevel = null;
		try {
			// Load level from temporary file
			tempLevel = model.getLevel(levelNum).getFromFile("temp");
			// set the total moves
			((PuzzleLevel) tempLevel).setTotalMoves(builderPuzzleLevelView.getMovesLeft());
			// set the remaining moves which is total moves
			((PuzzleLevel) tempLevel).setRemaingMoves(builderPuzzleLevelView.getMovesLeft());
			// replace the piece list with the generated one
			tempLevel.getBullpen().replacePieceList(bullpenController.generatePieceList());
			tempLevel.setLevelNum(-1);
			tempLevel.setStars(0);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		ArrayList<Level> tempList = new ArrayList<Level>();
		for (int i = 0; i < 15; i++) {
			tempList.add(tempLevel);
		}
		Model tempModel = new Model("", null, tempList);
		PuzzleLevelController plc = new PuzzleLevelController(mainController, this, tempModel, 1);
		mainController.requestSwap(plc);
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
		((PuzzleLevel) lvl).setTotalMoves(builderPuzzleLevelView.getMovesLeft());

		// set the remaining moves which is total moves
		((PuzzleLevel) lvl).setRemaingMoves(builderPuzzleLevelView.getMovesLeft());

		// replace the piece list with the generated one
		lvl.getBullpen().replacePieceList(bullpenController.generatePieceList());
		lvl.setStars(0);

		// save to file
		lvl.saveToFile();

		// reload the model to update and reinitialize
		model.reload();
		init();

		// send the request to re-render
		bullpenBuilderModeIsEnabled = false;
		mainController.requestSwap(this);
	}

	private void resetButtonClicked() {
		// reset the level
		model.setLevel(levelNum, BaseLevelGenerator.makeBaseLevels().get(levelNum - 1));
		init();
		bullpenBuilderModeIsEnabled = false;
		// send the request to re-render
		mainController.requestSwap(this);
	}

	// Rest is not used...

	@Override
	public void piecePressed(JBlockPanel jBlockPanel) {
	}

	@Override
	public void pieceReleased(JBlockPanel jBlockPanel) {
	}
	
	@Override
	public void requestReRender() {
		mainController.requestSwap(this);
	}

}
