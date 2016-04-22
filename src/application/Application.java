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
import entities.Achievement;
import entities.Block;
import entities.Board;
import entities.Bullpen;
import entities.EmptyBlock;
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
		
		ArrayList<Tile> mockTileRow = (new ArrayList<Tile>());
		Tile mockTile = new Tile(new EmptyBlock(), null, true);
		Tile mockTile2 = new Tile(new EmptyBlock(), null, false);
		
		boolean test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile2);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile2);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile2);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile2);
		test = mockTileRow.add(mockTile);
		
		ArrayList<ArrayList<Tile>> mockTiles = (new ArrayList<ArrayList<Tile>>());
		test = mockTiles.add(mockTileRow);
		test = mockTiles.add(mockTileRow);
		test = mockTiles.add(mockTileRow);
		test = mockTiles.add(mockTileRow);
		test = mockTiles.add(mockTileRow);
		test = mockTiles.add(mockTileRow);
		test = mockTiles.add(mockTileRow);
		test = mockTiles.add(mockTileRow);
		test = mockTiles.add(mockTileRow);
		test = mockTiles.add(mockTileRow);
		test = mockTiles.add(mockTileRow);
		test = mockTiles.add(mockTileRow);
		
		ArrayList<Piece> mockArrayPieces = (new ArrayList<Piece>());
		Board mockBoard = new Board(mockTiles);
		Bullpen mockBullpen = new Bullpen(mockArrayPieces);
		
		// PIECE TEST FOR BULLPEN
		Piece a1p = new Piece(Color.cyan);
		Block a1 = new Block(a1p);
		Block b1 = new Block(a1p);
		Block c1 = new Block(a1p);
		Block d1 = new Block(a1p);
		Block e1 = new Block(a1p);
		Block g1 = new Block(a1p);
		
		a1.linkNorth(b1);
		a1.linkEast(c1);
		c1.linkEast(d1);
		a1.linkWest(e1);
		e1.linkSouth(g1);
		
		mockArrayPieces.add(a1p);
		mockArrayPieces.add(a1p);
		mockArrayPieces.add(a1p);
		mockArrayPieces.add(a1p);
		mockArrayPieces.add(a1p);
		mockArrayPieces.add(a1p);
		mockArrayPieces.add(a1p);
		
		Level mockLevel = new Level(true, 16 ,mockBullpen, mockBoard, true);
		
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
