package builder;

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
		
		Level level = new Level(true, 16 , null, null, true);
		ArrayList<Level> levels = new ArrayList<Level>();
		
		for(int i = 1; i < 16; i++){
			try {
				level = level.getFromFile(i);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			levels.add(level);
		}

		
		ArrayList<Achievement> achievementList = null;
		
		Model mockModel = new Model("Kabasuji", achievementList, levels);
		
		this.model = mockModel;
	}
	
	public static void main(String[] args) {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(new BuilderMainController(new Builder()));

	}

}