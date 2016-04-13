package boundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class LevelView {
private JButton backButton;
	
	public LevelView() {
		// TODO Auto-generated constructor stub
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
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(6, 100, 192, 384);
		p.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setMaximumSize(new Dimension(100, 32767));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(215, 100, 384, 384);
		p.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Puzzle mode - 3");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(83, 6, 137, 45);
		p.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.setBounds(10, 5, 65, 48);
		p.add(btnNewButton);
		
		
		BufferedImage star_img = null;
		try {
			URL img = MockupGui.mockup.class.getResource("/img/888267.jpg");
			star_img = ImageIO.read(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedImage info_img = null;
		try {
			URL img = MockupGui.mockup.class.getResource("/img/888267.jpg");
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
		
		int X   = panel.getX();
		int Y = panel.getY();
		//int width  = panel.getWidth();
		//int height = panel.getHeight();
		
		JPanel tiles[][] = new JPanel[12][12];
		for(int i = 0;	i < 12; i++){
			for(int k = 0; k < 12; k++){
				
				tiles[k][i] = new JPanel();
				tiles[k][i].setVisible(true);
				tiles[k][i].setBorder(new LineBorder(new Color(0, 0, 0)));
				panel.add(tiles[k][i]);
				int x =  ((width/12)*k);
				int y = ((height/12)*i);
				int w = (width/12);
				int h = (height/12);
				tiles[k][i].setBounds(x, y, w, h);
				tiles[k][i].setBackground(new Color(250,255,255));
				
				if(((i==9) || (i == 11)) && (k == 7 || k == 9)){
					tiles[k][i].setBackground(Color.darkGray);
				}	
				
				System.out.println(x);
			}
		}
		
		
		
		
		
		/*
		
		BufferedImage achive_img = null;
		try {
			// load relative image
			URL img = boundry.AchievementView.class.getResource("/img/888267.jpg");
			achive_img = ImageIO.read(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Image achive_img_r = achive_img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		
		
		
		
		JLabel lblNewLabel = new JLabel("\n");
		lblNewLabel.setBounds(45, 84, 101, 61);
		p.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pros only");
		lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 28));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(55, 142, 65, 48);
		lblNewLabel.setIcon(new ImageIcon(achive_img_r));
		p.add(lblNewLabel_1);
		
		JLabel lblEarnedAchivements = new JLabel("Earned Achivements");
		lblEarnedAchivements.setFont(new Font("Menlo", Font.PLAIN, 28));
		lblEarnedAchivements.setForeground(Color.WHITE);
		lblEarnedAchivements.setBounds(153, 6, 311, 68);
		p.add(lblEarnedAchivements);
		
		
		*/
		
		return p;
	}
	
	public JButton getBackButton(){
		return backButton;
	}
}
