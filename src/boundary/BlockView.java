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

public class BlockView {

	int size;
	LinkedList<JBlockPanel> currentList;
	IBlock currentBlock;
	BlockController bc;
	
	public BlockView(BlockController bc){
		size = 32;
		this.bc = bc;
	}

	public LinkedList<JBlockPanel> render(IBlock block, int x, int y){
		LinkedList<JBlockPanel> list = new LinkedList<JBlockPanel>();
		IBlock dummyBlock = new Block(new Piece(Color.black, 0));
		renderToList(block, dummyBlock, list, x, y);
		currentList = list;
		currentBlock = block;
		return list;
	}
	
	public void renderToList(IBlock block, IBlock caller,LinkedList<JBlockPanel> list, int x, int y){
		if(block.isValidBlock()){
			JBlockPanel p = new JBlockPanel(this, block);
			p.setBackground(((Block) block).getPiece().getColor());
			p.setBounds(x, y, size, size);
			p.setBorder(BorderFactory.createLineBorder(Color.black));
			list.add(p);
			if(caller.isValidBlock()){
				if(caller != block.getNorth())renderToList(block.getNorth(), block, list, x, y-size);
				if(caller != block.getSouth())renderToList(block.getSouth(), block, list, x, y+size);
				if(caller != block.getEast())renderToList(block.getEast(), block, list, x-size, y);
				if(caller != block.getWest())renderToList(block.getWest(), block, list, x+size, y);
			}
		}
		
	}

	public void updateLocation(int x, int y) {
		for(JBlockPanel bp: currentList){
			Point p = bp.getLocation();
			bp.setLocation(p.x + x, p.y + y);
		}
	}
	
	public void updateTransform(JBlockPanel currentPanel) {
		updateTransformRecursive(currentPanel, currentPanel);
	}
	
	public void updateTransformRecursive(JBlockPanel currentPanel, JBlockPanel caller) {
		Point p = currentPanel.getLocation();
		
		IBlock north = currentPanel.getBlock().getNorth();
		IBlock south = currentPanel.getBlock().getSouth();
		IBlock east = currentPanel.getBlock().getEast();
		IBlock west = currentPanel.getBlock().getWest();
		
		JBlockPanel northPanel = null;
		JBlockPanel southPanel = null;
		JBlockPanel eastPanel = null;
		JBlockPanel westPanel = null;
		
		if(north.isValidBlock()) northPanel = this.seachForPanel(north);
		if(south.isValidBlock()) southPanel = this.seachForPanel(south);
		if(east.isValidBlock()) eastPanel = this.seachForPanel(east);
		if(west.isValidBlock()) westPanel = this.seachForPanel(west);
		
		if(north.isValidBlock() && northPanel != caller){
			northPanel.setLocation(p.x, p.y - size);
			updateTransformRecursive(northPanel, currentPanel);
		}
		
		if(south.isValidBlock() && southPanel != caller){
			southPanel.setLocation(p.x, p.y + size);
			updateTransformRecursive(southPanel, currentPanel);
		}
		
		if(east.isValidBlock() && eastPanel != caller){
			eastPanel.setLocation(p.x- size, p.y);
			updateTransformRecursive(eastPanel, currentPanel);
		}
		
		if(west.isValidBlock() && westPanel != caller){
			westPanel.setLocation(p.x + size, p.y);
			updateTransformRecursive(westPanel, currentPanel);
		}
		
	}
	
	public JBlockPanel seachForPanel(IBlock block){
		for(JBlockPanel bp: currentList){
			if(bp.getBlock() == block)
				return bp;
		}
		return null;
	}

	public void pressed(JBlockPanel jBlockPanel) {
		bc.pressed(jBlockPanel);
	}

	public void released(JBlockPanel jBlockPanel) {
		bc.released(jBlockPanel);
	}
	
}
