package MockupGui;

import java.net.URL;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class achivement {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					achivement window = new achivement();
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
	public achivement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BufferedImage achive_img = null;
		try {
			// load relative image
			URL img = MockupGui.achivement.class.getResource("/img/888267.jpg");
			achive_img = ImageIO.read(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Image achive_img_r = achive_img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 631, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.setBounds(10, 5, 65, 48);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\n");
		lblNewLabel.setBounds(45, 84, 101, 61);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pros only");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(55, 142, 65, 48);
		lblNewLabel.setIcon(new ImageIcon(achive_img_r));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblEarnedAchivements = new JLabel("Earned Achivements");
		lblEarnedAchivements.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblEarnedAchivements.setForeground(Color.WHITE);
		lblEarnedAchivements.setBounds(153, 6, 311, 68);
		frame.getContentPane().add(lblEarnedAchivements);
	}

}
