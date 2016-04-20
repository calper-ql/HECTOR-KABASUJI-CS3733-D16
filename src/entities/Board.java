package entities;

import java.util.ArrayList;

public class Board {
	ArrayList<ArrayList<Tile>> tiles; // column, row
	
	public Board(ArrayList<ArrayList<Tile>> tiles){
		this.tiles = tiles;
	}
	
	public Tile getTile(int col, int row){
		return tiles.get(col).get(row);
	}
	
}
