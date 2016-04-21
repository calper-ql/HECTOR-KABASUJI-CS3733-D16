package boundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import entities.Bullpen;

public class BullPenView {
	int x;
	int y;
	int width;
	int height;
	Bullpen bullpen;
	
	public BullPenView(int x, int y, int width, int height, Bullpen bullpen){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.bullpen = bullpen;
	}
	
	public JPanel render(){
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, width, height);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setMaximumSize(new Dimension(100, 32767));
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		scrollPane.setViewportView(panel_1);
		
		panel.setBounds(x, y, width, height);
		panel.setLayout(null);
		panel.add(scrollPane);
		
		return panel;
	}
}
