package boundary;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
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
	
	public void enableBuilder(){
		tilep.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				tile.iterateState();
			}
		});
	}
	
	public JPanel render(){
		tilep = new JPanel();
		tilep.setVisible(tile.enabled());
		tilep.setBorder(new LineBorder(new Color(0, 0, 0)));
		tilep.setBounds(size*col, size*row, size,size);
		tilep.setBackground(tileColor);
		JLabel release = new JLabel();
		release.setBounds(0,0,size,size);
		if(tile.getReleaseNumber().getNum() > 0){
			release.setText((new Integer(tile.getReleaseNumber().getNum())).toString());
			if(tile.getReleaseNumber().getColor() == 0) release.setForeground(Color.BLUE);
			if(tile.getReleaseNumber().getColor() == 1) release.setForeground(Color.RED);
			if(tile.getReleaseNumber().getColor() == 2) release.setForeground(Color.GREEN);
			tilep.add(release);
		}
		
		return tilep;
	}
	
	public void reset(){
		tileColor = Color.white;
	}
	
	public void setColor(Color c){
		tileColor = c;
	}
}
