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
		JPanel tilep = new JPanel();
		tilep.setVisible(tile.enabled());
		tilep.setBorder(new LineBorder(new Color(0, 0, 0)));
		tilep.setBounds(size*col, size*row, size,size);
		tilep.setBackground(new Color(250,255,255));
		return tilep;
	}
}
