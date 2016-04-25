package controllers;

import java.util.LinkedList;
import javax.swing.JPanel;
import boundary.BlockView;
import boundary.JBlockPanel;
import entities.IBlock;

public class BlockController implements Controller{
	IBlock block;
	BlockView all;
	
	LevelController lc;
	
	public BlockController(IBlock block, LevelController lc) {
		this.block = block;
		 all = new BlockView(this);
		 this.lc = lc;
	}
	
	@Override
	public JPanel getRenderedView() {
		
		return null;
	}
	
	public LinkedList<JBlockPanel> getAllViews(int x, int y) {
		
		LinkedList<JBlockPanel> panels = all.render(block, x, y);
		
		for(JBlockPanel p: panels){
			
		}
		
		return panels;
	}

	public void pressed(JBlockPanel jBlockPanel) {
		lc.piecePressed(jBlockPanel);
	}

	public void released(JBlockPanel jBlockPanel) {
		lc.released(jBlockPanel);
		
	}
	
}


