package entities;

public class LightningLevel extends Level{
	int totalTime;
	int timeRemaining;
	
	public LightningLevel(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints,
			int totalTime){
		super(hints, levelNum, bPen, board, hints, numStars);
		
		this.totalTime = totalTime;
		this.timeRemaining = 0;
	}
	
	public int getTimeRemaining(){
		return timeRemaining;
	}
	
	public int setTimeRemaining(int timeRemaining){
		this.timeRemaining = timeRemaining;
	}
	
	public boolean hasFinished(){
		int emptyTiles = 144;
		if(timeRemaining == 0){
			for(int c = 0; c < 12; c++){
				for(int r = 0; r < 12; r++){
					Tile curTile = board.tiles.get(c).get(r);
					if(!curTile.enabled() || curTile.block.){
						emptyTiles--; 
					}
				}
			}
			return true;
		} else return false;
	}
}