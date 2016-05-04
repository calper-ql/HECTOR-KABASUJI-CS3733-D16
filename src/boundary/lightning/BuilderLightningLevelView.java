/**
 * This Boundary class is responsible for everything associated 
 * with the view for the Lightning Level in Level Builder
 * @author
 */
package boundary.lightning;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import boundary.BuilderBaseLevelView;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BuilderLightningLevelView extends BuilderBaseLevelView {
	int minutes;
	int seconds;

	/**
	 * Class Constructor
	 * @param seconds
	 */
	public BuilderLightningLevelView(int seconds){
		super();
		this.seconds = seconds%60;
		this.minutes = (seconds-this.seconds)/60; 
	}
	
	/**
	 * Returns the remaining seconds for use by classes in other packages 
	 * @return this.seconds
	 */
	public int getSecondsLeft(){
		return this.seconds;
	}

	/**
	 * Returns the remaining minutes for use by classes in other packages
	 * @return this.minutes
	 */
	public int getMinutesLeft(){
		return this.minutes;
	}
	
	/**
	 * Renders components specifically associated with Lightning Level builder, 
	 * i.e. the timer
	 * @return superPanel
	 */
	public JPanel render() {
		JPanel superPanel = super.render();
		
		JLabel spLabel = new JLabel("timer:");
		spLabel.setBounds(350, 10, 100, 50);
		spLabel.setVisible(true);
		spLabel.setForeground(Color.white);
		
		JSpinner sp = new JSpinner(new SpinnerNumberModel(minutes, 0, 1000, 1));
		sp.setBounds(350, 10, 50, 50);
		sp.setVisible(true);
		
		sp.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				minutes = (int) ((JSpinner)arg0.getSource()).getValue();
			}
	    });
		
		JSpinner sp2 = new JSpinner(new SpinnerNumberModel(seconds, 0, 1000, 1));
		sp2.setBounds(400, 10, 50, 50);
		sp2.setVisible(true);
		
		sp2.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				seconds = (int) ((JSpinner)arg0.getSource()).getValue();
			}
	    });
		
		this.getLayeredPane().add(sp2, new Integer(0), 0);
		this.getLayeredPane().add(sp,new Integer(0), 0);
		//this.getLayeredPane().add(spLabel,new Integer(0), 0);

		return superPanel;
	}

	/**
	 * Returns the JLayeredPane 
	 * @return super.getLayeredPane()
	 */
	public JLayeredPane getLayeredPane() {
		return super.getLayeredPane();
	}
}
