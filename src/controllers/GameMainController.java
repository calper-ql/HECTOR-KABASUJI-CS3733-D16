package controllers;

import boundary.WindowManager;
import entities.Model;
import kabasuji.application.Application;

public class GameMainController extends MainController{
	private SplashScreenController ssc;
	private MainMenuController mmc;
	private Model model;
	private Application app;
	
	public GameMainController(Application app) {
		
		this.model = app.getModel();
		
		ssc = new SplashScreenController(false);
		mmc = new MainMenuController(this, model);
	}
	
	public void link(WindowManager wm){
		super.link(wm);
		this.requestSwap(ssc);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.requestSwap(mmc);
	}
}
