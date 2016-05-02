package boundary;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controllers.BoardController;
import entities.Block;
import entities.Board;
import entities.Bullpen;
import entities.EmptyBlock;
import entities.Piece;
import entities.Tile;

public class BoardView {
	
	int x = 215;
	int y = 100;
	int width = 384;
	int height = 384;
	
	Board board;
	
	TileView tileViews[][] = new TileView[12][12];
	private BoardController boardController;
	
	public BoardView(int x, int y, int width, int height, Board board, BoardController boardController) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = width;
		
		this.board = board;
		this.boardController = boardController;
		
		for(int i = 0;	i < 12; i++){
			for(int k = 0; k < 12; k++){
				this.tileViews[k][i] = (new TileView(width/12,k,i, board.getTile(k, i), this));
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

	public void disableBuilderMode() {
		for(int i = 0;	i < 12; i++){
			for(int k = 0; k < 12; k++){
				this.tileViews[k][i].disableBuilderMode();
			}
		}
	}

	public void enableHintSelection() {
		for(int i = 0;	i < 12; i++){
			for(int k = 0; k < 12; k++){
				this.tileViews[k][i].enableHintSelection();
			}
		}
	}
	
	public void enableRemoveMode(){
		for(int i = 0;	i < 12; i++){
			for(int k = 0; k < 12; k++){
				this.tileViews[k][i].enableRemoveMode();
			}
		}
	}

	public void disableRemoveMode() {
		for(int i = 0;	i < 12; i++){
			for(int k = 0; k < 12; k++){
				this.tileViews[k][i].disableRemoveMode();
			}
		}
	}

	public void disableHintSelection() {
		for(int i = 0;	i < 12; i++){
			for(int k = 0; k < 12; k++){
				this.tileViews[k][i].disableHintSelection();
			}
		}
	}

	public void removePiece(Piece piece) {
		for(int i = 0;	i < 12; i++){
			for(int k = 0; k < 12; k++){
				Tile temp = board.getTile(k, i);
				for(int j = 0;	j < 6; j++){
					try {
						if(temp.hasBlock())
						if(temp.getBlock() == piece.getBlock(j)){
							temp.setBlock(new EmptyBlock());
							this.tileViews[k][i].setColor(Color.white);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		boardController.addToBullpen(piece);
	}
	
	public void stateUpdated(){
		boardController.stateUpdated();
	}
}
