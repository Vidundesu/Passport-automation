package Applicant;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicantForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField fName;
	private JTextField mName;
	private JTextField lName;
	private JTextField txtFathersFullName;
	private JTextField textField;
	private JTextField HouseNo;
	private JTextField Road;
	private JTextField city;
	private JTextField day;
	private JTextField month;
	private JTextField year;
	private JLabel lblNewLabel_6;
	private JTextField pob;
	private JLabel lblNewLabel_7;
	private JTextField bNumber;
	private JLabel lblNewLabel_8;
	private JTextField email;
	private JLabel lblNewLabel_9;
	private JTextField mobileNumber;
	private JButton homeBtn;
	private JButton home;
	
	/**
	 * Create the panel.
	 */
	public ApplicantForm() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Applicant Registration");
		lblNewLabel.setBounds(40, 31, 367, 90);
		lblNewLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 30));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Applicant Full Name");
		lblNewLabel_1.setBounds(40, 132, 162, 14);
		lblNewLabel_1.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		add(lblNewLabel_1);
		
		fName = new JTextField();
		fName.setBounds(40, 157, 86, 20);
		fName.setHorizontalAlignment(SwingConstants.CENTER);
		fName.setToolTipText("");
		fName.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		fName.setText("First Name");
		addPlaceholderBehavior(fName, fName.getText());
		add(fName);
		fName.setColumns(10);
		
		mName = new JTextField();
		mName.setBounds(136, 157, 86, 20);
		mName.setHorizontalAlignment(SwingConstants.CENTER);
		mName.setText("Middle Name");
		addPlaceholderBehavior(mName, mName.getText());
		add(mName);
		mName.setColumns(10);
		
		lName = new JTextField();
		lName.setBounds(232, 157, 86, 20);
		lName.setHorizontalAlignment(SwingConstants.CENTER);
		lName.setText("Last Name");
		addPlaceholderBehavior(lName, lName.getText());
		add(lName);
		lName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Father's Name");
		lblNewLabel_2.setBounds(40, 188, 183, 14);
		lblNewLabel_2.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		add(lblNewLabel_2);
		
		txtFathersFullName = new JTextField();
		txtFathersFullName.setBounds(40, 213, 182, 20);
		txtFathersFullName.setHorizontalAlignment(SwingConstants.LEFT);
		add(txtFathersFullName);
		txtFathersFullName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mother's Name");
		lblNewLabel_3.setBounds(40, 244, 183, 14);
		lblNewLabel_3.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(40, 269, 182, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(40, 300, 125, 14);
		lblNewLabel_4.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		add(lblNewLabel_4);
		
		HouseNo = new JTextField();
		HouseNo.setBounds(40, 325, 86, 20);
		HouseNo.setHorizontalAlignment(SwingConstants.CENTER);
		HouseNo.setText("House No");
		addPlaceholderBehavior(HouseNo, HouseNo.getText());
		add(HouseNo);
		HouseNo.setColumns(10);
		
		Road = new JTextField();
		Road.setBounds(136, 325, 86, 20);
		Road.setHorizontalAlignment(SwingConstants.CENTER);
		Road.setText("Road");
		addPlaceholderBehavior(Road, Road.getText());
		add(Road);
		Road.setColumns(10);
		
		city = new JTextField();
		city.setBounds(232, 325, 86, 20);
		city.setHorizontalAlignment(SwingConstants.CENTER);
		city.setText("City");
		addPlaceholderBehavior(city, city.getText());
		add(city);
		city.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Date of Birth");
		lblNewLabel_5.setBounds(40, 356, 125, 14);
		lblNewLabel_5.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		add(lblNewLabel_5);
		
		day = new JTextField();
		day.setBounds(40, 381, 86, 20);
		day.setHorizontalAlignment(SwingConstants.CENTER);
		day.setText("DD");
		addPlaceholderBehavior(day, day.getText());
		add(day);
		day.setColumns(10);
		
		month = new JTextField();
		month.setBounds(136, 381, 86, 20);
		month.setHorizontalAlignment(SwingConstants.CENTER);
		month.setText("MM");
		addPlaceholderBehavior(month, month.getText());
		add(month);
		month.setColumns(10);
		
		year = new JTextField();
		year.setBounds(232, 381, 86, 20);
		year.setHorizontalAlignment(SwingConstants.CENTER);
		year.setText("YYYY");
		addPlaceholderBehavior(year, year.getText());
		add(year);
		year.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Place of Birth");
		lblNewLabel_6.setBounds(40, 412, 125, 14);
		lblNewLabel_6.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		add(lblNewLabel_6);
		
		pob = new JTextField();
		pob.setBounds(40, 437, 182, 20);
		add(pob);
		pob.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Birth Certificate Number");
		lblNewLabel_7.setBounds(40, 468, 199, 14);
		lblNewLabel_7.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		add(lblNewLabel_7);
		
		bNumber = new JTextField();
		bNumber.setBounds(40, 493, 114, 20);
		add(bNumber);
		bNumber.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Email Address");
		lblNewLabel_8.setBounds(40, 524, 148, 14);
		lblNewLabel_8.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		add(lblNewLabel_8);
		
		email = new JTextField();
		email.setBounds(40, 549, 162, 20);
		add(email);
		email.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Mobile Number");
		lblNewLabel_9.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(40, 580, 125, 14);
		add(lblNewLabel_9);
		
		mobileNumber = new JTextField();
		mobileNumber.setBounds(40, 605, 162, 20);
		add(mobileNumber);
		mobileNumber.setColumns(10);
		
		JButton home = new JButton("");
		home.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	ApplicantView frame = new ApplicantView();
		    	frame.switchToPanel();
		    }
		});
		
		
		ImageIcon icon = new ImageIcon("C:\\Users\\Vidun Nethdina\\Documents\\GitHub\\Passport-automation\\resources\\home.png");
		Image img = icon.getImage().getScaledInstance(42, 40, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		home.setIcon(icon);
		home.setBounds(875, 11, 52, 49);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.setBorder(null);
		add(home);
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
//	private void homeButton(ApplicantForm form, ApplicantView frame) {
//	
//		
//	}
		
}
