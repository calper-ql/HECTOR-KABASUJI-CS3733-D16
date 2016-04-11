package MockupGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
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
import javax.swing.ImageIcon;
import java.awt.Font;

public class mockup {

	private JFrame frame;

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
		frame.setBounds(100, 100, 605, 515);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(6, 100, 192, 384);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setMaximumSize(new Dimension(100, 32767));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(215, 100, 384, 384);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Puzzle mode - 3");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(83, 6, 137, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.setBounds(10, 5, 65, 48);
		frame.getContentPane().add(btnNewButton);
		
		
		BufferedImage star_img = null;
		try {
			URL img = MockupGui.mockup.class.getResource("/img/888267.jpg");
			star_img = ImageIO.read(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedImage info_img = null;
		try {
			URL img = MockupGui.mockup.class.getResource("/img/888267.jpg");
			info_img = ImageIO.read(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image star_img_r = star_img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		Image info_img_r = info_img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(star_img_r));
		lblNewLabel_1.setBounds(341, 27, 40, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(445, 27, 40, 40);
		lblNewLabel_2.setIcon(new ImageIcon(star_img_r));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(393, 27, 40, 40);
		lblNewLabel_3.setIcon(new ImageIcon(star_img_r));
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel label = new JLabel("01:34");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label.setForeground(Color.WHITE);
		label.setBackground(Color.WHITE);
		label.setBounds(518, 27, 78, 39);
		frame.getContentPane().add(label);
		
		JLabel lblTimeLeft = new JLabel("Time left:");
		lblTimeLeft.setForeground(Color.WHITE);
		lblTimeLeft.setBounds(508, 20, 61, 16);
		frame.getContentPane().add(lblTimeLeft);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(info_img_r));
		label_1.setBounds(20, 54, 40, 40);
		frame.getContentPane().add(label_1);
		
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
