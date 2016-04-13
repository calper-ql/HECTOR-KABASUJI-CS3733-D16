package entities;

import java.awt.Image;

public class Achievement {
	String name;
	Image img;
	boolean unlocked;
	
	public Achievement(String name, Image img, boolean unlocked){
		this.name = name;
		this.img = img;
		this.unlocked = unlocked;
	}
}
