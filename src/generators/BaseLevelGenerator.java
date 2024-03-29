/** Base Level Generator
 * This class creates a base level, or blank level which will be modified 
 * with specifics in order to be made into a puzzle, lightning, or release level 
 * 
 *  @author Morgan Garbett - mlgarbett@wpi.edu
 *  @author Can Alper - calper@wpi.edu
 *  @author Courtney Davis - cedavis@wpi.edu
 */

package generators;

import java.util.ArrayList;

import entities.*;

public class BaseLevelGenerator {
	
	/**
	 * Class constructor
	 */
	public BaseLevelGenerator(){
		
	}
	
	/**
	 * Creates a set of 15 base levels, with 5 Puzzle Levels, 5 Lightning Levels, and 5 Release Levels
	 * all including mock pieces, boards and bullpens
	 * @return baseLevels
	 */
	public static ArrayList<Level> makeBaseLevels(){
		ArrayList<Level> baseLevels = new ArrayList<Level>();
		//Make base Puzzle Levels
		for (int i = 1; i <= 5; i++){ 
			ArrayList<ArrayList<Tile>> mockTiles = (new ArrayList<ArrayList<Tile>>());
			
			for(int j = 0;	j < 12; j++){
				ArrayList<Tile> mockTileRow = (new ArrayList<Tile>());
				for(int k = 0; k < 12; k++){
					Tile mockTile = new Tile(new EmptyBlock(), new EmptyReleaseNumber(), false);
					mockTileRow.add(mockTile);
				}
				mockTiles.add(mockTileRow);
			}
			ArrayList<Piece> mockArrayPieces = (new ArrayList<Piece>());
			DefinedPieces dp = new DefinedPieces();
			//mockArrayPieces = dp.getPieces();
			
			Board mockBoard = new Board(mockTiles);
			Bullpen mockBullpen = new Bullpen(mockArrayPieces);
			PuzzleLevel temp = new PuzzleLevel(true, i, mockBullpen, mockBoard, false, 0);
			if(i == 1) temp.unlock();
			baseLevels.add(temp);
			
		}
		//Make base Lightning Levels
		for (int i = 6; i <= 10; i++){
			//Create Base Tiles
			ArrayList<ArrayList<Tile>> mockTiles = (new ArrayList<ArrayList<Tile>>());
			for(int j = 0;	j < 12; j++){
				ArrayList<Tile> mockTileRow = (new ArrayList<Tile>());
				for(int k = 0; k < 12; k++){
					Tile mockTile = new Tile(new EmptyBlock(), new EmptyReleaseNumber(), false);
					mockTileRow.add(mockTile);
				}
				mockTiles.add(mockTileRow);
			}
			// Create Base Pieces
			ArrayList<Piece> mockArrayPieces = (new ArrayList<Piece>());
			DefinedPieces dp = new DefinedPieces();
			//mockArrayPieces = dp.getPieces();
			// Create Base Bull-pen and Board
			Board mockBoard = new Board(mockTiles);
			Bullpen mockBullpen = new Bullpen(mockArrayPieces);
			
			LightningLevel temp = new LightningLevel(true, i, mockBullpen, mockBoard, false, 0);
			if(i == 6) temp.unlock();
			baseLevels.add(temp);
		}
		//Make base Release Levels
		for (int i = 11; i <= 15; i++){
			ArrayList<ReleaseNumberSet> releaseNumbers = new ArrayList<ReleaseNumberSet>();
			ArrayList<ArrayList<Tile>> mockTiles = (new ArrayList<ArrayList<Tile>>());
			
			for(int j = 0;	j < 12; j++){
				ArrayList<Tile> mockTileRow = (new ArrayList<Tile>());
				for(int k = 0; k < 12; k++){
					Tile mockTile = new Tile(new EmptyBlock(), new ReleaseNumber(0,0), false);
					mockTileRow.add(mockTile);
				}
				mockTiles.add(mockTileRow);
			}
			ArrayList<Piece> mockArrayPieces = (new ArrayList<Piece>());
			DefinedPieces dp = new DefinedPieces();
			//mockArrayPieces = dp.getPieces();
			
			Board mockBoard = new Board(mockTiles);
			Bullpen mockBullpen = new Bullpen(mockArrayPieces);
			//!!! Fix the releaseNumbers
			ReleaseLevel temp = new ReleaseLevel(true, i, mockBullpen, mockBoard, false, releaseNumbers);
			if(i == 11) temp.unlock();
			baseLevels.add(temp);
		}
		
		return baseLevels;
	}
	
	/**
	 * Main, runs makeBaseLevels and saves each base level to the file
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Level> baseLevels = makeBaseLevels();
		for (Level l : baseLevels){
			l.saveToFile();
		}
	}
}
