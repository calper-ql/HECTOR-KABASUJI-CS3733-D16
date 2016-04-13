package controllers;

import javax.swing.JPanel;

import boundary.SplashScreenView;
import entities.SplashScreen;

public class SplashScreenController implements Controller{
	private SplashScreen ss;
	private SplashScreenView ssv;
	public SplashScreenController(boolean isBuilder) {
		ss = new SplashScreen(isBuilder);
		ssv = new SplashScreenView(ss);
	}
	public SplashScreen get(){ return ss; }

	public JPanel getRenderedView() {
		return ssv.render();
	}
}
