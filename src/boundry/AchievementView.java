package boundry;

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
		
		
		
		
		
		
		/*puzzleButtons = new JButton[5];
		lightningButtons = new JButton[5];
		releaseButtons = new JButton[5];
		
		for(int i = 0; i < 5; i++){
			puzzleButtons[i] = new JButton(new Integer(i+1).toString());
			lightningButtons[i] = new JButton(new Integer(i+1).toString());
			releaseButtons[i] = new JButton(new Integer(i+1).toString());
			
			puzzleButtons[i]   .setBounds(50 + i*110, height/4   - 40, 100, 75);
			lightningButtons[i].setBounds(50 + i*110, height/4*2 - 40, 100, 75);
			releaseButtons[i]  .setBounds(50 + i*110, height/4*3 - 40, 100, 75);
			
			p.add(puzzleButtons[i]);
			p.add(lightningButtons[i]);
			p.add(releaseButtons[i]);
		}*/
		
		return p;
	}
	
	public JButton getBackButton(){
		return backButton;
	}
}
