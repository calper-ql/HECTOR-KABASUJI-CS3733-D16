package controllers;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundary.JBlockPanel;
import boundary.LevelView;

import entities.Board;
import entities.Bullpen;
import entities.EmptyBlock;
import entities.IBlock;
import entities.Level;
import entities.Model;
import entities.Piece;
import entities.Tile;

import entities.Block;
import entities.EmptyBlock;
import entities.Piece;

public class LevelController implements Controller{
	private LevelView lv;
	private MainController mc;
	private Controller back;
	private JButton backButton;
	
	BlockController bc;
	
	int ofsetx;
	int ofsety;
	JPanel p;
	
	
	public LevelController(MainController mc, Controller back, Model model) {
		this.mc = mc;
		this.back = back;
		bc = new BlockController(new EmptyBlock(), this);
		lv = new LevelView(model.getLevel(0), bc);
		ofsetx = 0;
		ofsety = 0;
	}

	
	public void update(IBlock block, int x, int y){
		ofsetx = x;
		ofsety = y;
		bc.setBlock(block);
		System.out.println("hit");
		mc.requestSwap(this);
	}
	
	@Override
	public JPanel getRenderedView() {
		Point loc = mc.getMouseLocation();
		LinkedList<JBlockPanel> blocks = bc.getAllViews(loc.x - ofsetx , loc.y - ofsety, true);
		p = lv.render(blocks);
		
		backButton = lv.getBackButton();
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				backButtonClicked();
			}	
		});
		
		return p;
		
	}
	
	private void backButtonClicked() {
		mc.requestSwap(back);
	}
}
