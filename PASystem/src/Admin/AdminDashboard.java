package Admin;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDashboard extends JPanel {

	protected static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	protected AdminView frame;
	Admin admin = new Admin();
	protected int nic;
	protected JTable apTable;
	JLabel apPassportImg ;
	JLabel apBirthImg ;
	Map<String, byte[]> imageDataMap;
	byte[] passportImage;
	byte[] birthImage;
	private JTable apStatusTable;
	private JScrollPane scrollPane_1;
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
		refreshBtn.setBounds(10, 349, 95, 23);
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
		apTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					int selectedRow = apTable.getSelectedRow();
					if(selectedRow != -1) {
						DefaultTableModel model =(DefaultTableModel) apTable.getModel();
						String selectedNIC = model.getValueAt(selectedRow, 0).toString();
						 nic = Integer.parseInt(selectedNIC);
						System.out.println(nic);
						imageDataMap = admin.getDocs(nic);
						passportImage = imageDataMap.get("passportImage");
						birthImage = imageDataMap.get("birthImage");
						displayImages(passportImage, apPassportImg);
						displayImages(birthImage, apBirthImg);
						
						System.out.println(passportImage);
						System.out.println(birthImage);
					}
				}
			}
		});
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
		
		apPassportImg = new JLabel();
		apPassportImg.setBounds(579, 73, 200, 265);
		add(apPassportImg);
		
		apBirthImg = new JLabel();
		apBirthImg.setBounds(789, 73, 200, 265);
		add(apBirthImg);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 395, 519, 172);
		add(scrollPane_1);
		
		apStatusTable = new JTable();
		scrollPane_1.setViewportView(apStatusTable);
		apStatusTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NIC", "firstName", "lastName","Status"
			}
		));
		apStatusTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					int selectedRow = apStatusTable.getSelectedRow();
					if(selectedRow != -1) {
						DefaultTableModel model =(DefaultTableModel) apStatusTable.getModel();
						String selectedNIC = model.getValueAt(selectedRow, 0).toString();
						 nic = Integer.parseInt(selectedNIC);
						System.out.println(nic);
						
					}
				}
			}
		});
		admin.displayStatus(apStatusTable);
		
	}
	public void displayImages(byte[]imageData, JLabel img) {
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
				Image image = ImageIO.read(bis);
				
				int width= apPassportImg.getWidth();
				int height = apPassportImg.getHeight();
				Image scaledImg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
				img.setIcon(new ImageIcon (scaledImg));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
