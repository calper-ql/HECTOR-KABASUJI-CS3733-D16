package entities;

import java.util.ArrayList;

public class Model {
	String name;
	ArrayList<Level> levels;
	ArrayList<Achievement> achievements;
	
	public Model(String name, ArrayList<Achievement> achievements, ArrayList<Level> levels){
		
		this.name = name;
		this.achievements = achievements;
		this.levels  = levels;
	}
}
