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

import boundary.LevelSelectView;
import controllers.lightning.LightningLevelController;
import controllers.puzzle.PuzzleLevelController;
import entities.Model;

public class LevelSelectController implements IController{
	private LevelSelectView lsv;
	private MainController mc;
	private IController back;
	private IController lvl;
	private Model model;

	private JButton backButton;
	private JButton[] puzzleButtons;
	private JButton[] lightningButtons;
	private JButton[] releaseButtons;

	public LevelSelectController(MainController mc, IController back, Model model) {
		this.mc = mc;
		this.back = back;
		this.model = model;
		lsv = new LevelSelectView();
	}

	@Override
	public JPanel getRenderedView() {
		JPanel p = lsv.render();

		backButton = lsv.getBackButton();
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				backButtonClicked();
			}	
		});

		puzzleButtons = lsv.getPuzzleButtons();


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

		lightningButtons = lsv.getLightningButtons();
		
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
		
		/** !!! When Release is implemented 
		releaseButtons = lsv.getReleaseButtons();
		
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
		*/
		
		
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

	private void backButtonClicked() {
		mc.requestSwap(back);
	}

	private void puzzleButtonClicked(int i){
		model.reload();
		this.lvl = new PuzzleLevelController(mc, this, model, i);
		mc.requestSwap(lvl);
	}
	private void lightningButtonClicked(int i){
		model.reload();
		this.lvl = new LightningLevelController(mc, this, model, i);
		mc.requestSwap(lvl);
	}
	//!!! when release implemented
	/**private void releaseButtonClicked(int i){
		model.reload();
		this.lvl = new ReleaseLevelController(mc, this, model, i);
		mc.requestSwap(lvl);
	}
	*/
}
