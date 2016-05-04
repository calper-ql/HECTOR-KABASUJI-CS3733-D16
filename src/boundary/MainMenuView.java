/**
 * This Boundary class renders all components associated with the Main Menu in the game play application
 * @author Can Alper - calper@wpi.edu
 */
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
	private JButton btnAchievements;
	
	/**
	 * Class Constructor
	 */	
	public MainMenuView(){}
	
	/**
	 * Renders all components associated with the main menu,
	 * including the Levels and Achievements buttons
	 * @return jp
	 */
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
		
		btnAchievements = new JButton("Achievements");
		btnAchievements.setBackground(Color.WHITE);
		btnAchievements.setBounds(50, 245, 200, 50);
		jp.add(btnAchievements);
		
		return jp;
	}
	
	/**
	 * Returns the Achievements Button for use by classes in other packages
	 * @return btnAchivements
	 */
	public JButton getAchievementButton(){
		return btnAchievements;
	}
	
	/**
	 * Returns the Levels Button for use by classes in other packages
	 * @return btnLevels
	 */
	public JButton getLevelsButton(){
		return btnLevels;
	}
	
}
