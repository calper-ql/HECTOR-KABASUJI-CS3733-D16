package boundry;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LevelSelectView {
	private JButton backButton;
	private JButton puzzleButtons[];
	private JButton lightningButtons[];
	private JButton releaseButtons[];
	
	public LevelSelectView() {
		// TODO Auto-generated constructor stub
	}
	
	public JPanel render(){
		JPanel p = new JPanel();
		
		backButton = new JButton("<");
		p.add(backButton);
		
		return p;
	}
	
	public JButton getBackButton(){
		return backButton;
	}
}
