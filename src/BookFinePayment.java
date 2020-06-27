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

public class BookFinePayment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static BookFinePayment frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BookFinePayment();
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
	public BookFinePayment() {
		setTitle("Book Fine Payment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Book Id");
		label.setFont(new Font("Arial", Font.BOLD, 12));
		label.setBounds(10, 13, 60, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(80, 11, 127, 20);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Member Id");
		label_1.setFont(new Font("Arial", Font.BOLD, 12));
		label_1.setBounds(10, 38, 60, 14);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(80, 36, 127, 20);
		contentPane.add(textField_1);
		
		JButton button = new JButton("Ok");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Fine frame1 = new Fine(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()));
					frame1.setVisible(true);
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(90, 67, 89, 23);
		contentPane.add(button);
	}

}
