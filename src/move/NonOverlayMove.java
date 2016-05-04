/** NonOverlayMove
 * 
 * 
 * @author Mike Harney - mdharney@wpi.edu
 * @author Can Alper - calper@wpi.edu
 */

package move;
import java.util.LinkedList;
import entities.Block;
import entities.IBlock;
import entities.Tile;

public class NonOverlayMove implements IMove{
	LinkedList<IBlock> blist;
	LinkedList<Tile> tlist;
	LinkedList<Tile> formertiles; //these represent all tiles that were covered so that when we hit 'undo', we can get them back in their former states.

	/**
	 * Class constructor
	 * @param blist
	 * @param tlist
	 */
	public NonOverlayMove(LinkedList<IBlock> blist, LinkedList<Tile> tlist) {
		this.blist = blist;
		this.tlist = tlist;
		this.formertiles = new LinkedList<Tile>();
	}
	
	
	/**
	 * If a move is valid, the list of tiles is updated to reflect this move
	 */
	public boolean doMove() {
		if (!this.valid()) { return false; } 		
		for(int i = 0; i < 6; i++){
			tlist.get(i).setBlock(blist.get(i));
		}
		return true;
	}


	/**
	 * in order to undo, sets the current list of tiles to be equal to the former list of tiles
	 */
	public boolean undo() {
		this.tlist = this.formertiles;
		return true;
	}

	/**
	 * checks to see if a move is valid, by ensuring that a tile does not already have a block, and is enabled
	 */
	public boolean valid() {
		for(Tile t : tlist){
			if(t.hasBlock() || !t.enabled()){
				return false;
			}
		}
		return true;
	}

}
