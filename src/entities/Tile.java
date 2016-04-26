package entities;

import java.awt.Color;
import java.io.Serializable;

public class Tile implements Serializable {
	IBlock block;
	ReleaseNumber num;
	boolean isEnabled;
	
	public Tile(IBlock block, ReleaseNumber num, boolean isEnabled){
		this.block = block;
		this.num = num;
		this.isEnabled = isEnabled;
	}
	
	public void setBlock(IBlock block){
		this.block = block;
		return;
	}
	
	public void iterateState(){
		if(num instanceof EmptyReleaseNumber){
			if(!isEnabled) enable();
			if(isEnabled) disable();
		}else{
			if(!isEnabled) enable();
			else{
				if(num.getNum() == 6 && num.getColor() == 2){
					num.setNum(0);
					num.setColor(0);
					disable();
				}else{
					if(num.getNum() == 6){
						num.setColor(num.getColor()+1);
						num.setNum(1);
					}else{
						num.setNum(num.getNum()+1);
					}
				
				}
			}
		}
	}
	
	public ReleaseNumber getReleaseNumber(){
		return num;
	}
	
	public boolean enabled(){ return isEnabled; }
	
	public void enable(){ isEnabled = true; }
	
	public void disable(){ isEnabled = false; }
	
	public boolean hasBlock(){
		return block.isValidBlock();
	}
	
	public IBlock getBlock(){
		return block;
	}
	
	public IBlock removeBlock(){
		IBlock temp = block;
		block = new EmptyBlock();
		return temp;
	}

}
