package boundary;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TileView {
	int size;
	int col;
	int row;
	
	public TileView(int size, int col, int row){
		this.size = size;
		this.col = col;
		this.row = row;
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
