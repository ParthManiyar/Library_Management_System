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

public class AddPeriodical extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtYyyymmdd;
	private JTextField textField_4;
	static AddPeriodical frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddPeriodical();
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
	public AddPeriodical() {
		setTitle("Add Periodical");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 11, 94, 14);
		contentPane.add(lblTitle);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(10, 36, 94, 14);
		contentPane.add(lblType);
		
		JLabel lblNumberOfCopies = new JLabel("Number Of Copies");
		lblNumberOfCopies.setBounds(10, 61, 94, 14);
		contentPane.add(lblNumberOfCopies);
		
		JLabel lblPublishedDate = new JLabel("Published Date");
		lblPublishedDate.setBounds(10, 87, 94, 14);
		contentPane.add(lblPublishedDate);
		
		JLabel lblSupplier = new JLabel("Supplier Id");
		lblSupplier.setBounds(10, 112, 94, 14);
		contentPane.add(lblSupplier);
		
		textField = new JTextField();
		textField.setBounds(123, 8, 140, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 33, 140, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(123, 58, 140, 20);
		contentPane.add(textField_2);
		
		txtYyyymmdd = new JTextField();
		txtYyyymmdd.setText("yyyy-mm-dd");
		txtYyyymmdd.setColumns(10);
		txtYyyymmdd.setBounds(123, 84, 140, 20);
		contentPane.add(txtYyyymmdd);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(123, 109, 140, 20);
		contentPane.add(textField_4);
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = PeriodicalDao.save(textField.getText(),textField_1.getText(),Integer.parseInt(textField_2.getText()),txtYyyymmdd.getText(),Integer.parseInt(textField_4.getText()));
				if (i > 0) {
                    JOptionPane.showMessageDialog(AddPeriodical.this, "Periodical added successfully!");
                    frame.dispose();

                } else {
                    JOptionPane.showMessageDialog(AddPeriodical.this, "Sorry, unable to save!");
                }
				frame.dispose();
			}
		});
		btnOk.setBounds(123, 140, 89, 23);
		contentPane.add(btnOk);
	}

}
