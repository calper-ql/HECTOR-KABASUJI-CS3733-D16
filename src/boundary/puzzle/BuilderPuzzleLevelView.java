package boundary.puzzle;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import boundary.BuilderBaseLevelView;
import entities.DefinedPieces;
import entities.Piece;

public class BuilderPuzzleLevelView extends BuilderBaseLevelView {
	
	int moves;
	
	public BuilderPuzzleLevelView(int moves){
		super();
		this.moves = moves;
	}
	
	public int getMoves(){
		return moves;
	}

	public JPanel render() {
		JPanel superPanel = super.render();
		
		JLabel spLabel = new JLabel("moves:");
		spLabel.setBounds(350, 10, 100, 50);
		spLabel.setVisible(true);
		spLabel.setForeground(Color.white);
		
		JSpinner sp = new JSpinner(new SpinnerNumberModel(moves, 0, 1000,1));
		sp.setBounds(400, 10, 50, 50);
		sp.setVisible(true);
		
		sp.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				moves = (int) ((JSpinner)arg0.getSource()).getValue();
			}
	    });
		
		this.getLayeredPane().add(sp,new Integer(0), 0);
		this.getLayeredPane().add(spLabel,new Integer(0), 0);

		return superPanel;
	}

	public JLayeredPane getLayeredPane() {
		return super.getLayeredPane();
	}
	 
}
