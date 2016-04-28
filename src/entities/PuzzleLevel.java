package entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PuzzleLevel extends Level{
	int movesTotal;
	int movesRemaining;
	
	public PuzzleLevel(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints,
			int movesTotal){
		super(hints, levelNum, bPen, board, hints);
		
		this.movesTotal = movesTotal;
		this.movesRemaining = movesTotal;
		
		return;
	}
	
	public void setTotalMoves(int num){
		movesTotal = num;
	}
	
	public int getTotalMoves(){
		return movesTotal;
	}
	
	public int getRemainingMoves(){
		return movesRemaining;
	}
	
	public void setRemaingMoves(int num){
		movesRemaining = num;
	}
	
	public boolean hasFinished(){
		// check finish condition
		int emptyTiles = this.getEmptyTileCount();
		if(movesRemaining == 0 || emptyTiles == 0){
			return true;
		} else return false;
	}
	
	public void updateStars(){
		int emptyTiles = this.getEmptyTileCount();
	
		// now update the score
		if(emptyTiles > 12) setStars(0);
		if(emptyTiles <= 12) setStars(1);
		if(emptyTiles <= 6) setStars(2);
		if(emptyTiles == 0) setStars(3);
	}
	
	public void updateAchievements(){
		ArrayList<Achievement> achievements = new ArrayList<Achievement>();
		if(this.getStars() == 1){
			achievements.get(0).setisUnlocked();
			achievements.get(0).saveAchievementToFile();
			}
		
		if(this.getStars() == 2){
			achievements.get(0).setisUnlocked();
			achievements.get(0).saveAchievementToFile();
			achievements.get(1).setisUnlocked();
			achievements.get(1).saveAchievementToFile();
		}
		
		if(this.getStars() == 3){
			achievements.get(0).setisUnlocked();
			achievements.get(0).saveAchievementToFile();
			achievements.get(1).setisUnlocked();
			achievements.get(1).saveAchievementToFile();
			achievements.get(2).setisUnlocked();
			achievements.get(2).saveAchievementToFile();			
		}
	
	}

}
