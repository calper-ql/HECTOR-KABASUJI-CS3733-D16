package controllers;

import boundary.WindowManager;
import builder.Builder;
import entities.Model;

public class BuilderMainController extends MainController{
	private SplashScreenController ssc;
	private BuilderLevelSelectController blsc;
	private Model model;
	
	public BuilderMainController(Builder app) {
		ssc = new SplashScreenController(true);
		model = app.getModel();
		blsc= new BuilderLevelSelectController(this, model);
	}
	
	public void link(WindowManager wm){
		super.link(wm);
		this.requestSwap(ssc);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.requestSwap(blsc);
	}
}
