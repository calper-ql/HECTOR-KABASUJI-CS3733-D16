package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundary.AchievementView;
import entities.Model;
import generators.BaseLevelGenerator;

public class AchievementController implements IController{
	private AchievementView av;
	private MainController mc;
	private IController back;
	private JButton backButton;
	private JButton resetButton;
	private Model model;
	
	public AchievementController(MainController mc, IController back, Model model) {
		this.mc = mc;
		this.back = back;
		this.model = model;
		av = new AchievementView();
	}

	@Override
	public JPanel getRenderedView() {
		JPanel p = av.render();
		
		backButton = av.getBackButton();
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				backButtonClicked();
			}	
		});
		
		resetButton = av.getResetButton();
		resetButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				resetButtonClicked();
			}	
		});
		
		return p;		
	}
	
	protected void resetButtonClicked() {
		// reset the achievements
		model.getAchievements();
		
		// send the request to re-render
			mc.requestSwap(this);
	}

	private void backButtonClicked() {
		mc.requestSwap(back);
	}
}
