package kabasuji.application;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import boundary.WindowManager;

import controllers.GameMainController;
import entities.Model;
import entities.Piece;
import entities.ReleaseNumber;
import entities.Achievement;
import entities.Block;
import entities.Board;
import entities.Bullpen;
import entities.DefinedPieces;
import entities.EmptyBlock;
import entities.EmptyReleaseNumber;
import entities.Level;
import entities.Tile;
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
