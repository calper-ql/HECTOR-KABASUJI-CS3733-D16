package entities;

import java.io.Serializable;
/**
 * Class to Represent Empty Blocks 
 * @author Can Alper - calper@wpi.edu
 *
 */
public class EmptyBlock implements IBlock ,Serializable{
	/**
	 * Empty Block Constructor takes no arguments.
	 */
	public EmptyBlock(){}

	/**
	 * Inherited method from IBlock interface (not used on Empty Block because they are empty).
	 */
	@Override
	public void rotateBlock(IBlock block) {
		// TODO Auto-generated method stub		
	}

	/**
	 * Inherited method from IBlock interface (not used on Empty Block because they are empty).
	 */
	@Override
	public void flipBlock(IBlock block, boolean horizontal) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Return the Northern Neighbor of the Empty Block which is another Empty Block.
	 */
	@Override
	public IBlock getNorth() {
		// TODO Auto-generated method stub
		return new EmptyBlock();
	}

	/**
	 * Return the Southern Neighbor of the Empty Block which is another Empty Block.
	 */
	@Override
	public IBlock getSouth() {
		// TODO Auto-generated method stub
		return new EmptyBlock();
	}

	/**
	 * Return the Eastern Neighbor of the Empty Block which is another Empty Block.
	 */
	@Override
	public IBlock getEast() {
		// TODO Auto-generated method stub
		return new EmptyBlock();
	}

	/**
	 * Return the Western Neighbor of the Empty Block which is another Empty Block.
	 */
	@Override
	public IBlock getWest() {
		// TODO Auto-generated method stub
		return new EmptyBlock();
	}

	/**
	 * Returns a boolean to state if this block is valid. Blocks in the Empty Block class will always be invalid (Comes from IBlock Interface).
	 */
	@Override
	public boolean isValidBlock() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the Piece associated with the Block, Empty Blocks do not have associated Pieces and return Null.
	 */
	@Override
	public Piece getPiece() {
		// TODO Auto-generated method stub
		return null;
	}


}
