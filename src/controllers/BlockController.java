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
	
	int ofsetx;
	int ofsety;
	public void sendToLevelController(IBlock ib, int x, int y){
		ofsetx = x;
		ofsety = y;
		lc.update(ib, x, y);
	}
	
	public LinkedList<JBlockPanel> getAllViews(int x, int y, boolean isOnLevel) {
		
		LinkedList<JBlockPanel> panels = all.render(block, x, y, isOnLevel);
		
		for(JBlockPanel p: panels){
			if(isOnLevel){
				p.setOfsetX(ofsetx);
				p.setOfsetY(ofsety);
			}
		}
		
		return panels;
	}
	
	public void setBlock(IBlock b){
		block = b;
	}
	
	public IBlock getBlock(){
		return block;
	}
	
	public void move(int x, int y){
		all.update(x, y);
	}
}


