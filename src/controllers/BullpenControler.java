package controllers;

import java.util.LinkedList;

import javax.swing.JPanel;

import boundary.BullPenView;
import boundary.JBlockPanel;
import entities.Bullpen;

public class BullpenControler {
	
	BullPenView bpv;
	
	public BullpenControler(Bullpen bp, BlockController bc) {
		bpv = new BullPenView(6, 100, 192, 384, bp, bc);
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

}

