package entities;

import java.util.ArrayList;

public class Board {
	ArrayList<Tile> tiles;
	
	public Board(ArrayList<Tile> tiles){
		this.tiles = tiles;
	}
	
	//not implemented at all
	public Tile getTile(int col, int row){
		return tiles.get(0);
	}
}
