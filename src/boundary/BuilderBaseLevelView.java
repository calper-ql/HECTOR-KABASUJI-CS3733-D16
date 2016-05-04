/** Builder Base Level View
 * This Boundary class is to render all components associated with the base level view in the Level Builder
 * @author Morgan Garbett - mlgarbett@wpi.edu
 * @author Courtney Davis - cedavis@wpi.edu
 * @author Can Alper - calper@wpi.edu
 */
package boundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class BuilderBaseLevelView {
	private JButton backButton;
	private JButton resetButton;
	private JButton saveButton;
	private JButton undoButton;
	private JButton redoButton;
	private JButton previewButton;
	private JRadioButton hintButton;
	
	JLayeredPane lp;
	
	/**
	 * Class Constructor
	 */
	public BuilderBaseLevelView(){
	}
	
	/**
	 * Returns the JLayered Pane for use by other classes
	 * @return lp
	 */
	public JLayeredPane getLayeredPane(){
		return lp;
	}
	
	/**
	 * Renders all components displayed as a part of the Level Builder Base Level View
	 * including the back button, undo button, save button, hint button, and preview button
	 * @return mp
	 */
	public JPanel render(){
		int width = 640;
		int height = 535;
		
		JPanel mp = new JPanel();
		mp.setLayout(null);
		
		lp = new JLayeredPane();
		
		JPanel p = new JPanel();
		
		lp.setLayout(null);
		lp.setPreferredSize(new Dimension(width, height));
		lp.setBounds(0, 0, width, height);
		
		p.setBackground(Color.darkGray);
		p.setLayout(null);
		p.setBounds(0, 0, width, height);
		
		backButton = new JButton("<");
		backButton.setBounds(10, 5, 65, 50);
		backButton.setBackground(Color.white);
		p.add(backButton);
		
		undoButton = new JButton("Undo");
		undoButton.setBounds(10, 60, 90, 30);
		undoButton.setBackground(Color.white);
		p.add(undoButton);
		
		redoButton = new JButton("Redo");
		redoButton.setBounds(110, 60, 90, 30);
		redoButton.setBackground(Color.white);
		p.add(redoButton);
		
		resetButton = new JButton("Reset");
		resetButton.setBounds(310, 60, 90, 30);
		resetButton.setBackground(Color.white);
		p.add(resetButton);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(210, 60, 90, 30);
		saveButton.setBackground(Color.white);
		p.add(saveButton);
		
		previewButton = new JButton("Preview");
		previewButton.setBounds(410, 60, 90, 30);
		previewButton.setBackground(Color.white);
		p.add(previewButton);
		
		hintButton = new JRadioButton("Enable Hints");
		hintButton.setBounds(500, 60, 95, 30);
		hintButton.setBackground(Color.white);
		p.add(hintButton);
		
		lp.add(p, new Integer(0), 0);
		mp.add(lp);
		
		return mp;
	}
	
	/**
	 * Returns the JButton back button for use by other classes 
	 * @return backButton
	 */
	public JButton getBackButton(){
		return backButton;
	}
	
	/**
	 * Returns the JButton reset button for use by other classes 
	 * @return resetButton
	 */
	public JButton getResetButton(){
		return resetButton;
	}
	
	/**
	 * Returns the JButton save button for use by other classes
	 * @return saveButton
	 */
	public JButton getSaveButton(){
		return saveButton;
	}
	
	/**
	 * Returns the JButton preview button for use by other classes
	 * @return previewButton
	 */
	public JButton getPreviewButton(){
		return previewButton;
	}
	
	/**
	 * Returns the JRadioButton hint button for use by other classes
	 * @return hintButton
	 */
	public JRadioButton getHintButton(){
		return hintButton;
	}
	
	/**
	 * Returns the JButton undo button for use by other classes
	 * @return undoButton
	 */
	public JButton getUndoButton() {
		return undoButton;
	}
	
	/**
	 * Returns the JButton redo button for use by other classes
	 * @return redoButton
	 */
	public JButton getRedoButton() {
		return redoButton;
	}
}
