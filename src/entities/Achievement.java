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
	
	public boolean saveAchievementToFile(){
		FileOutputStream fout;
		ObjectOutputStream oos;
		try {
			File dir = new File("achievements");
			if(!dir.exists()){
				dir.mkdirs();
			}
			
			File save = new File(dir, "achievement " + name);
			if(!save.exists()){
				save.createNewFile();
			}
			
			fout = new FileOutputStream("achievements/achievement " + name);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(this);
			oos.flush();
			fout.flush();
			oos.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public Achievement getAchievementFromFile() throws IOException, ClassNotFoundException{
		FileInputStream fout;
		ObjectInputStream oos;
		
		fout = new FileInputStream(("achievements/achievement " + name));
		oos = new ObjectInputStream(fout);
		Achievement loaded = (Achievement) oos.readObject();
		oos.close();
		return loaded;
		
	}
	
	public boolean isUnlocked(){
		return this.unlocked;
	}
	
	public String getName(){
		return this.name;
	}
}
