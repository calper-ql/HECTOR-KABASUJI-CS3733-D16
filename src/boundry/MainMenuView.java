package boundry;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entities.MainMenu;
import entities.SplashScreen;

public class MainMenuView {
	private MainMenu sp;
	public MainMenuView(MainMenu sp){
		this.sp = sp;
	}
	
	public JPanel render(){
		JPanel jp = new JPanel();
		jp.setLayout(null);
		int width = 640;
		int height = 535;
		jp.setBounds(0, 0, width, height);
		
		
		
		JLabel lblNewLabel = new JLabel("Kabasuji");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 99));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(37, 6, 413, 156);
		jp.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Levels");
		btnNewButton.setBounds(47, 185, 197, 50);
		jp.add(btnNewButton);
		
		JButton btnAchivements = new JButton("Achivements");
		btnAchivements.setBounds(47, 247, 197, 50);
		
		return jp;
	}
}
