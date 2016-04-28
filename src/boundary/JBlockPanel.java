package boundary;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import entities.EmptyBlock;
import entities.IBlock;

public class JBlockPanel extends JPanel implements MouseMotionListener, MouseListener {
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
		if(!enabled) return;
		ofsetx = e.getX();
		ofsety = e.getY();
		bv.pressed(this);
		clickLocation = this.getLocation();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(enabled)bv.released(this);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(enabled)bv.update(e.getX()-ofsetx, e.getY()-ofsety);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	
	}

	public IBlock getBlock() {
		// TODO Auto-generated method stub
		return ib;
	}
}
