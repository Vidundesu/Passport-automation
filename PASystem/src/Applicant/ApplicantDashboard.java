package Applicant;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Image;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicantDashboard extends JPanel {

	private static final long serialVersionUID = 1L;
	private String username;
	private String status;
	private String name;
	private LocalDate appointmentDate;
	private String date;
	private Applicant applicant;
	/**
	 * Create the panel.
	 */
	
	public ApplicantDashboard(String username) {
		setLayout(null);
		setBackground(new Color(53, 55, 75));
		this.username = username;
		applicant = new Applicant();
		applicant.retrieveApplicantData(username);
		  if(display()) {
	        	status();
	        }
		
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
		lblNewLabel.setBounds(1150, 10, 96, 53);

		add(lblNewLabel);
		
		JLabel applicantName = new JLabel(name);
		applicantName.setBounds(1245, 10, 104, 53);
		applicantName.setFont(new Font("Poppins Medium", Font.PLAIN, 18));
		add(applicantName);
		
		JLabel lblNewLabel_1 = new JLabel("Your Passport status is");
		lblNewLabel_1.setFont(new Font("Poppins Medium", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(49, 142, 326, 85);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Your Appointment Date: ");
		lblNewLabel_2.setFont(new Font("Poppins Medium", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(49, 314, 326, 91);
		add(lblNewLabel_2);
		
		JLabel apDate = new JLabel(date);
		apDate.setBounds(382, 314, 188, 91);
		apDate.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		add(apDate);
		
		
		
	
		
		JLabel lblNewLabel_3 = new JLabel("Schedule an new appointment date.");
		lblNewLabel_3.setFont(new Font("Poppins Medium", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(49, 461, 219, 45);
		add(lblNewLabel_3);

		setPreferredSize(new Dimension(1020,720));
		
		JDateChooser dateChooser = new JDateChooser();
		LocalDate today = LocalDate.now();
		dateChooser.getJCalendar().setMinSelectableDate(java.sql.Date.valueOf(today));
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		dateChooser.setBounds(49, 494, 188, 30);
		add(dateChooser);
		
		JButton DateSchedule = new JButton("Schedule!");
		DateSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate selectedDate = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				applicant.applicantAppointment(username, selectedDate);
			}
		});
		DateSchedule.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		DateSchedule.setBounds(247, 494, 89, 30);
		add(DateSchedule);
		
			lblNewLabel.setForeground(Color.WHITE);
	     	applicantName.setForeground(Color.WHITE);
	        lblNewLabel_1.setForeground(Color.WHITE);
	        
	        lblNewLabel_2.setForeground(Color.WHITE);
	        apDate.setForeground(Color.WHITE);
	        lblNewLabel_3.setForeground(Color.WHITE);
	        DateSchedule.setForeground(Color.WHITE);
	      
	}
	public boolean display() {
		List<Applicant> applicants = applicant.retrieveApplicantData(username);
		if(!applicants.isEmpty()) {
			for(Applicant applicant : applicants) {
				name = applicant.getUserName();
				status = applicant.getStatus();
				appointmentDate = applicant.getAppointmentDate();
				date = appointmentDate.toString();
			}
		}
		return true;
	}
	public void status() {
		
		JLabel applicantStatus = new JLabel(status);
		if (status.equals("Rejected")) {
			applicantStatus.setForeground(new Color(153, 0, 0));
		} else if (status.equals("Passed")) {
		    applicantStatus.setForeground(new Color(0, 204, 0));
		} else if (status.equals("Processing")) {
		 applicantStatus.setForeground(Color.WHITE);
		}
		applicantStatus.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		applicantStatus.setBounds(49, 214, 188, 30);
		add(applicantStatus);
		  
	}
   
}

