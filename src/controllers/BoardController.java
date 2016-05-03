package controllers;

import java.awt.Point;
import java.io.IOException;

import javax.swing.JPanel;

import boundary.BoardView;
import entities.Board;
import entities.Bullpen;
import entities.Level;
import entities.Model;
import entities.Piece;
import entities.PuzzleLevel;
import entities.Tile;
import java.util.ArrayList;

public class BoardController {

	JPanel p;
	BoardView bv;
	Level level;
	ILevelController levelController;
	Model model;
	
	public BoardController(Level level, ILevelController levelController, Model model) {
		bv = new BoardView(215, 100, 384, 384, level.getBoard(), this);
		this.level = level;
		this.levelController = levelController;
		this.model = model;
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
			
			if(level.hasFinished()){
				System.out.println("finished");
				try {
					if(level.getLevelNum()>0){
						PuzzleLevel savelvl = (PuzzleLevel) level.getFromFile(level.getLevelNum());
						savelvl.setStars(level.getStars());
						savelvl.saveToFile();
					}
				} catch (ClassNotFoundException | IOException e) {}
				try {
					if(level.getStars() > 0 && level.getLevelNum()>0){
						Level next = level.getFromFile(level.getLevelNum()+1);
						next.unlock();
						next.saveToFile();
					}
				} catch (ClassNotFoundException | IOException e) {}
				model.reload();
			}
		}
		
		if (level.hasFinished()){
			levelController.requestReRenderBack();
		} else {
			levelController.requestReRender();
		}
	}
	
	public void stateUpdated(){
		levelController.stateUpdated();
	}

	public ArrayList<ArrayList<Tile>> generateTileList() {
		return bv.generateTileList();
	}


}
