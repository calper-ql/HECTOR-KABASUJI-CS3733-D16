package entities;

public class Tile {
	Block block;
	int row;
	int col;
	ReleaseNumber num;
	
	public Tile(Block block, int row, int col, ReleaseNumber num){
		this.block = block;
		this.row = row;
		this.col = col;
		this.num = num;
	}
	
	void recieveBlock(Block block){
		this.block = block;
		return;
	}
	
	Block removeBlock(){
		return block;
	}
}
