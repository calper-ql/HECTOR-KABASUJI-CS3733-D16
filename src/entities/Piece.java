package entities;

import java.awt.Color;
import java.util.ArrayList;

public class Piece {
	ArrayList<Block> blocks;
	Color pieceColor;
	
	public Piece(Color pieceColor){
		blocks = new ArrayList<Block>(6);
		this.pieceColor = pieceColor;
	}	
	
	// getBlock returns Exception if the requested block is not a valid array #
	public IBlock getBlock(int numBlock) throws Exception{
		if (numBlock < 6 && numBlock > 0) return blocks.get(numBlock);
		else throw new Exception("Not a valid getBlock request");
	}
	
	public void addBlock(Block e){
		blocks.add(e);
	}
	
	public Color getColor(){ return pieceColor; }
}
