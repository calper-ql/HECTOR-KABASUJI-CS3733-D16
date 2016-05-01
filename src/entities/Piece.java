package entities;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

public class Piece implements Serializable{
	int id;
	ArrayList<Block> blocks;
	Color pieceColor;
	
	public Piece(Color pieceColor, int id){
		blocks = new ArrayList<Block>(6);
		this.pieceColor = pieceColor;
		this.id = id;
	}
	
	public int getID(){ return id; }
	
	// getBlock returns Exception if the requested block is not a valid array #
	public Block getBlock(int numBlock) throws Exception{
		if (numBlock < 6 && numBlock >= 0) return blocks.get(numBlock);
		else throw new Exception("Not a valid getBlock request");
	}
	
	public void addBlock(Block e){
		blocks.add(e);
	}
	
	public Color getColor(){ return pieceColor; }
}
