package move;
import java.util.LinkedList;
import entities.Block;
import entities.IBlock;
import entities.Tile;
//Michael Harney
public class OverlayMove implements IMove{
	LinkedList<IBlock> blist;
	LinkedList<Tile> tlist;
	LinkedList<Tile> formertiles; //these represent all tiles that were covered so that when we hit 'undo', we can get them back in their former states.

	public OverlayMove(LinkedList<IBlock> blist, LinkedList<Tile> tlist) {
		this.blist = blist;
		this.tlist = tlist;
		this.formertiles = new LinkedList<Tile>();
	}
	
/*	@Override*/
	public boolean doMove() {
		if (!this.valid()) { return false; } //just a formality		
		for(int i = 0; i < 6; i++){
			Tile t = tlist.get(i);
			this.formertiles.addLast(t);
			tlist.get(i).setBlock(blist.get(i));
		}		
		return true;
	}

	//@Override
	public boolean undo() {
		/*for(int i = 0; i < 6; i++){
			
		}*/
		this.tlist = this.formertiles;
		return true;
	}

	//@Override
	public boolean valid() {
		for(Tile t : tlist){
			if(!t.enabled()){
				return false;
			}
		}
		return true;
	}

}
