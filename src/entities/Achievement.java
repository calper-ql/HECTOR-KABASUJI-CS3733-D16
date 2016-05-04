
package entities;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * Achievement Class
 * Class to store the state of the achievements.
 * @author Morgan Garbett - mlgarbett@wpi.edu
 * @author Can Alper - calper@wpi.edu
 * @author Courtney Davis - cedavis@wpi.edu
 */
public class Achievement implements Serializable{
	String name;
	Image img;
	URL url;
	boolean unlocked = false;
	/**
	 * The Achievement contains information about a single achievement such as a name, image, and if it is unlocked.
	 * @param name The name of the achievement.
	 * @param url The URL of the achievement to make the Image.
	 * @param unlocked The Image associated with the achievement's URL.
	 */
	public Achievement(String name, URL url, boolean unlocked){
		this.name = name;
		this.url = url;
		this.unlocked = unlocked; 
	}
	/**
	 * Get the Image from the URL given when an Achievement is created.
	 * @return The Image associated with the achievement's URL
	 */
	public Image getImage(){
		return this.convertURLtoImage();
	}
	
	/**
	 * Convert the Achievement's associated URL to a rendered and scaled Image.
	 * @return The rendered and scaled instance of the Image.
	 */
	public Image convertURLtoImage(){
		BufferedImage mock_img = null;
		try {
			mock_img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Image img = mock_img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		return img;
	}
	
	/**
	 * Set the achievement's unlocked state to True. 
	 */
	public void setisUnlocked(){
		this.unlocked = true;
	}
	
	/**
	 * Save the Achievement to a folder called "achievements". Individual achievements are saved in files with the name that is associated with the Achievement object. 
	 * For example the first Achievement is saved as the file "Earned One Star In Puzzle!".
	 * @return A boolean determining if saving Achievement to file was successful. Success returns True and Failure returns False. 
	 */
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
	
	/**
	 * Gets the saved Achievement from the File that shares the passed in file name. For example to get the first achievement the method takes "Earned One Star In Puzzle!".
	 * @param name The name of the Achievement that should be loaded.
	 * @return The Achievement that has the same associated name as the input to the method. 
	 * @throws IOException In case of File Opening error.
	 * @throws ClassNotFoundException In case the serialized Achievement is not recognized.
	 */
	public Achievement getAchievementFromFile(String name) throws IOException, ClassNotFoundException{
		FileInputStream fout;
		ObjectInputStream oos;
		
		fout = new FileInputStream(("achievements/achievement " + name));
		oos = new ObjectInputStream(fout);
		Achievement loaded = (Achievement) oos.readObject();
		oos.close();
		return loaded;
		
	}
	
	/**
	 * Deletes the achievement files saved in the achievements directory/folder.
	 */
	public void deleteAcheivement(){
		File dir = new File("achievements");
		if(!dir.exists()){
			dir.mkdirs();
		}
		
		File save = new File(dir, "achievement " + name);
		if(save.exists()){
			save.delete();
		}
	}
	
	/**
	 * Informs if an Achievement is locked or not.
	 * @return The unlock status of the Achievement. Locked is False and Unlocked is True.
	 */
	public boolean isUnlocked(){
		return this.unlocked;
	}
	
	/**
	 * Informs what String associated with the name of the Achievement is.
	 * @return The name associated with the Achievement.
	 */
	public String getName(){
		return this.name;
	}

}