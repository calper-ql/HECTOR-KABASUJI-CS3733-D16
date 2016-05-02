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

public class Level implements Serializable {
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
	
	public boolean isLocked(){
		return isLocked;
	}
	
	public void unlock(){
		isLocked = true;
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
		if (levelNum < 0){
			return false;
		}
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
	
	public boolean saveToFile(String name){
		
		FileOutputStream fout;
		ObjectOutputStream oos;
		try {
			File dir = new File("levels");
			if(!dir.exists()){
				dir.mkdirs();
			}
			
			File save = new File(dir, "level" + name);
			if(!save.exists()){
				save.createNewFile();
			}
			
			fout = new FileOutputStream("levels/level" + name);
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
	
	public Level getFromFile(String name) throws IOException, ClassNotFoundException{
		FileInputStream fout;
		ObjectInputStream oos;
		
		fout = new FileInputStream(("levels/level" + name));
		oos = new ObjectInputStream(fout);
		Level loaded = (Level) oos.readObject();
		oos.close();
		return loaded;
		
	}
	
	public Level generateLevelCopy() throws ClassNotFoundException, IOException{
		this.saveToFile("tempCopy");
		return this.getFromFile("tempCopy");
	}
	
	public void setStars(int stars){
		if(stars > 0 || stars <= 3 && stars > this.stars){
			this.stars = stars;
		} else this.stars = 0;
	}
	
	public boolean hasFinished(){
		return false;
	}
	
	public int getEmptyTileCount(){
		int emptyTiles = 144;
		for(int c = 0; c < 12; c++){
			for(int r = 0; r < 12; r++){
				Tile curTile = board.tiles.get(c).get(r);
				if(!curTile.enabled() || curTile.hasBlock()){
					emptyTiles--; 
				}
			}
		}
		return emptyTiles;
	}

	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
		
	}
}
