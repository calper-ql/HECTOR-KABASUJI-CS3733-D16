/**
 * This Boundary class is responsible for rendering 
 * all components associated with the Level Select view in the game play application
 * @author
 */
package boundary;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelSelectView {
	private JButton backButton;
	private JButton[] puzzleButtons;
	private JButton[] lightningButtons;
	private JButton[] releaseButtons;

	/**
	 * Class constructor
	 */
	public LevelSelectView() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Renders all components associated with the Level Select View
	 * including the back button, puzzle, lightning, and release level buttons
	 * @return p
	 */
	public JPanel render(){
		JPanel p = new JPanel();
		p.setBackground(Color.darkGray);
		p.setLayout(null);
		int width = 640;
		int height = 535;
		
		backButton = new JButton("<");
		backButton.setBounds(10, 5, 65, 50);
		backButton.setBackground(Color.WHITE);
		p.add(backButton);
		
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
			
			puzzleButtons[i].setBackground(Color.WHITE);
			lightningButtons[i].setBackground(Color.WHITE);
			releaseButtons[i].setBackground(Color.WHITE);
			
			p.add(puzzleButtons[i]);
			p.add(lightningButtons[i]);
			p.add(releaseButtons[i]);
		}

		//Render Puzzle Level Icon
		BufferedImage puzzle_img = null;
		try {
			URL img = boundary.puzzle.BuilderPuzzleLevelView.class.getResource("/img/puzzle.png");
			puzzle_img = ImageIO.read(img);
		} catch (IOException e) {
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
			URL img = boundary.puzzle.BuilderPuzzleLevelView.class.getResource("/img/light.png");
			light_img = ImageIO.read(img);
		} catch (IOException e) {
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
			URL img = boundary.puzzle.BuilderPuzzleLevelView.class.getResource("/img/release.png");
			release_img = ImageIO.read(img);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image release_img_r = release_img.getScaledInstance(35, 50, Image.SCALE_SMOOTH);
		JLabel release_label = new JLabel("");
		release_label.setIcon(new ImageIcon(release_img_r));
		release_label.setBounds(9, 360, 100, 75);
		p.add(release_label);
		
		return p;
	}
	
	/**
	 * Returns the JButton backButton for use by classes in other packages
	 * @return backButton
	 */
	public JButton getBackButton(){
		return backButton;
	}
	
	/**
	 * returns the set of puzzleButtons for use by classes in other packages
	 * @return puzzleButtons
	 */
	public JButton[] getPuzzleButtons(){
		return puzzleButtons;
	}
	
	/**
	 * Returns the set of lightningButtons for use by classes in other packages
	 * @return lightningButtons
	 */
	public JButton[] getLightningButtons(){
		return lightningButtons;
	}
	
	/**
	 * Returns the set of releaseButtons for use by classes in other packages
	 * @return releaseButtons
	 */
	public JButton[] getReleaseButtons(){
		return releaseButtons;
	}
}
