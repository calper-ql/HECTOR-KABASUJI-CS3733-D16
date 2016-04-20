package entities;

public class Level implements ILevel {
	boolean isLocked;
	int levelNum;
	Bullpen bPen;
	Board board;
	boolean hints;
	int stars;
	
	public Level(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints){
		this.isLocked = isLocked;
		this.levelNum = levelNum;
		this.bPen = bPen;
		this.board = board;
		this.hints = hints;
		this.stars = 0;
	}
	
	public int getLevelNum(){
		return levelNum;
	}
	
	public Bullpen getBullpen(){
		return bPen;
	}
	
	public Board getBoard(){
		return board;
	}
	
	public int getStars(){
		return stars;
	}
	
	public void setStars(int stars){
		if(stars > 0 || stars <= 3){
			this.stars = stars;
		} else this.stars = 0;
	}
	
	public boolean hasWon(){
		return false;
	}
}
