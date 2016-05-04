package entities;

import java.util.LinkedList;
/**
 * The Splash Screen with all of our team members and the project name.
 * @author Can Alper - calper@wpi.edu
 *
 */
public class SplashScreen {
	
	LinkedList<String> nameList;
	String mainTitle;
	String teamName;
	/**
	 * Class to Create a SplashScreen to be rendered on Application start.
	 * @param isBuilder Boolean to determine if the splash should display builder title. True means display builder title, False means do not.
	 */
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
	
	/**
	 * Get the list of every team member.
	 * @return The names of the team members.
	 */
	public LinkedList<String> getNameList(){ return nameList; }
	
	/**
	 * Get the title of the Application.
	 * @return The main Title of the Builder and Application.
	 */
	public String getMainTitle(){ return mainTitle; }
	
	/**
	 * Get the name of the team.
	 * @return The name of the Team.
	 */
	public String getTeamName(){ return teamName; }
	
}
