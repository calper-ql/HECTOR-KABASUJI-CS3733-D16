package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundary.AchievementView;
import entities.Achievement;
import entities.Model;
import generators.AchievementGenerator;
import generators.BaseLevelGenerator;

public class AchievementController implements IController{
	private AchievementView av;
	private MainController mc;
	private IController back;
	private JButton backButton;
	private JButton resetButton;
	
	public AchievementController(MainController mc, IController back) {
		this.mc = mc;
		this.back = back;
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
		ArrayList<Achievement> achievements = AchievementGenerator.makeAchievements();
		for(Achievement a : achievements){
			a.deleteAcheivement();
		}
		// send the request to re-render
		mc.requestSwap(this);
	}

	private void backButtonClicked() {
		mc.requestSwap(back);
	}
}
