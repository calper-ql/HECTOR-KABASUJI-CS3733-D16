/**	SwingBasic Example
 *	This is a basic example for the Swing library
 * 
 * 	Author(s):
 * 		Can Alper.
 */

package SwingBasicExample;
import java.awt.Color;
import javax.swing.*;

public class SwingBasicExample {
	
	/** This method  taken from the Oracle website and modified.
	 * 	
	 * 	Here we can see a window getting created and displayed.
	 */
	private static void createAndShowGUI() {
        //Create and set up the window.
		System.out.println("Creating a window.");
        JFrame frame = new JFrame("Swing Basic Example Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setBackground(Color.black); // Does not work because there is no content...
        frame.getContentPane().setBackground(Color.black); //Works!
        
        System.out.println("Adding a label to the window.");
        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        label.setForeground(Color.white);
        frame.getContentPane().add(label);
        
        System.out.println("Displaying the window.");
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	public static void main(String[] args) {
		System.out.println("Start of the program.");
        createAndShowGUI();
        System.out.println("You will see the \"End of the program\" text printed but the program will keep running until the window is closed.");
        System.out.println("The reason for this is that Java is a high level language.");
        System.out.println("Unlike languages like C or C++, Java actually handles GUI on the background by default.");
		System.out.println("End of the program.");
	}

}
