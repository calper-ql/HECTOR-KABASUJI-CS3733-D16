package entities;

import java.awt.Color;
import java.io.Serializable;

/**
 * The Tile is within the Board of the Level and contains a Block and relevant state.
 * @author Can Alper - calper@wpi.edu
 *
 */
public class Tile implements Serializable {
	IBlock block;
	ReleaseNumber num;
	boolean isEnabled;
	boolean _isHintTile;
	
	/**
	 * The Tiles are held within a Board in a Level and contain Blocks that are part of Pieces.
	 * @param block The Block that the Tile holds state of.
	 * @param num The number associated with the Tile. By Default is Empty Release Number.
	 * @param isEnabled The boolean that says whether a Tile is on or off.
	 */
	public Tile(IBlock block, ReleaseNumber num, boolean isEnabled){
		this.block = block;
		this.num = num;
		this.isEnabled = isEnabled;
	}
	
	/**
	 * Toggles a Tile to contain a hint.
	 */
	public void enableHintTile(){
		this._isHintTile = true;
	}
	
	/**
	 * Toggles a Tile to remove a hint.
	 */
	public void disableHintTile(){
		this._isHintTile = false;
	}
	
	/**
	 * Method to say if a Tile is a hint or not.
	 * @return True if the Tile is a hint Tile, False if it is not.
	 */
	public boolean isHintTile(){
		return _isHintTile;
	}
	
	/**
	 * Sets what Block a Tile holds.
	 * @param block The Block the Tile must be aware of.
	 */
	public void setBlock(IBlock block){
		this.block = block;
		return;
	}
	
	/**
	 * If the Tile is an Empty Release Number it changes its enabled or disabled state. 
	 * If it holds a Release Number that is not Empty Release Number it cycles through every number and color for the three Number Sets.
	 */
	public void iterateState(){
		if(num instanceof EmptyReleaseNumber){
			if(!isEnabled) enable();
			else disable();
		}else{
			if(!isEnabled) enable();
			else{
				if(num.getNum() >= 6 && num.getColor() >= 2){
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
	
	/**
	 * 
	 * @return
	 */
	public ReleaseNumber getReleaseNumber(){
		return num;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean enabled(){ return isEnabled; }
	
	/**
	 * 
	 */
	public void enable(){ isEnabled = true; }
	
	/**
	 * 
	 */
	public void disable(){ isEnabled = false; }
	
	/**
	 * 
	 * @return
	 */
	public boolean hasBlock(){
		return block.isValidBlock();
	}
	
	/**
	 * 
	 * @return
	 */
	public IBlock getBlock(){
		return block;
	}
	
	/**
	 * 
	 * @return
	 */
	public IBlock removeBlock(){
		IBlock temp = block;
		block = new EmptyBlock();
		return temp;
	}

}
