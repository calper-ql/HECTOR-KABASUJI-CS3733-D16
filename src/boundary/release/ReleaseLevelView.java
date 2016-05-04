/**    	Release level View
 * 
 * 	  	This class is the release level view for the application.
 * 	 	A release level keeps track of how many release sets have been finished
 * 		This class adds the label for the moves left to the base level view class.
 * 
 * 		@author Can Alper - calper@wpi.edu
 */


package boundary.release;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import boundary.BaseLevelView;
import entities.Level;
import entities.ReleaseLevel;

public class ReleaseLevelView extends BaseLevelView{

	Level level;
	
	/** 
	 * 	Constructor takes the level from the Controller to display the sets
	 * 
	 *  @param level
	 */
	public ReleaseLevelView(Level level) {
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
		
		// Create the label with the complete release sets
		//System.out.println(((ReleaseLevel)level).getCompleteSets());
		//((ReleaseLevel)level).
		JLabel CompleteReleaseSets = new JLabel("Sets: " + new Integer(((ReleaseLevel)level).getCompleteSets()).toString());
		CompleteReleaseSets.setForeground(Color.white);
		CompleteReleaseSets.setBounds(400, 20, 150, 20);
		
		// Add to the layer 0 of the base Level View
		this.getLayeredPane().add(CompleteReleaseSets, new Integer(0), 0);
		
		// return the overlord panel
		return superPanel;
	}
	

}
