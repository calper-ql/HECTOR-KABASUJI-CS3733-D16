package entities;
/**
 * Interface for IBlocks. Any block object that wants to flip or rotate, should implement this interface.
 * @author Can Alper - calper@wpi.edu
 *
 */
public interface IBlock {

	/**
	 * Method to rotate the IBlock should be in all the IBlock classes.
	 * @param block The Block to be rotated.
	 */
	void rotateBlock(IBlock block);

	/**
	 * Method to flip the IBlock should be in all the IBlock classes.
	 * @param block The Block to flip.
	 * @param horizontal Boolean to check if the block flips horizontal. True means flip horizontal, False flips vertical.
	 */
	void flipBlock(IBlock block, boolean horizontal);
	
	IBlock getNorth();
	IBlock getSouth();
	IBlock getEast();
	IBlock getWest();
	boolean isValidBlock();
	Piece getPiece();
	
}
