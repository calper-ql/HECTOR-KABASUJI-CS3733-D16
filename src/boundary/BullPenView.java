/**Bullpen View
 * This Boundary class is to render all components associated with the Bullpen View
 * @author Zach Armsby - zrarmsby@wpi.edu
 * @author Can Alper - calper@wpi.edu
 */
package boundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controllers.BlockController;
import controllers.BullpenControler;
import entities.Bullpen;
import entities.DefinedPieces;
import entities.EmptyBlock;
import entities.IBlock;
import entities.Piece;

public class BullPenView {
	int x;
	int y;
	int width;
	int height;
	Bullpen bullpen;
	BlockController bc;
	LinkedList<LinkedList<JBlockPanel>> blocks;
	ArrayList<Piece> builderList;
	ArrayList<Integer> pieceNumber;
	boolean builderMode;
	BullpenControler bullpenControler;

	JPanel panel;// = new JPanel();
	JPanel panel_1;// = new JPanel();
	JScrollPane scrollPane; // = new JScrollPane();

	/**
	 * Class Constructor. also initializes the location, size and scroll functionality of the bullpen pane
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param bullpen
	 * @param bc
	 */
	public BullPenView(int x, int y, int width, int height, Bullpen bullpen, BlockController bc, BullpenControler bullpenControler) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.bc = bc;
		this.bullpen = bullpen;
		blocks = new LinkedList<LinkedList<JBlockPanel>>();

		this.bullpenControler = bullpenControler;
		panel = new JPanel();

		scrollPane = new JScrollPane();
		scrollPane.setVisible(true);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, width, height);

		panel_1 = new JPanel();
		panel_1.setVisible(true);
		panel_1.setBackground(Color.WHITE);
		panel_1.setMaximumSize(new Dimension(100, 32767));
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		scrollPane.setViewportView(panel_1);

		panel.setBounds(x, y, width, height);
		panel.setLayout(null);
		panel.add(scrollPane);

		panel.setVisible(true);

		builderMode = false;
		pieceNumber = new ArrayList<Integer>();
		builderList = new DefinedPieces().getPieces();
	}

	/**
	 * Iterates through a list of all define pieces and adds the pieces' ID numbers to the pieceNumber list 
	 */
	public void enableBuilderMode() {
		builderMode = true;
		pieceNumber = new ArrayList<Integer>();
		builderList = new DefinedPieces().getPieces();
		for (Piece p : builderList) {
			pieceNumber.add(0);
		}

		int k = 0;
		for (Piece p : builderList) {
			for (int i = 0; i < bullpen.getSize(); i++) {
				if (p.getID() == bullpen.getPiece(i).getID()) {
					pieceNumber.set(k, pieceNumber.get(k).intValue() + 1);
				}
			}
			k++;
		}
	}

	/**
	 * Sets builderMode to false
	 */
	public void disableBuilderMode() {
		builderMode = false;
	}

	/**
	 * Returns the ArrayList of integers, pieceNumber, for use by other classes
	 * @return pieceNumber
	 */
	ArrayList<Integer> getPieceNumbers() {
		return pieceNumber;
	}

	/**
	 * Iterates through the list of elements and removes the element corresponding to jbp 
	 * @param jbp
	 * @return elements
	 */
	public LinkedList<JBlockPanel> pop(JBlockPanel jbp) {
		for (LinkedList<JBlockPanel> elements : blocks) {
			for (JBlockPanel obj : elements) {
				if (obj == jbp) {
					blocks.remove(elements);
					return elements;
				}
			}
		}
		return null;
	}

	/**
	 * Iterates through a list of elements, then through each object in a block
	 *  if an object found that is the same as the JBlockPanel passed in as a parameter,
	 *  its 'blocks' JBlock panel is returned, otherwise null is returned 
	 * @param jbp
	 * @return elements
	 */	
	public LinkedList<JBlockPanel> get(JBlockPanel jbp) {
		for (LinkedList<JBlockPanel> elements : blocks) {
			for (JBlockPanel obj : elements) {
				if (obj == jbp) {
					return elements;
				}
			}
		}
		return null;
	}

	/**
	 * Renders all components associated with the bullpen, including
	 * @return panel
	 */
	public JPanel render() {

		if (!builderMode) {
			panel_1.removeAll();
			for (int i = 0; i < bullpen.getSize(); i++) {
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

				vertical_ofset += 32 * findNorthMostDist(currentBlock);
				horizontal_ofset += 32 * findEastMostDist(currentBlock);

				blocks.add(bv.render(currentBlock, horizontal_ofset, vertical_ofset));

				for (JBlockPanel b : blocks.getLast()) {
					b.setVisible(true);
					panelToAdd.add(b);
				}

				panelToAdd.setPreferredSize(new Dimension(100, 32 * 6));
				panel_1.add(panelToAdd);

			}
			return panel;
		} else {
			panel_1.removeAll();
			for (int i = 0; i < builderList.size(); i++) {
				BlockView bv = new BlockView(bc);
				JPanel panelToAdd = new JPanel();
				panelToAdd.setBorder(BorderFactory.createLineBorder(Color.black));
				panelToAdd.setLayout(null);
				IBlock currentBlock = null;
				try {
					currentBlock = builderList.get(i).getBlock(0);
				} catch (Exception e) {
					e.printStackTrace();
				}

				int vertical_ofset = 30;
				int horizontal_ofset = 0;

				vertical_ofset += 32 * findNorthMostDist(currentBlock);
				horizontal_ofset += 32 * findEastMostDist(currentBlock);

				blocks.add(bv.render(currentBlock, horizontal_ofset, vertical_ofset));

				for (JBlockPanel b : blocks.getLast()) {
					b.setVisible(true);
					panelToAdd.add(b);
				}
				
				JSpinner sp = new JSpinner(new SpinnerNumberModel(pieceNumber.get(i).intValue(), 0, 1000,1));
				sp.setBounds(0, 5, 50, 20);
				sp.setVisible(true);
				
				final int k = i;
				
				sp.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent arg0) {
						int val = (int) ((JSpinner)arg0.getSource()).getValue();
						pieceNumber.set(k, new Integer(val));
						bullpenControler.stateUpdated();
					}
			    });
				
				panelToAdd.add(sp);

				panelToAdd.setPreferredSize(new Dimension(120, 32 * 7));
				panel_1.add(panelToAdd);

			}
			return panel;
		}

	}

	/**
	 * a BMARK consists of a distance, boolean value and IBlock
	 * @author 
	 *
	 */
	public class BMARK {
		int dist;
		boolean mark;
		IBlock block;

		public BMARK(IBlock block, int dist) {
			this.block = block;
			this.mark = false;
			this.dist = dist;
		}

		public int getDist() {
			return dist;
		}

		public boolean isMarked() {
			return mark;
		}

		public void doMark() {
			mark = true;
		}

		public IBlock getBlock() {
			return block;
		}
	}

	/**
	 * Iterates through a list of BMARKs to find the eastmost item
	 * @param caller
	 * @return biggest
	 */
	public int findEastMostDist(IBlock caller) {
		LinkedList<BMARK> list = new LinkedList<BMARK>();
		BMARK first = new BMARK(caller, 0);
		list.add(first);
		findEastMostDistHelper(first, list, new EmptyBlock());
		int biggest = 0;
		for (BMARK item : list) {
			if (item.getDist() > biggest) {
				biggest = item.getDist();
			}
		}
		return biggest;
	}

	/**
	 * Iterates through a list of BMARKs to find the northmost item
	 * @param caller
	 * @return biggest
	 */
	public int findNorthMostDist(IBlock caller) {
		LinkedList<BMARK> list = new LinkedList<BMARK>();
		BMARK first = new BMARK(caller, 0);
		list.add(first);
		findNorthMostDistHelper(first, list, new EmptyBlock());
		int biggest = 0;
		for (BMARK item : list) {
			if (item.getDist() > biggest) {
				biggest = item.getDist();
			}
		}
		return biggest;
	}

	/**
	 * Iterates through a list of BMARKs to find the eastmost dist helper
	 * @param caller
	 * @return biggest
	 */
	public void findEastMostDistHelper(BMARK caller, LinkedList<BMARK> list, IBlock last) {
		IBlock callerN = caller.getBlock().getNorth();
		IBlock callerS = caller.getBlock().getSouth();
		IBlock callerE = caller.getBlock().getEast();
		IBlock callerW = caller.getBlock().getWest();

		if (callerN != last && callerN.isValidBlock()) {
			BMARK next = new BMARK(callerN, caller.getDist());
			list.add(next);
			findEastMostDistHelper(next, list, caller.getBlock());
		}

		if (callerS != last && callerS.isValidBlock()) {
			BMARK next = new BMARK(callerS, caller.getDist());
			list.add(next);
			findEastMostDistHelper(next, list, caller.getBlock());
		}

		if (callerE != last && callerE.isValidBlock()) {
			BMARK next = new BMARK(callerE, caller.getDist() + 1);
			list.add(next);
			findEastMostDistHelper(next, list, caller.getBlock());
		}

		if (callerW != last && callerW.isValidBlock()) {
			BMARK next = new BMARK(callerW, caller.getDist() - 1);
			list.add(next);
			findEastMostDistHelper(next, list, caller.getBlock());
		}

	}

	/**
	 * Iterates through a list of BMARKs to find the northmost dist helper
	 * @param caller
	 * @return biggest
	 */
	public void findNorthMostDistHelper(BMARK caller, LinkedList<BMARK> list, IBlock last) {
		IBlock callerN = caller.getBlock().getNorth();
		IBlock callerS = caller.getBlock().getSouth();
		IBlock callerE = caller.getBlock().getEast();
		IBlock callerW = caller.getBlock().getWest();

		if (callerN != last && callerN.isValidBlock()) {
			BMARK next = new BMARK(callerN, caller.getDist() + 1);
			list.add(next);
			findNorthMostDistHelper(next, list, caller.getBlock());
		}

		if (callerS != last && callerS.isValidBlock()) {
			BMARK next = new BMARK(callerS, caller.getDist() - 1);
			list.add(next);
			findNorthMostDistHelper(next, list, caller.getBlock());
		}

		if (callerE != last && callerE.isValidBlock()) {
			BMARK next = new BMARK(callerE, caller.getDist());
			list.add(next);
			findNorthMostDistHelper(next, list, caller.getBlock());
		}

		if (callerW != last && callerW.isValidBlock()) {
			BMARK next = new BMARK(callerW, caller.getDist());
			list.add(next);
			findNorthMostDistHelper(next, list, caller.getBlock());
		}

	}

	/**
	 * Iterates through a list of elements, 
	 * and disables press functionality on each block
	 */
	public void disablePress() {
		for (LinkedList<JBlockPanel> elements : blocks) {
			for (JBlockPanel obj : elements) {
				obj.disablePress();
			}
		}
	}
	
	/**
	 * Generates a list of defined pieces
	 * @return
	 */
	public ArrayList<Piece> generatePieceList(){
		ArrayList<Piece> list = new ArrayList<Piece>();
			for(int i = 0; i < pieceNumber.size(); i++){
				for(int k = 0; k < pieceNumber.get(i).intValue(); k++){
					ArrayList<Piece> tempList = new DefinedPieces().getPieces();
					list.add(tempList.get(i));
				}
			}
		return list;
	}

}
