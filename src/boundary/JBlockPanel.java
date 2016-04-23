package boundary;

import java.awt.Component;
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
	boolean _isOnLevel;
	
	public JBlockPanel(BlockView bv, IBlock ib) {
		super();
		ofsetx = 0;
		ofsety = 0;
		addMouseListener(this);
		addMouseMotionListener(this);
		this.bv = bv;
		this.ib = ib;
		_isOnLevel = false;
	}
	
	public boolean isOnLevel(){
		return _isOnLevel;
	}
	
	
	public void onLevel(){
		_isOnLevel = true;
	}
	
	public int getOfsetX() {return ofsetx;}
	public int getOfsetY() {return ofsety;}
	
	public void setOfsetX(int x) {ofsetx = x;}
	public void setOfsetY(int y) {ofsety = y;}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		ofsetx = e.getX();
		ofsety = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		bv.pressed(new EmptyBlock(), 0 ,0);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(_isOnLevel){
			
		}else {
			ofsetx = e.getX();
			ofsety = e.getY();
			bv.pressed(ib , ofsetx, ofsety);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(_isOnLevel)bv.update(e.getX()-ofsetx, e.getY()-ofsety);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	
	}
}
