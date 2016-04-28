package boundary;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controllers.MainMenuController;
import entities.SplashScreen;

public class MainMenuView {
	private JButton btnLevels;
	private JButton btnAchivements;
	
	public MainMenuView(){

	}
	
	public JPanel render(){
		JPanel jp = new JPanel();
		jp.setBackground(Color.darkGray);
		int width = 640;
		int height = 535;
		jp.setBounds(0, 0, width, height);
		jp.setLayout(null);
		
		JLabel menuLabel = new JLabel("Kabasuji");
		menuLabel.setFont(new Font("Menlo", Font.PLAIN, 99));
		menuLabel.setForeground(Color.WHITE);
		menuLabel.setBounds(40, 10, 500, 160);
		jp.add(menuLabel);
		
		btnLevels = new JButton("Levels");
		btnLevels.setBackground(Color.WHITE);
		btnLevels.setBounds(50, 185, 200, 50);
		jp.add(btnLevels);
		
		btnAchivements = new JButton("Achievements");
		btnAchivements.setBackground(Color.WHITE);
		btnAchivements.setBounds(50, 245, 200, 50);
		jp.add(btnAchivements);
		
		return jp;
	}
	
	public JButton getAchivementButton(){
		return btnAchivements;
	}
	
	public JButton getLevelsButton(){
		return btnLevels;
	}
	
}
