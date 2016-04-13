package boundary;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.MainController;

public class WindowManager {
	private JFrame mainFrame;
	private JPanel currentContext;
	private MainController mctrl;
	
	public WindowManager(int x, int y, int width, int height) {
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

	public void link(MainController mainController) {
		// TODO Auto-generated method stub
		mctrl = mainController;
		mctrl.link(this);
	}
}
