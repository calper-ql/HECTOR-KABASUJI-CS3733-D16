/** SwingKitchenSink
 * 	This program is used to display all of the visible features of the Swing library.
 * 
 * 	Author(s):
 * 	@author Can Alper
 */

package SwingKitchenSink;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class SwingKitchenSink {
	public static class Point2D {
		public int x;
		public int y;
		
		public Point2D(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	/** createWindow:
	 * 	Returns an initialized window with the given name and a black background.
	 * 
	 * @author Can Alper
	 * @param name
	 * @param size
	 * @return JFrame
	 */
	public static JFrame createWindow(String name, Point2D size) {
		// Create the new window with the given name.
		JFrame window = new JFrame(name);
		// Set the background thread to terminate when the window is closed.
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set the background color of the window.
		window.getContentPane().setBackground(Color.cyan);
		// Set window size the window to fit.
		window.pack();
		window.setSize(size.x, size.y);
		// Make the window visible.
		window.setVisible(true);
		// Set the layout manager to null for programmers to move things around.
		window.setLayout(null);
		// Return.
		return window;
	}
	
	/** createLabel:
	 * 	Creates and returns a label with the given text and location.
	 * 
	 * @author Can Alper
	 * @param text
	 * @param point
	 * @param size
	 * @return JLabel
	 */
	public static JLabel createLabel(String text, Point2D point, Point2D size){
		// Create the label.
		JLabel label = new JLabel();
		// Set the text of the label.
		label.setText(text);
		// Set the text color of the label.
		label.setForeground(Color.white);
		// Move the label to the given point.
		label.setLocation(point.x, point.y);
		// Set size
		label.setSize(size.x, size.y);
		// Return the label.
		return label;
	}
	
	/** createButton:
	 * 	Creates and returns a button with the given text and point.
	 * 
	 * @author Can Alper
	 * @param text
	 * @param point
	 * @param size
	 * @return JButton
	 */
	public static JButton createButton(String text, Point2D point, Point2D size){
		// Create the button.
		JButton button = new JButton();
		// Set the button text.
		button.setText(text);
		// Set the button foreground color to black.
		button.setForeground(Color.black);
		// Set the button background color to white.
		button.setBackground(Color.gray);
		// Set the button location (move...).
		button.setLocation(point.x, point.y);
		// Set the size.
		button.setSize(size.x, size.y);
		// Return the button.
		return button;
	}
	
	/**	main:
	 * 	Main program that creates every object.
	 * 
	 * @author Can Alper
	 * @param args
	 */
	public static void main(String[] args) {
		// Initialize the window.
		JFrame mainWindow = createWindow("Kitchen sink window.", new Point2D(400,200));
		// Create a label and link it to the main window
		final JLabel testLabel = createLabel("Test Label", new Point2D(0, 0), new Point2D(125,20));
		System.out.println("Linking testLabel to window.");
		mainWindow.getContentPane().add(testLabel);
		// Create a button and link it to the main window.
		JButton testButton = createButton("Test Button", new Point2D(125,50), new Point2D(125,50) );
		System.out.println("Linking testButton to window.");
		mainWindow.getContentPane().add(testButton);
		// Add a functionality to testButton
		// There is a weird java feature where you can intercept a class and add code into it. Java...
		testButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(testLabel.getText().equals("Test Label")){
					testLabel.setText("Not Test Label");
				}else{
					testLabel.setText("Test Label");
				}
			}
		});
		
	}

}
