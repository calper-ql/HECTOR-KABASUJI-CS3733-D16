package boundary;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import entities.Board;

public class BoardView {
	
	int x = 215;
	int y = 100;
	int width = 384;
	int height = 384;
	
	Board board;
	
	TileView tileViews[][] = new TileView[12][12];
	
	public BoardView(int x, int y, int width, int height, Board board) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = width;
		
		this.board = board;
		
		for(int i = 0;	i < 12; i++){
			for(int k = 0; k < 12; k++){
				tileViews[k][i] = (new TileView(width/12,k,i, board.getTile(k, i)));
			}
		}
	}
	
	public JPanel render(){
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(x, y, width, height);
		panel.setLayout(null);
		
		
		for(int i = 0;	i < 12; i++){
			for(int k = 0; k < 12; k++){
				panel.add(tileViews[k][i].render());
			}
		}
		
		return panel;
	}
}
