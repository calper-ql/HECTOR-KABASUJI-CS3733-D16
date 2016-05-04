package entities;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * The Class to define the attributes and state of the Release Level.
 * @author 
 *
 */
public class ReleaseLevel extends Level{
	ArrayList<ReleaseNumberSet> sets = new ArrayList<ReleaseNumberSet>(3);
	
	/**
	 * Release Level extends Level and super's the hints, level number, bull pen, board, and hints. It contains number sets unique to Release Level Types.
	 * @param isLocked Boolean that tells if the Level is locked.
	 * @param levelNum Integer that represents the 1-based index of the Level Number.
	 * @param bPen The Bull pen of the Level that holds all the Level Pieces.
	 * @param board The Board that holds all the tiles of the Level.
	 * @param hints The hints in a Level.
	 * @param sets The number sets that have been added to the Release Level.
	 */
	public ReleaseLevel(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints,
			ArrayList<ReleaseNumberSet> sets){
		super(isLocked, levelNum, bPen, board, hints);
		
		sets.add(new ReleaseNumberSet(0, new LinkedList<ReleaseNumber>()));
		sets.add(new ReleaseNumberSet(1, new LinkedList<ReleaseNumber>()));
		sets.add(new ReleaseNumberSet(2, new LinkedList<ReleaseNumber>()));
		this.sets = sets;
	}
	
	/**
	 * Resets the Stars earned in a Release Level.
	 */
	public void resetSets(){
		this.sets.get(0).resetSet();
		this.sets.get(1).resetSet();
		this.sets.get(2).resetSet();
	}
	
	/**
	 * Adds a Release Number to the correct Release Number set.
	 * @param num The release number to add to the set.
	 * @return Boolean stating if release number was added properly to Release Number Sets.
	 */
	public boolean addReleaseNumber(ReleaseNumber num){
		return sets.get(0).addNumber(num) 
				|| sets.get(1).addNumber(num) 
				|| sets.get(2).addNumber(num);
	}
	
	/**
	 * Removes the Release number specified from the ReleaseNumber sets.
	 * @param num The release number to remove from the release number sets.
	 * @return A boolean stating if the Release Number was properly removed from the Release Number Set.
	 */
	public boolean removeReleaseNumber(ReleaseNumber num){
		return sets.get(0).removeNumber(num)
				|| sets.get(1).removeNumber(num)
				|| sets.get(2).removeNumber(num);
	}
	
	/**
	 * Returns the total number of completed Release Number Sets. They are completed when the colored set contains the values 1-6.
	 * @return The number of completed Release Number Sets.
	 */
	public int getCompleteSets(){
		for(int row = 0; row < 12; row++){
			for(int col = 0; col < 12; col++){
				if(this.board.getTile(col, row).hasBlock()){
					addReleaseNumber(this.board.getTile(col, row).getReleaseNumber());
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < 3; i++){
			if(sets.get(i).isComplete()) result++;
		}
		return result;
	}
	
	/**
	 * Gets the number of Remaining Release Number Sets.
	 * @return The number of Remaining Release Number Sets.
	 */
	public int getRemainingSets(){
		int result = 0;
		for(int i = 0; i < 3; i++){
			if(!sets.get(i).isComplete()) result++;
		}
		return result;
	}
	
	/**
	 * Determines if a release level has finished. It is finished when there are 3 number sets collected.
	 */
	public boolean hasFinished(){
		//check finish condition
		int completeSets = this.getCompleteSets();
		if(completeSets == 3 || bPen.getSize() == 0) return true;
		else return false;
	}
	
	/**
	 * Updates the Stars based on how many release sets are collected. One set is one star, two sets is two stars, and three sets is three stars.
	 */
	public void updateStars(){
		int completeSets = this.getCompleteSets();
		if(completeSets == 0) setStars(0);
		if(completeSets == 1) setStars(1);
		if(completeSets == 2) setStars(2);
		if(completeSets == 3) setStars(3);
	}

	/**
	 * Get the number of remaining Moves for the release level. Will always return no moves left since there are no moves.
	 * @return 0
	 */
	public int getRemainingMoves() {
		return 0;
	}

	/**
	 * Sets the number of remaining moves. (Shouldn't be used for Release).
	 * @param i The number of remaining moves to set.
	 */
	public void setRemaingMoves(int i) {
		
	}
}
