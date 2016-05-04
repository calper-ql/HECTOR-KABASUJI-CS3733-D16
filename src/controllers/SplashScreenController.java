/**SplashScreen Controller
 *  Contoller displaying the splash screen 
 * @author Can Alper - calper@wpi.edu 
 */
package controllers;

import javax.swing.JPanel;

import boundary.SplashScreenView;
import entities.SplashScreen;

public class SplashScreenController implements IController{
	private SplashScreen ss;
	private SplashScreenView ssv;
	
	/**
	 * Class Constructor
	 * @param isBuilder
	 */
	public SplashScreenController(boolean isBuilder) {
		ss = new SplashScreen(isBuilder);
		ssv = new SplashScreenView(ss);
	}
	
	/**
	 * Get the splash screen entity
	 */
	public SplashScreen get(){ return ss; }

	/**
	 * Renders the splash screen view
	 */
	public JPanel getRenderedView() {
		return ssv.render();
	}
}
