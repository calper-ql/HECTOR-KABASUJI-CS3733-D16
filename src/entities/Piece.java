package entities;

import java.util.ArrayList;

public class Piece {
	public ArrayList<Block> blocks = new ArrayList<Block>(6);
	
	public Piece(ArrayList<Block> blocks){
		this.blocks = blocks;
	}
	
	// getBlock returns Exception if the requested block is not a valid array #
	public Block getBlock(int numBlock) throws Exception{
		if (numBlock < 6 && numBlock > 0) return blocks.get(numBlock);
		else throw new Exception("Not a valid getBlock request");
	}
}
