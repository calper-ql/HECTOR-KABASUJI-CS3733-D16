/**	Puzzle Level Controller
 * 	This Controller class is to control the gameplay of the Puzzle Level
 * 
 * 	@author Can Alper - calper@wpi.edu
 */

package controllers.puzzle;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
import entities.Achievement;
import entities.EmptyBlock;
import entities.IBlock;
import entities.Level;
import entities.Model;
import entities.PuzzleLevel;
import entities.Tile;
import move.NonOverlayMove;

public class PuzzleLevelController implements IController, ILevelController{
	private PuzzleLevelView puzzleLevelView;
	private MainController mainController;
	private IController back;
	private Model model;
	int levelNum;
	
	BullpenControler bullpenController;
	BoardController boardController;
	BlockController blockController;
	JPanel renderPanel;
	LinkedList<JBlockPanel> currentBlockPanelList;
	
	
	/**
	 * Constructor for class
	 * 
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
	public PuzzleLevelController(MainController mainController, IController back, Model model, int levelNum) {
		this.mainController = mainController;
		this.back = back;
		this.model = model;
		this.levelNum = levelNum;
		
		puzzleLevelView = new PuzzleLevelView(model.getLevel(levelNum));
		blockController = new BlockController(new EmptyBlock(), this); 
		bullpenController = new BullpenControler(model.getLevel(levelNum).getBullpen(), blockController, this);
		boardController = new BoardController(model.getLevel(levelNum), this, model);
		currentBlockPanelList = null;
		
	}
	
	/**
	 * This function adds the functionality to button and renders the views
	 * 
	 * @return panel
	 */
	@Override
	public JPanel getRenderedView() {
		// Render the main view
		renderPanel = puzzleLevelView.render();
		
		// Attach button
		puzzleLevelView.getBackButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				backButtonClicked();
			}	
		});
		
		// Render the components to the 0th layer
		puzzleLevelView.getLayeredPane().add(boardController.render(), new Integer(0), 0);
		puzzleLevelView.getLayeredPane().add(bullpenController.render(), new Integer(0), 0);
		boardController.enableRemoveMode();

		return renderPanel;
		
	}
	
	// Reload and swap to the higher controller
	private void backButtonClicked() {
		model.reload();
		mainController.requestSwap(back);
	}

	/**
	 * 	Receives the pressed block panel from the view and adds the list containing that panel 
	 *  from the bullpen to the layer 1 of this instance.
	 * 
	 * -----------------------------------
	 * -    LAYER 0 
	 * - 
	 * -   ------------------------------------
	 * -   -   
	 * -   -    LAYER 1
	 * -   -
	 * -   -
	 * -   -
	 *     -
	 *     -
	 *     -
	 * 
	 * @param jBlockPanel
	 */
	public void piecePressed(JBlockPanel jBlockPanel) {
		currentBlockPanelList = bullpenController.pop(jBlockPanel);
		
		//System.out.println(currentBlockPanelList);
		
		for(JBlockPanel item: currentBlockPanelList){
			try{
				renderPanel.add(item, new Integer(1), 0);
			}catch(Exception e){
				e.printStackTrace();	
			}
		}
	}


	/**
	 * Receives the released signal from the view on a JBlockPanel.
	 * Checks for the move and acts accordingly.
	 * 
	 *  @param jBlockPanel
	 */
	public void pieceReleased(JBlockPanel jBlockPanel) {
		// Lists for the move
		LinkedList<Tile> tl = new LinkedList<>();
		LinkedList<IBlock> bl= new LinkedList<>();
		
		
		// Populating the lists
		for(JBlockPanel jbp: currentBlockPanelList){
			try{
				// The tile underneath the JBlockPanel is found and added to the same index of the lists
				Tile temp = boardController.getTileAtPoint(new Point(16+jbp.getLocation().x, 16+jbp.getLocation().y));
				bl.add(jbp.getBlock());
				tl.add(temp);
			} catch (Exception e){
				// If the bounds are out of board we will receive an exception and it is handled here
				// The solution is to re-render without any moves whatsoever.
				mainController.requestSwap(this);
				return;
			}
		}		
		
		PuzzleLevel lvl = (PuzzleLevel) model.getLevel(levelNum);
		
		// If we get here we check for the validity of the move in doMove() and we act according to it
		if(new NonOverlayMove(bl, tl).doMove()){
			// If the processor gets here this means that the move was valid
			try {
				// We get the level and remove the piece from the bullpen
				// Can be different for other level types
				model.getLevel(levelNum).getBullpen().removePiece(bl.getFirst().getPiece());
				
			} catch (Exception e) {
				e.printStackTrace(); 
			}
			
			// Update the moves left
			
			lvl.setRemaingMoves(lvl.getRemainingMoves() - 1);
			lvl.updateStars();
			Level saveStars;
				try {
					saveStars = lvl.getFromFile(levelNum);
					saveStars.setStars(lvl.getStars());
					saveStars.saveToFile();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			ArrayList<Achievement> needToBeUnlocked = model.checkUnlockedAchievements();
			for (Achievement a: needToBeUnlocked){
				a.setisUnlocked();
				if(this.levelNum > 0) {
					a.saveAchievementToFile();
				}
			}
			if(lvl.hasFinished()){
				System.out.println("finished");
				try {
					if(lvl.getLevelNum()>0){
						Level savelvl = lvl.getFromFile(levelNum);
						savelvl.setStars(lvl.getStars());
						savelvl.saveToFile();
					}
				} catch (ClassNotFoundException | IOException e) {}
				try {
					if(lvl.getStars() > 0 && lvl.getLevelNum()>0){
						Level next = lvl.getFromFile(levelNum+1);
						next.unlock();
						next.saveToFile();
					}
				} catch (ClassNotFoundException | IOException e) {}
				
				model.reload();
				
			}
			
		}
		
		// finally we re-render
		if(!lvl.hasFinished())mainController.requestSwap(this);
		else mainController.requestSwap(back);
	}
	
	@Override
	public void requestReRender() {
		mainController.requestSwap(this);
	}

	@Override
	public void stateUpdated() {
		
	}

	@Override
	public void requestReRenderBack() {
		mainController.requestSwap(back);
	}
	
	public void setCurrentBlockPanelList(LinkedList<JBlockPanel> list){
		this.currentBlockPanelList = list;
	}
}
