package entities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import generators.AchievementGenerator;
/**
 * Class to create a specific Model that will represent our game of level,  
 * @author Morgan Garbett - mlgarbett@wpi.edu
 * @author Can Alper - calper@wpi.edu
 * @author Courtney Davis - cedavis@wpi.edu
 * @author Mike Harney - mdharney@wpi.edu
 * @author Zach Armsby - zrarmsby@wpi.edu
 * @author Ryan Wiesenberg - rmwiesenberg@wpi.edu
 */
public class Model implements Cloneable{
	String name;
	ArrayList<Level> levels;
	Level previewLevel;
	ArrayList<Achievement> achievements;
	
	/**
	 * The Model takes a name, array list of achievements, and an array list of levels.
	 * @param name The name of the Model.
	 * @param achievements The achievements of a model.
	 * @param levels The levels of a model.
	 */
	public Model(String name, ArrayList<Achievement> achievements, ArrayList<Level> levels){
		
		this.name = name;
		this.achievements = achievements;
		this.levels  = levels;
		
		previewLevel = new Level(true, -1, null, null, false);
		try {
			//Save the Preview and Get it from the temporary file.
			previewLevel.saveToFile();
			previewLevel = previewLevel.getFromFile(-1);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the Name associated with the Model.
	 * @return The name of the Model.
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Reloads the Levels of the Model from the files.
	 */
	public void reload(){
		Level level = new Level(true, 16 , null, null, true);
		ArrayList<Level> levels = new ArrayList<Level>();
		
		for(int i = 1; i < 16; i++){
			try {
				level = level.getFromFile(i);
				if(i == 1 || i == 6 || i == 11){
					level.unlock();
				}
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			levels.add(level);
		}

		try {
			previewLevel = previewLevel.getFromFile(-1);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		ArrayList<Achievement> achievementList = null;
		
		this.achievements = achievementList;
		this.levels = levels;
	}
	
	/**
	 * Gets the Level from the Model list of levels at the specified index.
	 * @param num The index of the Level to retrieve.
	 * @return The level at that specified index.
	 */
	public Level getLevel(int num){
		if(num == -1){
			return previewLevel;
		}
		return levels.get(num-1);
	}
	
	/**
	 * Sets the level at the given index in the level list of the Model.
	 * @param index The index to set the Level at.
	 * @param level The Level to be added at the given index.
	 */
	public void setLevel(int index, Level level){
		levels.set(index-1, level);
	}
	
	/**
	 * Sets the Level that will be used as a Preview in Level Builder.
	 * @param level The level to set as preview.
	 */
	public void setPreviewLevel(Level level){
		previewLevel = level;
	}

	/**
	 * Generates all ten of our predefined achievements and stores them in the Model achievement list.
	 * @return The list of our ten achievements generated.
	 */
	public ArrayList<Achievement> getAchievements() {
		achievements = AchievementGenerator.makeAchievements(); 
		return achievements;
	}
	
	/**
	 * Saves a given Achievement by name to the achievements directory.
	 * @param achievementName The name of the achievement to be saved.
	 */
	public void saveAchievement (String achievementName){
		for (int i = 0; i <= 9; i++){
			if(this.achievements.get(i).getName() == achievementName){
				this.achievements.get(i).saveAchievementToFile(); 
			}
		}
	}
	
	/**
	 * Check if an Achievement is already existing in the directory.
	 * @param name The name of the achievement to check if it exists.
	 * @return Boolean that says if the achievement exists or not in the files. True means it does and False means it does not.
	 */
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
	
	/**
	 * Gets a list of all the Achievements that are currently unlocked and meet requirements to unlock.
	 * @return The array list of Achievements are unlocked.
	 */
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
	
	/**
	 * Checks if an Achievement needs to be unlocked and adds them to an Array List.
	 * @return The list of achievements that need to be unlocked.
	 */
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
	
	/**
	 * Loads the given Achievement from file based on the name of the achievement.
	 * @param achievementName The name of the Achievement to load from file.
	 * @return The Achievement loaded from file.
	 */
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
