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
	
	public BullpenControler(Bullpen bp, BlockController bc, ILevelController lc) {
		bpv = new BullPenView(6, 100, 192, 384, bp, bc, this);
		this.bp = bp;
		this.lc = lc;
	}
	
	public LinkedList<JBlockPanel> pop(JBlockPanel jbp){
		return bpv.pop(jbp);
	}

	public JPanel render() {
		return bpv.render();
	}

	public LinkedList<JBlockPanel> get(JBlockPanel jBlockPanel) {
		return bpv.get(jBlockPanel);
	}

	public void add(JBlockPanel jBlockPanel) {
		// TODO Auto-generated method stub
		bp.addPiece(jBlockPanel.getBlock().getPiece());
		//bpv.render();
	}

	public void disablePress() {
		bpv.disablePress();
	}

	public void enableBuilderMode() {
		bpv.enableBuilderMode();
	}
	
	public ArrayList<Piece> generatePieceList(){
		return bpv.generatePieceList();
	}
	
	public void stateUpdated(){
		lc.stateUpdated();
	}

}

