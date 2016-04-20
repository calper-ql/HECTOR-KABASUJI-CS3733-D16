package boundary;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class JBlockPanel extends JPanel implements MouseMotionListener, MouseListener{
	int ofsetx;
	int ofsety;
	BlockView bv;
	
	public JBlockPanel(BlockView bv) {
		super();
		ofsetx = 0;
		ofsety = 0;
		addMouseListener(this);
		addMouseMotionListener(this);
		this.bv = bv;
	}
	
	public int getOfsetX() {return ofsetx;}
	public int getOfsetY() {return ofsety;}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		ofsetx = e.getX();
		ofsety = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		bv.update(e.getX()-ofsetx, e.getY()-ofsety);
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
}
