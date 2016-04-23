package boundary;

import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.BlockController;

import java.awt.Color;
import java.awt.Point;

import entities.Block;
import entities.EmptyBlock;
import entities.IBlock;
import entities.Piece;

public class BlockView{

	int size;
	LinkedList<JBlockPanel> currentList;
	IBlock currentBlock;
	BlockController bc;
	
	public BlockView(BlockController bc){
		size = 32;
		this.bc = bc;
	}

	public LinkedList<JBlockPanel> render(IBlock block, int x, int y, boolean isOnLevel){
		LinkedList<JBlockPanel> list = new LinkedList<JBlockPanel>();
		IBlock dummyBlock = new Block(new Piece(Color.black));
		renderToList(block, dummyBlock, list, x, y, isOnLevel);
		currentList = list;
		currentBlock = block;
		return list;
	}
	
	public void renderToList(IBlock block, IBlock caller,LinkedList<JBlockPanel> list, int x, int y,  boolean isOnLevel){
		if(block.isValidBlock()){
			JBlockPanel p = new JBlockPanel(this, block);
			if(isOnLevel) p.onLevel();
			p.setBackground(((Block) block).getPiece().getColor());
			p.setBounds(x, y, size, size);
			if(p.isOnLevel()){p.setBorder(BorderFactory.createLineBorder(Color.white));}
			else {p.setBorder(BorderFactory.createLineBorder(Color.black));}
			list.add(p);
			if(caller.isValidBlock()){
				if(caller != block.getNorth())renderToList(block.getNorth(), block, list, x, y-size, isOnLevel);
				if(caller != block.getSouth())renderToList(block.getSouth(), block, list, x, y+size, isOnLevel);
				if(caller != block.getEast())renderToList(block.getEast(), block, list, x-size, y, isOnLevel);
				if(caller != block.getWest())renderToList(block.getWest(), block, list, x+size, y, isOnLevel);
			}
		}
		
	}


	public void update(int x, int y) {
		for(JBlockPanel bp: currentList){
			Point p = bp.getLocation();
			bp.setLocation(p.x + x, p.y + y);
		}
	}
	
	public void pressed(IBlock ib, int x, int y){
		bc.sendToLevelController(ib, x, y);
	}
	
}
