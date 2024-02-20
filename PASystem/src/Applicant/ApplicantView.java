package Applicant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ApplicantView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel currentPanel;
	private JPanel newPanel;
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane = new ApplicantLogin(this);
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	public void switchPanel( JPanel newPanel) {
		contentPane.removeAll();
		contentPane= newPanel;
		setContentPane(contentPane);
		revalidate();
		repaint();
	}
}
