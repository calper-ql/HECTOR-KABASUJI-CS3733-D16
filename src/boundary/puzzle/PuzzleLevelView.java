package boundary.puzzle;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import entities.PuzzleLevel;

import boundary.BaseLevelView;
import entities.Level;

public class PuzzleLevelView extends BaseLevelView{

	Level level;
	
	public PuzzleLevelView(Level level) {
		super(level);
		this.level = level;
	}
	
	public JPanel render() {
		JPanel superPanel = super.render();
		JLabel remainingMoves = new JLabel("Moves left: " + new Integer(((PuzzleLevel)level).getRemainingMoves()).toString());
		remainingMoves.setForeground(Color.white);
		remainingMoves.setBounds(400, 20, 150, 20);
		this.getLayeredPane().add(remainingMoves, new Integer(0), 0);
		
		return superPanel;
	}

	public JButton getBackButton() {
		return super.getBackButton();
	}

}
