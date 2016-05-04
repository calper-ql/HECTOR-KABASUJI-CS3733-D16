/** Overlay Move
 * @author Mike Harney - mdharney@wpi.edu
 * @author Can Alper - calper@wpi.edu
 */
package move;
import java.util.LinkedList;
import entities.Block;
import entities.IBlock;
import entities.Tile;


public class OverlayMove implements IMove{
	LinkedList<IBlock> blist;
	LinkedList<Tile> tlist;
	LinkedList<Tile> formertiles; //these represent all tiles that were covered so that when we hit 'undo', we can get them back in their former states.

	/**
	 * Class constructor
	 * @param blist
	 * @param tlist
	 */
	public OverlayMove(LinkedList<IBlock> blist, LinkedList<Tile> tlist) {
		this.blist = blist;
		this.tlist = tlist;
		this.formertiles = new LinkedList<Tile>();
	}
	
	/**
	 * Checks to ensure that the move is valid, if so the current list of tiles is updated
	 */
	public boolean doMove() {
		if (!this.valid()) { return false; } //just a formality		
		for(int i = 0; i < 6; i++){
			Tile t = tlist.get(i);
			this.formertiles.addLast(t);
			tlist.get(i).setBlock(blist.get(i));
		}		
		return true;
	}

	/**
	 * sets the current list of tiles to the former list 
	 */
	public boolean undo() {
		/*for(int i = 0; i < 6; i++){
			
		}*/
		this.tlist = this.formertiles;
		return true;
	}

	/**
	 *  checks to make sure a move is valid
	 */
	public boolean valid() {
		for(Tile t : tlist){
			if(!t.enabled()){
				return false;
			}
		}
		return true;
	}

}
