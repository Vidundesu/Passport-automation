package Applicant;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.security.NoSuchAlgorithmException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import MainPackage.Encryptor;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ApplicantLogin extends JPanel {

	protected static final long serialVersionUID = 1L;
	protected JTextField ApUsername;
	protected JTextField ApPw;
	protected ApplicantView frame;
	/**
	 * Create the panel.
	 */
	public ApplicantLogin(ApplicantView frame) {
		this.frame = frame;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Applicant Login");
		lblNewLabel.setBounds(580, 244, 209, 67);
		lblNewLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 25));
		add(lblNewLabel);
		
		ApUsername = new JTextField();
		ApUsername.setBounds(580, 361, 209, 30);
		ApUsername.setHorizontalAlignment(SwingConstants.CENTER);
		ApUsername.setText("Enter username");
		ApUsername.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		add(ApUsername);
		ApUsername.setColumns(10);
		addPlaceholderBehavior(ApUsername, ApUsername.getText());
		
		ApPw = new JTextField();
		ApPw.setBounds(580, 402, 209, 30);
		ApPw.setText("Enter password");
		ApPw.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		ApPw.setHorizontalAlignment(SwingConstants.CENTER);
		add(ApPw);
		ApPw.setColumns(10);
		addPlaceholderBehavior(ApPw, ApPw.getText());
		
		JButton ApRegister = new JButton("Register");
		ApRegister.setBounds(704, 443, 85, 14);
		ApRegister.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		ApRegister.setHorizontalAlignment(SwingConstants.CENTER);
		
		ApRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicantForm form = new ApplicantForm(frame);
				frame.switchPanel(form);
			}
		});
		add(ApRegister);
		
		JButton ApLogin = new JButton("Login");
		ApLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = ApUsername.getText();
				String pw = ApPw.getText();
				Applicant applicant = new Applicant();
				if(applicant.applicantLogin(username, pw)) {
					ApplicantDashboard apDash = new ApplicantDashboard(username);
					frame.switchPanel(apDash);
				}else {
					JOptionPane.showMessageDialog(null, "Your credentials are wrong, Try again");
				}
			}
		});
		ApLogin.setBounds(580, 473, 209, 23);
		ApLogin.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		add(ApLogin);
		
		setPreferredSize(new Dimension(1020,720));
	}
	private void addPlaceholderBehavior(JTextField textField, String placeholder) {
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                }
            }
        });
    }
}
