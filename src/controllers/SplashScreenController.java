package controllers;

import javax.swing.JPanel;

import boundry.SplashScreenView;
import entities.SplashScreen;

public class SplashScreenController {
	private SplashScreen sp;
	private SplashScreenView spw;
	public SplashScreenController(SplashScreen sp, SplashScreenView spw) {
		this.sp = sp;
		this.spw = spw;
	}
	public SplashScreen get(){ return sp; }

	public JPanel getRenderedView() {
		return spw.render();
	}
}
