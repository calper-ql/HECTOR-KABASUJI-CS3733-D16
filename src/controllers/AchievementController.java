package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundary.AchievementView;
import entities.Model;

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
		
		resetButton = av.getBackButton();
		resetButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				resetButtonClicked();
			}	
		});
		
		return p;		
	}
	
	protected void resetButtonClicked() {
		Model model = new Model("", null, null);
		model.reload();
		
		model.generateAchievements();
		model.unlockAchievements();
	}

	private void backButtonClicked() {
		mc.requestSwap(back);
	}
}
