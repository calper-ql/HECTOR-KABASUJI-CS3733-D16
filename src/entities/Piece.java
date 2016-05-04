package entities;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * The Class that contains the relevant state of a Piece.
 * @author 
 *
 */
public class Piece implements Serializable{
	int id;
	ArrayList<Block> blocks;
	Color pieceColor;
	/**
	 * The constructor of a Piece that takes its color and ID. The Piece contains an associated ArrayList of Blocks.
	 * @param pieceColor The Color of a given Piece.
	 * @param id The ID of a given Piece (Ranges from 1 to 35).
	 */
	public Piece(Color pieceColor, int id){
		blocks = new ArrayList<Block>(6);
		this.pieceColor = pieceColor;
		this.id = id;
	}
	/**
	 * Gets the ID associated with a Piece.
	 * @return The ID of the Piece.
	 */
	public int getID(){ return id; }
	
	/**
	 * Gets a given block from the Piece itself.
	 * @param numBlock The number of the Block to be retrieved.
	 * @return The Block retrieved.
	 * @throws Exception If the Block is not valid Block to request.
	 */
	// getBlock returns Exception if the requested block is not a valid array #
	public Block getBlock(int numBlock) throws Exception{
		if (numBlock < 6 && numBlock >= 0) return blocks.get(numBlock);
		else throw new Exception("Not a valid getBlock request");
	}
	
	/**
	 * Add the Block given to the Piece.
	 * @param e The block to add to the Pieces Block list.
	 */
	public void addBlock(Block e){
		blocks.add(e);
	}
	
	/**
	 * Get the color of the Piece.
	 * @return The color of the given Piece.
	 */
	public Color getColor(){ return pieceColor; }
}
