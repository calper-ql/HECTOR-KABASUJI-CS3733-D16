package boundary.lightning;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

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
		JLabel remainingTime = new JLabel("Time left: ");
		remainingTime.setForeground(Color.white);
		remainingTime.setBounds(400, 20, 150, 20);
		this.getLayeredPane().add(remainingTime, new Integer(0), 0);

		ActionListener countDown = new ActionListener()
		{

			Timer timer = new Timer(100, null);
		    public void actionPerformed(ActionEvent e)
		    {
		        int timeLeft = (new Integer(((LightningLevel)level).getTimeRemaining()));
		        SimpleDateFormat df=new SimpleDateFormat("mm:ss:S");
		        remainingTime.setText(df.format(timeLeft));
		        if(timeLeft<=0)
		        {
		        	
		            timer.stop();
		        }
		    }
		};
		new Timer(100, countDown);
		
		return superPanel;
	}

	public JButton getBackButton() {
		return super.getBackButton();
	}

}
