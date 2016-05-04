/**Block Controller
 * This controller class handles all push events and view updates for blocks
 */
package controllers;

import java.util.LinkedList;
import javax.swing.JPanel;
import boundary.BlockView;
import boundary.JBlockPanel;
import entities.IBlock;

public class BlockController implements IController{
	IBlock block;
	BlockView all;
	
	ILevelController lc;
	
	/**
	 * Class constructor
	 * @param block
	 * @param lc
	 */
	public BlockController(IBlock block, ILevelController lc) {
		this.block = block;
		 all = new BlockView(this);
		 this.lc = lc;
	}
	
	/**
	 * returns the rendered view for a block for use by classes in other packages
	 */
	@Override
	public JPanel getRenderedView() {
		
		return null;
	}
	
	/**
	 * Returns the list of all rendered JBlockPanels
	 * @param x
	 * @param y
	 * @return panels
	 */
	public LinkedList<JBlockPanel> getAllViews(int x, int y) {
		LinkedList<JBlockPanel> panels = all.render(block, x, y);
		for(JBlockPanel p: panels){}
		return panels;
	}

	/**
	 * Calls the piece pressed method on a given JBlockPanel passed in as a parameter
	 * @param jBlockPanel
	 */
	public void pressed(JBlockPanel jBlockPanel) {
		lc.piecePressed(jBlockPanel);
	}

	/**
	 * Calls the piece released method on a given JBlockPanel passed in as a parameter
	 * @param jBlockPanel
	 */
	public void released(JBlockPanel jBlockPanel) {
		lc.pieceReleased(jBlockPanel);
		
	}
	
}


