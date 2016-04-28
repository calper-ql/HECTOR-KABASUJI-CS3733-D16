package kabasuji.application;

import java.util.ArrayList;

import boundary.WindowManager;

import controllers.GameMainController;
import entities.Model;
import entities.Achievement;
import generators.AchievementGenerator;


public class Application {
	private Model model;
	
	public Application(){
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
		wmg.link(new GameMainController(new Application()));
	}

}
