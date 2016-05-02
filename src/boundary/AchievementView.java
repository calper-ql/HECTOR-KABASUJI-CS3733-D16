package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Achievement;
import entities.Model;
import generators.AchievementGenerator;

public class AchievementView {
	private JButton backButton;
	private JButton resetButton;
	
	public AchievementView() {
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
		
		Model model = new Model("", null, null);
		model.reload();
		
		model.generateAchievements();
		model.unlockAchievements();
		
		ArrayList<Achievement> achievementList = model.getAchievements();
		
		for(int i = 0; i<=2; i++){
			Achievement a = achievementList.get(i);
			if (a.isUnlocked()){
				Image img = a.getImage();
				
				JLabel lblNewLabel = new JLabel("\n");
				
				lblNewLabel.setBounds(110 + i*160, 65, 101, 90);
				p.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(a.getName());
				lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 9));
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setBounds(100 + i*150, 50, 300, 200);
				lblNewLabel.setIcon(new ImageIcon(img));
				p.add(lblNewLabel_1);
			}
		}
		for(int i = 0; i<=2; i++){
			Achievement a = achievementList.get(i+3);
			if (a.isUnlocked()){
				Image img = a.getImage();
				
				JLabel lblNewLabel = new JLabel("\n");
				
				lblNewLabel.setBounds(110 + i*160, 165, 101, 90);
				p.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(a.getName());
				lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 9));
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setBounds(100 + i*150, 150, 300, 200);
				lblNewLabel.setIcon(new ImageIcon(img));
				p.add(lblNewLabel_1);
			}
		}
		for(int i = 0; i<=2; i++){
			Achievement a = achievementList.get(i+6);
			if (a.isUnlocked()){
				Image img = a.getImage();
				
				JLabel lblNewLabel = new JLabel("\n");
				
				lblNewLabel.setBounds(110 + i*160, 265, 101, 90);
				p.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(a.getName());
				lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 9));
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setBounds(100 + i*150, 250, 300, 200);
				lblNewLabel.setIcon(new ImageIcon(img));
				p.add(lblNewLabel_1);
			}
		}
		for(int i = 0; i<=0; i++){
			Achievement a = achievementList.get(i+9);
			if (a.isUnlocked()){
				Image img = a.getImage();
				
				JLabel lblNewLabel = new JLabel("\n");
				
				lblNewLabel.setBounds(270, 365, 101, 90);
				p.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(a.getName());
				lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 9));
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setBounds(263, 350, 300, 200);
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

	public JButton getResetButton(){
		return resetButton;
	}
}
