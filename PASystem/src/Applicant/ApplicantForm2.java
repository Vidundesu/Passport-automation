package Applicant;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;

public class ApplicantForm2 extends JPanel {

	protected static final long serialVersionUID = 1L;
	protected JTextField username;
	protected JTextField password;
	protected JTextField confirmPw;
	
	/**
	 * Create the panel.
	 */
	public ApplicantForm2() {
		
		setLayout(null);
		 setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		JLabel lblNewLabel = new JLabel("Now create an Username and a Password to continue");
		lblNewLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 19));
		lblNewLabel.setBounds(283, 88, 596, 55);
		add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(283, 180, 233, 44);
		add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter a suitable username");
		lblNewLabel_1.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(283, 154, 168, 14);
		add(lblNewLabel_1);
		
		password = new JTextField();
		password.setBounds(283, 278, 233, 44);
		add(password);
		password.setColumns(10);
		
		confirmPw = new JTextField();
		confirmPw.setBounds(283, 358, 233, 44);
		add(confirmPw);
		confirmPw.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter a password");
		lblNewLabel_2.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(283, 253, 115, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm password");
		lblNewLabel_3.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(283, 333, 115, 14);
		add(lblNewLabel_3);
		
		JButton registerBtn = new JButton("Register!");
		registerBtn.setBounds(283, 432, 115, 33);
		add(registerBtn);

	}
}
