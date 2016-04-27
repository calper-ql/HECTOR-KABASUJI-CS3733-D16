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
	
	public Builder(){
		initialize();
	}
	
	public Model getModel(){
		return model;
	}
	
	
	public void initialize() {
		initializeModel();
		
	}
	
	public void initializeModel(){
		Model model = new Model("Kabasuji", null, null);
		model.reload();
		this.model = model;
	}
	
	public static void main(String[] args) {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(new BuilderMainController(new Builder()));

	}

}