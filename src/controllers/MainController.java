package controllers;

import boundry.MainMenuView;
import boundry.SplashScreenView;
import boundry.WindowManager;
import entities.SplashScreen;

public class MainController {
	  WindowManager wm;
	  private MainMenuController mmc;
	  private SplashScreenController ssc;
	  
	  
	  public MainController(){
		  ssc = new SplashScreenController();
		  mmc = new MainMenuController(this);
	  }
	  
	  public void link(WindowManager wm){
		  this.wm = wm;
		  wm.swap(ssc.getRenderedView());
		  try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
		  wm.swap(mmc.getRenderedView());
	  }
	  
	  public void requestSwap(Controller ctrl){
		  wm.swap(ctrl.getRenderedView());
	  }

}
