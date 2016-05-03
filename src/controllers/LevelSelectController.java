package controllers;

import java.awt.Color;
import java.awt.Font;
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
import entities.Achievement;
import entities.Level;
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
		
		//Render Puzzle Level Stars
		for(int i = 1; i<=5; i++){
			int starCount;
			try {
				starCount = model.getLevel(i).getFromFile(i).getStars();
				if (starCount >= 1){
					BufferedImage star_img = null;
					try {
						URL img = boundary.BaseLevelView.class.getResource("/img/star-xxl.png");
						star_img = ImageIO.read(img);
					} catch (IOException e) {
						e.printStackTrace();
					}
					Image star_img_r = star_img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					JLabel lblNewLabel_1 = new JLabel("");
					lblNewLabel_1.setIcon(new ImageIcon(star_img_r));
					lblNewLabel_1.setBounds(50 + i*110, 535/4 - 40, 100, 75);
					p.add(lblNewLabel_1);
				}
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		//Render Lightning Level Stars
		for(int i = 6; i<=10; i++){
			Level l = model.getLevel(i);
			if (l.getStars() == 1){
				BufferedImage star_img = null;
				try {
					URL img = boundary.BaseLevelView.class.getResource("/img/star-xxl.png");
					star_img = ImageIO.read(img);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Image star_img_r = star_img.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setIcon(new ImageIcon(star_img_r));
				lblNewLabel_1.setBounds(50 + i*110, 535/4*2 - 40, 100, 75);
				p.add(lblNewLabel_1);
			}
		}
		//Render Release Level Stars
		for(int i = 11; i<=15; i++){
			Level l = model.getLevel(i);
			if (l.getStars() == 1){
				BufferedImage star_img = null;
				try {
					URL img = boundary.BaseLevelView.class.getResource("/img/star-xxl.png");
					star_img = ImageIO.read(img);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Image star_img_r = star_img.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setIcon(new ImageIcon(star_img_r));
				lblNewLabel_1.setBounds(50 + i*110, 535/4*3 - 40, 100, 75);
				p.add(lblNewLabel_1);
			}
		}
		
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
