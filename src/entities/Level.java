package entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.print.DocFlavor.URL;

public class Level implements Serializable {
	boolean isLocked;
	int levelNum;
	Bullpen bPen;
	Board board;
	boolean hints;
	int stars = 0;
	boolean isSaveable;

	public Level(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints) {
		this.isLocked = isLocked;
		this.levelNum = levelNum;
		this.bPen = bPen;
		this.board = board;
		this.hints = hints;
		this.isSaveable = true;
	}

	public void disableSaving() {
		isSaveable = false;
	}

	public boolean getIsSavable() {
		return isSaveable;
	}

	public void enableSaving() {
		isSaveable = true;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void unlock() {
		isLocked = false;
	}

	public int getLevelNum() {
		return levelNum;
	}

	public Bullpen getBullpen() {
		return bPen;
	}

	public Board getBoard() {
		return board;
	}

	public int getStars() {
		return stars;
	}

	public boolean saveToFile() {
		if (!this.isSaveable)
			return true;
		FileOutputStream fout;
		ObjectOutputStream oos;
		try {
			File dir = new File("levels");
			if (!dir.exists()) {
				dir.mkdirs();
			}

			File save = new File(dir, "level" + levelNum);
			if (!save.exists()) {
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

	public boolean saveToFile(String name) {
		if (!this.isSaveable)
			return true;
		FileOutputStream fout;
		ObjectOutputStream oos;
		try {
			File dir = new File("levels");
			if (!dir.exists()) {
				dir.mkdirs();
			}

			File save = new File(dir, "level" + name);
			if (!save.exists()) {
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

	public Level getFromFile(int levelNum) throws IOException, ClassNotFoundException {
		if (levelNum == 0) {
			FileInputStream fout;
			ObjectInputStream oos;

			fout = new FileInputStream(("levels/level" + -1));
			oos = new ObjectInputStream(fout);
			Level loaded = (Level) oos.readObject();
			oos.close();
			return loaded;
		}
		FileInputStream fout;
		ObjectInputStream oos;

		fout = new FileInputStream(("levels/level" + levelNum));
		oos = new ObjectInputStream(fout);
		Level loaded = (Level) oos.readObject();
		oos.close();
		return loaded;

	}

	public Level getFromFile(String name) throws IOException, ClassNotFoundException {
		FileInputStream fout;
		ObjectInputStream oos;

		fout = new FileInputStream(("levels/level" + name));
		oos = new ObjectInputStream(fout);
		Level loaded = (Level) oos.readObject();
		oos.close();
		return loaded;

	}

	public Level generateLevelCopy() throws ClassNotFoundException, IOException {
		this.saveToFile("tempCopy");
		return this.getFromFile("tempCopy");
	}

	public void setStars(int stars) {
		if ((stars > 0 || stars <= 3) && stars > this.stars)
			this.stars = stars;
	}

	public void resetLevel() {
		this.isLocked = true;
		forceStars(0);
	}

	public void forceStars(int stars) {
		this.stars = stars;
	}

	public boolean hasFinished() {
		return false;
	}

	public int getEmptyTileCount() {
		int emptyTiles = 144;
		for (int c = 0; c < 12; c++) {
			for (int r = 0; r < 12; r++) {
				Tile curTile = board.tiles.get(c).get(r);
				if (!curTile.enabled() || curTile.hasBlock()) {
					emptyTiles--;
				}
			}
		}
		return emptyTiles;
	}

	// USE WITH CAUTION: TESTING ONLY
	public void disableAllTiles() {
		for (int c = 0; c < 12; c++) {
			for (int r = 0; r < 12; r++) {
				board.tiles.get(c).get(r).disable();
			}
		}
	}

	// USE WITH CAUTION: TESTING ONLY
	public void enableAllTiles() {
		for (int c = 0; c < 12; c++) {
			for (int r = 0; r < 12; r++) {
				board.tiles.get(c).get(r).enable();
			}
		}
	}
	
	// USE WITH CAUTION: TESTING ONLY
	public void emptyBullpen() {
		int size = bPen.getSize();
		for (int i = 0; i < size; i++) {
			Piece p = bPen.getPiece(0);
			try {
				bPen.removePiece(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// USE WITH CAUTION: TESTING ONLY
	public void testLevelSetup(){
		enableAllTiles();
		forceStars(0);
		emptyBullpen();
	}

	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;

	}

	public void lock() {
		isLocked = true;
	}
}
