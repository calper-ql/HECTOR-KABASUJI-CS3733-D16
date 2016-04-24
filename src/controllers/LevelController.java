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
import javax.swing.JLayeredPane;
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
	
	LinkedList<JBlockPanel> blocks;
	BullpenControler bucont;
	BoardController bocont;
	BlockController blcont;
	JPanel p;
	
	public LevelController(MainController mc, Controller back, Model model) {
		this.mc = mc;
		this.back = back;
		lv = new LevelView(model.getLevel(0));
		blcont = new BlockController(new EmptyBlock(), this);
		bucont = new BullpenControler(model.getLevel(0).getBullpen(), blcont);
	}
	

	@Override
	public JPanel getRenderedView() {
		Point loc = mc.getMouseLocation();
		
		p = lv.render();
		
		backButton = lv.getBackButton();
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				backButtonClicked();
			}	
		});
		
		lv.getLayeredPane().add(bucont.render(),new Integer(0), 0);
		
		return p;
		
	}
	
	private void backButtonClicked() {
		mc.requestSwap(back);
	}

	public void piecePressed(JBlockPanel jBlockPanel) {
		LinkedList<JBlockPanel> list = bucont.pop(jBlockPanel);
		try{
			if(list.isEmpty()) return;
		}catch(Exception e){
			return;
		}
		for(JBlockPanel item: list){
			try{
				p.add(item,new Integer(1), 0);
			}catch(Exception e){
						
			}
		}
	}


	public void released(JBlockPanel jBlockPanel) {
		JLayeredPane layers = lv.getLayeredPane();
		layers = new JLayeredPane();
		mc.requestSwap(this);
	}
}
