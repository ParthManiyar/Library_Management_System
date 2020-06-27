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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class IssuePeriodical extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static IssuePeriodical frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new IssuePeriodical();
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
	public IssuePeriodical() {
		setTitle("Issue Periodical");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 136);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPeriodicalId = new JLabel("Periodical ID");
		lblPeriodicalId.setFont(new Font("Arial", Font.BOLD, 12));
		lblPeriodicalId.setBounds(10, 13, 75, 14);
		contentPane.add(lblPeriodicalId);
		
		JLabel label_1 = new JLabel("Member Id");
		label_1.setFont(new Font("Arial", Font.BOLD, 12));
		label_1.setBounds(10, 38, 75, 14);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(95, 11, 127, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 36, 127, 20);
		contentPane.add(textField_1);
		
		JButton button = new JButton("Ok");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Issue1 frame1;
				try {
					frame1 = new Issue1(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()));
					frame1.setVisible(true);
					JOptionPane.showMessageDialog(IssuePeriodical.this, "Periodical issued successful");
					frame.dispose();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(IssuePeriodical.this, e);
				}
				
				
			}
		});
		button.setBounds(90, 67, 89, 23);
		contentPane.add(button);
	}
}
