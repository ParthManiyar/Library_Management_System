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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class IssueBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static IssueBook frame;
   public static void main(String[] args) {
	   EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new IssueBook();
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
	public IssueBook() {
		setTitle("Issue Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 292, 142);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookId = new JLabel("Book Id");
		lblBookId.setFont(new Font("Arial", Font.BOLD, 12));
		lblBookId.setBounds(10, 11, 60, 14);
		contentPane.add(lblBookId);
		
		JLabel lblMemberId = new JLabel("Member Id");
		lblMemberId.setFont(new Font("Arial", Font.BOLD, 12));
		lblMemberId.setBounds(10, 36, 60, 14);
		contentPane.add(lblMemberId);
		
		textField = new JTextField();
		textField.setBounds(80, 9, 127, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(80, 34, 127, 20);
		contentPane.add(textField_1);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
							try {
								Issue frame1 = new Issue(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()));
								frame1.setVisible(true);
								JOptionPane.showMessageDialog(IssueBook.this, "Book issued successful");
								frame.dispose();
								
							}
							catch(SQLException e1) {
								JOptionPane.showMessageDialog(IssueBook.this, e1.getMessage());				
								}
							catch (Exception e2) {
								System.out.println(e2);
							}
			}

		});
		btnOk.setBounds(90, 65, 89, 23);
		contentPane.add(btnOk);
	}
}
