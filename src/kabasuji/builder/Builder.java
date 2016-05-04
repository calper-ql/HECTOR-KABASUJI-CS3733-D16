/** Builder 
 * Application for Kabasuji Level Builder
 * 
 * @author Can Alper - calper@wpi.edu
 */

package kabasuji.builder;

import java.io.IOException;
import java.util.ArrayList;

import boundary.WindowManager;
import controllers.BuilderMainController;
import entities.Achievement;
import entities.Board;
import entities.Bullpen;
import entities.DefinedPieces;
import entities.EmptyBlock;
import entities.EmptyReleaseNumber;
import entities.Level;
import entities.Model;
import entities.Piece;
import entities.Tile;

public class Builder {

	private Model model;
	
	/**
	 * Class Constructor
	 */
	public Builder(){
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
	 * Runs the initialize model method	
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
	 * Main, instantiates a new window manager
	 * @param args
	 */
	public static void main(String[] args) {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(new BuilderMainController(new Builder()));

	}

}