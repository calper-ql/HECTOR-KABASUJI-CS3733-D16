/**Builder Level Select Controller
 * This controller class handles all push events and view updates 
 * associated with the Level Select screen in the Level Builder
 * @author Courtney Davis - cedavis@wpi.edu
 * @author Morgan Garbett - mlgarbett@wpi.edu
 * @author Can Alper - calper@wpi.edu
 */
package controllers;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import boundary.BuilderLevelSelectView;
import boundary.LevelSelectView;
import controllers.lightning.BuilderLightningLevelController;
import controllers.puzzle.BuilderPuzzleLevelController;
import controllers.release.BuilderReleaseLevelController;
import entities.Model;

public class BuilderLevelSelectController implements IController{
	private BuilderLevelSelectView blsv;
	private MainController mc;
	private IController lvl;
	private Model model;
	
	private JButton backButton;
	private JButton[] puzzleButtons;
	private JButton[] lightningButtons;
	private JButton[] releaseButtons;
	
	/**
	 * Class constructor
	 * @param mc
	 * @param model
	 */
	public BuilderLevelSelectController(MainController mc, Model model) {
		// TODO Auto-generated constructor stub
		this.mc = mc;
		this.model = model;
		blsv = new BuilderLevelSelectView();
	}

	/**
	 * Returns the rendered view of the level select screen, with buttons 1-15 
	 * for the puzzle, lightning, and release levels and their associated action listener methods
	 * @return p
	 */
	@Override
	public JPanel getRenderedView() {
		JPanel p = blsv.render();
		
		puzzleButtons = blsv.getPuzzleButtons();
		
		puzzleButtons[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				puzzleButtonClicked(1);
			}	
		});
		puzzleButtons[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				puzzleButtonClicked(2);
			}	
		});
		puzzleButtons[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				puzzleButtonClicked(3);
			}	
		});
		puzzleButtons[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				puzzleButtonClicked(4);
			}	
		});
		puzzleButtons[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				puzzleButtonClicked(5);
			}	
		});
		
		lightningButtons = blsv.getLightningButtons();
		
		
		lightningButtons[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lightningButtonClicked(6);
			}	
		});
		lightningButtons[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lightningButtonClicked(7);
			}	
		});
		lightningButtons[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lightningButtonClicked(8);
			}	
		});
		lightningButtons[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lightningButtonClicked(9);
			}	
		});
		lightningButtons[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lightningButtonClicked(10);
			}	
		});
		releaseButtons = blsv.getReleaseButtons();
		
		releaseButtons[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				releaseButtonClicked(11);
			}	
		});
		
			releaseButtons[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				releaseButtonClicked(12);
			}	
		});
		
			releaseButtons[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				releaseButtonClicked(13);
			}	
		});
		
			releaseButtons[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				releaseButtonClicked(14);
			}	
		});
		
			releaseButtons[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				releaseButtonClicked(15);
			}	
		});
		
		//Render Puzzle Level Icon
				BufferedImage puzzle_img = null;
				try {
					URL img = boundary.puzzle.BuilderPuzzleLevelView.class.getResource("/img/puzzle.png");
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
					URL img = boundary.puzzle.BuilderPuzzleLevelView.class.getResource("/img/light.png");
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
					URL img = boundary.puzzle.BuilderPuzzleLevelView.class.getResource("/img/release.png");
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
	
	/**
	 * Creates a new Builder Puzzle Level Controller object once a puzzle button is clicked 
	 * then requests the view be re-rendered	
	 * @param i
	 */
	private void puzzleButtonClicked(int i){
		this.lvl = new BuilderPuzzleLevelController(mc, this, model, i);
		mc.requestSwap(lvl);
	}
	
	/**
	 * Creates a new Builder Lightning Level Controller object once a puzzle button is clicked 
	 * then requests the view be re-rendered	
	 * @param i
	 */
	private void lightningButtonClicked(int i){
		this.lvl = new BuilderLightningLevelController(mc, this, model, i);
		mc.requestSwap(lvl);
	}
	
	/**
	 * Creates a new Builder Release Level Controller object once a puzzle button is clicked 
	 * then requests the view be re-rendered	
	 * @param i
	 */
	private void releaseButtonClicked(int i){
		this.lvl = new BuilderReleaseLevelController(mc, this, model, i);
		mc.requestSwap(lvl);
	}
}
