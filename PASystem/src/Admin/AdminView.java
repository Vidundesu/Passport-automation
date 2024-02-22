package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminView extends JFrame {

	protected static final long serialVersionUID = 1L;
	protected JPanel currentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView();
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
	public AdminView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 359);
		currentPanel = new JPanel();
		currentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		currentPanel = new AdminLogin(this);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(currentPanel);
	}
	public void switchPanel(JPanel newPanel) {
		currentPanel.removeAll();
		currentPanel= newPanel;
		setContentPane(currentPanel);
		revalidate();
		repaint();
	}

}
