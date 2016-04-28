package boundary;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import entities.Block;
import entities.Board;
import entities.Tile;

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
				this.tileViews[k][i] = (new TileView(width/12,k,i, board.getTile(k, i)));
			}
		}
	}
	
	public JPanel render(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(x, y, width, height);
		panel.setLayout(null);
		
		for(int i = 0;	i < 12; i++){
			for(int k = 0; k < 12; k++){
				if(board.getTile(k, i).hasBlock()){
					this.tileViews[k][i].setColor(((board.getTile(k, i).getBlock())).getPiece().getColor());
				}
				panel.add(tileViews[k][i].render());
			}
		}
		
		return panel;
	}
	
	public Tile getTileAtPoint(Point p){
		Point abs = new Point(p.x - x,p.y - y);
		if(abs.x < 0) return board.getTile(-1, -1);
		if(abs.y < 0) return board.getTile(-1, -1);
		return board.getTile(abs.x/32, abs.y/32);
	}
	
	public void enableBuilderMode(){
		for(int i = 0;	i < 12; i++){
			for(int k = 0; k < 12; k++){
				this.tileViews[k][i].enableBuilderMode();
			}
		}
	}
}
