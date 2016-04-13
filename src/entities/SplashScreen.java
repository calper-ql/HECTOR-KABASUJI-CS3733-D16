package entities;

import java.util.LinkedList;

public class SplashScreen {
	
	LinkedList<String> nameList;
	String mainTitle;
	String teamName;
	
	public SplashScreen(boolean isBuilder){
		teamName = "Hector";
		nameList = new LinkedList<String>();
		nameList.add("Can Alper");
		nameList.add("Zach Armsby");
		nameList.add("Mike Harney");
		nameList.add("Morgan Garbett");
		nameList.add("Ryan Wiesenberg");
		nameList.add("Courtney Davis");
		if(isBuilder) mainTitle = "Kabasuji Level Builder";
		else mainTitle = "Kabasuji";
	}
	
	public LinkedList<String> getNameList(){ return nameList; }
	public String getMainTitle(){ return mainTitle; }
	public String getTeamName(){ return teamName; }
	
}
