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
	
	public boolean hasWon(){
		int emptyTiles = 144;
		if(timeRemaining == 0){
			for(int i = 0; i < 144; i++){
				
			}
		} else return false;
	}
}