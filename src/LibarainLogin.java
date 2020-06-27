import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LibarainLogin extends JFrame {

	private JPanel contentPane;
	private JTextField text;
	private JPasswordField password;
	static LibarainLogin frame;
	static LibarainView frame1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibarainLogin();
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
	public LibarainLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labe_1 = new JLabel(" Enter Name:");
		labe_1.setFont(new Font("Arial", Font.BOLD, 12));
		labe_1.setBounds(24, 11, 73, 20);
		contentPane.add(labe_1);
		
		text = new JTextField();
		text.setBounds(123, 12, 146, 20);
		contentPane.add(text);
		text.setColumns(10);
		
		JLabel labe_2 = new JLabel("Password:");
		labe_2.setFont(new Font("Arial", Font.BOLD, 12));
		labe_2.setBounds(24, 42, 73, 20);
		contentPane.add(labe_2);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter Your Password");
		passwordField.setBounds(123, 43, 146, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin_1 = new JButton("Login");
		btnLogin_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(((text.getText().equals("Parth Maniyar")) && (String.valueOf(passwordField.getPassword()).equals("1741068")))||((text.getText().equals("Kausha Vora")) && (String.valueOf(passwordField.getPassword()).equals("1741016")))) {
					frame.dispose();
					LibarainView.main(new String[] {});
				}
				else{
					JOptionPane.showMessageDialog(LibarainLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
					text.setText("");
					passwordField.setText("");
				}
			}
		});
		btnLogin_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnLogin_1.setBounds(123, 93, 89, 23);
		contentPane.add(btnLogin_1);
		
}
}
