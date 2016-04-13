package boundry;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BuilderLevelSelectView {
	private JButton[] puzzleButtons;
	private JButton[] lightningButtons;
	private JButton[] releaseButtons;
	
	
	public BuilderLevelSelectView(){

	}
	
	public JPanel render(){
		JPanel p = new JPanel();
		p.setBackground(Color.darkGray);
		int width = 640;
		int height = 535;
		p.setBounds(0, 0, width, height);
		p.setLayout(null);
		
		
		JLabel builderTitle = new JLabel("Level Builder");
		builderTitle.setFont(new Font("Menlo", Font.PLAIN, 28));
		builderTitle.setForeground(Color.WHITE);
		builderTitle.setBounds(153, 6, 311, 68);
		p.add(builderTitle);
		
		
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
			
			p.add(puzzleButtons[i]);
			p.add(lightningButtons[i]);
			p.add(releaseButtons[i]);
		}
		
		return p;
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
