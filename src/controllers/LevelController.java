package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundry.LevelView;

public class LevelController implements Controller{
	private LevelView lv;
	private MainController mc;
	private Controller back;
	private JButton backButton;
	
	public LevelController(MainController mc, Controller back) {
		// TODO Auto-generated constructor stub
		this.mc = mc;
		this.back = back;
		lv = new LevelView();
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
		// TODO Auto-generated method stub
		mc.requestSwap(back);
	}
}
