package boundry;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entities.SplashScreen;

public class SplashScreenView {
	private SplashScreen sp;
	public SplashScreenView(SplashScreen sp){
		this.sp = sp;
	}
	
	public JPanel render(){
		JPanel jp = new JPanel();
		jp.setBackground(Color.darkGray);
		jp.setLayout(null);
		int width = 640;
		int height = 535;
		jp.setBounds(0, 0, width, height);
		for(int i = 0; i < sp.getNameList().size(); i++){
			JLabel label = new JLabel(sp.getNameList().get(i), SwingConstants.CENTER);
			label.setFont(new Font("Menlo", Font.PLAIN, 13));
			label.setForeground(Color.white);
			int label_width = 150;
			label.setBounds(width/2 - label_width/2, (535/3) + 70 + i*20, label_width, 15);
			jp.add(label);
		}
		
		JLabel title = new JLabel(sp.getMainTitle(), SwingConstants.CENTER);
		JLabel teamName = new JLabel(sp.getTeamName(), SwingConstants.CENTER);
		
		title.setFont(new Font("Menlo", Font.PLAIN, 55));
		teamName.setFont(new Font("Menlo", Font.PLAIN, 35));
		
		title.setForeground(Color.white);
		teamName.setForeground(Color.white);
		
		title.setBounds(width/2 - 400/2, 50, 400, 100);
		teamName.setBounds(width/2 - 200/2,	150, 200, 50);
		
		jp.add(title);
		jp.add(teamName);
		
		return jp;
	}
}