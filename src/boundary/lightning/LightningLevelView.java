package boundary.lightning;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import boundary.BaseLevelView;
import entities.Level;

public class LightningLevelView extends BaseLevelView{
	Level level;
	
	public LightningLevelView(Level level) {
		super(level);
		this.level = level;
	}
	
	public JPanel render() {
		JPanel superPanel = super.render();
		JLabel remainingTime = new JLabel("Time left: ");
		remainingTime.setForeground(Color.white);
		remainingTime.setBounds(400, 20, 150, 20);
		this.getLayeredPane().add(remainingTime, new Integer(0), 0);

		
		Timer timer = new javax.swing.Timer(5000, null);
		timer.setInitialDelay(0);
		
		return superPanel;
	}

	public JButton getBackButton() {
		return super.getBackButton();
	}

}
