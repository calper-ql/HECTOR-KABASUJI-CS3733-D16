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
/**
 * 
 * @author Courtney, 
 *
 */
public class BuilderLevelSelectView {
	private JButton[] puzzleButtons;
	private JButton[] lightningButtons;
	private JButton[] releaseButtons;
	
	
	public BuilderLevelSelectView(){

	}
	
	public JPanel render(){
		JPanel p = new JPanel();
		p.setBackground(Color.darkGray);
		int width = 640;
		int height = 535;
		p.setBounds(0, 0, width, height);
		p.setLayout(null);
		
		
		JLabel builderTitle = new JLabel("Level Builder");
		builderTitle.setFont(new Font("Menlo", Font.PLAIN, 35));
		builderTitle.setForeground(Color.WHITE);
		builderTitle.setBounds(width/3 + 5, 6, 400, 68);
		p.add(builderTitle);
		
		JLabel builderSubTitle = new JLabel("Level Selection");
		builderSubTitle.setFont(new Font("Menlo", Font.PLAIN, 24));
		builderSubTitle.setForeground(Color.WHITE);
		builderSubTitle.setBounds(width/3 + 20, 6, 400, 130);
		p.add(builderSubTitle);
		
		
		puzzleButtons = new JButton[5];
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
		}
		//Render Puzzle Level Icon
				BufferedImage puzzle_img = null;
				try {
					URL img = boundary.BuilderLevelView.class.getResource("/img/puzzle.png");
					puzzle_img = ImageIO.read(img);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Image puzzle_img_r = puzzle_img.getScaledInstance(35, 50, Image.SCALE_SMOOTH);
				
				JLabel puzzle_label = new JLabel("");
				puzzle_label.setIcon(new ImageIcon(puzzle_img_r));
				puzzle_label.setBounds(9, 93, 100, 75);
				p.add(puzzle_label);
				
				//Render Lightning Level Icon
				BufferedImage light_img = null;
				try {
					URL img = boundary.BuilderLevelView.class.getResource("/img/light.png");
					light_img = ImageIO.read(img);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Image light_img_r = light_img.getScaledInstance(35, 50, Image.SCALE_SMOOTH);
				
				JLabel light_label = new JLabel("");
				light_label.setIcon(new ImageIcon(light_img_r));
				light_label.setBounds(9, 230, 100, 75);
				p.add(light_label);

				//Render Release Level Icon
						BufferedImage release_img = null;
						try {
							URL img = boundary.BuilderLevelView.class.getResource("/img/release.png");
							release_img = ImageIO.read(img);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						Image release_img_r = release_img.getScaledInstance(35, 50, Image.SCALE_SMOOTH);
						
						JLabel release_label = new JLabel("");
						release_label.setIcon(new ImageIcon(release_img_r));
						release_label.setBounds(9, 360, 100, 75);
						p.add(release_label);
				
		return p;
	}
	
	
	public JButton[] getPuzzleButtons(){
		return puzzleButtons;
	}
	
	public JButton[] getLightningButtons(){
		return lightningButtons;
	}
	
	public JButton[] getReleaseButtons(){
		return releaseButtons;
	}
}
