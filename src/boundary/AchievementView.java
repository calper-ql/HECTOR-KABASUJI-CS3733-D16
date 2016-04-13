package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AchievementView {
	private JButton backButton;
	private JButton resetButton;
	
	public AchievementView() {
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
		
		resetButton = new JButton("reset");
		resetButton.setBounds(640-20-65, 5, 65, 50);
		p.add(resetButton);
		
		BufferedImage achive_img = null;
		try {
			// load relative image
			URL img = boundary.AchievementView.class.getResource("/img/888267.jpg");
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
		
		JLabel lblEarnedAchivements = new JLabel("Earned Achievements");
		lblEarnedAchivements.setFont(new Font("Menlo", Font.PLAIN, 28));
		lblEarnedAchivements.setForeground(Color.WHITE);
		lblEarnedAchivements.setBounds(153, 6, 311, 68);
		p.add(lblEarnedAchivements);
		
		return p;
	}
	
	public JButton getBackButton(){
		return backButton;
	}
}
