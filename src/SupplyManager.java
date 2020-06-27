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
import java.sql.SQLException;

public class SupplyManager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	static SupplyManager frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SupplyManager();
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
	public SupplyManager() {
		setTitle("Supplier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("GST Number");
		lblId.setFont(new Font("Arial", Font.BOLD, 12));
		lblId.setBounds(10, 11, 75, 14);
		contentPane.add(lblId);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setFont(new Font("Arial", Font.BOLD, 12));
		lblCompanyName.setBounds(10, 36, 95, 14);
		contentPane.add(lblCompanyName);
		
		JLabel lblAddress = new JLabel("Contact Number ");
		lblAddress.setFont(new Font("Arial", Font.BOLD, 12));
		lblAddress.setBounds(10, 61, 95, 14);
		contentPane.add(lblAddress);
		
		JLabel lblGstNumber = new JLabel("E-mail Id");
		lblGstNumber.setFont(new Font("Arial", Font.BOLD, 12));
		lblGstNumber.setBounds(10, 86, 95, 14);
		contentPane.add(lblGstNumber);
		
		textField = new JTextField();
		textField.setBounds(115, 9, 119, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 34, 119, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(115, 59, 119, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(115, 84, 119, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = 0;
				try {
					i = SupplierDao.save(textField.getText(),textField_1.getText() , textField_2.getText(), textField_3.getText());
					 if (i > 0) {
		                    JOptionPane.showMessageDialog(SupplyManager.this, "Supplier added successfully!");
		                    frame.dispose();

		                }
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(SupplyManager.this, e1.getMessage());
				}
				
			
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(79, 115, 89, 23);
		contentPane.add(btnNewButton);
	}
}
