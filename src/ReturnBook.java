import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static ReturnBook frame;
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				frame = new ReturnBook();
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
	public ReturnBook() {
		setTitle("Return Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 253, 133);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookId = new JLabel("Book Id");
		lblBookId.setBounds(10, 11, 68, 14);
		contentPane.add(lblBookId);
		
		JLabel lblMemberId = new JLabel("Member Id");
		lblMemberId.setBounds(10, 36, 68, 14);
		contentPane.add(lblMemberId);
		
		textField = new JTextField();
		textField.setBounds(82, 8, 108, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 33, 108, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Return frame1 = new Return(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()));
					frame1.setVisible(true);
					 frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton.setBounds(69, 61, 89, 23);
		contentPane.add(btnNewButton);
	}

}
