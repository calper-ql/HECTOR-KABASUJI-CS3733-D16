package entities;

import java.io.IOException;
import java.util.ArrayList;

import generators.AchievementGenerator;

public class Model implements Cloneable{
	String name;
	ArrayList<Level> levels;
	ArrayList<Achievement> achievements;
	
	public Model(String name, ArrayList<Achievement> achievements, ArrayList<Level> levels){
		
		this.name = name;
		this.achievements = achievements;
		this.levels  = levels;
	}
	
	public String getName(){
		return name;
	}
	
	public void unlockAchievements(){
		// If any puzzle levels have 1 2 or 3 stars unlock respective achievements
		for (int i = 1; i <= 5; i++){
			Level l = this.getLevel(i);
			if(l.getStars() >= 1){
				achievements.get(0).setisUnlocked();
			}
			if(l.getStars() >= 2){
				achievements.get(1).setisUnlocked();
			}
			if(l.getStars() >= 3){
				achievements.get(2).setisUnlocked();
			}
		}
		
		// If any lightning levels have 1 2 or 3 stars unlock respective achievements
		for (int i = 6; i <= 10; i++){
			Level l = this.getLevel(i);
			if(l.getStars() >= 1){
				achievements.get(3).setisUnlocked();
			}
			if(l.getStars() >= 2){
				achievements.get(4).setisUnlocked();
			}
			if(l.getStars() >= 3){
				achievements.get(5).setisUnlocked();
			}
		}
		
		// If any release levels have 1 2 or 3 stars unlock respective achievements
		for (int i = 11; i <= 15; i++){
			Level l = this.getLevel(i);
			if(l.getStars() >= 1){
				achievements.get(6).setisUnlocked();
			}
			if(l.getStars() >= 2){
				achievements.get(7).setisUnlocked();
			}
			if(l.getStars() >= 3){
				achievements.get(8).setisUnlocked();
			}
		}
		
		// If all 15 levels are unlocked unlock last achievement
		int j = 0;
		for (Level l : levels){
			if (l.isLocked() == false){
				j++;
			}
		}
		if (j == 15){
			achievements.get(9).setisUnlocked();
		}
	}
	
	public void reload(){
		Level level = new Level(true, 16 , null, null, true);
		ArrayList<Level> levels = new ArrayList<Level>();
		
		for(int i = 1; i < 16; i++){
			try {
				level = level.getFromFile(i);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			levels.add(level);
		}

		
		ArrayList<Achievement> achievementList = null;
		
		this.achievements = achievementList;
		this.levels = levels;
	}
	
	public Level getLevel(int num){
		return levels.get(num-1);
	}
	
	public void setLevel(int index, Level level){
		levels.set(index-1, level);
	}

	public void generateAchievements() {
		this.achievements = AchievementGenerator.makeAchievements();
	}

	public ArrayList<Achievement> getAchievements() {
		return this.achievements;
	}

}
