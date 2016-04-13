package entities;

import java.util.ArrayList;

public class Block {
	Piece piece;
	
	Block north;
	Block east;
	Block south;
	Block west;
	
	public Block(Piece piece, ArrayList<Block> blocks){
		this.piece = piece;
		
		this.north = blocks.get(0);
		this.east = blocks.get(1);
		this.south = blocks.get(2);
		this.west = blocks.get(3);
		return;
	}
	
	public void rotatePiece(){
		return;
	}
	
	public void flipPiece(){
		return;
	}
}
