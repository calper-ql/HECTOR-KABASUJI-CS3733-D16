package entities;

public class Level {
	boolean isLocked;
	int levelNum;
	Bullpen bPen;
	Board board;
	boolean hints;
	
	public Level(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints){
		this.isLocked = isLocked;
		this.levelNum = levelNum;
		this.bPen = bPen;
		this.board = board;
		this.hints = hints;
		
		return;
	}
	
	
}