package entities;

import java.awt.Image;

public class Achievement {
	String name;
	Image img;
	boolean unlocked = false;
	
	public Achievement(String name, Image img, boolean unlocked){
		this.name = name;
		this.img = img;
		this.unlocked = unlocked;
	}

/**
 * Get the lock status of the achievement.
 * Will return False if locked and True if unlocked.
 * @return The boolean associated with the achievement stating whether it is unlocked or not
 */
public boolean isUnlocked(){
	return this.unlocked;
}

public void check(){
	//When some conditions that are stored elsewhere are met some logic will go here and:
	this.unlocked = true;
}

public String getName() {
	return this.name;
}
}
