package Applicant;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class ApplicantView extends javax.swing.JFrame{
	 private javax.swing.JPanel CurrentPanel;
	 private javax.swing.JTextField ApplicantID;
	 private javax.swing.JPanel ApplicantMain;
	 private javax.swing.JTextField ApplicantPw;
	 private javax.swing.JButton Applicantlogin;
	 private javax.swing.JLabel applicantRegister;
	 private javax.swing.JLabel jLabel1;
	 
	public ApplicantView() {
			
		ApplicantMain = new javax.swing.JPanel();
        CurrentPanel = ApplicantMain;

        jLabel1 = new javax.swing.JLabel();
        ApplicantID = new javax.swing.JTextField();
        ApplicantPw = new javax.swing.JTextField();
        applicantRegister = new javax.swing.JLabel();
        Applicantlogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Applicant");

        ApplicantID.setText("Applicant ID");
        ApplicantPw.setText("Applicant Password");

        applicantRegister.setText("Register");
        applicantRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registerButton(ApplicantView.this);
            }
        });

        Applicantlogin.setText("Log in");
        Applicantlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        javax.swing.GroupLayout ApplicantMainLayout = new javax.swing.GroupLayout(ApplicantMain);
        ApplicantMain.setLayout(ApplicantMainLayout);
        ApplicantMainLayout.setHorizontalGroup(
                ApplicantMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ApplicantMainLayout.createSequentialGroup()
                                .addContainerGap(421, Short.MAX_VALUE)
                                .addGroup(ApplicantMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(applicantRegister)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ApplicantID, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ApplicantPw, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Applicantlogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(400, 400, 400))
        );
        ApplicantMainLayout.setVerticalGroup(
                ApplicantMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ApplicantMainLayout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132)
                                .addComponent(ApplicantID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ApplicantPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(applicantRegister)
                                .addGap(47, 47, 47)
                                .addComponent(Applicantlogin)
                                .addContainerGap(255, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ApplicantMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ApplicantMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

	        
	}
    private void registerButton(ApplicantView frame) {
    		
    	 javax.swing.JTextField afName;
         javax.swing.JTextField alName;
         javax.swing.JTextField amName;
         javax.swing.JPanel applicantRegisterP;
         javax.swing.JTextField birthNumber;
         javax.swing.JTextField city;
         javax.swing.JTextField day;
         javax.swing.JTextField email;
         javax.swing.JTextField fatherName;
         javax.swing.JTextField houseNumber;
         javax.swing.JLabel jLabel1;
         javax.swing.JLabel jLabel10;
         javax.swing.JLabel jLabel2;
         javax.swing.JLabel jLabel3;
         javax.swing.JLabel jLabel4;
         javax.swing.JLabel jLabel5;
         javax.swing.JLabel jLabel6;
         javax.swing.JLabel jLabel7;
         javax.swing.JLabel jLabel8;
         javax.swing.JLabel jLabel9;
         javax.swing.JTextField mobile;
         javax.swing.JTextField month;
         javax.swing.JTextField motherName;
         javax.swing.JTextField pob;
         javax.swing.JTextField road;
         javax.swing.JTextField year;  
    	
    	  applicantRegisterP = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();
          afName = new javax.swing.JTextField();
          amName = new javax.swing.JTextField();
          alName = new javax.swing.JTextField();
          jLabel3 = new javax.swing.JLabel();
          fatherName = new javax.swing.JTextField();
          jLabel4 = new javax.swing.JLabel();
          motherName = new javax.swing.JTextField();
          jLabel5 = new javax.swing.JLabel();
          houseNumber = new javax.swing.JTextField();
          road = new javax.swing.JTextField();
          city = new javax.swing.JTextField();
          jLabel6 = new javax.swing.JLabel();
          day = new javax.swing.JTextField();
          month = new javax.swing.JTextField();
          year = new javax.swing.JTextField();
          jLabel8 = new javax.swing.JLabel();
          pob = new javax.swing.JTextField();
          jLabel7 = new javax.swing.JLabel();
          birthNumber = new javax.swing.JTextField();
          jLabel9 = new javax.swing.JLabel();
          email = new javax.swing.JTextField();
          jLabel10 = new javax.swing.JLabel();
          mobile = new javax.swing.JTextField();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

          jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
          jLabel1.setText("Applicant Registration");

          jLabel2.setText("Full Name");

          afName.setText("First");

          amName.setText("Middle");

          alName.setText("Last");

          jLabel3.setText("Father Name");

          fatherName.setText("Father's Full Name");
          fatherName.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  fatherNameActionPerformed(evt);
              }
          });

          jLabel4.setText("Mother Name");

          motherName.setText("Mother's full Name");

          jLabel5.setText("Current Address");

          houseNumber.setText("House Number");

          road.setText("Road");

          city.setText("city");

          jLabel6.setText("Date of Birth");

          day.setText("Day");

          month.setText("Month");

          year.setText("Year");

          jLabel8.setText("Place of Birth");

          jLabel7.setText("Birth Certificate Number");

          jLabel9.setText("Email address");

          jLabel10.setText("Mobile Number");

          javax.swing.GroupLayout applicantRegisterPLayout = new javax.swing.GroupLayout(applicantRegisterP);
          applicantRegisterP.setLayout(applicantRegisterPLayout);
          applicantRegisterPLayout.setHorizontalGroup(
              applicantRegisterPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(applicantRegisterPLayout.createSequentialGroup()
                  .addGap(49, 49, 49)
                  .addGroup(applicantRegisterPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(jLabel10)
                      .addComponent(jLabel9)
                      .addComponent(jLabel7)
                      .addComponent(jLabel8)
                      .addComponent(jLabel6)
                      .addGroup(applicantRegisterPLayout.createSequentialGroup()
                          .addComponent(houseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addGap(18, 18, 18)
                          .addComponent(road, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addGap(18, 18, 18)
                          .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addComponent(jLabel5)
                      .addComponent(jLabel4)
                      .addComponent(jLabel3)
                      .addComponent(jLabel2)
                      .addComponent(jLabel1)
                      .addGroup(applicantRegisterPLayout.createSequentialGroup()
                          .addGroup(applicantRegisterPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                              .addComponent(motherName, javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(fatherName, javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(applicantRegisterPLayout.createSequentialGroup()
                                  .addComponent(afName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                  .addGap(18, 18, 18)
                                  .addComponent(amName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                          .addGap(18, 18, 18)
                          .addComponent(alName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addGroup(applicantRegisterPLayout.createSequentialGroup()
                          .addGroup(applicantRegisterPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                              .addComponent(mobile, javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(email, javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(birthNumber, javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(pob, javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(applicantRegisterPLayout.createSequentialGroup()
                                  .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                  .addGap(18, 18, 18)
                                  .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                          .addGap(18, 18, 18)
                          .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                  .addContainerGap(585, Short.MAX_VALUE))
          );
          applicantRegisterPLayout.setVerticalGroup(
              applicantRegisterPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(applicantRegisterPLayout.createSequentialGroup()
                  .addGap(47, 47, 47)
                  .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(12, 12, 12)
                  .addComponent(jLabel2)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(applicantRegisterPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(afName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(amName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(alName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18)
                  .addComponent(jLabel3)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(fatherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)
                  .addComponent(jLabel4)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(motherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)
                  .addComponent(jLabel5)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(applicantRegisterPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(houseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(road, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18)
                  .addComponent(jLabel6)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(applicantRegisterPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18)
                  .addComponent(jLabel8)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(pob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)
                  .addComponent(jLabel7)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(birthNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)
                  .addComponent(jLabel9)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)
                  .addComponent(jLabel10)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addContainerGap(53, Short.MAX_VALUE))
          );

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(applicantRegisterP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );
          layout.setVerticalGroup(
              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(applicantRegisterP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );

          
       
//      registerP.add(new JLabel("This is testing"));
        applicantRegisterP.setSize(CurrentPanel.getSize());
       
        frame.getContentPane().remove(frame.CurrentPanel);
        frame.getContentPane().add(applicantRegisterP);
        frame.CurrentPanel = applicantRegisterP;

        frame.revalidate();
        frame.repaint();
    }

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               ApplicantView applicant = new ApplicantView();
               applicant.setVisible(true);
               applicant.setSize(1020,720);
            }
        });
		
	}
	
}
