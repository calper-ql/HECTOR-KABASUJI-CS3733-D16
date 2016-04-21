package entities;

public class LightningLevel extends Level{
	int totalTime;
	int timeRemaining;
	
	public LightningLevel(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints,
			int totalTime){
		super(hints, levelNum, bPen, board, hints);
		
		this.totalTime = totalTime;
		this.timeRemaining = totalTime;
	}
	
	public int getTimeRemaining(){
		return timeRemaining;
	}
	
	public void setTimeRemaining(int timeRemaining){
		this.timeRemaining = timeRemaining;
	}
	
	public boolean hasFinished(){
		int emptyTiles = 144;
		// check finish condition
		if(timeRemaining == 0){
			for(int c = 0; c < 12; c++){
				for(int r = 0; r < 12; r++){
					Tile curTile = board.tiles.get(c).get(r);
					if(!curTile.enabled() || curTile.block.isValidBlock()){
						emptyTiles--; 
					}
				}
			}
			// now update the score
			if(emptyTiles > 12) setStars(0);
			if(emptyTiles <= 12) setStars(1);
			if(emptyTiles <= 6) setStars(2);
			if(emptyTiles == 0) setStars(3);
			return true;
		} else return false;
	}
}