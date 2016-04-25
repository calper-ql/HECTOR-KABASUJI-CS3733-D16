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
import entities.EmptyBlock;
import entities.IBlock;

public class BullPenView {
	int x;
	int y;
	int width;
	int height;
	Bullpen bullpen;
	BlockController bc;
	LinkedList<LinkedList<JBlockPanel>> blocks;
	
	
	JPanel panel;
	JScrollPane scrollPane;
	JPanel panel_1;
	
	
	
	//int scrollPosition = 0;
	
	public BullPenView(int x, int y, int width, int height, Bullpen bullpen, BlockController bc){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.bc = bc;
		this.bullpen = bullpen;
		blocks = new LinkedList<LinkedList<JBlockPanel>>();
		
		this.panel = new JPanel();
		this.panel_1 = new JPanel();
		this.scrollPane = new JScrollPane();
		
		scrollPane.setVisible(true);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, width, height);
		
		//panel_1 = new JPanel();
		panel_1.setVisible(true);
		panel_1.setBackground(Color.WHITE);
		panel_1.setMaximumSize(new Dimension(100, 32767));
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane.setViewportView(panel_1);
		
		panel.setBounds(x, y, width, height);
		panel.setLayout(null);
		panel.add(scrollPane);
		
	}
	
	public LinkedList<JBlockPanel> pop(JBlockPanel jbp){
		for(LinkedList<JBlockPanel> elements: blocks){
			for(JBlockPanel obj: elements){
				if(obj == jbp){
					blocks.remove(elements);
					return elements;
				}
			}
		}
		return null;
	}
	
	public LinkedList<JBlockPanel> get(JBlockPanel jbp) {
		for(LinkedList<JBlockPanel> elements: blocks){
			for(JBlockPanel obj: elements){
				if(obj == jbp){
					return elements;
				}
			}
		}
		return null;
	}
	
	public JPanel render(){
		panel_1.removeAll();
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
			
			int vertical_ofset = 0;
			int horizontal_ofset = 0;
			
			vertical_ofset += 32*findNorthMostDist(currentBlock);
			horizontal_ofset += 32*findEastMostDist(currentBlock);
			
			blocks.add(bv.render(currentBlock, horizontal_ofset, vertical_ofset));
			
			for(JBlockPanel b: blocks.getLast()){
				b.setVisible(true);
				panelToAdd.add(b);
			}
			
			panelToAdd.setPreferredSize(new Dimension(100, 32*6));
			panel_1.add(panelToAdd);
			
		}
	
		panel.setVisible(true);
		
		return panel;
	}
	
	public class BMARK{
		int dist;
		boolean mark;
		IBlock block;
		public BMARK(IBlock block, int dist){
			this.block = block;
			this.mark = false;
			this.dist = dist;
		}
		public int getDist(){return dist;}
		public boolean isMarked(){return mark;}
		public void doMark(){mark = true;}
		public IBlock getBlock(){return block;}
	}
	
	public int findEastMostDist(IBlock caller){
		LinkedList<BMARK> list = new LinkedList<BMARK>();
		BMARK first = new BMARK(caller, 0);
		list.add(first);
		findEastMostDistHelper(first, list, new EmptyBlock());
		int biggest = 0;
		for(BMARK item: list){
			if(item.getDist() > biggest){
				biggest = item.getDist();
			}
		}
		return biggest;
	}
	
	public int findNorthMostDist(IBlock caller){
		LinkedList<BMARK> list = new LinkedList<BMARK>();
		BMARK first = new BMARK(caller, 0);
		list.add(first);
		findNorthMostDistHelper(first, list, new EmptyBlock());
		int biggest = 0;
		for(BMARK item: list){
			if(item.getDist() > biggest){
				biggest = item.getDist();
			}
		}
		return biggest;
	}
	
	public void findEastMostDistHelper(BMARK caller, LinkedList<BMARK> list, IBlock last){
		IBlock callerN = caller.getBlock().getNorth();
		IBlock callerS = caller.getBlock().getSouth();
		IBlock callerE = caller.getBlock().getEast();
		IBlock callerW = caller.getBlock().getWest();
		
		if(callerN != last && callerN.isValidBlock()){
			BMARK next = new BMARK(callerN, caller.getDist());
			list.add(next);
			findEastMostDistHelper(next, list, caller.getBlock());
		}
		
		if(callerS != last && callerS.isValidBlock()){
			BMARK next = new BMARK(callerS, caller.getDist());
			list.add(next);
			findEastMostDistHelper(next, list, caller.getBlock());
		}
		
		if(callerE != last && callerE.isValidBlock()){
			BMARK next = new BMARK(callerE, caller.getDist() + 1);
			list.add(next);
			findEastMostDistHelper(next, list, caller.getBlock());
		}
		
		if(callerW != last && callerW.isValidBlock()){
			BMARK next = new BMARK(callerW, caller.getDist() - 1);
			list.add(next);
			findEastMostDistHelper(next, list, caller.getBlock());
		}
		
		
	}
	
	public void findNorthMostDistHelper(BMARK caller, LinkedList<BMARK> list, IBlock last){
		IBlock callerN = caller.getBlock().getNorth();
		IBlock callerS = caller.getBlock().getSouth();
		IBlock callerE = caller.getBlock().getEast();
		IBlock callerW = caller.getBlock().getWest();

		if(callerN != last && callerN.isValidBlock()){
			BMARK next = new BMARK(callerN, caller.getDist()+1);
			list.add(next);
			findNorthMostDistHelper(next, list, caller.getBlock());
		}
		
		if(callerS != last && callerS.isValidBlock()){
			BMARK next = new BMARK(callerS, caller.getDist()-1);
			list.add(next);
			findNorthMostDistHelper(next, list, caller.getBlock());
		}
		
		if(callerE != last && callerE.isValidBlock()){
			BMARK next = new BMARK(callerE, caller.getDist());
			list.add(next);
			findNorthMostDistHelper(next, list, caller.getBlock());
		}
		
		if(callerW != last && callerW.isValidBlock()){
			BMARK next = new BMARK(callerW, caller.getDist());
			list.add(next);
			findNorthMostDistHelper(next, list, caller.getBlock());
		}
		
		
	}

	public void add(LinkedList<JBlockPanel> list) {
		blocks.add(list);
		
	}
	
}
