package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundary.AchievementView;

public class AchievementController implements IController{
	private AchievementView av;
	private MainController mc;
	private IController back;
	private JButton backButton;
	
	public AchievementController(MainController mc, IController back) {
		// TODO Auto-generated constructor stub
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
		
		return p;		
	}
	
	private void backButtonClicked() {
		mc.requestSwap(back);
	}
}
