package entities;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Class that defines the Bull pen and its attributes. Bull pen contains an ArrayList of Pieces.
 * @author Can Alper - calper@wpi.edu
 * @author Zach Armsby - zrarmsby@wpi.edu
 */
public class Bullpen implements Serializable{
	ArrayList<Piece> pieces;
	/**
	 * Bull pen contains an ArrayList of all of the Pieces inside of it.
	 * @param pieces The Array List of all the Pieces inside the Bull pen.
	 */
	public Bullpen(ArrayList<Piece> pieces){
		this.pieces = pieces;
		return;
	}
	/**
	 * Adds a specified Piece to the Bull Pen Array List.
	 * @param piece The Piece to be added to the Bull Pen.
	 */
	public void addPiece(Piece piece){
		pieces.add(piece);
	}
	/**
	 * Removes a specific Piece from the Bull pen.
	 * @param piece The Piece to be removed from the Bull pen.
	 * @throws Exception Piece not found exception means that the requested Piece to remove is not currently in the Bull pen.
	 */
	public void removePiece(Piece piece) throws Exception{
		boolean success = pieces.remove(piece);
		if(!success) throw new Exception("Piece not found");
	}
	/**
	 * Gets the Piece out of the Bull Pen at the specified index.
	 * @param index The index of the Piece to retrieve.
	 * @return The piece at the index provided. 
	 */
	public Piece getPiece(int index){
		return pieces.get(index);
	}
	/**
	 * Gets the size of the Bull pen, inform how many pieces are in it.
	 * @return The number of Pieces in the Bull pen.
	 */
	public int getSize(){
		return pieces.size();
	}
	/**
	 * Replaces the Pieces in a Bull pen with a new ArrayList of Pieces.
	 * @param generatePieceList The new Piece list to populate the Bull pen.
	 */
	public void replacePieceList(ArrayList<Piece> generatePieceList) {
		pieces = generatePieceList;
	}

}
