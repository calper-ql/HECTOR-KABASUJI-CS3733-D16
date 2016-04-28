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
	
	public boolean hasFinished(){
		// check finish condition
		if(movesRemaining == 0){
			
			return true;
		} else return false;
	}
	
	public void updateStars(){
		int emptyTiles = 144;
		for(int c = 0; c < 12; c++){
			for(int r = 0; r < 12; r++){
				Tile curTile = board.tiles.get(c).get(r);
				if(!curTile.enabled() || curTile.hasBlock()){
					emptyTiles--; 
				}
			}
		}
		// now update the score
		if(emptyTiles > 12) setStars(0);
		if(emptyTiles <= 12) setStars(1);
		if(emptyTiles <= 6) setStars(2);
		if(emptyTiles == 0) setStars(3);
	}

}
