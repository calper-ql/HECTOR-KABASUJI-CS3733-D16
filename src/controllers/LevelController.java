package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public LevelController(MainController mc, Controller back, Model model) {
		this.mc = mc;
		this.back = back;
		bc = new BlockController(new EmptyBlock());
		lv = new LevelView(model.getLevel(0));
	}

	public void update(IBlock block){
		bc = new BlockController(block);
		mc.requestSwap(this);
	}
	
	@Override
	public JPanel getRenderedView() {
		JPanel p = lv.render(bc.getAllViews(100 , 100));
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
