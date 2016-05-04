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
		
		ArrayList<Achievement> achievementList = AchievementGenerator.makeAchievements();
		
			if (model.checkAchievementExists("Earned One Star In Puzzle!")){
				Image img = achievementList.get(0).getImage();
				
				JLabel lblNewLabel = new JLabel("\n");
				
				lblNewLabel.setBounds(110 + 0*160, 65, 101, 90);
				p.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(achievementList.get(0).getName());
				lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 9));
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setBounds(100 + 0*150, 50, 300, 200);
				lblNewLabel.setIcon(new ImageIcon(img));
				p.add(lblNewLabel_1);
			}
			if (model.checkAchievementExists("Earned Two Stars In Puzzle!")){
				Image img = achievementList.get(1).getImage();
				
				JLabel lblNewLabel = new JLabel("\n");
				
				lblNewLabel.setBounds(110 + 1*160, 65, 101, 90);
				p.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(achievementList.get(1).getName());
				lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 9));
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setBounds(100 + 1*150, 50, 300, 200);
				lblNewLabel.setIcon(new ImageIcon(img));
				p.add(lblNewLabel_1);
			}
			if (model.checkAchievementExists("Earned Three Stars In Puzzle!")){
				Image img = achievementList.get(2).getImage();
				
				JLabel lblNewLabel = new JLabel("\n");
				
				lblNewLabel.setBounds(110 + 2*160, 65, 101, 90);
				p.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(achievementList.get(2).getName());
				lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 9));
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setBounds(100 + 2*150, 50, 300, 200);
				lblNewLabel.setIcon(new ImageIcon(img));
				p.add(lblNewLabel_1);
			}
			if (model.checkAchievementExists("Earned One Star In Lightning!")){
				Image img = achievementList.get(3).getImage();
				
				JLabel lblNewLabel = new JLabel("\n");
				
				lblNewLabel.setBounds(110 + 0*160, 165, 101, 90);
				p.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(achievementList.get(3).getName());
				lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 9));
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setBounds(100 + 0*150, 150, 300, 200);
				lblNewLabel.setIcon(new ImageIcon(img));
				p.add(lblNewLabel_1);
			}
			if (model.checkAchievementExists("Earned Two Stars In Lightning!")){
				Image img = achievementList.get(4).getImage();
				
				JLabel lblNewLabel = new JLabel("\n");
				
				lblNewLabel.setBounds(110 + 1*160, 165, 101, 90);
				p.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(achievementList.get(4).getName());
				lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 9));
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setBounds(100 + 1*150, 150, 300, 200);
				lblNewLabel.setIcon(new ImageIcon(img));
				p.add(lblNewLabel_1);
			}
			if (model.checkAchievementExists("Earned Three Stars In Lightning!")){
				Image img = achievementList.get(5).getImage();
				
				JLabel lblNewLabel = new JLabel("\n");
				
				lblNewLabel.setBounds(110 + 2*160, 165, 101, 90);
				p.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(achievementList.get(5).getName());
				lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 9));
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setBounds(100 + 2*150, 150, 300, 200);
				lblNewLabel.setIcon(new ImageIcon(img));
				p.add(lblNewLabel_1);
			}
		
		if (model.checkAchievementExists("Earned One Star In Release!")){
			Image img = achievementList.get(6).getImage();
			
			JLabel lblNewLabel = new JLabel("\n");
			
			lblNewLabel.setBounds(110 + 0*160, 265, 101, 90);
			p.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel(achievementList.get(6).getName());
			lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 9));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(100 + 0*150, 250, 300, 200);
			lblNewLabel.setIcon(new ImageIcon(img));
			p.add(lblNewLabel_1);
		}
		if (model.checkAchievementExists("Earned Two Star In Release!")){
			Image img = achievementList.get(7).getImage();
			
			JLabel lblNewLabel = new JLabel("\n");
			
			lblNewLabel.setBounds(110 + 1*160, 265, 101, 90);
			p.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel(achievementList.get(7).getName());
			lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 9));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(100 + 1*150, 250, 300, 200);
			lblNewLabel.setIcon(new ImageIcon(img));
			p.add(lblNewLabel_1);
		}
		if (model.checkAchievementExists("Earned Three Star In Release!")){
			Image img = achievementList.get(8).getImage();
			
			JLabel lblNewLabel = new JLabel("\n");
			
			lblNewLabel.setBounds(110 + 2*160, 265, 101, 90);
			p.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel(achievementList.get(8).getName());
			lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 9));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(100 + 2*150, 250, 300, 200);
			lblNewLabel.setIcon(new ImageIcon(img));
			p.add(lblNewLabel_1);
		}
		if (model.checkAchievementExists("Unlocked 15 Levels!")){
			Image img = achievementList.get(9).getImage();
			
			JLabel lblNewLabel = new JLabel("\n");
			
			lblNewLabel.setBounds(270, 365, 101, 90);
			p.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel(achievementList.get(9).getName());
			lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 9));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(263, 350, 300, 200);
			lblNewLabel.setIcon(new ImageIcon(img));
			p.add(lblNewLabel_1);
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
