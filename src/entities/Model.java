package entities;

import java.io.File;
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
	
	
	public void reload(){
		Level level = new Level(true, 16 , null, null, true);
		ArrayList<Level> levels = new ArrayList<Level>();
		
		for(int i = 1; i < 16; i++){
			try {
				level = level.getFromFile(i);
			} catch (ClassNotFoundException | IOException e) {
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

	public ArrayList<Achievement> getAchievements() {
		achievements = AchievementGenerator.makeAchievements(); 
		return achievements;
	}
	
	public void saveAchievement (String achievementName){
		for (int i = 0; i <= 9; i++){
			if(this.achievements.get(i).getName() == achievementName){
				this.achievements.get(i).saveAchievementToFile(); 
			}
			}
	}

	public boolean checkAchievementExists(String name){
		File dir = new File("achievements");
		if(!dir.exists()){
			return false;
		}
		
		File save = new File(dir, "achievement " + name);
		if(!save.exists()){
			return false;
		}
		
		return true;
	}
	public ArrayList<Achievement> getUnlockedAchievements(){
		ArrayList<Achievement> unlocked = new ArrayList<Achievement>();
		if(this.checkAchievementExists("Earned One Star In Puzzle!")){
			Achievement a = AchievementGenerator.makeAchievements().get(0);
			unlocked.add(a);
		}
		if(this.checkAchievementExists("Earned Two Stars In Puzzle!")){
			Achievement a = AchievementGenerator.makeAchievements().get(1);
			unlocked.add(a);
		}
		if(this.checkAchievementExists("Earned Three Stars In Puzzle!")){
			Achievement a = AchievementGenerator.makeAchievements().get(2);
			unlocked.add(a);
		}
		if(this.checkAchievementExists("Earned One Star In Lightning!")){
			Achievement a = AchievementGenerator.makeAchievements().get(3);
			unlocked.add(a);
		}
		if(this.checkAchievementExists("Earned Two Stars In Lightning!")){
			Achievement a = AchievementGenerator.makeAchievements().get(4);
			unlocked.add(a);
		}
		if(this.checkAchievementExists("Earned Three Stars In Lightning!")){
			Achievement a = AchievementGenerator.makeAchievements().get(5);
			unlocked.add(a);
		}
		if(this.checkAchievementExists("Earned One Star In Release!")){
			Achievement a = AchievementGenerator.makeAchievements().get(6);
			unlocked.add(a);
		}
		if(this.checkAchievementExists("Earned Two Star In Release!")){
			Achievement a = AchievementGenerator.makeAchievements().get(7);
			unlocked.add(a);
		}
		if(this.checkAchievementExists("Earned Three Star In Release!")){
			Achievement a = AchievementGenerator.makeAchievements().get(8);
			unlocked.add(a);
		} 
		if(this.checkAchievementExists("Unlocked 15 Levels!")){
			Achievement a = AchievementGenerator.makeAchievements().get(9);
			unlocked.add(a);
		}
		return unlocked;
	}
	
	public ArrayList<Achievement> checkUnlockedAchievements(){
		ArrayList<Achievement> needToBeUnlocked = new ArrayList<Achievement>();
			if(!this.checkAchievementExists("Earned One Star In Puzzle!")){
				for(int i = 0; i <= 4; i++){
					if(levels.get(i).getStars() >= 1){
						Achievement a = AchievementGenerator.makeAchievements().get(0);
						needToBeUnlocked.add(a);
					}
				}
			} 
			if(!this.checkAchievementExists("Earned Two Stars In Puzzle!")){
				for(int i = 0; i <= 4; i++){
					if(levels.get(i).getStars() >= 2){
						Achievement a = AchievementGenerator.makeAchievements().get(1);
						needToBeUnlocked.add(a);
					}
				}
			}
			if(!this.checkAchievementExists("Earned Three Stars In Puzzle!")){
				for(int i = 0; i <= 4; i++){
					if(levels.get(i).getStars() >= 3){
						Achievement a = AchievementGenerator.makeAchievements().get(2);
						needToBeUnlocked.add(a);
					}
				}
			}
			if(!this.checkAchievementExists("Earned One Star In Lightning!")){
				for(int i = 5; i <= 9; i++){
					if(levels.get(i).getStars() >= 1){
						Achievement a = AchievementGenerator.makeAchievements().get(3);
						needToBeUnlocked.add(a);
					}
				}
			}
			if(!this.checkAchievementExists("Earned Two Stars In Lightning!")){
				for(int i = 5; i <= 9; i++){
					if(levels.get(i).getStars() >= 2){
						Achievement a = AchievementGenerator.makeAchievements().get(4);
						needToBeUnlocked.add(a);
					}
				}
			}
			if(!this.checkAchievementExists("Earned Three Stars In Lightning!")){
				for(int i = 5; i <= 9; i++){
					if(levels.get(i).getStars() >= 3){
						Achievement a = AchievementGenerator.makeAchievements().get(5);
						needToBeUnlocked.add(a);
					}
				}
			}
			if(!this.checkAchievementExists("Earned One Star In Release!")){
				for(int i = 10; i <= 14; i++){
					if(levels.get(i).getStars() >= 1){
						Achievement a = AchievementGenerator.makeAchievements().get(6);
						needToBeUnlocked.add(a);
					}
				}
			}
			if(!this.checkAchievementExists("Earned Two Star In Release!")){
				for(int i = 10; i <= 14; i++){
					if(levels.get(i).getStars() >= 2){
						Achievement a = AchievementGenerator.makeAchievements().get(7);
						needToBeUnlocked.add(a);
					}
				}
			}
			if(!this.checkAchievementExists("Earned Three Star In Release!")){
				for(int i = 10; i <= 14; i++){
					if(levels.get(i).getStars() >= 3){
						Achievement a = AchievementGenerator.makeAchievements().get(8);
						needToBeUnlocked.add(a);
					}
				}
			}
			if(!this.checkAchievementExists("Unlocked 15 Levels!")){
				// If all 15 levels are unlocked unlock last achievement
				int j = 0;
				for (Level l : levels){
					if (l.isLocked() == false){
						j++;
					}
				}
				if (j == 15){
					Achievement a = AchievementGenerator.makeAchievements().get(9);
					needToBeUnlocked.add(a);
				}
			}
			return needToBeUnlocked;
	}
	
	public Achievement loadAchievement(String achievementName){
		achievements = AchievementGenerator.makeAchievements(); 
		for (int i = 0; i <= 9; i++){
		try {
			return this.achievements.get(i).getAchievementFromFile(achievementName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		}
		return null;
	}
}
