import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InputForm extends JFrame {

	private JPanel contentPane;
	private JTextField utext;
	public static String transferdUsername;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputForm frame = new InputForm();
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
	public InputForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		utext = new JTextField();
		utext.setBackground(new Color(255, 250, 205));
		utext.setBounds(180, 84, 172, 30);
		contentPane.add(utext);
		utext.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Welcome To MyProgram:))");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
		lblNewLabel.setBounds(115, 24, 224, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblPleaseEnterUsername = new JLabel("Please Enter Username:");
		lblPleaseEnterUsername.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblPleaseEnterUsername.setBounds(24, 84, 157, 30);
		contentPane.add(lblPleaseEnterUsername);
		
		JButton ok = new JButton("OK!");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transferdUsername=utext.getText();
				TeachForm tf=new TeachForm();
				tf.show();
			}
		});
		ok.setBackground(new Color(255, 160, 122));
		ok.setBounds(140, 172, 165, 30);
		contentPane.add(ok);
	}

}
