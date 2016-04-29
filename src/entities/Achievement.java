package entities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class Achievement {
	String name;
	Image img;
	URL url;
	boolean unlocked = true;
	
	public Achievement(String name, URL url, boolean unlocked){
		this.name = name;
		this.url = url;
		this.unlocked = unlocked;
	}
	
	public Image getImage(){
		return this.convertURLtoImage();
	}
	
	public Image convertURLtoImage(){
		BufferedImage mock_img = null;
		try {
			mock_img = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image img = mock_img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		return img;
	}
	
	public void setisUnlocked(){
		this.unlocked = true;
	}
	
	public boolean isUnlocked(){
		return this.unlocked;
	}
	
	public String getName(){
		return this.name;
	}
}
