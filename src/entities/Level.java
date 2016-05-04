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
/**
 * Class to store all the persistent information of a Level.
 * @author Can Alper - calper@wpi.edu
 * @author Courtney Davis - cedavis@wpi.edu
 * @author Morgan Garbett - mlgarbett@wpi.edu
 *
 */
public class Level implements Serializable {
	boolean isLocked;
	int levelNum;
	Bullpen bPen;
	Board board;
	boolean hints;
	int stars = 0;
	boolean isSaveable;
	
	/**
	 * Level holds all the relevant entities and attributes of a Level. isSaveable is a boolean flag used for Preview mechanism.
	 * @param isLocked Boolean that states whether a Level is locked or not. True is Locked, False is unlocked.
	 * @param levelNum The Number associated with a given Level.
	 * @param bPen The Bull pen, initially containing all the starting pieces of a Level.
	 * @param board The Board that holds the Tiles. Initially starts with 12x12 enabled Tiles.
	 * @param hints Boolean that states if a Level has hints.
	 */
	public Level(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints) {
		this.isLocked = isLocked;
		this.levelNum = levelNum;
		this.bPen = bPen;
		this.board = board;
		this.hints = hints;
		this.isSaveable = true;
	}

	/**
	 * Disables the saving of a level by setting boolean is isSaveable flag to false.
	 */
	public void disableSaving() {
		isSaveable = false;
	}

	/**
	 * Gets whether the Level can be saved to file or not. If it is a preview level we do not save.
	 * @return The boolean that tells whether the Level is saveable or not.
	 */
	public boolean getIsSavable() {
		return isSaveable;
	}

	/**
	 * Enables the saving of a level by setting boolean is isSaveable flag to true.
	 */
	public void enableSaving() {
		isSaveable = true;
	}

	/**
	 * Method to inform if a specific Level is locked or not.
	 * @return Boolean that states if a Level is locked or not.
	 */
	public boolean isLocked() {
		return isLocked;
	}

	/**
	 * Sets the Level to unlocked.
	 */
	public void unlock() {
		isLocked = false;
	}
	
	/**
	 * Gets the associated Level Number of the Level.
	 * @return The level number of the Level.
	 */
	public int getLevelNum() {
		return levelNum;
	}

	/**
	 * Get the bull pen of the level.
	 * @return The Bull pen of the Level with all the possible Pieces.
	 */
	public Bullpen getBullpen() {
		return bPen;
	}

	/**
	 * Gets the Board of the Level and returns it.
	 * @return The Board of the Level with all its associated Tiles inside.
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Gets the number of Stars a Level has.
	 * @return The number of Stars of a Level.
	 */
	public int getStars() {
		return stars;
	}

	/**
	 * Saves the Level to the File. 
	 * @return A boolean that tells if the level was saved properly or not.
	 */
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

	/**
	 * Saves a Level to file. Files saved have the given name associated with them (Used for saving temporary levels).
	 * @param name The name of the Level to get saved.
	 * @return boolean whether level save was a success or not.
	 */
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

	/**
	 * Loads a Level from the file based on the Levels Level Number.
	 * @param levelNum The Level number of the Level to be retrieved from Files.
	 * @return The level saved at the File location identified by the index given.
	 * @throws IOException In case of File Opening error.
	 * @throws ClassNotFoundException In case the serialized Level is not recognized.
	 */
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

	/**
	 * Loads a Level from Levels associated name.
	 * @param name The name of the Level saved to the directory of Levels that we are trying to retrieve.
	 * @return The Level with the same associated name we are looking for.
	 * @throws IOException In case of File Opening error.
	 * @throws ClassNotFoundException In case the serialized Level is not recognized.
	 */
	public Level getFromFile(String name) throws IOException, ClassNotFoundException {
		FileInputStream fout;
		ObjectInputStream oos;

		fout = new FileInputStream(("levels/level" + name));
		oos = new ObjectInputStream(fout);
		Level loaded = (Level) oos.readObject();
		oos.close();
		return loaded;

	}

	/**
	 * Copies a Level and all of its attributes to a temporary file.
	 * @return The Level copy created.
	 * @throws IOException In case of File Opening error.
	 * @throws ClassNotFoundException In case the serialized Level is not recognized.
	 */
	public Level generateLevelCopy() throws ClassNotFoundException, IOException {
		this.saveToFile("tempCopy");
		return this.getFromFile("tempCopy");
	}

	/**
	 * Updates a Levels star count to a specified value.
	 * @param stars The number of Stars to associate with the Level.
	 */
	public void setStars(int stars) {
		if ((stars > 0 || stars <= 3) && stars > this.stars)
			this.stars = stars;
	}

	/**
	 * Reset the Level to locked state with no earned stars.
	 */
	public void resetLevel() {
		forceStars(0);
		this.isLocked = true;
	}

	/**
	 * Forces the Stars to be a specified number(for testing)
	 * @param stars what number the stars should be forced to.
	 */
	public void forceStars(int stars) {
		this.stars = stars;
	}

	/**
	 * Returns a boolean that states if a level has finished or not.
	 * @return False, a base Level type does not have win conditions.
	 */
	public boolean hasFinished() {
		return false;
	}

	/**
	 * Informs of the number of empty tiles on a level's board.
	 * @return Returns the count of the number of Tiles on the Level's board that are empty.
	 */
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

	/**
	 * Disables all the Tiles of a Level.
	 */
	// USE WITH CAUTION: TESTING ONLY
	public void disableAllTiles() {
		for (int c = 0; c < 12; c++) {
			for (int r = 0; r < 12; r++) {
				board.tiles.get(c).get(r).disable();
			}
		}
	}

	/**
	 * Enables all the Tiles of a Level.
	 */
	// USE WITH CAUTION: TESTING ONLY
	public void enableAllTiles() {
		for (int c = 0; c < 12; c++) {
			for (int r = 0; r < 12; r++) {
				board.tiles.get(c).get(r).enable();
			}
		}
	}
	
	/**
	 * Empties the Bull pen of all pieces.
	 */
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
	public void setupTestLevel(){
		enableAllTiles();
		forceStars(0);
		emptyBullpen();
	}

	/**
	 * Sets the level Number associated with a level.
	 * @param levelNum The number to set the Level Number to.
	 */
	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;

	}

	/**
	 * Locks the level.
	 */
	public void lock() {
		isLocked = true;
	}
}
