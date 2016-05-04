/**Lightning Level Controller
 * This Controller Class is responsible for the push events and 
 * boundary refreshes for components specific to the Lightning Level
 * @author Morgan Garbett - mlgarbett@wpi.edu
 * @author Can Alper - calper@wpi.edu
 * @author Zach Armsby - zrarmsby@wpi.edu
 * @author Courtney Davis - cedavis@wpi.edu
 */
package controllers.lightning;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

import boundary.JBlockPanel;
import boundary.lightning.LightningLevelView;
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
import entities.LightningLevel;
import entities.Tile;
import move.NonOverlayMove;
import move.OverlayMove;

public class LightningLevelController implements IController, ILevelController, Runnable{
	private LightningLevelView lightningLevelView;
	private MainController mainController;
	private IController back;
	private Model model;
	int levelNum;
	
	BullpenControler bullpenController;
	BoardController boardController;
	BlockController blockController;
	JPanel renderPanel;
	LinkedList<JBlockPanel> currentBlockPanelList;
	Thread counter;
	boolean shouldStop;
	
	/**
	 * Class Constructor
	 * @param mainController
	 * @param back
	 * @param model
	 * @param levelNum
	 */
	public LightningLevelController(MainController mainController, IController back, Model model, int levelNum) {
		this.mainController = mainController;
		this.back = back;
		this.model = model;
		this.levelNum = levelNum;
		
		lightningLevelView = new LightningLevelView(model.getLevel(levelNum));
		blockController = new BlockController(new EmptyBlock(), this);
		bullpenController = new BullpenControler(model.getLevel(levelNum).getBullpen(), blockController, this);
		boardController = new BoardController(model.getLevel(levelNum), this, model);
		currentBlockPanelList = null;
		counter = new Thread(this);
		counter.start();
		shouldStop = false;
		
	}
	

	/**
	 * Render the view for the lightning level
	 */
	@Override
	public JPanel getRenderedView() {
		// Render the main view
		renderPanel = lightningLevelView.render();
		
		//Attach button  
		lightningLevelView.getBackButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				backButtonClicked();
			}	
		});
		
		// Render the components to the 0th layer
		lightningLevelView.getLayeredPane().add(boardController.render(), new Integer(0), 0);
		lightningLevelView.getLayeredPane().add(bullpenController.render(), new Integer(0), 0);
		
		return renderPanel;
		
	}
		
	/**
	 * Handle the back button click and swap the view for the previous view
	 */
	private void backButtonClicked() {
		model.reload();
		shouldStop = true;
		mainController.requestSwap(back);
	}

	/**
	 * Handle the piece press and remove the piece from the bullpen
	 */
	public void piecePressed(JBlockPanel jBlockPanel) {
		currentBlockPanelList = bullpenController.pop(jBlockPanel);
		
		for(JBlockPanel item: currentBlockPanelList){
			try{
				renderPanel.add(item, new Integer(1), 0);
			}catch(Exception e){
				e.printStackTrace();	
			}
		}
	}

	/**
	 * Handle the piece release and add the piece to the board and update the state
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
				
		// If we get here we check for the validity of the move in doMove() and we act according to it
		if(new OverlayMove(bl, tl).doMove()){
		// If the processor gets here this means that the move was valid
			try {  
				// We get the level and remove the piece from the bullpen
				// Can be different for other level types
				model.getLevel(levelNum).getBullpen().removePiece(bl.getFirst().getPiece());
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		// Update the model left
		Level lvl = model.getLevel(levelNum);
		((LightningLevel)lvl).updateStars();
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
		// finally we re-render
		if(!lvl.hasFinished())mainController.requestSwap(this);
		else {
			shouldStop = true;
			mainController.requestSwap(back);
		}
	}

	/**
	 * Run the lightning level 
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			Level lvlt = model.getLevel(levelNum);
			((LightningLevel)(lvlt)).setTimeRemaining(((LightningLevel)lvlt).getTimeRemaining()-1);
			lightningLevelView.updateTimer();
			
			
			if(((LightningLevel)lvlt).getTimeRemaining() <= 0){
				// Update the model left
				Level lvl = model.getLevel(levelNum);
				((LightningLevel)lvl).updateStars();
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
					a.saveAchievementToFile();
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
				// finally we re-render
				if(!lvl.hasFinished())mainController.requestSwap(this);
				else {
					shouldStop = true;
					mainController.requestSwap(back);
				}
				
				
			}
			
			counter = new Thread(this);
			if(!this.shouldStop)counter.start();
		} catch (Exception e) {
		
		}
		
	}
	
	/**
	 * render the lightning view and swap in the view
	 */
	@Override
	public void requestReRender() {
		mainController.requestSwap(this);
	}

	
	/**
	 * update the state of the game 
	 */
	@Override
	public void stateUpdated() {
		
	}

	/**
	 * swap in the previous view  
	 */
	@Override
	public void requestReRenderBack() {
		shouldStop = true;
		mainController.requestSwap(back);
	}
	
	/**
	 * Set current block panel list
	 * @param list
	 */
	public void setCurrentBlockPanelList(LinkedList<JBlockPanel> list){
		this.currentBlockPanelList = list;
	}
}

