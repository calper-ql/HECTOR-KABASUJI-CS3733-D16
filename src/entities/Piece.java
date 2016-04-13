package entities;

import java.util.ArrayList;

public class Piece {
	ArrayList<Block> blocks;
	
	public Piece(ArrayList<Block> blocks){
		this.blocks = blocks;
		return;
	}
	
	public Block getBlock(){
		return blocks.get(0);
	}
}
