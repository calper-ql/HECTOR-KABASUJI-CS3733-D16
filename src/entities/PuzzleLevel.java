package entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * Class that Defines the state of a Puzzle Level.
 * @author Can Alper - calper@wpi.edu
 *
 */
public class PuzzleLevel extends Level{
	int movesTotal;
	int movesRemaining;
	/**
	 * Puzzle Level extends Level and super's the hints, level number, bull pen, board, and hints. It contains a total moves unique to Puzzle Level Types.
	* @param isLocked Boolean that tells if the Level is locked.
	 * @param levelNum Integer that represents the 1-based index of the Level Number.
	 * @param bPen The Bull pen of the Level that holds all the Level Pieces.
	 * @param board The Board that holds all the tiles of the Level.
	 * @param hints The hints in a Level.
	 * @param movesTotal The total moves allowed on a Puzzle Level.
	 */
	public PuzzleLevel(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints,
			int movesTotal){
		super(isLocked, levelNum, bPen, board, hints);
		  
		this.movesTotal = movesTotal;
		this.movesRemaining = movesTotal;
		
		return;
	}
	
	/**
	 * Sets the total Moves allowed on that Puzzle Level.
	 * @param num The number of moves to allow.
	 */
	public void setTotalMoves(int num){
		movesTotal = num;
	}
	
	/**
	 * Gets the total number of moves allowed in a Puzzle Level.
	 * @return The number of allowed moves.
	 */
	public int getTotalMoves(){
		return movesTotal;
	}
	
	/**
	 * Gets how many moves a Game has remaining for Puzzle Level.
	 * @return The moves remaining.
	 */
	public int getRemainingMoves(){
		return movesRemaining;
	}
	
	/**
	 * Sets the remaining moves for a Puzzle Level.
	 * @param num The total moves to set for the Puzzle Level.
	 */
	public void setRemaingMoves(int num){
		movesRemaining = num;
	}
	
	/**
	 * Determines if a Puzzle level is done. Returns True if finished or False if not. A puzzle level is done when moves left is 0 or board tiles enabled and empty is 0.
	 */
	public boolean hasFinished(){
		// check finish condition
		int emptyTiles = this.getEmptyTileCount();
		if(movesRemaining <= 0 || emptyTiles <= 0){
			return true;
		} else return false;
	}
	
	/**
	 * Gives the correct number of stars based on how many uncovered enabled tiles there are.
	 */
	public void updateStars(){
		int emptyTiles = this.getEmptyTileCount();
	
		// now update the score
		if(emptyTiles == 0) setStars(3);
		if(emptyTiles <= 6) setStars(2);
		if(emptyTiles <= 12) setStars(1);
		if(emptyTiles > 12) setStars(0);		
	}	
}
