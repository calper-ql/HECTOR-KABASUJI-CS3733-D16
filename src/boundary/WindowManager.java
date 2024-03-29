/**Window Manager
 * This Boundary Class is responsible for managing Window Views 
 * @author Can Alper - calper@wpi.edu
 */
package boundary;

import java.awt.Point;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.MainController;

public class WindowManager {
	private JFrame mainFrame;
	private JPanel currentContext;
	private MainController mctrl;

	/**
	 * Class constructor
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public WindowManager(int x, int y, int width, int height) {
		currentContext = new JPanel();
		mainFrame = new JFrame();
		mainFrame.setVisible(true);
		mainFrame.setBounds(x, y, width, height);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().add(currentContext);	
	}
	
	/**
	 * returns the mouse position from the main frame
	 * @return mainFrame.getMousePosition()
	 */
	public Point getMouseLocation(){
		return mainFrame.getMousePosition();
	}
	
	public void render(){}
	
	/**
	 * Handles updating a panel 
	 * @param nextContext
	 */
	public void swap(JPanel nextContext){
		currentContext = nextContext;
		mainFrame.getContentPane().removeAll();
		mainFrame.getContentPane().add(nextContext);
		mainFrame.validate();
		mainFrame.repaint();	
	}

	/**
	 * Manages the relationship between the Main Controller and link
	 * @param mainController
	 */
	public void link(MainController mainController) {
		mctrl = mainController;
		mctrl.link(this);
	}
}
