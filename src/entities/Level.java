package entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.print.DocFlavor.URL;

public class Level implements ILevel, Serializable {
	boolean isLocked;
	int levelNum;
	Bullpen bPen;
	Board board;
	boolean hints;
	int stars = 0;
	
	public Level(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints){
		this.isLocked = isLocked;
		this.levelNum = levelNum;
		this.bPen = bPen;
		this.board = board;
		this.hints = hints;
	}
	
	public int getLevelNum(){
		return levelNum;
	}
	
	public Bullpen getBullpen(){
		return bPen;
	}
	
	public Board getBoard(){
		return board;
	}
	
	public int getStars(){
		return stars;
	}
	
	public boolean saveToFile(){
		
		FileOutputStream fout;
		ObjectOutputStream oos;
		try {
			File dir = new File("levels");
			if(!dir.exists()){
				dir.mkdirs();
			}
			
			File save = new File(dir, "level" + levelNum);
			if(!save.exists()){
				save.createNewFile();
			}
			
			fout = new FileOutputStream("levels/level" + levelNum);
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
	
	public Level getFromFile(int levelNum) throws IOException, ClassNotFoundException{
		FileInputStream fout;
		ObjectInputStream oos;
		
		fout = new FileInputStream(("levels/level" + levelNum));
		oos = new ObjectInputStream(fout);
		Level loaded = (Level) oos.readObject();
		oos.close();
		return loaded;
		
	}
	
	public void setStars(int stars){
		if(stars > 0 || stars <= 3){
			this.stars = stars;
		} else this.stars = 0;
	}
	
	public boolean hasFinished(){
		return false;
	}
}
