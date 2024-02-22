package Admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class AdminDashboard extends JPanel {

	protected static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	protected AdminView frame;
	public AdminDashboard(AdminView frame) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Admin");
		lblNewLabel.setBounds(20, 11, 199, 51);
		lblNewLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		add(lblNewLabel);
	}
}
