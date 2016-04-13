package application;

import boundry.MainMenuView;
import boundry.WindowManager;
import controllers.MainMenuController;

public class MainController {
	  WindowManager wm;
	  MainMenuController mmc;
	  
	  MainController(){
		  mmc = new MainMenuController(new MainMenuView());
	  }
	  
	  public void link(WindowManager wm){
		  this.wm = wm;
		  wm.swap(mmc.getRenderedView());
	  }

}
