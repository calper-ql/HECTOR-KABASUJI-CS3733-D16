package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundry.MainMenuView;

public class MainMenuController  {
	
	private MainMenuView mmv;
	private JButton lb;
	private JButton ab;
	
	public MainMenuController(MainMenuView mmv) {
		// TODO Auto-generated constructor stub
		this.mmv = mmv;
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
		System.out.println("Poop");
	}
	
	private void achivementsButtonClicked(){
		System.out.println("Pee");
	}

}
