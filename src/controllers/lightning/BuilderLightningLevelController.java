/**
 * This Controller class handles all push events and boundary refreshes for the Lightning Level Builder
 * @author Morgan Garbett - mlgarbett@wpi.edu
 * @author Can Alper - calper@wpi.edu
 * @author Zach Armsby - zrarmsby@wpi.edu
 * @author Courtney Davis - cedavis@wpi.edu
 */

package controllers.lightning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

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
import controllers.puzzle.PuzzleLevelController;
import entities.EmptyBlock;
import entities.Level;
import entities.Model;
import entities.PuzzleLevel;
import entities.LightningLevel;
import generators.BaseLevelGenerator;

public class BuilderLightningLevelController implements IController, ILevelController {
	/* Things we need */
	private MainController mainController;
	private IController back;
	private int levelNum;
	private Model model;
	private boolean bullpenBuilderModeIsEnabled;

	/* Things we create */
	private BuilderLightningLevelView builderLightningLevelView;
	private BullpenControler bullpenController;
	private BoardController boardController;
	private BlockController blockController;
	private JPanel renderPanel;

	/* for undo and redo */
	private Stack<Level> levelStates;
	private Stack<Level> redoStates;
	
	/**
	 * 
	 * @param mainController
	 * @param back
	 * @param model
	 * @param levelNum
	 */
	public BuilderLightningLevelController(MainController mainController, IController back, Model model, int levelNum) {
		this.mainController = mainController;
		this.back = back;
		this.levelNum = levelNum;
		this.model = model;
		this.bullpenBuilderModeIsEnabled = false;
		this.levelStates = new Stack<>();
		this.redoStates = new Stack<>();
		Level temp = null;
		try {
			temp = model.getLevel(levelNum).generateLevelCopy();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		levelStates.add(temp);
		init();

	}

	/**
	 * Update the state of the game
	 */
	public void stateUpdated(){
		this.redoStates = new Stack<>();
		try {
			// copy the level
			Level temp = model.getLevel(levelNum).generateLevelCopy();
			
			// set the total time
			((LightningLevel) temp).setTotalTime(
					builderLightningLevelView.getSecondsLeft() + builderLightningLevelView.getMinutesLeft() * 60);

			// set the remaining time which is total time
			((LightningLevel) temp).setTimeRemaining(((LightningLevel) temp).getTotalTime());


			// replace the piece list with the generated one
			temp.getBullpen().replacePieceList(bullpenController.generatePieceList());
			
			levelStates.add(temp);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initializes the Controllers and the view.
	 */
	private void init() {
		builderLightningLevelView = new BuilderLightningLevelView(((LightningLevel) model.getLevel(levelNum)).getTotalTime());
		blockController = new BlockController(new EmptyBlock(), this);
		bullpenController = new BullpenControler(model.getLevel(levelNum).getBullpen(), blockController, this);
		boardController = new BoardController(model.getLevel(levelNum), this, model);
	}

	/**
	 * This function adds the button listeners and renders the bullpen and board
	 * to the view.
	 * 
	 * @return panel
	 */
	@Override
	public JPanel getRenderedView() {
		renderPanel = builderLightningLevelView.render();

		// Back button
		builderLightningLevelView.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backButtonClicked();
			} 
		});

		// Save button
		builderLightningLevelView.getSaveButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveButtonClicked();
			}
		});

		// Reset button
		builderLightningLevelView.getResetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButtonClicked();
			}
		});

			
		// Undo Button
		builderLightningLevelView.getUndoButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				undoButtonClicked();
				}
		});
		
		// Redo Button
		builderLightningLevelView.getRedoButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redoButtonClicked();
			}
			});
				
		// Preview Button
		builderLightningLevelView.getPreviewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previewButtonClicked();
			}

		});

		// Hint button
		builderLightningLevelView.getHintButton().addItemListener(new ItemListener() {

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
		// Both the bull-pen and the board needs to be at the 0th layer.

		// Warning!!!
		// bullpenController must be enabled for builder !BEFORE! the rendering.
		if (!bullpenBuilderModeIsEnabled) {
			bullpenController.enableBuilderMode();
			bullpenBuilderModeIsEnabled = true;
		}
		builderLightningLevelView.getLayeredPane().add(bullpenController.render(), new Integer(0), 0);
		bullpenController.disablePress();

		// Warning!!!
		// boardController must be enabled for builder !AFTER! the rendering.
		builderLightningLevelView.getLayeredPane().add(boardController.render(), new Integer(0), 0);
		boardController.enableBuilderMode();

		// return the renderPanel.
		return renderPanel;
	}
	

	/**
	 * Controller to save the state of the level builder level then preview that
	 * level in the Kabasuji game and then return to the Level Builder screen
	 */
	private void previewButtonClicked() {
		model.getLevel(levelNum).saveToFile("temp");
		Level tempLevel = null;
		try {
			// Load level from temporary file
			tempLevel = model.getLevel(levelNum).getFromFile("temp");

			// set the total time
			((LightningLevel) tempLevel).setTotalTime(
					builderLightningLevelView.getSecondsLeft() + builderLightningLevelView.getMinutesLeft() * 60);

			// set the remaining moves which is total moves
			((LightningLevel) tempLevel).setTimeRemaining(((LightningLevel) tempLevel).getTotalTime());

			// replace the piece list with the generated one
			tempLevel.getBullpen().replacePieceList(bullpenController.generatePieceList());
			tempLevel.resetLevel();
			tempLevel.setLevelNum(-1);
			tempLevel.saveToFile();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		ArrayList<Level> tempList = new ArrayList<Level>();
		for (int i = 0; i < 15; i++) {
			tempList.add(tempLevel);
		}
		Model tempModel = new Model("", null, tempList);
		tempModel.setPreviewLevel(tempLevel);
		LightningLevelController plc = new LightningLevelController(mainController, this, tempModel, -1);
		mainController.requestSwap(plc);
	}
	
	/**
	 * Handles the back button being pressed and swaps the views
	 */
	private void backButtonClicked() {
		model.reload();
		// send the request to re-render to the higher controller
		mainController.requestSwap(back);
	}
	
	/**
	 * Handle save button click and save the level to a file
	 */
	private void saveButtonClicked() {
		// get level
		Level lvl = model.getLevel(levelNum);

		// set the total time
		((LightningLevel) lvl).setTotalTime(
				builderLightningLevelView.getSecondsLeft() + builderLightningLevelView.getMinutesLeft() * 60);

		// set the remaining time which is total time
		((LightningLevel) lvl).setTimeRemaining(((LightningLevel) lvl).getTotalTime());

		// replace the piece list with the generated one
		lvl.getBullpen().replacePieceList(bullpenController.generatePieceList());
		lvl.resetLevel();
		
		// save to file
		lvl.saveToFile();

		// reload the model to update and reinitialize
		model.reload();
		init();

		// send the request to re-render
		bullpenBuilderModeIsEnabled = false;
		mainController.requestSwap(this);
	}
	
	/**
	 * Handle the reset button click and swap the views
	 */
	private void resetButtonClicked() {
		// reset the level
		model.setLevel(levelNum, BaseLevelGenerator.makeBaseLevels().get(levelNum - 1));
		init();
		bullpenBuilderModeIsEnabled = false;
		// send the request to re-render
		mainController.requestSwap(this);
	}

	@Override
	public void piecePressed(JBlockPanel jBlockPanel) {
	}

	@Override
	public void pieceReleased(JBlockPanel jBlockPanel) {
	}

	/**
	 * Swap to the current view
	 */
	@Override
	public void requestReRender() {
		mainController.requestSwap(this);
	}
	
	/**
	 * Handle the undo button click and do undo 
	 */
	private void undoButtonClicked() {
		if(levelStates.size() > 1){
			redoStates.add(levelStates.pop());
		}
		
		Level lvl = null;
		try {
			lvl = levelStates.peek().generateLevelCopy();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		model.setLevel(levelNum, lvl);
		init();
		bullpenBuilderModeIsEnabled = false;
		this.requestReRender();
	}
	
	/**
	 * Handle the redo button click and do redo 
	 */
	private void redoButtonClicked() {
		if(!redoStates.isEmpty()){
			levelStates.add(redoStates.pop());
			Level lvl = null;
			try {
				lvl = levelStates.peek().generateLevelCopy();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			
			model.setLevel(levelNum, lvl);
			init();
			bullpenBuilderModeIsEnabled = false;
			this.requestReRender();
		}
	}
	
	/**
	 * Swap to previois view
	 */
	@Override
	public void requestReRenderBack() {
		mainController.requestSwap(back);
	}

}
