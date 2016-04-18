package entities;

public class Tile {
	IBlock block;
	int row;
	int col;
	ReleaseNumber num;
	boolean enabled;
	
	public Tile(IBlock block, int row, int col, ReleaseNumber num, boolean enabled){
		this.block = block;
		this.row = row;
		this.col = col;
		this.num = num;
		this.enabled = enabled;
	}
	
	void recieveBlock(Block block){
		this.block = block;
		return;
	}
	
	void enable(){ enabled = true; }
	
	void disable(){ enabled = false; }
	
	IBlock removeBlock(){
		return block;
	}
}
