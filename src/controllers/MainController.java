/** MainController
* the main controller of kabasuji, handles the window and swaps
* @author Can Alper - calper@wpi.edu
*/

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
	 
	  /** Class Constructor
	   * 
	   */
	  public MainController(){
		  
	  }
	  
	  /**
	   * Links the window manager and the main controller
	   * @param wm
	   */
	  public void link(WindowManager wm){
		  this.wm = wm;
	  }
	  
	  /**
	   * Handles swap requests and changes views
	   * @param ctrl
	   */
	  public void requestSwap(IController ctrl){
		  current = ctrl.getRenderedView();
		  wm.swap(current);
	  }
	  
	  /**
	   * Gets the mouse location
	   * @return current.getMousePosition()
	   */
	  public Point getMouseLocation(){
		  
		  return current.getMousePosition();
	  }

}
