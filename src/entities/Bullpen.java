package entities;

import java.util.ArrayList;

public class Bullpen {
	ArrayList<Piece> pieces;
	
	public Bullpen(ArrayList<Piece> pieces){
		this.pieces = pieces;
		return;
	}
	
	void addPiece(Piece piece){
		return;
	}
	
	Block removePiece(Piece piece){
		return piece.getBlock();
	}

}
