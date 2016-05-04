package entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PuzzleLevel extends Level{
	int movesTotal;
	int movesRemaining;
	
	public PuzzleLevel(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints,
			int movesTotal){
		super(isLocked, levelNum, bPen, board, hints);
		  
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
	
	public boolean hasFinished(){
		// check finish condition
		int emptyTiles = this.getEmptyTileCount();
		if(movesRemaining <= 0 || emptyTiles <= 0){
			return true;
		} else return false;
	}
	
	public void updateStars(){
		int emptyTiles = this.getEmptyTileCount();
	
		// now update the score
		if(emptyTiles == 0) setStars(3);
		if(emptyTiles <= 6) setStars(2);
		if(emptyTiles <= 12) setStars(1);
		if(emptyTiles > 12) setStars(0);		
	}	
}
