package entities;

public class Tile {
	IBlock block;
	ReleaseNumber num;
	boolean isEnabled;
	
	public Tile(IBlock block, ReleaseNumber num, boolean isEnabled){
		this.block = block;
		this.num = num;
		this.isEnabled = isEnabled;
	}
	
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
