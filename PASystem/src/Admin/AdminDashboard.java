package Admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDashboard extends JPanel {

	protected static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	protected AdminView frame;
	Admin admin = new Admin();
	
	private JTable apTable;
	public AdminDashboard(AdminView frame) {
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Welcome Admin");
		lblNewLabel.setBounds(20, 11, 199, 51);
		lblNewLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		add(lblNewLabel);
		
		JButton refreshBtn = new JButton("Refresh Db");
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				admin.displayApplicants(apTable);
			}
		});
		refreshBtn.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		refreshBtn.setBounds(696, 27, 95, 23);
		add(refreshBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setBounds(10, 73, 519, 265);
		add(scrollPane);
		
		apTable = new JTable();
		scrollPane.setViewportView(apTable);
		apTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Applicant NIC", "First Name", "Last Name", "Birthcertificate", "Email"
			}
		));
		admin.displayApplicants(apTable);
		apTable.getColumnModel().getColumn(3).setPreferredWidth(83);
		apTable.getColumnModel().getColumn(4).setPreferredWidth(100);
	}
}
