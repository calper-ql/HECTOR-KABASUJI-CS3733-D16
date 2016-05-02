package entities;

import java.util.ArrayList;
import java.util.LinkedList;

public class ReleaseLevel extends Level{
	ArrayList<ReleaseNumberSet> sets = new ArrayList<ReleaseNumberSet>(3);
		
	public ReleaseLevel(boolean isLocked, int levelNum, Bullpen bPen, Board board, boolean hints,
			ArrayList<ReleaseNumberSet> sets){
		super(hints, levelNum, bPen, board, hints);
		
		sets.add(new ReleaseNumberSet(0, new LinkedList<ReleaseNumber>()));
		sets.add(new ReleaseNumberSet(1, new LinkedList<ReleaseNumber>()));
		sets.add(new ReleaseNumberSet(2, new LinkedList<ReleaseNumber>()));
		this.sets = sets;
	}
	
	public void resetSets(){
		this.sets.get(0).resetSet();
		this.sets.get(1).resetSet();
		this.sets.get(2).resetSet();
	}
	
	public boolean addReleaseNumber(ReleaseNumber num){
		return sets.get(0).addNumber(num) 
				|| sets.get(1).addNumber(num) 
				|| sets.get(2).addNumber(num);
	}
	
	public boolean removeReleaseNumber(ReleaseNumber num){
		return sets.get(0).removeNumber(num)
				|| sets.get(1).removeNumber(num)
				|| sets.get(2).removeNumber(num);
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
		int completeSets = this.getCompleteSets();
		if(completeSets == 3 || bPen.getSize() == 0) return true;
		else return false;
	}
	
	public void updateStars(){
		int completeSets = this.getCompleteSets();
		if(completeSets == 0) setStars(0);
		if(completeSets == 1) setStars(1);
		if(completeSets == 2) setStars(2);
		if(completeSets == 3) setStars(3);
	}

	public int getRemainingMoves() {
		// TODO Auto-generated method stub
		return 0;
	}
}
