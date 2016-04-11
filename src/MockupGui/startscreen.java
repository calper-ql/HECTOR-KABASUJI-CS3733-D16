package MockupGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class startscreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startscreen window = new startscreen();
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
	public startscreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kabasuji");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 99));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(37, 6, 413, 156);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Levels");
		btnNewButton.setBounds(47, 185, 197, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAchivements = new JButton("Achivements");
		btnAchivements.setBounds(47, 247, 197, 50);
		frame.getContentPane().add(btnAchivements);
		frame.setBounds(100, 100, 605, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
