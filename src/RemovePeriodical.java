import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class RemovePeriodical extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static RemovePeriodical frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new RemovePeriodical();
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
	public RemovePeriodical() {
		setTitle("Remove Periodical");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 127);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(10, 36, 46, 14);
		contentPane.add(lblQuantity);
		
		textField = new JTextField();
		textField.setBounds(66, 8, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(66, 33, 131, 20);
		contentPane.add(textField_1);
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i1 = 0;
				try {
					i1 = PeriodicalDao.remove(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()));
	                JOptionPane.showMessageDialog(RemovePeriodical.this, "Periodical removed successfully!");

				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
					JOptionPane.showMessageDialog(RemovePeriodical.this, e1.getMessage());
				}
                
                frame.dispose();
			}
		});
		btnOk.setBounds(66, 64, 89, 23);
		contentPane.add(btnOk);
	}

}
