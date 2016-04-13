package controllers;

import boundary.WindowManager;

public class GameMainController extends MainController{
	private SplashScreenController ssc;
	private MainMenuController mmc;
	
	public GameMainController() {
		ssc = new SplashScreenController(false);
		mmc = new MainMenuController(this);
	}
	
	public void link(WindowManager wm){
		super.link(wm);
		this.requestSwap(ssc);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.requestSwap(mmc);
	}
}
