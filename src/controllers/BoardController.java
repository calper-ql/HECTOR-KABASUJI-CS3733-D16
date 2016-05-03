package controllers;

import java.awt.Point;

import javax.swing.JPanel;

import boundary.BoardView;
import entities.Board;
import entities.Bullpen;
import entities.Level;
import entities.Piece;
import entities.PuzzleLevel;
import entities.Tile;
import java.util.ArrayList;

public class BoardController {

	JPanel p;
	BoardView bv;
	Level level;
	ILevelController levelController;
	public BoardController(Level level, ILevelController levelController) {
		bv = new BoardView(215, 100, 384, 384, level.getBoard(), this);
		this.level = level;
		this.levelController = levelController;
	}
	
	public JPanel render() {
		
		return bv.render();
	}
	
	public Tile getTileAtPoint(Point p){
		return bv.getTileAtPoint(p);
	}
	
	public void enableBuilderMode(){
		bv.enableBuilderMode();
	}

	public void disableBuilderMode() {
		bv.disableBuilderMode();
		
	}

	public void enableRemoveMode(){
		bv.enableRemoveMode();
	}

	public void disableRemoveMode() {
		bv.disableRemoveMode();
	}

	
	public void enableHintSelection() {
		bv.enableHintSelection();
		
	}
	public void disableHintSelection() {
		bv.disableHintSelection();
		
	}

	public void addToBullpen(Piece piece) {
		level.getBullpen().addPiece(piece);
		if(level instanceof PuzzleLevel){
			((PuzzleLevel) level).setRemaingMoves(((PuzzleLevel) level).getRemainingMoves()-1);
		}
		levelController.requestReRender();
	}
	
	public void stateUpdated(){
		levelController.stateUpdated();
	}

	public ArrayList<ArrayList<Tile>> generateTileList() {
		return bv.generateTileList();
	}


}
