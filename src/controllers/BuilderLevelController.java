package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundary.BuilderLevelView;
import boundary.JBlockPanel;

public class BuilderLevelController implements Controller, ILevelController{
	private BuilderLevelView blv;
	private MainController mc;
	private Controller back;
	private JButton backButton;
	
	public BuilderLevelController(MainController mc, Controller back) {
		// TODO Auto-generated constructor stub
		this.mc = mc;
		this.back = back;
		blv = new BuilderLevelView();
	}

	@Override
	public JPanel getRenderedView() {
		JPanel p = blv.render();
		
		backButton = blv.getBackButton();
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

	@Override
	public void piecePressed(JBlockPanel jBlockPanel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pieceReleased(JBlockPanel jBlockPanel) {
		// TODO Auto-generated method stub
		
	}
}
