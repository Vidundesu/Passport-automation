package Applicant;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ApplicantForm2 extends JPanel {

	protected static final long serialVersionUID = 1L;
	protected JTextField usernameAp;
	protected JTextField passwordAp;
	protected JTextField confirmPwAp;
	private JTextField passkeyAp;
	
	/**
	 * Create the panel.
	 */
	public ApplicantForm2(Applicant applicantN) {
		
		setLayout(null);
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		JLabel lblNewLabel = new JLabel("Now create an Username and a Password to continue");
		lblNewLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 19));
		lblNewLabel.setBounds(283, 88, 596, 55);
		add(lblNewLabel);
		
		usernameAp = new JTextField();
		usernameAp.setBounds(283, 180, 233, 44);
		add(usernameAp);
		usernameAp.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter a suitable username");
		lblNewLabel_1.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(283, 154, 168, 14);
		add(lblNewLabel_1);
		
		passwordAp = new JTextField();
		passwordAp.setBounds(283, 278, 233, 44);
		add(passwordAp);
		passwordAp.setColumns(10);
		
		confirmPwAp = new JTextField();
		confirmPwAp.setBounds(283, 358, 233, 44);
		add(confirmPwAp);
		confirmPwAp.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter a password");
		lblNewLabel_2.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(283, 253, 115, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm password");
		lblNewLabel_3.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(283, 333, 115, 14);
		add(lblNewLabel_3);
		
		JButton registerBtn = new JButton("Register!");
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String username = usernameAp.getText();
				String passkey = passkeyAp.getText();
				String password = passwordAp.getText().equals(confirmPwAp.getText())?passwordAp.getText():null;
				if(password.equals(null)) {
					JOptionPane.showMessageDialog(null, "Check whether your passwords confirmation is correct?");
				}
				applicantN.applicantLoginCredentials(username, password, passkey);
			}
		});
		registerBtn.setBounds(283, 504, 115, 33);
		add(registerBtn);
		
		passkeyAp = new JTextField();
		passkeyAp.setColumns(10);
		passkeyAp.setBounds(283, 449, 233, 44);
		add(passkeyAp);
		
		JLabel lblNewLabel_4 = new JLabel("Enter a passkey");
		lblNewLabel_4.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(283, 413, 136, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("For an example: Enter your first pet's name");
		lblNewLabel_5.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblNewLabel_5.setForeground(new Color(128, 128, 128));
		lblNewLabel_5.setBounds(283, 434, 248, 14);
		add(lblNewLabel_5);

	}
}
