package Admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class AdminDashboard extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public AdminDashboard() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Admin");
		lblNewLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblNewLabel.setBounds(20, 11, 199, 51);
		add(lblNewLabel);

	}
}
