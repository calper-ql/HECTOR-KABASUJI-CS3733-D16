/**Board Controller
 * This controller class handles all push events and view updates for the board
 * @author Zach Armsby - zrarmsby@wpi.edu
 * @author Can Alper - calper@wpi.edu
 * @author Morgan Garbett - mlgarbett@wpi.edu
 * @author Courtney Davis - cedavis@wpi.edu
 */
package controllers;

import java.awt.Point;
import java.io.IOException;

import javax.swing.JPanel;

import boundary.BoardView;
import entities.Board;
import entities.Bullpen;
import entities.Level;
import entities.Model;
import entities.Piece;
import entities.PuzzleLevel;
import entities.Tile;
import java.util.ArrayList;

public class BoardController {

	JPanel p;
	BoardView bv;
	Level level;
	ILevelController levelController;
	Model model;
	
	/**
	 * Class constructor
	 * @param level
	 * @param levelController
	 * @param model
	 */
	public BoardController(Level level, ILevelController levelController, Model model) {
		bv = new BoardView(215, 100, 384, 384, level.getBoard(), this);
		this.level = level;
		this.levelController = levelController;
		this.model = model;
	}
	
	/**
	 * Returns the rendered board view
	 * @return
	 */
	public JPanel render() {
		
		return bv.render();
	}
	
	/**
	 * Returns the rendered view of a tile at a given point p
	 * @param p
	 * @return bv.getTileAtPoint(p)
	 */
	public Tile getTileAtPoint(Point p){
		return bv.getTileAtPoint(p);
	}
	
	/**
	 * Enables the builder mode for the board view associated with this board controller class
	 */
	public void enableBuilderMode(){
		bv.enableBuilderMode();
	}

	/**
	 * Disables the builder mode for the board view associated with this board controller class
	 */
	public void disableBuilderMode() {
		bv.disableBuilderMode();
		
	}

	/**
	 * Enables the moving of pieces form the board
	 */
	public void enableRemoveMode(){
		bv.enableRemoveMode();
	}

	/**
	 * Disables the moving of pieces form the board
	 */
	public void disableRemoveMode() {
		bv.disableRemoveMode();
	}

	/**
	 * Enables the hint selection for the board view associated with this board controller class
	 */
	public void enableHintSelection() {
		bv.enableHintSelection();
		
	}
	
	/**
	 * Disables the hint selection for the board view associated with this board controller class
	 */
	public void disableHintSelection() {
		bv.disableHintSelection();
		
	}

	/**
	 * Adds a piece to the bullpen and updates state
	 * @param piece
	 */
	public void addToBullpen(Piece piece) {
		level.getBullpen().addPiece(piece);
		if(level instanceof PuzzleLevel){
			((PuzzleLevel) level).setRemaingMoves(((PuzzleLevel) level).getRemainingMoves()-1);
			
			if(level.hasFinished()){
				System.out.println("finished");
				try {
					if(level.getLevelNum()>0){
						PuzzleLevel savelvl = (PuzzleLevel) level.getFromFile(level.getLevelNum());
						savelvl.setStars(level.getStars());
						savelvl.saveToFile();
					}
				} catch (ClassNotFoundException | IOException e) {}
				try {
					if(level.getStars() > 0 && level.getLevelNum()>0){
						Level next = level.getFromFile(level.getLevelNum()+1);
						next.unlock();
						next.saveToFile();
					}
				} catch (ClassNotFoundException | IOException e) {}
				model.reload();
			}
		}
		
		if (level.hasFinished()){
			levelController.requestReRenderBack();
		} else {
			levelController.requestReRender();
		}
	}
	
	/**
	 * Updates the state of the board
	 */
	public void stateUpdated(){
		levelController.stateUpdated();
	}

	/**
	 * Generates a list of Tiles (depricated)
	 */
	public ArrayList<ArrayList<Tile>> generateTileList() {
		return bv.generateTileList();
	}


}
