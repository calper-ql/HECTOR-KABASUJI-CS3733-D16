package entities;

import java.util.ArrayList;

public class ReleaseLevel extends Level{
	ArrayList<ReleaseNumberSet> sets;
	
	public ReleaseLevel(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints,
			ArrayList<ReleaseNumberSet> sets){
		super(hints, levelNum, bPen, board, hints);
		
		this.sets = sets;
		
		return;
	}
	
	public int getCompleteSets(){
		int result = 0;
		for(int i = 0; i < 3; i++){
			if(sets.get(i).isComplete()) result++;
		}
		return result;
	}
	
	public int getRemainingSets(){
		int result = 0;
		for(int i = 0; i < 3; i++){
			if(!sets.get(i).isComplete()) result++;
		}
		return result;
	}
	
	public boolean hasFinished(){
		//check finish condition
		if(this.getCompleteSets() == 3)
	}
}
