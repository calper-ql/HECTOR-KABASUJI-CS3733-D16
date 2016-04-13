package boundry;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainBoundry {
	private JFrame mainFrame;
	private JPanel currentContext;
	
	public MainBoundry(int x, int y, int width, int height) {
		currentContext = new JPanel();
		mainFrame = new JFrame();
		mainFrame.setVisible(true);
		mainFrame.setBounds(x, y, width, height);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().add(currentContext);
	}
	
	public void render(){
		
	}
	
	public void swap(JPanel nextContext){
		currentContext = nextContext;
		mainFrame.getContentPane().removeAll();
		mainFrame.getContentPane().add(nextContext);
		mainFrame.validate();
	}
}
