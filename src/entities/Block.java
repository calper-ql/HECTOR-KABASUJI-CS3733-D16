package entities;

import java.io.Serializable;
/**
 * Class that defines the Blocks that will compose pieces. Blocks are aware of their neighbors and are linked. Blocks with no neighbors are neighbors with Empty Blocks.
 * @author Can Alper - calper@wpi.edu
 * @author Zach Armsby - zrarmsby@wpi.edu
 * @author Ryan Wiesenberg - rmwiesenberg@wpi.edu
 */
public class Block implements IBlock, Serializable{
	Piece piece;
	IBlock north;
	IBlock east;
	IBlock south;
	IBlock west;
	/**
	 * Blocks know the Pieces they are part of and they share links with their neighbors on all 4 sides.
	 * @param piece The piece a block is a part of.
	 */
	public Block(Piece piece){
		this.piece = piece;
		piece.addBlock(this);
		north = new EmptyBlock();
		south = new EmptyBlock();
		east = new EmptyBlock();
		west = new EmptyBlock();
	}
	
	/**
	 * Method that gets the Piece associated with a specific Block, the Piece the Block is a part of.
	 * @return The Piece associated with the Block.
	 */
	public Piece getPiece(){
		return piece;
	}
	
	/**
	 * Method to rotate Piece around the Block called on. If the CounterClockwise boolean is True it will rotate the Piece counterclockwise around a Block, otherwise it will rotate three times to simulate Clockwise rotate.
	 * @param CounterClockwise The boolean to say if the Piece should rotate counter clockwise around this Block, or if it should rotate Clockwise.
	 */
	public void rotate(boolean CounterClockwise){
		if(CounterClockwise){
			rotateBlock(this);
		}else{
			rotateBlock(this);
			rotateBlock(this);
			rotateBlock(this);
		}
	}
	
	/**
	 * Rotate the Blocks neighbors based on the position of the Block rotate is called from in relation to the other 5 Blocks in the Piece.
	 */
	public void rotateBlock(IBlock caller){
		IBlock holder = this.west;
		this.west = this.north;
		this.north = this.east; 
		this.east = this.south;
		this.south = holder;
		if (caller != this.north && this.north.isValidBlock()) this.north.rotateBlock(this);
		if (caller != this.east && this.east.isValidBlock()) this.east.rotateBlock(this);
		if (caller != this.south && this.south.isValidBlock()) this.south.rotateBlock(this);
		if (caller != this.west && this.west.isValidBlock()) this.west.rotateBlock(this);
	}
	
	/**
	 * Flip the Piece horizontally or vertically from the Block it was called from.
	 * @param horizontal Boolean that tells if the Piece should flip horizontally or not. True means flip horizontally off of Block called on, or False means flip vertically off Block called on.
	 */
	public void flip(boolean horizontal){
		flipBlock(this, horizontal);
		return;
	}

	/**
	 * Flip the neighbors of the Blocks that the flip method is called on.
	 * @param caller The Block of the Piece that the flip is originally called on and then it's neighbor Blocks when called recursively. 
	 * @param horizontal Boolean that tells whether the Piece should flip horizontally based on caller Block, or if it should flip vertically. True means horizontal flip and False means vertical flip.
	 */
	public void flipBlock(IBlock caller, boolean horizontal){
		IBlock holder = null;
		if(horizontal){
			holder = this.east;
			this.east = this.west;
			this.west = holder;
		} else {
			holder = this.north;
			this.north = this.south;
			this.south = holder;
		}
		
		
		if(caller != this.east) if(this.east.isValidBlock()) this.east.flipBlock(this, horizontal);
		if(caller != this.west) if(this.west.isValidBlock()) this.west.flipBlock(this, horizontal);
		if(caller != this.north) if(this.north.isValidBlock()) this.north.flipBlock(this, horizontal);
		if(caller != this.south) if(this.south.isValidBlock())	this.south.flipBlock(this, horizontal);
	}

	/**
	 * Links the Northern neighbor of the Block the method is called on.
	 * @param b The Block you want to link North of current Block.
	 */
	public void linkNorth(Block b){
		north = b;
		b.south = this;
	}
	
	/**
	 * Links the Southern neighbor of the Block the method is called on.
	 * @param b The Block you want to link South of current Block.
	 */
	public void linkSouth(Block b){
		south = b;
		b.north = this;
	}
	
	/**
	 * Links the Western neighbor of the Block the method is called on.
	 * @param b The Block you want to link West of current Block.
	 */
	public void linkWest(Block b){
		west = b;
		b.east = this;
	}
	
	/**
	 * Links the Eastern neighbor of the Block the method is called on.
	 * @param b The Block you want to link East of current Block.
	 */
	public void linkEast(Block b){
		east = b;
		b.west = this;
	}

	/**
	 * Returns the Northern neighbor of the Block called on.
	 */
	@Override
	public IBlock getNorth() {
		// TODO Auto-generated method stub
		return north;
	}

	/**
	 * Returns the Southern neighbor of the Block called on.
	 */
	@Override
	public IBlock getSouth() {
		// TODO Auto-generated method stub
		return south;
	}

	/**
	 * Returns the Eastern neighbor of the Block called on.
	 */
	@Override
	public IBlock getEast() {
		// TODO Auto-generated method stub
		return east;
	}

	/**
	 * Returns the Western neighbor of the Block called on.
	 */
	@Override
	public IBlock getWest() {
		// TODO Auto-generated method stub
		return west;
	}

	/**
	 * Returns a boolean to state if this block is valid. Blocks in the Block class will always be valid (Comes from IBlock Interface).
	 */
	@Override
	public boolean isValidBlock() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
