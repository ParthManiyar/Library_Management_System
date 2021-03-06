import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReturnPeriodical extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static ReturnPeriodical frame ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ReturnPeriodical();
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
	public ReturnPeriodical() {
		setTitle("Return Periodical");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPeriodicalId = new JLabel("Periodical Id");
		lblPeriodicalId.setFont(new Font("Arial", Font.BOLD, 12));
		lblPeriodicalId.setBounds(10, 13, 77, 14);
		contentPane.add(lblPeriodicalId);
		
		JLabel label_1 = new JLabel("Member Id");
		label_1.setFont(new Font("Arial", Font.BOLD, 12));
		label_1.setBounds(10, 38, 77, 14);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(97, 11, 127, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 36, 127, 20);
		contentPane.add(textField_1);
		
		JButton button = new JButton("Ok");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Return1 frame1 = new Return1(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()));
					frame1.setVisible(true);
					 frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		button.setBounds(90, 67, 89, 23);
		contentPane.add(button);
	}

}
