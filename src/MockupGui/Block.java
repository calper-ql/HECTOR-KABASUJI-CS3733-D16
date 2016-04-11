package MockupGui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;


public class Block extends JLabel implements MouseListener, MouseMotionListener, IBlock {
	
	Color color;
	int x;
	int y;
	
	int ofsetx;
	int ofsety;
	
	
	int size;
	boolean pressed;
	
	public IBlock up;
	public IBlock down;
	public IBlock left;
	public IBlock right;
	
	public Block(int size, Color color){
		super();
		x = 0;
		y = 0;
		ofsetx = 0;
		ofsety = 0;
		this.size = size;
		this.color = color;
		this.setOpaque(true);
		this.setBackground(color);
		this.pressed = false;
		up = new EmptyBlock();
		down = new EmptyBlock();
		left = new EmptyBlock();
		right = new EmptyBlock();
		this.setSize(size, size);
		this.setLocation(x, y);
		this.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void build(IBlock b) {
		
		this.setLocation(x, y);
		
		// TODO Auto-generated method stub
		left.setCoord(x-size, y);
		right.setCoord(x+size, y);
		up.setCoord(x, y-size);
		down.setCoord(x, y+size);
		
		if(b != up)up.build(this);
		if(b != down)down.build(this);
		if(b != left)left.build(this);
		if(b != right)right.build(this);	
	}
	
	public void build(){
		build(this);
	}
	
	public void linkUp(Block b){
		up = b;
		b.down = this;
	}
	
	public void linkDown(Block b){
		down = b;
		b.up = this;
	}
	
	public void linkLeft(Block b){
		left = b;
		b.right = this;
	}
	
	public void linkRight(Block b){
		right = b;
		b.left = this;
	}
	
	@Override
	public void setCoord(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x += e.getX() - ofsetx;
		y += e.getY() - ofsety;
		build();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		ofsetx = e.getX();
		ofsety = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		ofsetx = 0;
		ofsety = 0;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
