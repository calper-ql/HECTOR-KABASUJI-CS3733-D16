package boundary;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BoardView {
	
	public BoardView() {
		// TODO Auto-generated constructor stub
	}
	
	public JPanel render(){
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(215, 100, 384, 384);
		panel.setLayout(null);
		
		int X = panel.getX();
		int Y = panel.getY();
		int widthP  = panel.getWidth();
		int heightP = panel.getHeight();
		
		JPanel tiles[][] = new JPanel[12][12];
		for(int i = 0;	i < 12; i++){
			for(int k = 0; k < 12; k++){
				
				tiles[k][i] = (new TileView(widthP/12,k,i)).render();
				panel.add(tiles[k][i]);
				
			}
		}
		
		return panel;
	}
}
