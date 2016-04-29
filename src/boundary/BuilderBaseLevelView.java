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
	private JRadioButton hintButton;
	
	JLayeredPane lp;
	
	public BuilderBaseLevelView(){

	}
	
	public JLayeredPane getLayeredPane(){
		return lp;
	}
	
	
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
		
		undoButton = new JButton("undo");
		undoButton.setBounds(10, 60, 90, 30);
		undoButton.setBackground(Color.white);
		p.add(undoButton);
		
		resetButton = new JButton("reset");
		resetButton.setBounds(210, 60, 90, 30);
		resetButton.setBackground(Color.white);
		p.add(resetButton);
		
		saveButton = new JButton("save");
		saveButton.setBounds(110, 60, 90, 30);
		saveButton.setBackground(Color.white);
		p.add(saveButton);
		
		hintButton = new JRadioButton("Enable Hints");
		hintButton.setBounds(500, 60, 95, 30);
		hintButton.setBackground(Color.white);
		p.add(hintButton);
		
		lp.add(p, new Integer(0), 0);
		mp.add(lp);
		
		return mp;
	}
	
	public JButton getBackButton(){
		return backButton;
	}
	
	public JButton getResetButton(){
		return resetButton;
	}
	
	public JButton getSaveButton(){
		return saveButton;
	}
	
	public JRadioButton getHintButton(){
		return hintButton;
	}
}
