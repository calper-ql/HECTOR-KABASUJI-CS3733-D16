/**	Base Level View
 * 	This Boundary class is to render all components associated with the Base Level
 * 
 * @author Morgan Garbett - mlgarbett@wpi.edu
 * @author Can Alper - calper@wpi.edu
 * @author Courtney Davis - cedavis@wpi.edu
 */
package boundary;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import controllers.BlockController;
import entities.Board;
import entities.Level;
import entities.Tile;

import entities.IBlock;

public class BaseLevelView {
	private JButton backButton;
	private BoardView boardView;
	private BullPenView bullView;
	
	private Level level;
	JLayeredPane lp;
	
	/**
	 * Constructor for the class 
	 * 
	 * the level parameter sets what the given level is  
	 * 
	 * @param level
	 */	
	public BaseLevelView(Level level) {
		this.level = level;
	}

	/**
	 * Returns all view layers
	 * 
	 * @return lp
	 */
	public JLayeredPane getLayeredPane(){
		return lp;
	}

	/**
	 * Adds a JBlockPanel (which is an extension of JPanel, 
	 * and handles mouse controls and moves other block panels when necessary)
	 *  to the set of all layered views
	 *  
	 *  Parameter bv determines which JBlockPanel will be added to lp 
	 *  (the set of all layered views)
	 * 
	 * @param bv
	 */

	public void addJBlockPanel(JBlockPanel bv){
		lp.add(bv, new Integer(1), 0);
	}

	/**
	 * Removes a layer	
	 */
	public void clear(){
		removeLayer(lp, 1);
	}

	/**
	 * 	Removes a layer and all its components from a given JLayeredPane
	 * 
	 * pane specifies the JLayeredPane from which a layer will be removed
	 * layer specifies which layer will be removed
	 * 
	 * @param pane
	 * @param layer
	 */
	void removeLayer(JLayeredPane pane, int layer) {    
		Component[] comps = pane.getComponentsInLayer(layer);    
		for(int x = 0; x < comps.length; x++) {       
			pane.remove(comps[x]);   
		}    
		pane.repaint();
		System.out.println("Should be removed");
	} 

	/**
	 * Renders all components displayed as a part of a Base Level including
	 * 	window size and background color
	 * 	back and info buttons 
	 * 	stars, depending on how many have been earned
	 * 	
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
		backButton.setBackground(Color.WHITE);
		p.add(backButton);
		
		  
		JButton btnNewButton = new JButton("<");
		btnNewButton.setBounds(10, 5, 65, 48);
		p.add(btnNewButton);
		
		BufferedImage star_img = null;
		try {
			URL img = boundary.BaseLevelView.class.getResource("/img/star-xxl.png");
			star_img = ImageIO.read(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedImage info_img = null;
		try {
			URL img = boundary.BaseLevelView.class.getResource("/img/info.png");
			info_img = ImageIO.read(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Image star_img_r = star_img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		Image info_img_r = info_img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		if(level.getStars() == 0){
			
		}else if(level.getStars() == 1){
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(star_img_r));
			lblNewLabel_1.setBounds(380, 40, 30, 30);
			p.add(lblNewLabel_1);
		}else if(level.getStars() == 2){
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(star_img_r));
			lblNewLabel_1.setBounds(380, 40, 30, 30);
			p.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setBounds(432, 40, 30, 30);
			lblNewLabel_2.setIcon(new ImageIcon(star_img_r));
			p.add(lblNewLabel_2);
		}else if(level.getStars() == 3){
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(star_img_r));
			lblNewLabel_1.setBounds(380, 40, 30, 30);
			p.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setBounds(432, 40, 30, 30);
			lblNewLabel_2.setIcon(new ImageIcon(star_img_r));
			p.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setBounds(484, 40, 30, 30);
			lblNewLabel_3.setIcon(new ImageIcon(star_img_r));
			p.add(lblNewLabel_3);
		}
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(info_img_r));
		label_1.setBounds(20, 54, 40, 40);
		//p.add(label_1);
		
		lp.add(p, new Integer(0), 0);
		mp.add(lp);
		
		return mp;
	}

	/**
	 * 	Returns the back button for use by other classes
	 * 
	 * @return backButton
	 */
	public JButton getBackButton(){
		return backButton;
	}
}
