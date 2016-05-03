package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Board implements Serializable{
	ArrayList<ArrayList<Tile>> tiles; // column, row
	
	public Board(ArrayList<ArrayList<Tile>> tiles){
		this.tiles = tiles;
	}
	
	public Tile getTile(int col, int row){
		return tiles.get(col).get(row);
	}

	public void replaceTileList(ArrayList<ArrayList<Tile>> generateTileList) {
		tiles = generateTileList;
		
	}
	
}
