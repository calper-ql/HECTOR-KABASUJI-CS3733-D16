package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundary.BuilderLevelSelectView;
import boundary.LevelSelectView;
import controllers.lightning.BuilderLightningLevelController;
import controllers.puzzle.BuilderPuzzleLevelController;
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
	
	public BuilderLevelSelectController(MainController mc, Model model) {
		// TODO Auto-generated constructor stub
		this.mc = mc;
		this.model = model;
		blsv = new BuilderLevelSelectView();
	}

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
				lightningButtonClicked(1);
			}	
		});
		lightningButtons[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lightningButtonClicked(2);
			}	
		});
		lightningButtons[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lightningButtonClicked(3);
			}	
		});
		lightningButtons[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lightningButtonClicked(4);
			}	
		});
		lightningButtons[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lightningButtonClicked(5);
			}	
		});
		
		return p;		
	}
	
	
	private void puzzleButtonClicked(int i){
		this.lvl = new BuilderPuzzleLevelController(mc, this, model, i);
		mc.requestSwap(lvl);
	}
	
	private void lightningButtonClicked(int i){
		this.lvl = new BuilderLightningLevelController(mc, this, model, i);
		mc.requestSwap(lvl);
	}
	
	private void ReleaseButtonClicked(int i){
		this.lvl = new BuilderPuzzleLevelController(mc, this, model, i);
		mc.requestSwap(lvl);
	}
}
