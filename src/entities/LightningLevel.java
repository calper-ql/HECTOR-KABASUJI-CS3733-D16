package entities;

import java.util.ArrayList;
/**
 * The Class to define the attributes and state of the Lightning Level.
 * @author Courtney Davis - cedavis@wpi.edu
 *
 */
public class LightningLevel extends Level{
	int totalTime;
	int timeRemaining;
	/**
	 * Lightning Level extends Level and super's the hints, level number, bull pen, board, and hints. It contains a total time unique to Lightning Level Types.
	 * @param isLocked Boolean that tells if the Level is locked.
	 * @param levelNum Integer that represents the 1-based index of the Level Number.
	 * @param bPen The Bull pen of the Level that holds all the Level Pieces.
	 * @param board The Board that holds all the tiles of the Level.
	 * @param hints The hints in a Level.
	 * @param totalTime The total Time remaining in a Lightning Level.
	 */
	public LightningLevel(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints,
			int totalTime){
		super(isLocked, levelNum, bPen, board, hints);
		
		this.totalTime = totalTime;
		this.timeRemaining = totalTime;
	}
	
	/**
	 * Get the total Time for a Lightning Level.
	 * @return The total time a Lightning Level has.
	 */
	public int getTotalTime(){
		return this.totalTime;
		
	}
	
	/**
	 * Method to change the total time a lightning level has.
	 * @param time The total time to set for a lightning level.
	 */
	public void setTotalTime(int time){
		this.totalTime = time;
	}
	
	/**
	 * Method that returns the time associated with a 
	 * @return 
	 */
	public int getTimeRemaining(){
		return timeRemaining;
	}
	
	/**
	 * Change the time remaining of a Lightning level.
	 * @param timeRemaining The time remaining to set in the Lightning Level.
	 */
	public void setTimeRemaining(int timeRemaining){
		this.timeRemaining = timeRemaining;
	}
	
	/**
	 * Returns a Boolean: True if lightning level is finished, False if it is not. Finished implies time remaining is 0 or enabled tiles remaining is 0.
	 */
	public boolean hasFinished(){
		// check finish condition
		int emptyTiles = this.getEmptyTileCount();
		if(timeRemaining <= 0 || emptyTiles <= 0){
			return true;
		} else return false;
	}
	
	/**
	 * Updates the number of stars based on how many Tiles that are enabled are left. 12 enabled tiles left is one star. 6 enabled tiles left is 2 stars. 0 enabled tiles left is 3 stars.
	 */
	public void updateStars(){
		int emptyTiles = this.getEmptyTileCount();
	  
		// now update the score
		if(emptyTiles > 12) setStars(0);
		if(emptyTiles <= 12) setStars(1);
		if(emptyTiles <= 6) setStars(2);
		if(emptyTiles == 0) setStars(3);
	}
}