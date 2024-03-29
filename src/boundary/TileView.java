/**
 * This Boundary Class is responsible for rendering all components associated with a tile's view
 * @author Can Alper - calper@wpi.edu
 * @author Morgan Garbett - mlgarbett@wpi.edu
 * @author Courtney Davis - cedavis@wpi.edu
 */
package boundary;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import entities.Piece;
import entities.Tile;

public class TileView {
	int size;
	int col;
	int row;
	
	Tile tile;
	Color tileColor;
	JPanel tilep;
	
	MouseListener builderListener;
	MouseListener hintListener;
	MouseListener removeListener;
	BoardView boardView;

	/**
	 * Class Constructor
	 * @param size
	 * @param col
	 * @param row
	 * @param tile
	 */
	public TileView(int size, int col, int row, Tile tile, BoardView boardView){
		this.size = size;
		this.col = col;
		this.row = row;
		tileColor = Color.white;
		this.tile = tile;
		this.boardView = boardView;
		tilep = new JPanel();
	}
	
	/**
	 * Enables the remove mode functionality 
	 */
	public void enableRemoveMode(){
		removeListener = new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(!tile.hasBlock())return;
				Piece piece = tile.getBlock().getPiece();
				boardView.removePiece(piece);
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		};
		
		
		
		tilep.addMouseListener(removeListener);
	}
	
	/**
	 * Disables the remove mode functionality
	 */
	public void disableRemoveMode(){
		tilep.removeMouseListener(removeListener);
	}
	
	/**
	 * Disables the builder mode functionality
	 */
	public void enableBuilderMode(){
		builderListener = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				tile.iterateState();
				boardView.stateUpdated();
				propertiesInit();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		};
		tilep.addMouseListener(builderListener);
	}
	
	/**
	 * Allows for selecting of tiles to be hints
	 */
	public void enableHintSelection(){
		hintListener = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (tile.isHintTile()){
					tile.disableHintTile();
				} else {
					tile.enableHintTile();
				}
				propertiesInit();
				boardView.stateUpdated();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
			
			};
		tilep.addMouseListener(hintListener);
	}
	
	/**
	 * Renders the views of all components associated with a tile
	 * @return
	 */
	public JPanel render(){
		tilep = new JPanel();
		propertiesInit();
		
		return tilep;
	}
	
	/**
	 * Initializes all the Swing components associated with tiles
	 */
	private void propertiesInit(){
		tilep.removeAll();
		tilep.setVisible(true);
		tilep.setBorder(new LineBorder(new Color(0, 0, 0)));
		tilep.setBounds(size*col, size*row, size,size);
		if(tile.enabled()) tilep.setBackground(tileColor);
		else tilep.setBackground(Color.darkGray);
		if(tile.enabled() && !tile.hasBlock() && tile.isHintTile()){
			tilep.setBackground(Color.YELLOW);
		}
		if(tile.enabled() && tile.isHintTile()){
			tilep.setBorder(new LineBorder(new Color(0, 236, 255)));
		}
		JLabel release = new JLabel();
		release.setHorizontalAlignment(SwingConstants.CENTER);
		release.setVerticalAlignment(SwingConstants.CENTER);
		release.setBounds(0,0,size,size);
		if(tile.getReleaseNumber().getNum() > 0){
			release.setText((new Integer(tile.getReleaseNumber().getNum())).toString());
			if(tile.getReleaseNumber().getColor() == 0) release.setForeground(Color.BLUE);
			if(tile.getReleaseNumber().getColor() == 1) release.setForeground(Color.RED);
			if(tile.getReleaseNumber().getColor() == 2) release.setForeground(Color.GREEN);
			tilep.add(release);
		}
	}
	
	/**
	 * sets the tile color back to white, indicating it have been reset
	 */
	public void reset(){
		tileColor = Color.white;
	}
	
	/**
	 * Changes the color of a tile, based on any given color
	 * @param c
	 */
	public void setColor(Color c){
		tileColor = c;
		tilep.setBackground(c);
	}

	/**
	 * removes any Builder functionality for a tile
	 */
	public void disableBuilderMode() {
		tilep.removeMouseListener(builderListener);
	}
	
	/**
	 * removes any hint functionality for a tile
	 */
	public void disableHintSelection() {
		tilep.removeMouseListener(hintListener);
	}

}
