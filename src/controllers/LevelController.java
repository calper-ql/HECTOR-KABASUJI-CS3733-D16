package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundary.LevelView;
import entities.Board;
import entities.Bullpen;
import entities.EmptyBlock;
import entities.Level;
import entities.Model;
import entities.Piece;
import entities.Tile;

public class LevelController implements Controller{
	private LevelView lv;
	private MainController mc;
	private Controller back;
	private JButton backButton;
	
	public LevelController(MainController mc, Controller back, Model model) {
		this.mc = mc;
		this.back = back;
		
		lv = new LevelView(model.getLevel(0));
	}

	@Override
	public JPanel getRenderedView() {
		JPanel p = lv.render();
		
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
