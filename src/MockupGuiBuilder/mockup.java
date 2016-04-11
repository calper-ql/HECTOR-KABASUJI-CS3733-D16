package MockupGuiBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class mockup {

	private JFrame frame;
	private JTextField txtEditTimeLeft;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mockup window = new mockup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mockup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 631, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Block block_1 = new Block(384/12,new Color(10,255,10));
		block_1.setLocation(0, 0);
		Block block_2 = new Block(384/12,new Color(10,255,10));
		Block block_3 = new Block(384/12,new Color(10,255,10));
		Block block_4 = new Block(384/12,new Color(10,255,10));
		Block block_5 = new Block(384/12,new Color(10,255,10));
		Block block_6 = new Block(384/12,new Color(10,255,10));
		frame.getContentPane().add(block_1);
		frame.getContentPane().add(block_2);
		frame.getContentPane().add(block_3);
		frame.getContentPane().add(block_4);
		frame.getContentPane().add(block_5);
		frame.getContentPane().add(block_6);
		
		block_1.linkUp(block_2);
		block_2.linkRight(block_3);
		block_3.linkUp(block_4);
		block_2.linkLeft(block_5);
		block_5.linkUp(block_6);
		block_1.build();
		
		Block block_11 = new Block(384/12,new Color(255,10,10));
		block_11.setLocation(0, 0);
		Block block_21 = new Block(384/12,new Color(255,10,10));
		Block block_31 = new Block(384/12,new Color(255,10,10));
		Block block_41 = new Block(384/12,new Color(255,10,10));
		Block block_51 = new Block(384/12,new Color(255,10,10));
		Block block_61 = new Block(384/12,new Color(255,10,10));
		frame.getContentPane().add(block_11);
		frame.getContentPane().add(block_21);
		frame.getContentPane().add(block_31);
		frame.getContentPane().add(block_41);
		frame.getContentPane().add(block_51);
		frame.getContentPane().add(block_61);
		
		block_11.linkRight(block_21);
		block_21.linkRight(block_31);
		block_31.linkDown(block_41);
		block_21.linkUp(block_51);
		block_51.linkUp(block_61);
		block_11.build();
		
		Block block_12 = new Block(384/12,new Color(255,10,255));
		block_11.setLocation(0, 0);
		Block block_22 = new Block(384/12,new Color(255,10,255));
		Block block_32 = new Block(384/12,new Color(255,10,255));
		Block block_42 = new Block(384/12,new Color(255,10,255));
		Block block_52 = new Block(384/12,new Color(255,10,255));
		Block block_62 = new Block(384/12,new Color(255,10,255));
		frame.getContentPane().add(block_12);
		frame.getContentPane().add(block_22);
		frame.getContentPane().add(block_32);
		frame.getContentPane().add(block_42);
		frame.getContentPane().add(block_52);
		frame.getContentPane().add(block_62);
		
		block_12.linkRight(block_22);
		block_22.linkRight(block_32);
		block_32.linkUp(block_42);
		block_22.linkUp(block_52);
		block_52.linkUp(block_62);
		block_12.build();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(215, 100, 384, 384);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lightning mode - 3");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(83, 6, 137, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.setBounds(10, 5, 65, 48);
		frame.getContentPane().add(btnNewButton);
		
		
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
		frame.getContentPane().add(btnSaveLevel);
		
		JButton btnResetLevel = new JButton("Reset Level");
		btnResetLevel.setBounds(343, 66, 102, 23);
		frame.getContentPane().add(btnResetLevel);
		
		JButton btnNewButton_1 = new JButton("Undo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(10, 62, 65, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		txtEditTimeLeft = new JTextField();
		txtEditTimeLeft.setText("Edit Time Left");
		txtEditTimeLeft.setBounds(412, 31, 86, 20);
		frame.getContentPane().add(txtEditTimeLeft);
		txtEditTimeLeft.setColumns(10);
		
		JLabel lblTimeRemaining = new JLabel("Time Remaining");
		lblTimeRemaining.setBounds(402, 6, 123, 14);
		frame.getContentPane().add(lblTimeRemaining);
		lblTimeRemaining.setForeground(Color.WHITE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 100, 195, 384);
		frame.getContentPane().add(layeredPane);
		
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
		frame.getContentPane().add(scrollBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 100, 22, 384);
		frame.getContentPane().add(scrollPane);
		
		int X   = panel.getX();
		int Y = panel.getY();
		int width  = panel.getWidth();
		int height = panel.getHeight();
		
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
		
		
	}
}
