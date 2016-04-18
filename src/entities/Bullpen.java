package entities;

import java.util.ArrayList;

public class Bullpen {
	ArrayList<Piece> pieces;
	
	public Bullpen(ArrayList<Piece> pieces){
		this.pieces = pieces;
		return;
	}
	
	void addPiece(Piece piece){
		pieces.add(piece);
	}
	
	void removePiece(Piece piece) throws Exception{
		boolean success = pieces.remove(piece);
		if(!success) throw new Exception("Piece not found");
	}

}
