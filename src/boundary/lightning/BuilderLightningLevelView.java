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
	
	int timer;
	
	public BuilderLightningLevelView(int timer){
		super();
		this.timer = timer;
	}
	
	public int getTime(){
		return timer;
	}

	public JPanel render() {
		JPanel superPanel = super.render();
		
		JLabel spLabel = new JLabel("timer:");
		spLabel.setBounds(350, 10, 100, 50);
		spLabel.setVisible(true);
		spLabel.setForeground(Color.white);
		
		JSpinner sp = new JSpinner(new SpinnerNumberModel(timer, 0, 1000,1));
		sp.setBounds(400, 10, 50, 50);
		sp.setVisible(true);
		
		sp.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				timer = (int) ((JSpinner)arg0.getSource()).getValue();
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
