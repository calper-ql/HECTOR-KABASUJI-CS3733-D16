package baseLevelGenerator;

import java.util.ArrayList;

import entities.*;

public class BaseLevelGenerator {
	public BaseLevelGenerator(){
	}
	public static ArrayList<ILevel> makeBaseLevels(){
		ArrayList<ILevel> baseLevels = new ArrayList<ILevel>();
		//Make base Puzzle Levels
		for (int i = 1; i <= 5; i++){
			ArrayList<ArrayList<Tile>> mockTiles = (new ArrayList<ArrayList<Tile>>());
			
			for(int j = 0;	j < 12; j++){
				ArrayList<Tile> mockTileRow = (new ArrayList<Tile>());
				for(int k = 0; k < 12; k++){
					Tile mockTile = new Tile(new EmptyBlock(), null, true);
					mockTileRow.add(mockTile);
				}
				mockTiles.add(mockTileRow);
			}
			ArrayList<Piece> mockArrayPieces = (new ArrayList<Piece>());
			DefinedPieces dp = new DefinedPieces();
			mockArrayPieces = dp.getPieces();
			
			Board mockBoard = new Board(mockTiles);
			Bullpen mockBullpen = new Bullpen(mockArrayPieces);
			baseLevels.add(new PuzzleLevel(true, i, mockBullpen, mockBoard, false, 0));
		}
		//Make base Lightning Levels
		for (int i = 6; i <= 10; i++){
			//Create Base Tiles
			ArrayList<ArrayList<Tile>> mockTiles = (new ArrayList<ArrayList<Tile>>());
			for(int j = 0;	j < 12; j++){
				ArrayList<Tile> mockTileRow = (new ArrayList<Tile>());
				for(int k = 0; k < 12; k++){
					Tile mockTile = new Tile(new EmptyBlock(), null, true);
					mockTileRow.add(mockTile);
				}
				mockTiles.add(mockTileRow);
			}
			// Create Base Pieces
			ArrayList<Piece> mockArrayPieces = (new ArrayList<Piece>());
			DefinedPieces dp = new DefinedPieces();
			mockArrayPieces = dp.getPieces();
			// Create Base Bull-pen and Board
			Board mockBoard = new Board(mockTiles);
			Bullpen mockBullpen = new Bullpen(mockArrayPieces);
			
			baseLevels.add(new LightningLevel(true, i, mockBullpen, mockBoard, false, 0));
		}
		//Make base Release Levels
		for (int i = 11; i <= 15; i++){
			//!!!
			ArrayList<ReleaseNumberSet> releaseNumbers = new ArrayList<ReleaseNumberSet>();
			ArrayList<ArrayList<Tile>> mockTiles = (new ArrayList<ArrayList<Tile>>());
			
			for(int j = 0;	j < 12; j++){
				ArrayList<Tile> mockTileRow = (new ArrayList<Tile>());
				for(int k = 0; k < 12; k++){
					Tile mockTile = new Tile(new EmptyBlock(), null, true);
					mockTileRow.add(mockTile);
				}
				mockTiles.add(mockTileRow);
			}
			ArrayList<Piece> mockArrayPieces = (new ArrayList<Piece>());
			DefinedPieces dp = new DefinedPieces();
			mockArrayPieces = dp.getPieces();
			
			Board mockBoard = new Board(mockTiles);
			Bullpen mockBullpen = new Bullpen(mockArrayPieces);
			//!!! Fix the releaseNumbers
			baseLevels.add(new ReleaseLevel(true, i, mockBullpen, mockBoard, false, releaseNumbers));
		}
		for (ILevel l : baseLevels){
			l.saveToFile();
		}
		return baseLevels;
	}
	
	public static void main(String[] args) {
		makeBaseLevels();
	}
}
