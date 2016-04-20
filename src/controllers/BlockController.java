package controllers;

import java.util.LinkedList;
import javax.swing.JPanel;
import boundary.BlockView;
import boundary.JBlockPanel;
import entities.IBlock;

public class BlockController implements Controller{
	IBlock block;
	BlockView all;
	
	public BlockController(IBlock block) {
		this.block = block;
		 all = new BlockView();
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

}
