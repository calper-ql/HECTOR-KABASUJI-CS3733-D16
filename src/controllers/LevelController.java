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
import boundary.BaseLevelView;

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

public class LevelController implements IController, ILevelController{
	private BaseLevelView lv;
	private MainController mc;
	private IController back;
	private JButton backButton;
	
	LinkedList<JBlockPanel> blocks;
	BullpenControler bucont;
	BoardController bocont;
	BlockController blcont;
	JPanel p;
	LinkedList<JBlockPanel> currentList ;
	
	public LevelController(MainController mc, IController back, Model model) {
		this.mc = mc;
		this.back = back;
		lv = new BaseLevelView(model.getLevel(0));
		blcont = new BlockController(new EmptyBlock(), this);
		bucont = new BullpenControler(model.getLevel(0).getBullpen(), blcont, this);
		bocont = new BoardController(model.getLevel(0), this, model);
		currentList = null;
		
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
		
		lv.getLayeredPane().add(bocont.render(), new Integer(0), 0);
		lv.getLayeredPane().add(bucont.render(), new Integer(0), 0);

		return p;
		
	}
	
	private void backButtonClicked() {
		mc.requestSwap(back);
	}

	public void piecePressed(JBlockPanel jBlockPanel) {
		LinkedList<JBlockPanel> list = bucont.pop(jBlockPanel);
		currentList = list;
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


	public void pieceReleased(JBlockPanel jBlockPanel) {
		JLayeredPane layers = lv.getLayeredPane();
		layers = new JLayeredPane();
		// Check for the board
		// do the move
		LinkedList<Tile> tl = new LinkedList<>();
		
		for(JBlockPanel jbp: currentList){
			try{
				Tile temp = bocont.getTileAtPoint(new Point(16+jbp.getLocation().x, 16+jbp.getLocation().y));
				tl.add(temp);
			} catch (Exception e){
				System.out.println("stt");
			}
		}		
		
		if(tl.size() != 6){
			mc.requestSwap(this);
			bucont.add(jBlockPanel);
			System.out.println("stt err");
			return;
		}
		
		for(int i = 0; i < currentList.size(); i++){
			tl.get(i).setBlock(jBlockPanel.getBlock());
		}	
		
		mc.requestSwap(this);
	}


	@Override
	public void requestReRender() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void stateUpdated() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void requestReRenderBack() {
		// TODO Auto-generated method stub
		//mainController.requestSwap(back);
	}
}
