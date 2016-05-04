package entities;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Class to represent the Board of the game. Boards contain a double array list of Tiles.
 * @author Can Alper - calper@wpi.edu
 * @author Zach Armsby - zrarmsby@wpi.edu
 */
public class Board implements Serializable{
	ArrayList<ArrayList<Tile>> tiles; // column, row
	/**
	 * Board Constructor takes in a double array list of all it's tiles.
	 * @param tiles The double array list of every Tile on a Board.
	 */
	public Board(ArrayList<ArrayList<Tile>> tiles){
		this.tiles = tiles;
	}
	/**
	 * Gets the Tile associated with the given column and row of the Double Array List
	 * @param col The Column index of the Tile we are searching for.
	 * @param row The Row index of the Tile we are searching for.
	 * @return
	 */
	public Tile getTile(int col, int row){
		return tiles.get(col).get(row);
	}
	/**
	 * Updates the Double Array List of Tiles we want the Board to contain.
	 * @param generateTileList The Tile list that we want to update the Board with.
	 */
	public void replaceTileList(ArrayList<ArrayList<Tile>> generateTileList) {
		tiles = generateTileList;
		
	}
	
}
