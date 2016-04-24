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
	Color tileColor;
	JPanel tilep;
	
	public TileView(int size, int col, int row, Tile tile){
		this.size = size;
		this.col = col;
		this.row = row;
		tileColor = Color.white;
		this.tile = tile;
	}
	
	public JPanel render(){
		tilep = new JPanel();
		tilep.setVisible(tile.enabled());
		tilep.setBorder(new LineBorder(new Color(0, 0, 0)));
		tilep.setBounds(size*col, size*row, size,size);
		tilep.setBackground(tileColor);
		return tilep;
	}
	
	public void reset(){
		tileColor = Color.white;
	}
	
	public void setColor(Color c){
		tileColor = c;
	}
}
