package boundary;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LevelSelectView {
	private JButton backButton;
	private JButton[] puzzleButtons;
	private JButton[] lightningButtons;
	private JButton[] releaseButtons;
	
	public LevelSelectView() {
		// TODO Auto-generated constructor stub
	}
	
	public JPanel render(){
		JPanel p = new JPanel();
		p.setBackground(Color.darkGray);
		p.setLayout(null);
		int width = 640;
		int height = 535;
		
		backButton = new JButton("<");
		backButton.setBounds(10, 5, 65, 50);
		backButton.setBackground(Color.WHITE);
		p.add(backButton);
		
		puzzleButtons = new JButton[5];
		lightningButtons = new JButton[5];
		releaseButtons = new JButton[5];
		
		for(int i = 0; i < 5; i++){
			puzzleButtons[i] = new JButton(new Integer(i+1).toString());
			lightningButtons[i] = new JButton(new Integer(i+1).toString());
			releaseButtons[i] = new JButton(new Integer(i+1).toString());
			
			puzzleButtons[i]   .setBounds(50 + i*110, height/4   - 40, 100, 75);
			lightningButtons[i].setBounds(50 + i*110, height/4*2 - 40, 100, 75);
			releaseButtons[i]  .setBounds(50 + i*110, height/4*3 - 40, 100, 75);
			
			puzzleButtons[i].setBackground(Color.WHITE);
			lightningButtons[i].setBackground(Color.WHITE);
			releaseButtons[i].setBackground(Color.WHITE);
			
			p.add(puzzleButtons[i]);
			p.add(lightningButtons[i]);
			p.add(releaseButtons[i]);
		}
		
		return p;
	}
	
	public JButton getBackButton(){
		return backButton;
	}
	
	public JButton[] getPuzzleButtons(){
		return puzzleButtons;
	}
	
	public JButton[] getLightningButtons(){
		return lightningButtons;
	}
	
	public JButton[] getReleaseButtons(){
		return releaseButtons;
	}
}
