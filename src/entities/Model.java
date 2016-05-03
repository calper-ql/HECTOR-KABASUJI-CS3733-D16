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
		return this.achievements;
	}
	
	public void saveAchievement (){
		
	}
	
	public Achievement loadAchievement(String achievementName){
		for (int i = 0; i <= 9; i++){
		if(this.achievements.get(i).getName() == achievementName){
		try {
			return this.achievements.get(i).getAchievementFromFile(achievementName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		}
		}
		return null;
	}
}
