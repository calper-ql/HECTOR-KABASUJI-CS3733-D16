package entities;

public class PuzzleLevel extends Level{
	int movesTotal;
	int movesRemaining;
	
	public PuzzleLevel(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints,
			int movesTotal){
		super(hints, levelNum, bPen, board, hints);
		
		this.movesTotal = movesTotal;
		this.movesRemaining = movesTotal;
		
		return;
	}

}
