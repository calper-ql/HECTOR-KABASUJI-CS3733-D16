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
	
	public LightningLevelView(Level level) {
		super(level);
		this.level = level;
	}
	
	public JPanel render() {
		JPanel superPanel = super.render();
		// Create the label with the remaining time
		JLabel remainingTime = new JLabel("Time left: " + new Integer(((LightningLevel)level).getTimeRemaining()).toString());
		remainingTime.setForeground(Color.white);
		remainingTime.setBounds(400, 20, 150, 20);
		
		// Add to the layer 0 of the base Level View
		this.getLayeredPane().add(remainingTime, new Integer(0), 0);
		
		return superPanel;
	}

	public JButton getBackButton() {
		return super.getBackButton();
	}

}
