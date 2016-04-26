package controllers;

import java.awt.Point;

import javax.swing.JPanel;

import boundary.MainMenuView;
import boundary.SplashScreenView;
import boundary.WindowManager;
import entities.SplashScreen;

public class MainController {
	  WindowManager wm;
	  JPanel current;
	 
	  public MainController(){
		  
	  }
	  
	  public void link(WindowManager wm){
		  this.wm = wm;
	  }
	  
	  public void requestSwap(IController ctrl){
		  current = ctrl.getRenderedView();
		  wm.swap(current);
	  }
	  
	  public Point getMouseLocation(){
		  
		  return current.getMousePosition();
	  }

}
