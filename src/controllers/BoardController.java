package controllers;

import java.awt.Point;

import javax.swing.JPanel;

import boundary.BoardView;
import entities.Board;
import entities.Tile;

public class BoardController {

	JPanel p;
	BoardView bv;
	
	public BoardController(Board board) {
		bv = new BoardView(215, 100, 384, 384, board);
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

	public void enableHintSelection() {
		bv.enableHintSelection();
		
	}
	public void disableHintSelection() {
		bv.disableHintSelection();
		
	}

}
