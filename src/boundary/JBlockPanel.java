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
	
	public void enablePress(){
		enabled = true;
	}
	
	public void disablePress(){
		enabled = false;
	}
	
	public int getOfsetX() {return ofsetx;}
	public int getOfsetY() {return ofsety;}
	
	public void setOfsetX(int x) {ofsetx = x;}
	public void setOfsetY(int y) {ofsety = y;}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 3) return;
		if(!enabled) return;
		ofsetx = e.getX();
		ofsety = e.getY();
		bv.pressed(this);
		clickLocation = this.getLocation();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == 3) return;
		if(enabled)bv.released(this);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.requestFocus();
	}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getButton() == 3) return;
		if(enabled)bv.updateLocation(e.getX()-ofsetx, e.getY()-ofsety);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	
	}

	public IBlock getBlock() {
		return ib;
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

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
