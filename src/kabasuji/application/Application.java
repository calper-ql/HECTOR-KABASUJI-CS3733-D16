/** Application
 * Application for Kabasuji game play 
 * 
 * @author Can Alper - calper@wpi.edu
 */

package kabasuji.application;

import java.util.ArrayList;

import boundary.WindowManager;

import controllers.GameMainController;
import entities.Model;
import entities.Achievement;
import generators.AchievementGenerator;


public class Application {
	private Model model;
	

	/**
	 * Class constructor
	 */
	public Application(){
		initialize();
	}
	
	/**
	 * Returns the model for use by classes in other packages
	 * @return model
	 */
	public Model getModel(){
		return model;
	}
	
	/**
	 * Runs initializeModel()
	 */
	public void initialize() {
		initializeModel();
		
	}
	
	/**
	 * Initializes a new Model with null achievements and levels, 
	 * then loads the base levels from the file
	 */
	public void initializeModel(){
		Model model = new Model("Kabasuji", null, null);
		model.reload();
		this.model = model;
	}

	/**
	 * Main, instantiates a new WindowManager
	 * @param args
	 */
	public static void main(String[] args) {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(new GameMainController(new Application()));
	}

}
