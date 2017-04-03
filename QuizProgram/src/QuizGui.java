import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.naming.ldap.Rdn;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class QuizGui {

	protected JFrame frame;
	protected static List <Integer>qNo;
	private int count;
	private int qCount;
	private List<Integer>optionNo;
	private final ButtonGroup btngrp;
	private final Timer timer;
	/**
	 * Launch the application.
	 */
	
	public QuizGui() {
		btngrp=new ButtonGroup();
		count=0;
		qCount=1;
		qNo=new ArrayList<>();
		optionNo=new ArrayList<>();
		for (int i=1;i<=5;i++) {
			qNo.add(i);
		}
		Collections.shuffle(qNo);
		
		for (int i = 1; i <=4; i++) {
			optionNo.add(i);
		}
		Collections.shuffle(optionNo);
		timer=new Timer();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JLabel lblNewLabel_2;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setToolTipText("Question");
		lblNewLabel.setBounds(10, 85, 152, 28);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setText("Q"+qCount+":"+setQues());
		
		JLabel lblNewLabel_1 = new JLabel("Table Quiz");
		lblNewLabel_1.setFont(new Font("Broadway", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(143, 21, 162, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Press Next to see the next question");
		lblNewLabel_2.setBounds(116, 55, 259, 19);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNext = new JButton("Next");
		
		btnNext.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNext);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button",false);
		rdbtnNewRadioButton.setBounds(20, 120, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button",false);
		rdbtnNewRadioButton_1.setBounds(20, 156, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button",false);
		rdbtnNewRadioButton_2.setBounds(303, 120, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setVisible(false);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button",false);
		rdbtnNewRadioButton_3.setBounds(158, 156, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton radioButton = new JRadioButton("",false);
		radioButton.setBounds(158, 120, 109, 23);
		frame.getContentPane().add(radioButton);
		
		btngrp.add(radioButton);
		btngrp.add(rdbtnNewRadioButton);
		btngrp.add(rdbtnNewRadioButton_1);
		btngrp.add(rdbtnNewRadioButton_2);
		btngrp.add(rdbtnNewRadioButton_3);
		//btngrp.setSelected(rdbtnNewRadioButton_2.getModel(), true);
		rdbtnNewRadioButton.setText(setOption(optionNo.get(0)));
		rdbtnNewRadioButton_1.setText(setOption(optionNo.get(1)));
		radioButton.setText(setOption(optionNo.get(2)));
		rdbtnNewRadioButton_3.setText(setOption(optionNo.get(3)));
		
		JLabel lblNewLabel_3 = new JLabel("A.");
		lblNewLabel_3.setBounds(10, 124, 19, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblB = new JLabel("B.");
		lblB.setBounds(10, 160, 19, 14);
		frame.getContentPane().add(lblB);
		
		JLabel lblC = new JLabel("C.");
		lblC.setBounds(143, 124, 19, 14);
		frame.getContentPane().add(lblC);
		
		JLabel lblD = new JLabel("D.");
		lblD.setBounds(143, 160, 29, 14);
		frame.getContentPane().add(lblD);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_4.setBounds(347, 21, 77, 20);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		timer.scheduleAtFixedRate(new TimerTask(){
			int i=20;
			public void run(){
				
				
				if(i<10){
					lblNewLabel_4.setText("0:0"+i--);
				}
				else{
					lblNewLabel_4.setText("0:"+i--);
				}
				if(i<0){
					timer.cancel();
					if(btngrp.getSelection()==null){
						//System.out.println("correct");
						rdbtnNewRadioButton_2.setSelected(true);
					}
					JOptionPane.showMessageDialog(frame, "Times Up!!! you have given "+checkNoOfCorrectAns()+" out of 5 Questions Correct");
					frame.dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								ResultWindow window = new ResultWindow();
								window.frame.setVisible(true);
								window.frame.setResizable(false);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		}, 0,1000 );

		rdbtnNewRadioButton.addChangeListener(e->{
			
			writeAns(rdbtnNewRadioButton.getText());
			
		});
rdbtnNewRadioButton_1.addChangeListener(e->{
			
			writeAns(rdbtnNewRadioButton_1.getText());
		});
radioButton.addChangeListener(e->{
	
	writeAns(radioButton.getText());
});
rdbtnNewRadioButton_3.addChangeListener(e->{
	
	writeAns(rdbtnNewRadioButton_3.getText());
});
rdbtnNewRadioButton_2.addItemListener(e->{
	clearAllUnselectedFiles();
	
});
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btngrp.getSelection()==null){
					JOptionPane.showMessageDialog(frame, "Please select option");
				}
				else{
				if(count<=3){
			//		writeAns(textField.getText());
				//	btngrp.setSelected(rdbtnNewRadioButton_2.getModel(), true);;
					btngrp.clearSelection();
					Collections.shuffle(optionNo);
					count++;
					lblNewLabel.setText("Q"+(++qCount)+":"+setQues());
					rdbtnNewRadioButton.setText(setOption(optionNo.get(0)));
					rdbtnNewRadioButton_1.setText(setOption(optionNo.get(1)));
					radioButton.setText(setOption(optionNo.get(2)));
					rdbtnNewRadioButton_3.setText(setOption(optionNo.get(3)));
					
				//	textField.setText("");
					lblNewLabel_2.setText("Press Next to see the next Question");
				}
				else{
					//JOptionPane.showMessageDialog(null, "Quiz Completed!!");
					timer.cancel();
					JOptionPane.showMessageDialog(frame, "Quiz Completed!! You have given "+checkNoOfCorrectAns()+" out of 5 questions correct");
					frame.dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								ResultWindow window = new ResultWindow();
								window.frame.setVisible(true);
								window.frame.setResizable(false);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				}
			}
		});
		 
	}
	public String setQues(){
		
		
		
		try(BufferedReader br=new BufferedReader(new FileReader("//src\\Quiz\\Q\\"+qNo.get(count)+".txt"))){
			return br.readLine();
		}
		catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	public void writeAns(String text){
		try(BufferedWriter bw=new BufferedWriter(new FileWriter("\\src\\Quiz\\UA\\"+qNo.get(count)+".txt"))){
			bw.write(text);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public boolean checkAns(int no){
		String uAns=null,dAns=null;
		try(BufferedReader br=new BufferedReader(new FileReader("\\src\\Quiz\\UA\\"+no+".txt"))){
			 uAns= br.readLine();
			// System.out.println(uAns);
		}
		catch(IOException e){
			e.printStackTrace();
			
	}try(BufferedReader br=new BufferedReader(new FileReader("\\src\\Quiz\\A\\"+no+".txt"))){
			 dAns= br.readLine();
		}
		catch(IOException e){
			e.printStackTrace();
			
	}try{
		if(uAns.equals(dAns)){
			return true;
		}
		else
			return false;
	}
	catch(NullPointerException e){
		return false;
	}
}
	public String setOption(int optNo){
		try(BufferedReader br=new BufferedReader(new FileReader("\\src\\Quiz\\Option\\"+qNo.get(count)+"\\"+optNo+".txt"))){
			return br.readLine();
		}
		catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	public int checkNoOfCorrectAns(){
		boolean []arr=new boolean[5];
		int j=0,counter=0;
		for (int i = 1; i <= arr.length; i++) {
			arr[j++]=checkAns(i);
		}
		for (int k = 0; k < arr.length; k++) {
			if(arr[k]==true){
				 counter++;
			}
			
	}
		return counter;
	}
	public static void ClearAllUserFiles(){
		for (int i =1 ; i <=5; i++) {
			try(BufferedWriter bw=new BufferedWriter(new FileWriter("\\src\\Quiz\\UA\\"+i+".txt"))){
				bw.write("");
			}
			catch(IOException e){
				e.printStackTrace();
			}
			
		}
	}
	public  void clearAllUnselectedFiles(){
		for (int i =count ; i <5; i++) {
			try(BufferedWriter bw=new BufferedWriter(new FileWriter("\\src\\Quiz\\UA\\"+qNo.get(i)+".txt"))){
				bw.write("");
			}
			catch(IOException e){
				e.printStackTrace();
			}
	}
}
}
