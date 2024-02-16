package Applicant;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class ApplicantView extends javax.swing.JFrame{
	 protected javax.swing.JPanel CurrentPanel;
	 private javax.swing.JTextField ApplicantID;
	 protected javax.swing.JPanel ApplicantMain;
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
            	ApplicantForm form = new ApplicantForm();
            	registerButton(ApplicantView.this, form);
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
    private void registerButton(ApplicantView frame, ApplicantForm form) {
        form.setSize(CurrentPanel.getSize());
       
        frame.getContentPane().remove(frame.CurrentPanel);
        frame.getContentPane().add(form);
        frame.CurrentPanel = form;

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
