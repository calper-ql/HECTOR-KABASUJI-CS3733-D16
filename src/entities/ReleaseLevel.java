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
}
