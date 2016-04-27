/**    	Builder Puzzle level View
 * 
 * 	  	This class is the puzzle level view for the builder.
 * 	 	A puzzle level keeps track of moves and in order to set the moves,
 * 		this class utilizes a JSpinner. More on the JSpinner is explained in the code.
 * 		This class is an extension of the BuilderBaseLevelView.
 * 
 * 		@author Can Alper - calper@wpi.edu
 */

package boundary.puzzle;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import boundary.BuilderBaseLevelView;

public class BuilderPuzzleLevelView extends BuilderBaseLevelView {
	
	/* A class field to keep track of the moves. */
	int movesLeft;
	
	/** Constructor  
	 * Moves Left for the initial view.
	 * @param movesLeft
	 * 
	 */
	public BuilderPuzzleLevelView(int movesLeft){
		super();
		this.movesLeft = movesLeft;
	}
	
	
	/** Returns the current value of the JSpinner.
	 * 
	 * @param movesLeft
	 */
	public int getMovesLeft(){
		return movesLeft;
	}

	/**	Renders the Builder Base Level View and adds the JSpinner to the right corner of the screen.
	 * 
	 * @return panel
	 */
	public JPanel render() {
		// Render the the Builder Base Level View
		JPanel superPanel = super.render();
		
		// Create a label for the moves
		JLabel spLabel = new JLabel("moves:");
		spLabel.setBounds(350, 10, 100, 50);
		spLabel.setVisible(true);
		spLabel.setForeground(Color.white);
		
		// Create a JSpinner for the View and Give the model of 0 to 1000
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(movesLeft, 0, 1000,1));
		spinner.setBounds(400, 10, 50, 50);
		spinner.setVisible(true);
		
		// Add the listener. This will update the moves.
		spinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				movesLeft = (int) ((JSpinner)arg0.getSource()).getValue();
			}
	    });
		
		// Add the label and the spinner to the Layered Pane's 0th layer
		this.getLayeredPane().add(spinner,new Integer(0), 0);
		this.getLayeredPane().add(spLabel,new Integer(0), 0);
		
		// return the rendered super panel
		return superPanel;
	}

}
