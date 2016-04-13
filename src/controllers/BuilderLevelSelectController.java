package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import boundary.BuilderLevelSelectView;
import boundary.LevelSelectView;

public class BuilderLevelSelectController implements Controller{
	private BuilderLevelSelectView blsv;
	private MainController mc;
	private Controller lvl;
	
	private JButton backButton;
	private JButton[] puzzleButtons;
	private JButton[] lightningButtons;
	private JButton[] releaseButtons;
	
	public BuilderLevelSelectController(MainController mc) {
		// TODO Auto-generated constructor stub
		this.mc = mc;
		this.lvl = new BuilderLevelController(mc, this);
		blsv = new BuilderLevelSelectView();
	}

	@Override
	public JPanel getRenderedView() {
		JPanel p = blsv.render();
		
		
		puzzleButtons = blsv.getPuzzleButtons();
		
		
		puzzleButtons[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				puzzleButtonClicked(1);
			}	
		});
		puzzleButtons[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				puzzleButtonClicked(2);
			}	
		});
		puzzleButtons[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				puzzleButtonClicked(3);
			}	
		});
		puzzleButtons[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				puzzleButtonClicked(4);
			}	
		});
		puzzleButtons[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				puzzleButtonClicked(5);
			}	
		});
		
		return p;		
	}
	
	
	private void puzzleButtonClicked(int i){
		mc.requestSwap(lvl);
	}
}
