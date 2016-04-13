package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class BuilderLevelView {
	private JButton backButton;
	
	public BuilderLevelView(){

	}
	
	public JPanel render(){
		JPanel p = new JPanel();
		p.setBackground(Color.darkGray);
		int width = 640;
		int height = 535;
		p.setBounds(0, 0, width, height);
		p.setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(215, 100, 384, 384);
		p.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lightning mode - 3");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(83, 6, 137, 45);
		p.add(lblNewLabel);
		
		backButton = new JButton("<");
		backButton.setBounds(10, 5, 65, 48);
		p.add(backButton);
		
		
		BufferedImage star_img = null;
		try {
			URL img = MockupGuiBuilder.mockup.class.getResource("/img/star-xxl.png");
			star_img = ImageIO.read(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedImage info_img = null;
		try {
			URL img = MockupGuiBuilder.mockup.class.getResource("/img/888267.jpg");
			info_img = ImageIO.read(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image star_img_r = star_img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		Image info_img_r = info_img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		
		JButton btnSaveLevel = new JButton("Save Level");
		btnSaveLevel.setBounds(215, 66, 102, 23);
		p.add(btnSaveLevel);
		
		JButton btnResetLevel = new JButton("Reset Level");
		btnResetLevel.setBounds(343, 66, 102, 23);
		p.add(btnResetLevel);
		
		JButton btnNewButton_1 = new JButton("Undo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(10, 62, 65, 27);
		p.add(btnNewButton_1);
		
		JTextField txtEditTimeLeft;
		txtEditTimeLeft = new JTextField();
		txtEditTimeLeft.setText("Edit Time Left");
		txtEditTimeLeft.setBounds(412, 31, 86, 20);
		p.add(txtEditTimeLeft);
		txtEditTimeLeft.setColumns(10);
		
		JLabel lblTimeRemaining = new JLabel("Time Remaining");
		lblTimeRemaining.setBounds(402, 6, 123, 14);
		p.add(lblTimeRemaining);
		lblTimeRemaining.setForeground(Color.WHITE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 100, 195, 384);
		p.add(layeredPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 170, 193);
		layeredPane.add(panel_2);
		
		JSpinner spinner_1 = new JSpinner();
		panel_2.add(spinner_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(134, 11, -56, 71);
		layeredPane.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 191, 170, 193);
		layeredPane.add(panel_3);
		
		JSpinner spinner = new JSpinner();
		panel_3.add(spinner);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(183, 102, 22, 382);
		p.add(scrollBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 100, 22, 384);
		p.add(scrollPane);
		
		int X   = panel.getX();
		int Y = panel.getY();
		//int width  = panel.getWidth();
		//int height = panel.getHeight();
		
		JPanel tiles[][] = new JPanel[12][12];
		for(int i = 0;	i < 12; i++){
			for(int k = 0; k < 12; k++){
				
				tiles[k][i] = new JPanel();
				tiles[k][i].setVisible(true);
				tiles[k][i].setBorder(new LineBorder(new Color(0, 0, 0)));
				panel.add(tiles[k][i]);
				int x =  ((width/12)*k);
				int y = ((height/12)*i);
				int w = (width/12);
				int h = (height/12);
				tiles[k][i].setBounds(x, y, w, h);
				tiles[k][i].setBackground(new Color(250,255,255));
				
				if(((i==9) || (i == 11)) && (k == 7 || k == 9)){
					tiles[k][i].setBackground(Color.darkGray);
				}	
				
				System.out.println(x);
			}
		}
		
		
		return p;
	}
	public JButton getBackButton(){
		return backButton;
	}
}
