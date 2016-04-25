package controllers;

import java.util.LinkedList;

import javax.swing.JPanel;

import boundary.BullPenView;
import boundary.JBlockPanel;
import entities.Bullpen;

public class BullpenControler {
	
	BullPenView bpv;
	Bullpen bp;
	
	public BullpenControler(Bullpen bp, BlockController bc) {
		bpv = new BullPenView(6, 100, 192, 384, bp, bc);
		this.bp = bp;
	}
	
	public LinkedList<JBlockPanel> pop(JBlockPanel jbp){
		try {
			bp.removePiece(jbp.getBlock().getPiece());
		} catch (Exception e) {
			System.out.println("piece remove error bullpen controller");
			e.printStackTrace();
		}
		return bpv.pop(jbp);
	}

	public JPanel render() {
		return bpv.render();
	}

	public LinkedList<JBlockPanel> get(JBlockPanel jBlockPanel) {
		return bpv.get(jBlockPanel);
	}
	
	public void add(LinkedList<JBlockPanel> list){
		bpv.add(list);
		bp.addPiece(list.getLast().getBlock().getPiece());
	}

}

