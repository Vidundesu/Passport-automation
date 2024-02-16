package Applicant;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class ApplicantDashboard extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ApplicantDashboard() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(502, 5, 10, 10);
		add(panel);
		
		JButton messageBtn = new JButton("");
		ImageIcon icon = new ImageIcon("C:\\Users\\User\\OneDrive\\Documents\\GitHub\\Passport-automation\\resources\\messenger.png");
		Image img = icon.getImage().getScaledInstance(42, 40, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		messageBtn.setIcon(icon);
		messageBtn.setBounds(10, 11, 54, 53);
		messageBtn.setOpaque(false);
		messageBtn.setContentAreaFilled(false);
		messageBtn.setBorderPainted(false);
		
		add(messageBtn);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 18));
		lblNewLabel.setBounds(794, 11, 96, 53);
		add(lblNewLabel);
		
		JLabel applicantName = new JLabel("logged name");
		applicantName.setBounds(900, 11, 104, 53);
		add(applicantName);
		
		JLabel lblNewLabel_1 = new JLabel("Your Passport status is");
		lblNewLabel_1.setFont(new Font("Poppins Medium", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(49, 142, 326, 85);
		add(lblNewLabel_1);
		
		JLabel applicantStatus = new JLabel("Approved");
		applicantStatus.setForeground(new Color(0, 128, 0));
		applicantStatus.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		applicantStatus.setBounds(49, 214, 188, 30);
		add(applicantStatus);

	}
}