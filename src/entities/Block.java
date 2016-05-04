package entities;

import java.io.Serializable;
/**
 * 
 * @author Can Alper - calper@wpi.edu
 *
 */
public class Block implements IBlock, Serializable{
	Piece piece;
	
	IBlock north;
	IBlock east;
	IBlock south;
	IBlock west;
	
	public Piece getPiece(){
		return piece;
	}
	
	public Block(Piece piece){
		this.piece = piece;
		piece.addBlock(this);
		north = new EmptyBlock();
		south = new EmptyBlock();
		east = new EmptyBlock();
		west = new EmptyBlock();
	}
	
	public void rotate(boolean CounterClockwise){
		if(CounterClockwise){
			rotateBlock(this);
		}else{
			rotateBlock(this);
			rotateBlock(this);
			rotateBlock(this);
		}
	}
	
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
	
	public void flip(boolean horizontal){
		flipBlock(this, horizontal);
		return;
	}

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

	public void linkNorth(Block b){
		north = b;
		b.south = this;
	}
	
	public void linkSouth(Block b){
		south = b;
		b.north = this;
	}
	
	public void linkWest(Block b){
		west = b;
		b.east = this;
	}
	
	public void linkEast(Block b){
		east = b;
		b.west = this;
	}

	@Override
	public IBlock getNorth() {
		// TODO Auto-generated method stub
		return north;
	}

	@Override
	public IBlock getSouth() {
		// TODO Auto-generated method stub
		return south;
	}

	@Override
	public IBlock getEast() {
		// TODO Auto-generated method stub
		return east;
	}

	@Override
	public IBlock getWest() {
		// TODO Auto-generated method stub
		return west;
	}

	@Override
	public boolean isValidBlock() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
