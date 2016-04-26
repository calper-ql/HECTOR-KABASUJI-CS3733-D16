package generators;

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
	
	public static void main(String[] args) {
		makeAchievements();
	}
}
