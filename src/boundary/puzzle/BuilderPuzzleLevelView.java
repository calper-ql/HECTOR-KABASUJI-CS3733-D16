package boundary.puzzle;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import boundary.BuilderBaseLevelView;

public class BuilderPuzzleLevelView extends BuilderBaseLevelView {
	

	 public BuilderPuzzleLevelView(){
		 super();
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
