package boundary.puzzle;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import boundary.BaseLevelView;
import entities.Level;

public class PuzzleLevelView extends BaseLevelView{

	public PuzzleLevelView(Level level) {
		super(level);
		
	}
	
	public JPanel render() {
		JPanel superPanel = super.render();
		
		return superPanel;
	}

	public JButton getBackButton() {
		return super.getBackButton();
	}

	public JLayeredPane getLayeredPane() {
		return super.getLayeredPane();
	}

}
