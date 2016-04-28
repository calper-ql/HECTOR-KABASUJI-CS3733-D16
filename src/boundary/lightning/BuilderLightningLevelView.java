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
	
	public BuilderLightningLevelView(int seconds){
		super();
		this.seconds = seconds;
	}
	
	public int getTimeLeft(){
		return this.seconds;
	}

	public JPanel render() {
		JPanel superPanel = super.render();
		
		JLabel spLabel = new JLabel("timer:");
		spLabel.setBounds(350, 10, 100, 50);
		spLabel.setVisible(true);
		spLabel.setForeground(Color.white);
		
		JSpinner sp = new JSpinner(new SpinnerNumberModel(minutes, 0, 1000, 1));
		sp.setBounds(400, 10, 50, 50);
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
		
		
		this.getLayeredPane().add(sp,new Integer(0), 0);
		this.getLayeredPane().add(spLabel,new Integer(0), 0);

		return superPanel;
	}

	public JLayeredPane getLayeredPane() {
		return super.getLayeredPane();
	}
}
