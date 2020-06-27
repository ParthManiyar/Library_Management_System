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
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberManager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static MemberManager frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MemberManager();
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
	public MemberManager() {
		setTitle("Member");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("First Name");
		lblId.setFont(new Font("Arial", Font.BOLD, 12));
		lblId.setBounds(10, 11, 100, 14);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Last Name");
		lblName.setFont(new Font("Arial", Font.BOLD, 12));
		lblName.setBounds(10, 36, 100, 14);
		contentPane.add(lblName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Arial", Font.BOLD, 12));
		lblType.setBounds(10, 61, 100, 14);
		contentPane.add(lblType);
		
		textField = new JTextField();
		textField.setBounds(120, 9, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 34, 116, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 59, 116, 20);
		contentPane.add(textField_2);
		
		JButton btnAdd = new JButton("OK");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = MemberDao.save(textField.getText(),textField_1.getText(),textField_2.getText());
				if (i > 0) {
                    JOptionPane.showMessageDialog(MemberManager.this, "Member added successfully!");
					frame.dispose();

                } else {
                    JOptionPane.showMessageDialog(MemberManager.this, "Sorry, unable to save!");
                }
			}
		});
		
		btnAdd.setBounds(67, 91, 89, 23);
		contentPane.add(btnAdd);
		
	}
}
