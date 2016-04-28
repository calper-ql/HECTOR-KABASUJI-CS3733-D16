package entities;

import java.util.ArrayList;

public class LightningLevel extends Level{
	int totalTime;
	int timeRemaining;
	
	public LightningLevel(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints,
			int totalTime){
		super(hints, levelNum, bPen, board, hints);
		
		this.totalTime = totalTime;
		this.timeRemaining = totalTime;
	}
	
	public int getTotalTime(){
		return this.totalTime;
		
	}
	
	public void setTotalTime(int time){
		this.totalTime = time;
	}
	
	public int getTimeRemaining(){
		return timeRemaining;
	}
	
	public void setTimeRemaining(int timeRemaining){
		this.timeRemaining = timeRemaining;
	}
	public boolean hasFinished(){
		// check finish condition
		int emptyTiles = this.getEmptyTileCount();
		if(timeRemaining == 0 || emptyTiles == 0){
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
			achievements.get(3).setisUnlocked();
			achievements.get(3).saveAchievementToFile();
		}
		
		if(this.getStars() == 2){
			achievements.get(3).setisUnlocked();
			achievements.get(3).saveAchievementToFile();
			achievements.get(4).setisUnlocked();
			achievements.get(4).saveAchievementToFile();
		}
		
		if(this.getStars() == 3){
			achievements.get(3).setisUnlocked();
			achievements.get(3).saveAchievementToFile();
			achievements.get(4).setisUnlocked();
			achievements.get(4).saveAchievementToFile();
			achievements.get(5).setisUnlocked();
			achievements.get(5).saveAchievementToFile();			
		}
	
	}
}