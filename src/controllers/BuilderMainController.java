package controllers;

import boundary.WindowManager;

public class BuilderMainController extends MainController{
	private SplashScreenController ssc;
	private BuilderLevelSelectController blsc;
	
	public BuilderMainController() {
		ssc = new SplashScreenController();
		blsc= new BuilderLevelSelectController(this);
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
		this.requestSwap(blsc);
	}
}
