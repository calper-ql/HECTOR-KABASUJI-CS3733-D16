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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class BuilderBaseLevelView {
	private JButton backButton;
	private JButton resetButton;
	private JButton saveButton;
	
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
		p.add(backButton);
		
		
		JLabel lblNewLabel = new JLabel("Puzzle mode");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(83, 6, 137, 45);
		p.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.setBounds(10, 5, 65, 48);
		p.add(btnNewButton);
		
		BufferedImage info_img = null;
		try {
			URL img = boundary.BaseLevelView.class.getResource("/img/info.png");
			info_img = ImageIO.read(img);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image info_img_r = info_img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(info_img_r));
		label_1.setBounds(20, 54, 40, 40);
		p.add(label_1);
		
		lp.add(p, new Integer(0), 0);
		mp.add(lp);
		
		return mp;
	}
	
	public JButton getBackButton(){
		return backButton;
	}
}
