package controllers.release;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Stack;

import javax.swing.JPanel;

import boundary.JBlockPanel;
import boundary.lightning.BuilderLightningLevelView;
import boundary.puzzle.BuilderPuzzleLevelView;
import boundary.release.BuilderReleaseLevelView;
import controllers.BlockController;
import controllers.BoardController;
import controllers.BuilderLevelSelectController;
import controllers.BullpenControler;
import controllers.IController;
import controllers.ILevelController;
import controllers.MainController;
import entities.EmptyBlock;
import entities.Level;
import entities.Model;
import entities.PuzzleLevel;

public class BuilderReleaseLevelController implements IController, ILevelController {

	/* Things we need */
	private MainController mainController;
	private IController back;
	private int levelNum;
	private Model model;
	private boolean bullpenBuilderModeIsEnabled;

	/* Things we create */
	private BuilderReleaseLevelView builderReleaseLevelView;
	private BullpenControler bullpenController;
	private BoardController boardController;
	private BlockController blockController;
	private JPanel renderPanel;

	/* for undo and redo */
	private Stack<Level> levelStates;
	private Stack<Level> redoStates;

	public BuilderReleaseLevelController(MainController mc, BuilderLevelSelectController back, Model model, int i) {
		this.back = back;
		this .levelNum = i;
		this.mainController = mc;
		this.model = model;
		bullpenBuilderModeIsEnabled = false;
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

	private void init(){
		builderReleaseLevelView = new BuilderReleaseLevelView(this);
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
		renderPanel = builderReleaseLevelView.render();

		// Back button
		builderReleaseLevelView.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backButtonClicked();
			}
		});

		// Save button
		builderReleaseLevelView.getSaveButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveButtonClicked();
			}
		});

		// Reset button
		builderReleaseLevelView.getResetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//resetButtonClicked();
			}

		});

		// Undo Button
		builderReleaseLevelView.getUndoButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				undoButtonClicked();
			}
		});

		// Undo Button
		builderReleaseLevelView.getRedoButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redoButtonClicked();
			}
		});

		// Preview Button
		builderReleaseLevelView.getPreviewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//previewButtonClicked();
			}

		});

		// Hint button
		builderReleaseLevelView.getHintButton().addItemListener(new ItemListener() {
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
		builderReleaseLevelView.getLayeredPane().add(bullpenController.render(), new Integer(0), 0);
		bullpenController.disablePress();

		// Warning!!!
		// boardController must be enabled for builder !AFTER! the rendering.
		builderReleaseLevelView.getLayeredPane().add(boardController.render(), new Integer(0), 0);
		boardController.enableBuilderMode();

		// return the renderPanel.
		return renderPanel;
	}

	protected void saveButtonClicked() {
		// get level
		Level lvl = model.getLevel(levelNum);

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

	// Reload the model before backing up.
	private void backButtonClicked() {
		model.reload();
		// send the request to re-render to the higher controller
		mainController.requestSwap(back);
	}

	@Override
	public void piecePressed(JBlockPanel jBlockPanel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pieceReleased(JBlockPanel jBlockPanel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestReRender() {
		mainController.requestSwap(this);
	}

	@Override
	public void stateUpdated(){
		this.redoStates = new Stack<>();
		try {
			// copy the level
			Level temp = model.getLevel(levelNum).generateLevelCopy();
			
			// replace the piece list with the generated one
			temp.getBullpen().replacePieceList(bullpenController.generatePieceList());
			levelStates.add(temp);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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

	@Override
	public void requestReRenderBack() {
		// TODO Auto-generated method stub
		
	}
}
