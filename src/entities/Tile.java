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
	
	public void recieveBlock(Block block){
		this.block = block;
		return;
	}
	
	public boolean enabled(){ return isEnabled; }
	
	public void enable(){ isEnabled = true; }
	
	public void disable(){ isEnabled = false; }
	
	public IBlock removeBlock(){
		return block;
	}
}
