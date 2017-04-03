import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class StartWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow window = new StartWindow();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Table Quiz");
		label.setFont(new Font("Broadway", Font.PLAIN, 24));
		label.setBounds(139, 23, 162, 33);
		frame.getContentPane().add(label);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							QuizGui window = new QuizGui();
							window.frame.setVisible(true);
							window.frame.setResizable(false);
							QuizGui.ClearAllUserFiles();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setBounds(172, 115, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(172, 149, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblThisQuizConsists = new JLabel("This Quiz consists of 5 questions ");
		lblThisQuizConsists.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblThisQuizConsists.setBackground(Color.WHITE);
		lblThisQuizConsists.setForeground(Color.RED);
		lblThisQuizConsists.setBounds(122, 52, 198, 34);
		frame.getContentPane().add(lblThisQuizConsists);
		
		JLabel lblTimeToComplete = new JLabel("Time to complete the quiz is 20 seconds");
		lblTimeToComplete.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTimeToComplete.setForeground(Color.RED);
		lblTimeToComplete.setBounds(99, 85, 259, 19);
		frame.getContentPane().add(lblTimeToComplete);
	}
}
