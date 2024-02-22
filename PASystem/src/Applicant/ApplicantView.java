package Applicant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ApplicantView extends JFrame {

	protected static final long serialVersionUID = 1L;
	protected JPanel currentPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicantView frame = new ApplicantView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ApplicantView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		currentPanel = new JPanel();
		currentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		currentPanel = new ApplicantLogin(this);
		
		setContentPane(currentPanel);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	public void switchToLogin() {
		currentPanel.removeAll();
		currentPanel = new ApplicantLogin(this);
		setContentPane(currentPanel);
		revalidate();
		repaint();
	}
	public void switchPanel( JPanel newPanel) {
		currentPanel.removeAll();
		currentPanel= newPanel;
		setContentPane(currentPanel);
		revalidate();
		repaint();
	}

}
