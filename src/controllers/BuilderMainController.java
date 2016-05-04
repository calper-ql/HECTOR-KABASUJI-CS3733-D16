/**Builder Main Controller
 * Controller for the Level Builder application
 * @author 
 */
package controllers;

import boundary.WindowManager;
import entities.Model;
import kabasuji.builder.Builder;

public class BuilderMainController extends MainController{
	private SplashScreenController ssc;
	private BuilderLevelSelectController blsc;
	private Model model;
	
	/**
	 * Class Constructor
	 * @param app
	 */
	public BuilderMainController(Builder app) {
		ssc = new SplashScreenController(true);
		model = app.getModel();
		blsc= new BuilderLevelSelectController(this, model);
	}
	
	/**
	 * Executes the display of the splash screen and the swap to the appropriate initial screen for game play
	 * @param wm
	 */
	public void link(WindowManager wm){
		super.link(wm);
		this.requestSwap(ssc);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.requestSwap(blsc);
	}
}
