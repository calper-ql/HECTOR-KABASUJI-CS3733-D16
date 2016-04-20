package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundary.LevelView;
import entities.Board;
import entities.Bullpen;
import entities.EmptyBlock;
import entities.Level;
import entities.Piece;
import entities.Tile;

public class LevelController implements Controller{
	private LevelView lv;
	private MainController mc;
	private Controller back;
	private JButton backButton;
	
	
	
	
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
	}

	@Override
	public JPanel getRenderedView() {
		JPanel p = lv.render();
		
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
