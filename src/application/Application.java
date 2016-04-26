package application;

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
		
	
		
		ArrayList<ArrayList<Tile>> mockTiles = (new ArrayList<ArrayList<Tile>>());
		
		for(int i = 0;	i < 12; i++){
			ArrayList<Tile> mockTileRow = (new ArrayList<Tile>());
			for(int k = 0; k < 12; k++){
				Tile mockTile = new Tile(new EmptyBlock(), new EmptyReleaseNumber(), true);
				mockTileRow.add(mockTile);
			}
			mockTiles.add(mockTileRow);
		}
		
		ArrayList<Piece> mockArrayPieces = (new ArrayList<Piece>());
		DefinedPieces dp = new DefinedPieces();
		mockArrayPieces = dp.getPieces();
		
		Board mockBoard = new Board(mockTiles);
		Bullpen mockBullpen = new Bullpen(mockArrayPieces);
		
		Level mockLevel = new Level(true, 16 ,mockBullpen, mockBoard, true);

		
		mockLevel.saveToFile();
		try {
			mockLevel = mockLevel.getFromFile(16);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		ArrayList<Level> mockLevels = new ArrayList<Level>();
		mockLevels.add(mockLevel);
		mockLevels.add(mockLevel);
		mockLevels.add(mockLevel);
		mockLevels.add(mockLevel);
		mockLevels.add(mockLevel);
		mockLevels.add(mockLevel);
		mockLevels.add(mockLevel);
		mockLevels.add(mockLevel);
		mockLevels.add(mockLevel);
		mockLevels.add(mockLevel);
		mockLevels.add(mockLevel);
		mockLevels.add(mockLevel);
		mockLevels.add(mockLevel);
		mockLevels.add(mockLevel);
		mockLevels.add(mockLevel);
		
		
		BufferedImage mock_img = null;
		try {
			// load relative image
			URL img = boundary.AchievementView.class.getResource("/img/888267.jpg");
			mock_img = ImageIO.read(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image mock_img_r = mock_img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		
		Achievement mockAchievement = new Achievement("yolo",mock_img_r, true);
		ArrayList<Achievement> mockAchievements = new ArrayList<Achievement>();
		mockAchievements.add(mockAchievement);
		
		
		Model mockModel = new Model("Kabasuji", mockAchievements, mockLevels);
		
		this.model = mockModel;
	}

	public static void main(String[] args) {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(new GameMainController(new Application()));
	}

}
