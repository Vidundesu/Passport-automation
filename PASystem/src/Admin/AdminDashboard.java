package Admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Admin.Admin.ReportGenerate;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class AdminDashboard extends JPanel {

	protected static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	protected AdminView frame;
	Admin admin = new Admin();
	protected int nic;
	protected JTable apTable;
	protected JLabel apPassportImg ;
	protected JLabel apBirthImg ;
	protected Map<String, byte[]> imageDataMap;
	protected byte[] passportImage;
	protected byte[] birthImage;
	protected JTable apStatusTable;
	protected JScrollPane scrollPane_1;
	protected JRadioButton passBtn;
	protected JRadioButton rejectBtn;
	protected JLabel applicantLbl;
	protected JLabel apCount;
	protected JLabel apPassportCount;
	protected JLabel apRejectedCount;
	
	protected String count;
	protected String pasCount;
	protected String rejCount;
	
	protected String status;
	public AdminDashboard(AdminView frame) {
		setBackground(new Color(53, 55, 75));
		
		setLayout(null);
		 displayReports();
		
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
		apPassportImg.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		add(apPassportImg);
		
		apBirthImg = new JLabel();
		apBirthImg.setBounds(789, 73, 200, 265);
		apBirthImg.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
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
		
		ButtonGroup group = new ButtonGroup();
		
		rejectBtn = new JRadioButton("Rejected");
		rejectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton radioButton = (JRadioButton) e.getSource();
				status = radioButton.getText();
			}
		});
		rejectBtn.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		rejectBtn.setBounds(579, 469, 109, 23);
		add(rejectBtn);
		
		passBtn = new JRadioButton("Passed");
		passBtn.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		passBtn.setBounds(579, 503, 109, 23);
		passBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton radioButton = (JRadioButton) e.getSource();
				status = radioButton.getText();
			}
		});
		add(passBtn);
		
		group.add(rejectBtn);
		group.add(passBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Set Status");
		lblNewLabel_1.setFont(new Font("Poppins Medium", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(579, 395, 119, 33);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Applicant : ");
		lblNewLabel_2.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(579, 428, 72, 14);
		add(lblNewLabel_2);
		
		String apLbl = String.valueOf(nic);
		applicantLbl = new JLabel(apLbl);
		applicantLbl.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		applicantLbl.setBounds(646, 428, 46, 14);
		add(applicantLbl);
		
		JLabel lblNewLabel_3 = new JLabel("Total Applicants : ");
		lblNewLabel_3.setFont(new Font("Poppins Medium", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(731, 395, 163, 33);
		add(lblNewLabel_3);
		
		JLabel apCount = new JLabel(count);
		apCount.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		apCount.setBounds(904, 400, 46, 24);
		add(apCount);
		
		JButton insertBtn = new JButton("Update");
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(admin.updateApplicantStatus(status, nic)) {
					JOptionPane.showMessageDialog(null,"Application status is set to : "+status);
					
					if(!status.equals("Rejected")) {
						JOptionPane.showMessageDialog(null,"Applicant added to the passport holders list");
					}else {
						return;
					}
				}else {
					JOptionPane.showMessageDialog(null, "Application status set failed, Check requirements");
				}
				
			}
		});
		insertBtn.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		insertBtn.setBounds(579, 544, 100, 23);
		add(insertBtn);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		logoutBtn.setBounds(1200, 27, 89, 23);
		add(logoutBtn);
		
		JLabel lblNewLabel_4 = new JLabel("Upcoming Appointments");
		lblNewLabel_4.setFont(new Font("Poppins Medium", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(1050, 74, 250, 40);
		add(lblNewLabel_4);
		
		JLabel psporlbl = new JLabel("Total Passports : ");
		psporlbl.setFont(new Font("Poppins Medium", Font.PLAIN, 18));
		psporlbl.setBounds(731, 453, 163, 23);
		add(psporlbl);
		
		 apPassportCount = new JLabel(pasCount);
		apPassportCount.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		apPassportCount.setBounds(904, 458, 46, 14);
		add(apPassportCount);
		
		JLabel lblNewLabel_5 = new JLabel("Total Rejected Applicants: ");
		lblNewLabel_5.setFont(new Font("Poppins Medium", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(731, 493, 250, 33);
		add(lblNewLabel_5);
		
		 apRejectedCount = new JLabel(rejCount);
		apRejectedCount.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		apRejectedCount.setBounds(980, 495, 46, 24);
		add(apRejectedCount);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(1050, 110, 250, 486);
		String[] dates = admin.displayDates();
		StringBuilder sb = new StringBuilder();
		for (String date : dates) {
		    sb.append("  "+date).append("\n\n"); // Append each date with a newline
		}
		textArea.setText(sb.toString());
		textArea.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		add(textArea);
		
		
		
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
	public void displayReports() {
		List<ReportGenerate> reports = admin.reportGeneration();
		if(!reports.isEmpty()) {
			for(ReportGenerate report : reports) {
				 count = String.valueOf(report.getApplicantCount());
				 pasCount =String.valueOf( report.getPassportCount());
				 rejCount = String.valueOf(report.getRejectedCount());			
			}
		}
	}
}
