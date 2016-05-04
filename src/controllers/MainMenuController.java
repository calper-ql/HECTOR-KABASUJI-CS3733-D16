/**MainMenu Controller
 *  Controller for the main menu/ opening screen
 * @author Morgan Garbett - mlgarbett@wpi.edu
 * @author Can Alper - calper@wpi.edu
 * @author Courtney Davis - cedavis@wpi.edu
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundary.MainMenuView;
import entities.Model;

public class MainMenuController implements IController {
	private MainMenuView mmv;
	private JButton lb;
	private JButton ab;
	private MainController mc;
	
	private Model model;
	LevelSelectController lsc;
	AchievementController ac;
	
	/**
	 * Class Constructor
	 * @param mc
	 * @param model
	 */
	public MainMenuController(MainController mc, Model model) {
		// TODO Auto-generated constructor stub
		this.mmv = new MainMenuView();
		this.mc = mc;
		this.model = model;
		
		lsc = new LevelSelectController(mc, this, model);
		ac = new AchievementController(mc, this);
	}
	
	/**
	 * renders the view for the main menu
	 * @return ret
	 */
	public JPanel getRenderedView(){
		JPanel ret = mmv.render();
		lb = mmv.getLevelsButton();
		ab = mmv.getAchievementButton();
		
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
	
	/**
	 * Swap views to the level select
	 */
	private void levelsButtonClicked(){
		mc.requestSwap(lsc);
	}
	
	/**
	 * Swap the view to the Achievement screen
	 */
	private void achivementsButtonClicked(){
		mc.requestSwap(ac);
		
	}

}
