package boundary;

import java.awt.Color;
import java.awt.Font;
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

import entities.Achievement;
import generators.AchievementGenerator;

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
		
		AchievementGenerator ag = new AchievementGenerator();
		ArrayList<Achievement> achievementList = ag.makeAchievements();
			
		
		for(int i = 0; i<=4; i++){
			Achievement a = achievementList.get(i);
			if (a.isUnlocked()){
				Image img = a.getImage();
				
				JLabel lblNewLabel = new JLabel("\n");
				
				lblNewLabel.setBounds(45 + i*10, 84, 101, 61);
				p.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(a.getName());
				lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 28));
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setBounds(55, 142, 65, 48);
				lblNewLabel.setIcon(new ImageIcon(img));
				p.add(lblNewLabel_1);
			}
		}
	
	
		for(int i = 0; i<=4; i++){
			Achievement a = achievementList.get(i+5);
			if (a.isUnlocked()){
				Image img = a.getImage();
				
				JLabel lblNewLabel = new JLabel("\n");
				
				lblNewLabel.setBounds(45 + i*10, 150, 101, 61);
				p.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(a.getName());
				lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 28));
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setBounds(55, 142, 65, 48);
				lblNewLabel.setIcon(new ImageIcon(img));
				p.add(lblNewLabel_1);
			}
	}
		
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
