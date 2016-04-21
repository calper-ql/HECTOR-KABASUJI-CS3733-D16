package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundary.LevelSelectView;
import entities.Model;

public class LevelSelectController implements Controller{
	private LevelSelectView lsv;
	private MainController mc;
	private Controller back;
	private Controller lvl;
	private Model model;
	
	private JButton backButton;
	private JButton[] puzzleButtons;
	private JButton[] lightningButtons;
	private JButton[] releaseButtons;
	
	public LevelSelectController(MainController mc, Controller back, Model model) {
		this.mc = mc;
		this.back = back;
		this.model = model;
		
		this.lvl = new LevelController(mc, back);
		
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
		
		return p;		
	}
	
	private void backButtonClicked() {
		// TODO Auto-generated method stub
		mc.requestSwap(back);
	}
	
	private void puzzleButtonClicked(int i){
		mc.requestSwap(lvl);
	}
}
