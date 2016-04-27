/**    	Puzzle level View
 * 
 * 	  	This class is the puzzle level view for the application.
 * 	 	A puzzle level keeps track of moves and in order to set the moves,
 * 		This class adds the label for the moves left to the base level view class.
 * 
 * 		@author Can Alper - calper@wpi.edu
 */


package boundary.puzzle;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import boundary.BaseLevelView;
import entities.Level;
import entities.PuzzleLevel;

public class PuzzleLevelView extends BaseLevelView{

	Level level;
	
	/** 
	 * 	Constructor takes the level from the Controller to display the moves
	 * 
	 *  @param level
	 */
	public PuzzleLevelView(Level level) {
		super(level);
		this.level = level;
	}
	
	/**
	 * 	This function renders the Base Level View and adds a label for the moves left to it.
	 * 
	 * 	@return panel
	 */
	public JPanel render() {
		// Render to the super panel
		JPanel superPanel = super.render();
		
		// Create the label with the remaining moves
		JLabel remainingMoves = new JLabel("Moves left: " + new Integer(((PuzzleLevel)level).getRemainingMoves()).toString());
		remainingMoves.setForeground(Color.white);
		remainingMoves.setBounds(400, 20, 150, 20);
		
		// Add to the layer 0 of the base Level View
		this.getLayeredPane().add(remainingMoves, new Integer(0), 0);
		
		// return the overlord panel
		return superPanel;
	}

}
