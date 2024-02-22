package Admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import MainPackage.*;
public class AdminLogin extends JPanel {

	protected static final long serialVersionUID = 1L;
	protected JTextField adminUsername;
	protected JPasswordField adminPw;
	protected JLabel lblNewLabel_1;
	protected JLabel lblNewLabel_2;
	protected JButton adminLogin;

	protected AdminView frame;
	/**
	 * Create the panel.
	 */
	public AdminLogin(AdminView frame) {
		this.frame = frame;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblNewLabel.setBounds(597, 197, 292, 66);
		add(lblNewLabel);
		
		adminUsername = new JTextField();
		adminUsername.setHorizontalAlignment(SwingConstants.CENTER);
		adminUsername.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		adminUsername.setBounds(597, 303, 243, 48);
		add(adminUsername);
		adminUsername.setColumns(10);
		
		adminPw = new JPasswordField();
		adminPw.setHorizontalAlignment(SwingConstants.CENTER);
		adminPw.setToolTipText("");
		
		adminPw.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		adminPw.setBounds(597, 376, 243, 48);
		add(adminPw);
		
		lblNewLabel_1 = new JLabel("Enter password");
		lblNewLabel_1.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(597, 362, 84, 14);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Enter username");
		lblNewLabel_2.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(597, 286, 108, 14);
		add(lblNewLabel_2);
		
		adminLogin = new JButton("Login");
		adminLogin.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		adminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = adminUsername.getText();
				String password = adminPw.getText();
				
				Admin admin = new Admin();
				if(admin.adminLogin(username, password)) {
					
				}
				
			}
		});
		adminLogin.setBounds(597, 445, 243, 23);
		add(adminLogin);

	}
}
