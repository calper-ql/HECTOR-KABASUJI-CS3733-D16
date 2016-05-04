/**
 *This Boundary Class is responsible for rendering all components specific to the Lightning Level in the game play application  
 * @author
 */
package boundary.lightning;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import boundary.BaseLevelView;
import entities.Level;
import entities.LightningLevel;

public class LightningLevelView extends BaseLevelView{
	Level level;
	
	JLabel remainingTime;
	
	/**
	 * Class Constructor
	 * @param level
	 */
	public LightningLevelView(Level level) {
		super(level);
		this.level = level;
	}
	
	/**
	 * Renders elements that are specific to the Lightning Level in the game play application,
	 * i.e. the timer
	 * @return superPanel
	 */
	public JPanel render() {
		JPanel superPanel = super.render();
		// Create the label with the remaining time
		Integer seconds = new Integer(((LightningLevel)level).getTimeRemaining()%60); 
		Integer minutes = new Integer((((LightningLevel)level).getTimeRemaining() - seconds.intValue())/60); 
		
		remainingTime = new JLabel("Time left: " + minutes.toString() + " minutes " + seconds.toString() + " seconds" );
		remainingTime.setForeground(Color.white);
		remainingTime.setBounds(300, 20, 300, 20);
		
		// Add to the layer 0 of the base Level View
		this.getLayeredPane().add(remainingTime, new Integer(0), 0);
		
		return superPanel;
	}

	/**
	 * Returns the back button from the super class for use by classes in other packages
	 * @return super.getBackButton()
	 */
	public JButton getBackButton() {
		return super.getBackButton();
	}

	/**
	 * Gets the minutes and seconds remaining and updates the timer display
	 */
	public void updateTimer() {
		Integer seconds = new Integer(((LightningLevel)level).getTimeRemaining()%60); 
		Integer minutes = new Integer((((LightningLevel)level).getTimeRemaining() - seconds.intValue())/60); 
		remainingTime.setText("Time left: " + minutes.toString() + " minutes " + seconds.toString() + " seconds");
	}

}
