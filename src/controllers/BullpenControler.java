/**Bullpen Controller
 *  Controller for dealing with the bullpen
 * @author Zach Armsby - zrarmsby@wpi.edu
 * @author Can Alper - calper@wpi.edu
 */
package controllers;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

import boundary.BullPenView;
import boundary.JBlockPanel;
import entities.Bullpen;
import entities.DefinedPieces;
import entities.Piece;

public class BullpenControler {
	
	BullPenView bpv;
	Bullpen bp;
	ILevelController lc;
	
	/**
	 * Class Constructor
	 * @param bp
	 * @param bc
	 * @param lc
	 */
	public BullpenControler(Bullpen bp, BlockController bc, ILevelController lc) {
		bpv = new BullPenView(6, 100, 192, 384, bp, bc, this);
		this.bp = bp;
		this.lc = lc;
	}
	
	/**
	 * returns the view associated with the JBlockPanel passed in as a parameter
	 * @param jbp
	 * @return bpv.pop(jbp)
	 */
	public LinkedList<JBlockPanel> pop(JBlockPanel jbp){
		return bpv.pop(jbp);
	}

	/**
	 * Calls the render method on the bullpen view associated with this class
	 * @return
	 */
	public JPanel render() {
		return bpv.render();
	}

	/**
	 * Gets and returns the view associated with a given JBlockPanel
	 * @param jBlockPanel
	 * @return bpv.get(jBlockPanel)
	 */
	public LinkedList<JBlockPanel> get(JBlockPanel jBlockPanel) {
		return bpv.get(jBlockPanel);
	}

	/**
	 * Adds a JBlockPanel and its associated piece to the bullpen
	 * @param jBlockPanel
	 */
	public void add(JBlockPanel jBlockPanel) {
		// TODO Auto-generated method stub
		bp.addPiece(jBlockPanel.getBlock().getPiece());
		//bpv.render();
	}

	/**
	 * Disables the press functionality in the bullpen view
	 */
	public void disablePress() {
		bpv.disablePress();
	}

	/**
	 * Enables the Builder Mode functionality in the bullpen view
	 */
	public void enableBuilderMode() {
		bpv.enableBuilderMode();
	}
	
	/**
	 * Returns the list of pieces from the bullpen view
	 * @return bpv.generatePieceList()
	 */
	public ArrayList<Piece> generatePieceList(){
		return bpv.generatePieceList();
	}
	
	/**
	 * Updates the state of the board
	 */
	public void stateUpdated(){
		lc.stateUpdated();
	}

}

