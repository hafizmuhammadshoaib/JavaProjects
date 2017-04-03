import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultWindow {

	protected JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultWindow window = new ResultWindow();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ResultWindow() {
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
		label.setBounds(139, 11, 162, 33);
		frame.getContentPane().add(label);
		
		JLabel lblAnswers = new JLabel("Result");
		lblAnswers.setForeground(Color.DARK_GRAY);
		lblAnswers.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAnswers.setBackground(Color.WHITE);
		lblAnswers.setBounds(193, 37, 48, 34);
		frame.getContentPane().add(lblAnswers);
		
		JLabel lblNewLabel = new JLabel("Q1");
		lblNewLabel.setBounds(10, 109, 24, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel lblQ = new JLabel("Q2");
		lblQ.setBounds(10, 134, 24, 14);
		frame.getContentPane().add(lblQ);
		
		
		JLabel lblQ_1 = new JLabel("Q3");
		lblQ_1.setBounds(10, 161, 24, 14);
		frame.getContentPane().add(lblQ_1);
		
		JLabel lblQ_2 = new JLabel("Q4");
		lblQ_2.setBounds(10, 189, 24, 14);
		frame.getContentPane().add(lblQ_2);
		
		JLabel lblQ_3 = new JLabel("Q5");
		lblQ_3.setBounds(10, 214, 24, 14);
		frame.getContentPane().add(lblQ_3);
		
		JLabel lblQuestions = new JLabel("Questions");
		lblQuestions.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuestions.setBounds(10, 87, 56, 14);
		frame.getContentPane().add(lblQuestions);
		
		JLabel lblYourAnswers = new JLabel("Your Answers");
		lblYourAnswers.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYourAnswers.setBounds(193, 87, 83, 14);
		frame.getContentPane().add(lblYourAnswers);
		
		JLabel lblCorrectAnswers = new JLabel("Correct Answers");
		lblCorrectAnswers.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCorrectAnswers.setBounds(330, 87, 94, 14);
		frame.getContentPane().add(lblCorrectAnswers);
		
		JLabel qLabel0 = new JLabel("");
		qLabel0.setBounds(34, 109, 67, 14);
		frame.getContentPane().add(qLabel0);
		qLabel0.setText(setQues(0));
		
		JLabel qLabel1 = new JLabel("");
		qLabel1.setBounds(34, 134, 67, 14);
		frame.getContentPane().add(qLabel1);
		qLabel1.setText(setQues(1));
		
		JLabel qLabel2 = new JLabel("");
		qLabel2.setBounds(34, 161, 67, 14);
		frame.getContentPane().add(qLabel2);
		qLabel2.setText(setQues(2));
		
		JLabel qLabel3 = new JLabel("");
		qLabel3.setBounds(34, 189, 67, 14);
		frame.getContentPane().add(qLabel3);
		qLabel3.setText(setQues(3));
		
		JLabel qLabel4 = new JLabel("");
		qLabel4.setBounds(34, 214, 67, 14);
		frame.getContentPane().add(qLabel4);
		qLabel4.setText(setQues(4));
		
		JLabel yALabel0 = new JLabel("");
		yALabel0.setBounds(193, 109, 67, 14);
		frame.getContentPane().add(yALabel0);
		yALabel0.setText(setAns(0));
		
		JLabel yALabel1 = new JLabel("");
		yALabel1.setBounds(193, 134, 67, 14);
		frame.getContentPane().add(yALabel1);
		yALabel1.setText(setAns(1));
		
		JLabel yALabel2 = new JLabel("");
		yALabel2.setBounds(193, 161, 67, 14);
		frame.getContentPane().add(yALabel2);
		yALabel2.setText(setAns(2));
		
		JLabel yAlabel3 = new JLabel("");
		yAlabel3.setBounds(193, 189, 67, 14);
		frame.getContentPane().add(yAlabel3);
		yAlabel3.setText(setAns(3));
		
		JLabel yALabel4 = new JLabel("");
		yALabel4.setBounds(193, 214, 67, 14);
		frame.getContentPane().add(yALabel4);
		yALabel4.setText(setAns(4));
		
		JLabel cALabel0 = new JLabel("");
		cALabel0.setBounds(330, 109, 67, 14);
		frame.getContentPane().add(cALabel0);
		cALabel0.setText(setDefaultAns(0));
		
		JLabel cALabel1 = new JLabel("");
		cALabel1.setBounds(330, 134, 67, 14);
		frame.getContentPane().add(cALabel1);
		cALabel1.setText(setDefaultAns(1));
		
		JLabel cALabel2 = new JLabel("");
		cALabel2.setBounds(330, 161, 67, 14);
		frame.getContentPane().add(cALabel2);
		cALabel2.setText(setDefaultAns(2));
		
		JLabel cALabel3 = new JLabel("");
		cALabel3.setBounds(330, 189, 67, 14);
		frame.getContentPane().add(cALabel3);
		cALabel3.setText(setDefaultAns(3));
		
		JLabel cALabel4 = new JLabel("");
		cALabel4.setBounds(330, 214, 67, 14);
		frame.getContentPane().add(cALabel4);
		cALabel4.setText(setDefaultAns(4));
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(330, 230, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
	private String setQues(int no){
		try(BufferedReader br=new BufferedReader(new FileReader("\\src\\Quiz\\Q\\"+QuizGui.qNo.get(no)+".txt"))){
			return br.readLine();
		}
		catch(IOException e){
			e.printStackTrace();
			return null;
	}

}
	private String setAns(int no){
		String ans=null;
		try(BufferedReader br=new BufferedReader(new FileReader("\\src\\Quiz\\UA\\"+QuizGui.qNo.get(no)+".txt"))){
			ans=br.readLine();
			if(ans.equals(null)){
				return "N/A";
			}
			else{
				return ans;
			}
		}
		
		catch(NullPointerException e){
			return "N/A";
		}
		catch(IOException e){
			e.printStackTrace();
			return null;
	}
		
		
}
	private String setDefaultAns(int no){
		try(BufferedReader br=new BufferedReader(new FileReader("\\src\\Quiz\\A\\"+QuizGui.qNo.get(no)+".txt"))){
			 return br.readLine();
			// System.out.println(uAns);
		}
		catch(IOException e){
			e.printStackTrace();
			return null;
	}
		
	}
}