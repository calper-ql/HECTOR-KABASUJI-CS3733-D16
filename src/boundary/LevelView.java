package boundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import entities.Board;
import entities.Level;
import entities.Tile;

public class LevelView {
	private JButton backButton;
	
	private BoardView boardView;
	private BullPenView bullView;
	
	private Level level;
	
	public LevelView(Level level) {
		this.boardView = new BoardView(215, 100, 384, 384, level.getBoard());
		this.bullView = new BullPenView(6, 100, 192, 384, level.getBullpen());
		
		this.level = level;
	}
	
	public JPanel render(){
		JPanel p = new JPanel();
		p.setBackground(Color.darkGray);
		p.setLayout(null);
		int width = 640;
		int height = 535;
		
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
		
		
		BufferedImage star_img = null;
		try {
			URL img = boundary.LevelView.class.getResource("/img/star-xxl.png");
			star_img = ImageIO.read(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedImage info_img = null;
		try {
			URL img = boundary.LevelView.class.getResource("/img/info.png");
			info_img = ImageIO.read(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image star_img_r = star_img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		Image info_img_r = info_img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(star_img_r));
		lblNewLabel_1.setBounds(341, 27, 40, 40);
		p.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(445, 27, 40, 40);
		lblNewLabel_2.setIcon(new ImageIcon(star_img_r));
		p.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(393, 27, 40, 40);
		lblNewLabel_3.setIcon(new ImageIcon(star_img_r));
		p.add(lblNewLabel_3);
		
		JLabel label = new JLabel("01:34");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label.setForeground(Color.WHITE);
		label.setBackground(Color.WHITE);
		label.setBounds(518, 27, 78, 39);
		p.add(label);
		
		JLabel lblTimeLeft = new JLabel("Time left:");
		lblTimeLeft.setForeground(Color.WHITE);
		lblTimeLeft.setBounds(508, 20, 61, 16);
		p.add(lblTimeLeft);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(info_img_r));
		label_1.setBounds(20, 54, 40, 40);
		p.add(label_1);
		
		p.add(bullView.render());
		p.add(boardView.render());
		
		return p;
	}
	
	public JButton getBackButton(){
		return backButton;
	}
}
