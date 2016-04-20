package boundary;

import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	public BlockView(){
		size = 32;
	}
	

	public LinkedList<JBlockPanel> render(IBlock block, int x, int y){
		LinkedList<JBlockPanel> list = new LinkedList<JBlockPanel>();
		IBlock dummyBlock = new Block(new Piece(Color.black));
		renderToList(block, dummyBlock, list, x, y);
		currentList = list;
		currentBlock = block;
		return list;
	}
	
	public void renderToList(IBlock block, IBlock caller,LinkedList<JBlockPanel> list, int x, int y){
		if(block.isValidBlock()){
			JBlockPanel p = new JBlockPanel(this);
			p.setBackground(((Block) block).getPiece().getColor());
			p.setBounds(x, y, size, size);
			p.setBorder(BorderFactory.createLineBorder(Color.black));
			list.add(p);
			System.out.println(block);
			if(caller.isValidBlock()){
				if(caller != block.getNorth())renderToList(block.getNorth(), block, list, x, y-size);
				if(caller != block.getSouth())renderToList(block.getSouth(), block, list, x, y+size);
				if(caller != block.getEast())renderToList(block.getEast(), block, list, x-size, y);
				if(caller != block.getWest())renderToList(block.getWest(), block, list, x+size, y);
			}
		}
		
	}


	public void update(int x, int y) {
		for(JBlockPanel bp: currentList){
			Point p = bp.getLocation();
			bp.setLocation(p.x + x, p.y + y);
		}
	}
	
}
