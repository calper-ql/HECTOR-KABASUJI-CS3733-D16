package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundary.MainMenuView;

public class MainMenuController implements Controller {
	private MainMenuView mmv;
	private JButton lb;
	private JButton ab;
	private MainController mc;
	LevelSelectController lsc;
	AchievementController ac;
	
	public MainMenuController(MainController mc) {
		// TODO Auto-generated constructor stub
		this.mmv = new MainMenuView();
		this.mc = mc;
		lsc = new LevelSelectController(mc, this);
		ac = new AchievementController(mc, this);
	}
	
	
	public JPanel getRenderedView(){
		JPanel ret = mmv.render();
		lb = mmv.getLevelsButton();
		ab = mmv.getAchivementButton();
		
		lb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				levelsButtonClicked();
			}
		});
		
		ab.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				achivementsButtonClicked();
			}
		});
		
		return ret;
	}
	
	private void levelsButtonClicked(){
		mc.requestSwap(lsc);
	}
	
	private void achivementsButtonClicked(){
		mc.requestSwap(ac);
	}

}
