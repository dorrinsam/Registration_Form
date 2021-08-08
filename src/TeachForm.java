import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class TeachForm extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField degreetext;
	private JTextField questiontext;
	private JTextField answertext;
	File studentfile=new File("Student.txt");
	int level;
	int number1;
	int number2;
	int counter;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeachForm frame = new TeachForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeachForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 291);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JTextField();
		user.setBounds(41, 57, 141, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel pointlbl = new JLabel("Point:0");
		pointlbl.setBounds(257, 11, 46, 14);
		contentPane.add(pointlbl);
		
		degreetext = new JTextField();
		degreetext.setColumns(10);
		degreetext.setBounds(41, 102, 141, 20);
		user.setText(InputForm.transferdUsername);
		contentPane.add(degreetext);
		
		JButton startbtn = new JButton("Press here To Start");
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=false;
				try {
					Scanner reader=new Scanner(studentfile);
					while(reader.hasNextLine())
					{
						String[]filelines=reader.nextLine().split(" ");
						if(user.getText().equals(filelines[0]))
						{
							flag=true;
							degreetext.setText(filelines[1]);
							break;
							
						}
					}
					reader.close();

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				StudentClass sc=new StudentClass();
				if(flag==false)
				{
					level=1;
					degreetext.setText(String.valueOf(level));
					sc.setUs(user.getText());
					sc.setlevel(String.valueOf(level));
				}
				try {
					FileWriter fw=new FileWriter(studentfile);
					fw.write(sc.getstudent_username()+"*"+sc.getstudent_level());
					fw.write("\n");
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(degreetext.getText().equals("1"))
				{
					level=1;

					Random r=new Random();
					number1=r.nextInt(level*10);
					Random r1=new Random();
					number2=r1.nextInt(level*10);
					questiontext.setText(String.valueOf(number1)+"*"+String.valueOf(number2));
				}
				if(degreetext.getText().equals("2"))
				{
					level=2;

					Random r=new Random();
					number1=r.nextInt(level*100);
					Random r1=new Random();
					number2=r1.nextInt(level*100);
					questiontext.setText(String.valueOf(number1)+"*"+String.valueOf(number2));
				}
				if(degreetext.getText().equals("3"))
				{
					level=3;

					Random r=new Random();
					number1=r.nextInt(level*100);
					Random r1=new Random();
					number2=r1.nextInt(level*100);
					questiontext.setText(String.valueOf(number1)+"*"+String.valueOf(number2));
				}
				
			
			}
		});
		startbtn.setBounds(41, 133, 141, 23);
		contentPane.add(startbtn);
		
		questiontext = new JTextField();
		questiontext.setBounds(257, 57, 141, 20);
		contentPane.add(questiontext);
		questiontext.setColumns(10);
		
		answertext = new JTextField();
		answertext.setColumns(10);
		answertext.setBounds(257, 102, 141, 20);
		contentPane.add(answertext);
		
		JButton next = new JButton("NextQuestion");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answertext.getText().equals(String.valueOf(number1*number2)))
				{
					counter++;
				}
				if(counter==10)
				{
					level++;
				}
				switch (level) {
				case 1:
					Random r=new Random();
					 number1=r.nextInt(level*10);
					Random r1=new Random();
					 number2=r1.nextInt(level*10);
					answertext.setText(String.valueOf(number1)+"*"+String.valueOf(number2));
					break;
				case 2:
					Random r2=new Random();
					 number1=r2.nextInt(level*100);
					Random r3=new Random();
					number2=r3.nextInt(level*100);
					answertext.setText(String.valueOf(number1)+"*"+String.valueOf(number2));
					break;
				case 3:
					Random r4=new Random();
					 number1=r4.nextInt(level*100);
					Random r5=new Random();
					number2=r5.nextInt(level*100);
					answertext.setText(String.valueOf(number1)+"*"+String.valueOf(number1));
					break;
					
				}
			
				
				StudentClass stc=new StudentClass();
				stc.setUs(user.getText());
				stc.setlevel(String.valueOf(level));
				try {
					FileWriter fw=new FileWriter(studentfile);
					fw.write(stc.getstudent_username()+"*"+stc.getstudent_level());
					fw.write("\n");
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pointlbl.setText("point:"+counter);
				
			}
			
		});
		next.setBounds(257, 133, 141, 23);
		contentPane.add(next);
		
		
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(41, 43, 86, 14);
		contentPane.add(lblUsername);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setBounds(41, 88, 86, 14);
		contentPane.add(lblLevel);
		
		JLabel lblNewLabel = new JLabel("Question:");
		lblNewLabel.setBounds(257, 43, 72, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setBounds(257, 88, 72, 14);
		contentPane.add(lblAnswer);
	}

}
