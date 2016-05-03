package generators;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import entities.*;

public class AchievementGenerator {
	
	public AchievementGenerator(){
	}
	
	public static ArrayList<Achievement> makeAchievements(){
		ArrayList<Achievement> achievements = new ArrayList<Achievement>();
		URL i1 = generators.AchievementGenerator.class.getResource("/img/i1.png");
		URL i2 = generators.AchievementGenerator.class.getResource("/img/i2.png");
		URL i3 = generators.AchievementGenerator.class.getResource("/img/i3.png");
		URL i4 = generators.AchievementGenerator.class.getResource("/img/i4.png");
		URL i5 = generators.AchievementGenerator.class.getResource("/img/i5.png");
		URL i6 = generators.AchievementGenerator.class.getResource("/img/i6.png");
		URL i7 = generators.AchievementGenerator.class.getResource("/img/i7.png");
		URL i8 = generators.AchievementGenerator.class.getResource("/img/i8.png");
		URL i9 = generators.AchievementGenerator.class.getResource("/img/i9.png");
		URL i10 = generators.AchievementGenerator.class.getResource("/img/i10.png");
		
		Achievement a1 = new Achievement("Earned One Star In Puzzle!", i1, false);
		Achievement a2 = new Achievement("Earned Two Stars In Puzzle!", i2, false);
		Achievement a3 = new Achievement("Earned Three Stars In Puzzle!", i3, false);
		Achievement a4 = new Achievement("Earned One Star In Lightning!", i4, false);
		Achievement a5 = new Achievement("Earned Two Stars In Lightning!", i5, false);
		Achievement a6 = new Achievement("Earned Three Stars In Lightning!", i6, false);
		Achievement a7 = new Achievement("Earned One Star In Release!", i7, false);
		Achievement a8 = new Achievement("Earned Two Star In Release!", i8, false);
		Achievement a9 = new Achievement("Earned Three Star In Release!", i9, false);
		Achievement a10 = new Achievement("Unlocked 15 Levels!", i10, false);
		
		achievements.add(a1);
		achievements.add(a2);
		achievements.add(a3);
		achievements.add(a4);
		achievements.add(a5);
		achievements.add(a6);
		achievements.add(a7);
		achievements.add(a8);
		achievements.add(a9);
		achievements.add(a10);
		for (Achievement a : achievements){
			a.saveAchievementToFile();
		}
		return achievements;
		
	}
	

	public ArrayList<Achievement> loadAchievements(){
		ArrayList<Achievement> achievementList = new ArrayList<Achievement>();
		
		Achievement a1 = new Achievement("Earned One Star In Puzzle!", null, false);
		Achievement a2 = new Achievement("Earned Two Stars In Puzzle!", null, false);
		Achievement a3 = new Achievement("Earned Three Stars In Puzzle!", null, false);
		Achievement a4 = new Achievement("Earned One Star In Lightning!", null, false);
		Achievement a5 = new Achievement("Earned Two Stars In Lightning!", null, false);
		Achievement a6 = new Achievement("Earned Three Stars In Lightning!", null, false);
		Achievement a7 = new Achievement("Earned One Star In Release!", null, false);
		Achievement a8 = new Achievement("Earned Two Star In Release!", null, false);
		Achievement a9 = new Achievement("Earned Three Star In Release!", null, false);
		Achievement a10 = new Achievement("Unlocked 15 Levels!", null, false);
		try {
			a1 = a1.getAchievementFromFile(a1.getName());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			a2 = a2.getAchievementFromFile(a2.getName());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			a3 = a3.getAchievementFromFile(a3.getName());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			a4 = a4.getAchievementFromFile(a4.getName());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			a5 = a5.getAchievementFromFile(a5.getName());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			a6 = a6.getAchievementFromFile(a6.getName());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			a7 = a7.getAchievementFromFile(a7.getName());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			a8 = a8.getAchievementFromFile(a8.getName());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			a9 = a9.getAchievementFromFile(a9.getName());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			a10 = a10.getAchievementFromFile(a10.getName());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		achievementList.add(a1);
		achievementList.add(a2);
		achievementList.add(a3);
		achievementList.add(a4);
		achievementList.add(a5);
		achievementList.add(a6);
		achievementList.add(a7);
		achievementList.add(a8);
		achievementList.add(a9);
		achievementList.add(a10);
		
		return achievementList;
	}
	
	public static void main(String[] args) {
		makeAchievements();
	}
}