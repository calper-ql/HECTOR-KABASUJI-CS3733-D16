package entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
	
	public void setTotalMoves(int num){
		movesTotal = num;
	}
	
	public int getTotalMoves(){
		return movesTotal;
	}
	
	public int getRemainingMoves(){
		return movesRemaining;
	}
	
	public void setRemaingMoves(int num){
		movesRemaining = num;
	}

}
