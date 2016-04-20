package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundary.JBlockPanel;
import boundary.LevelView;

import entities.Board;
import entities.Bullpen;
import entities.EmptyBlock;
import entities.Level;
import entities.Piece;
import entities.Tile;

import entities.Block;
import entities.EmptyBlock;
import entities.Piece;

public class LevelController implements Controller{
	private LevelView lv;
	private MainController mc;
	private Controller back;
	private JButton backButton;
	BlockController bc;
	
	public LevelController(MainController mc, Controller back) {
		// TODO Auto-generated constructor stub
		this.mc = mc;
		this.back = back;
		
		ArrayList<Tile> mockTileRow = (new ArrayList<Tile>());
		Tile mockTile = new Tile(new EmptyBlock(), null, true);
		
		boolean test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile);
		test = mockTileRow.add(mockTile);
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
		Level mockLevel = new Level(true, 16 ,mockBullpen, mockBoard, true);
		
		
		lv = new LevelView(mockLevel);
		bc = new BlockController(new EmptyBlock());

	}

	@Override
	public JPanel getRenderedView() {
		Block a1 = new Block(new Piece(Color.CYAN));
		Block a2 = new Block(a1.getPiece());
		Block a3 = new Block(a1.getPiece());
		
		a1.linkNorth(a2);
		a1.linkEast(a3);
		
		bc = new BlockController(a1);
		JPanel p = lv.render(bc.getAllViews(100 , 100));
		
		backButton = lv.getBackButton();
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				backButtonClicked();
			}	
		});
		
		return p;		
	}
	
	private void backButtonClicked() {
		// TODO Auto-generated method stub
		mc.requestSwap(back);
	}
}
