package entities;

public class LightningLevel extends Level{
	int totalTime;
	int timeRemaining;
	
	public LightningLevel(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints,
			int totalTime){
		super(hints, levelNum, bPen, board, hints);
		
		this.totalTime = totalTime;
		this.timeRemaining = totalTime;
		
		return;
	}

}