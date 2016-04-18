package entities;

public class Tile {
	IBlock block;
	int row;
	int col;
	ReleaseNumber num;
	boolean isEnabled;
	
	public Tile(IBlock block, int row, int col, ReleaseNumber num, boolean isEnabled){
		this.block = block;
		this.row = row;
		this.col = col;
		this.num = num;
		this.isEnabled = isEnabled;
	}
	
	int getRow(){ return row; }
	
	int getCol(){ return col; }
	
	void recieveBlock(Block block){
		this.block = block;
		return;
	}
	
	boolean enabled(){ return isEnabled; }
	
	void enable(){ isEnabled = true; }
	
	void disable(){ isEnabled = false; }
	
	IBlock removeBlock(){
		return block;
	}
}
