package controllers;

import boundary.MainMenuView;
import boundary.SplashScreenView;
import boundary.WindowManager;
import entities.SplashScreen;

public class MainController {
	  WindowManager wm;
	 
	  
	  
	  public MainController(){
		  
	  }
	  
	  public void link(WindowManager wm){
		  this.wm = wm;
	  }
	  
	  public void requestSwap(Controller ctrl){
		  wm.swap(ctrl.getRenderedView());
	  }

}
