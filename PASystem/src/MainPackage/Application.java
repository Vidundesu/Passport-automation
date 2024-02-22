package MainPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Application extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
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
	public Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 953, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Passport Automation System");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton logAdmin = new JButton("Log in as an Admin");
		logAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		logAdmin.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		logAdmin.setBounds(599, 288, 231, 61);
		contentPane.add(logAdmin);
		
		JButton logApplicant = new JButton("Log in as an Applicant");
		logApplicant.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		logApplicant.setBounds(599, 376, 231, 61);
		contentPane.add(logApplicant);
	}
}
