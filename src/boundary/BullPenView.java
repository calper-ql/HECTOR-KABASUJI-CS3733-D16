package boundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import controllers.BlockController;
import entities.Bullpen;
import entities.IBlock;

public class BullPenView {
	int x;
	int y;
	int width;
	int height;
	Bullpen bullpen;
	BlockController bc;
	
	public BullPenView(int x, int y, int width, int height, Bullpen bullpen, BlockController bc){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.bc = bc;
		this.bullpen = bullpen;
	}
	
	public JPanel render(){
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, width, height);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setMaximumSize(new Dimension(100, 32767));
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane.setViewportView(panel_1);
		
		panel.setBounds(x, y, width, height);
		panel.setLayout(null);
		panel.add(scrollPane);
	
		for(int i = 0; i < bullpen.getSize(); i++){
			BlockView bv = new BlockView(bc);
			JPanel panelToAdd = new JPanel();
			panelToAdd.setBorder(BorderFactory.createLineBorder(Color.black));
			panelToAdd.setLayout(null);
			IBlock currentBlock = null;
			try {
				currentBlock = bullpen.getPiece(i).getBlock(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			IBlock vertical = currentBlock;
			IBlock horizontal = currentBlock;
			
			int vertical_ofset = -32;
			int horizontal_ofset = -32;
			
			while(vertical.isValidBlock()){
				vertical_ofset += 32;
				vertical = vertical.getNorth();
			}
			
			while(horizontal.isValidBlock()){
				horizontal_ofset += 32;
				horizontal = horizontal.getEast();
			}
			
			LinkedList<JBlockPanel> blocks = bv.render(currentBlock, horizontal_ofset, vertical_ofset, false);
			
			for(JBlockPanel b: blocks){
				panelToAdd.add(b);
			}
			
			panelToAdd.setPreferredSize(new Dimension(100, 32*6));
			panel_1.add(panelToAdd);
			
		}
	
		
		
		return panel;
	}
}
