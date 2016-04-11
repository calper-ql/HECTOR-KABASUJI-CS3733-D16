package MockupGuiBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;

public class levelselect {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					levelselect window = new levelselect();
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
	public levelselect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.darkGray);
		frame.getContentPane().setForeground(Color.RED);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setBounds(100, 100, 605, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		BufferedImage star_img = null;
		try {
			// get relative image
			URL img = MockupGuiBuilder.levelselect.class.getResource("/img/star-xxl.png");
			star_img = ImageIO.read(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedImage info_img = null;
		try {
			// get relative image
			URL img = MockupGuiBuilder.levelselect.class.getResource("/img/888267.jpg");
			info_img = ImageIO.read(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image star_img_r = star_img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		Image info_img_r = info_img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(66, 154, 40, 40);
		label_1.setIcon(new ImageIcon(star_img_r));
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(96, 154, 40, 40);
		label_2.setIcon(new ImageIcon(star_img_r));
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(127, 154, 40, 40);
		label_3.setIcon(new ImageIcon(star_img_r));
		frame.getContentPane().add(label_3);
		
		
		JLabel lblNewLabel = new JLabel("Level Select");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(241, -11, 108, 77);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Puzzle");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(6, 98, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lightning");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(6, 238, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Release");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(6, 380, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(Color.darkGray);
		scrollPane.setBounds(66, 65, 533, 77);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBackground(Color.darkGray);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.setSize(new Dimension(50,50));
		panel.add(btnNewButton_1);
		
		JButton button = new JButton("2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(button);
		
		JButton button_2 = new JButton("3");
		panel.add(button_2);
		
		JButton button_3 = new JButton("4");
		panel.add(button_3);
		
		JButton btnNewButton_3 = new JButton("5");
		panel.add(btnNewButton_3);
		
		JLabel label = new JLabel("");
		label.setBounds(96, 37, 61, 16);
		frame.getContentPane().add(label);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		scrollPane_1.setBackground(Color.darkGray);
		scrollPane_1.setBounds(66, 206, 533, 77);
		frame.getContentPane().add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setBackground(Color.darkGray);
		panel_1.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnNewButton = new JButton("1");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("2");
		panel_1.add(btnNewButton_2);
		
		JButton button_4 = new JButton("3");
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("4");
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("5");
		panel_1.add(button_6);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(null);
		scrollPane_2.setBackground(Color.darkGray);
		scrollPane_2.setBounds(66, 345, 533, 77);
		frame.getContentPane().add(scrollPane_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.darkGray);
		scrollPane_2.setViewportView(panel_2);
		
		JButton btnNewButton_4 = new JButton("1");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.setLayout(new GridLayout(0, 5, 0, 0));
		panel_2.add(btnNewButton_4);
		
		JButton button_1 = new JButton("2");
		panel_2.add(button_1);
		
		JButton btnNewButton_5 = new JButton("3");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("4");
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("5");
		panel_2.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("<");
		btnNewButton_8.setBounds(10, 5, 65, 48);
		frame.getContentPane().add(btnNewButton_8);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(169, 154, 40, 40);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(201, 154, 40, 40);
		frame.getContentPane().add(label_5);
		
		label_5.setIcon(new ImageIcon(star_img_r));
		label_4.setIcon(new ImageIcon(star_img_r));
		
		
	}
}
