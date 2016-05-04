/**
 * This Boundary class is to render all components associated with JBlockPanels
 * @author Can Alper - calper@wpi.edu
 * @author Zach Armsby - zrarmsby@wpi.edu
 */
package boundary;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import entities.EmptyBlock;
import entities.IBlock;
import entities.Block;

public class JBlockPanel extends JPanel implements MouseMotionListener, MouseListener, FocusListener, KeyListener {
	int ofsetx;
	int ofsety;
	BlockView bv;
	IBlock ib;
	
	Point clickLocation;
	boolean enabled;

	/**
	 * Class constructor
	 * @param bv
	 * @param ib
	 */
	public JBlockPanel(BlockView bv, IBlock ib) {
		super();
		ofsetx = 0;
		ofsety = 0;
		addMouseListener(this);
		addMouseMotionListener(this);
		addFocusListener(this);
		addKeyListener(this);
		this.setFocusable(true);
		this.bv = bv;
		enabled = true;
		this.ib = ib;
	}

	/**
	 * Sets enabled boolean to true
	 */
	public void enablePress(){
		enabled = true;
	}
	
	/**
	 * Sets enabled boolean to false
	 */
	public void disablePress(){
		enabled = false;
	}
	
	/**
	 * Returns the int ofsetx for use by classes in other packages
	 * @return ofsetx
	 */
	public int getOfsetX() {return ofsetx;}
	
	/**
	 * Returns the int ofsety for use by classes in other packages
	 * @return ofsety
	 */
	public int getOfsetY() {return ofsety;}
	
	/**
	 * Sets ofsetx to the integer passed in as a parameter	
	 * @param x
	 */
	public void setOfsetX(int x) {ofsetx = x;}
	
	/**
	 * Sets ofsety to the integer passed in as a parameter	
	 * @param y
	 */
	public void setOfsetY(int y) {ofsety = y;}


	@Override
	public void mouseClicked(MouseEvent e) {}

	/**
	 * Once a mouse is pressed, the location and ofsetx and ofsety are updated
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 3) return;
		if(!enabled) return;
		ofsetx = e.getX();
		ofsety = e.getY();
		bv.pressed(this);
		clickLocation = this.getLocation();
	}

	/**
	 * If this JBlockPanel is enabled, the released method is called on the associated Block View
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == 3) return;
		if(enabled)bv.released(this);
	}

	/**
	 * Calls the request Focus method once a mouse event takes place
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		this.requestFocus();
	}

	
	@Override
	public void mouseExited(MouseEvent e) {}

	/**
	 * Handles necessary view components of a dragging action
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getButton() == 3) return;
		if(enabled)bv.updateLocation(e.getX()-ofsetx, e.getY()-ofsety);
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	/**
	 * Returns the IBlock associated with this JBlockPanel for use by classes in other packages
	 * @return ib
	 */
	public IBlock getBlock() {
		return ib;
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	/**
	 * Handles the use of keys.
	 * Rotates right if r key is pressed
	 * Rotates left is l key is pressed
	 * Flips horizontally if h key is pressed
	 * Flips vertically if v key is pressed 
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == 'r'){
			((Block)this.ib).rotate(true);
			bv.updateTransform(this);
		}
		if(e.getKeyChar() == 'l'){
			((Block)this.ib).rotate(false);
			bv.updateTransform(this);
		}
		if(e.getKeyChar() == 'h'){
			((Block)this.ib).flip(true);
			bv.updateTransform(this);
		}
		if(e.getKeyChar() == 'v'){
			((Block)this.ib).flip(false);
			bv.updateTransform(this);
		}
		
	}

	@Override
	public void focusGained(FocusEvent e) {}

	@Override
	public void focusLost(FocusEvent e) {}
}
