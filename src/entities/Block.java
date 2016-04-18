package entities;

public class Block implements IBlock{
	Piece piece;
	
	IBlock north;
	IBlock east;
	IBlock south;
	IBlock west;
	
	public Block(Piece piece){
		this.piece = piece;
	}
	
	public void rotate(){
		rotateBlock(this);
		return;
	}
	public void rotateBlock(IBlock caller){
		
		IBlock holder;
		holder = this.east;
		
		this.east = this.north;
		this.north = this.west;
		this.west = this.south;
		this.south = holder;
		
		if (caller != this.north){
			this.north.rotateBlock(this);
		}
		if (caller != this.east){
			this.east.rotateBlock(this);
		}
		if (caller != this.south){
			this.south.rotateBlock(this);
		}
		if (caller != this.west){
			this.west.rotateBlock(this);
		}
		return;
	}
	
	public void flip(){
		flipBlock(this);
		return;
	}
	public void flipBlock(IBlock caller){
		IBlock holder;
		holder = this.east;
		
		this.east = this.west;
		this.west = holder;
		
		if (caller != this.west){
			this.west.flipBlock(this);
		}
		if (caller != this.east){
			this.east.flipBlock(this);
		}
		
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

	
}
