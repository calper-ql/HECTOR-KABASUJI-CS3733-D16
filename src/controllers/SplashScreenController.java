package controllers;

import javax.swing.JPanel;

import boundry.SplashScreenView;
import entities.SplashScreen;

public class SplashScreenController implements Controller{
	private SplashScreen ss;
	private SplashScreenView ssv;
	public SplashScreenController() {
		ss = new SplashScreen(false);
		ssv = new SplashScreenView(ss);
	}
	public SplashScreen get(){ return ss; }

	public JPanel getRenderedView() {
		return ssv.render();
	}
}
