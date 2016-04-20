package boundary;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import entities.Tile;

public class TileView {
	int size;
	int col;
	int row;
	
	Tile tile;
	
	public TileView(int size, int col, int row, Tile tile){
		this.size = size;
		this.col = col;
		this.row = row;
		
		this.tile = tile;
	}
	
	public JPanel render(){
		JPanel tile = new JPanel();
		tile.setVisible(true);
		tile.setBorder(new LineBorder(new Color(0, 0, 0)));
		tile.setBounds(size*col, size*row, size,size);
		tile.setBackground(new Color(250,255,255));
		return tile;
	}
}
