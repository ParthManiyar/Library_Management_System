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
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class BookManager extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	static BookManager frame;
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				frame = new BookManager();
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
	public BookManager() {
		setTitle("Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookname = new JLabel("ISBN No");
		lblBookname.setFont(new Font("Arial", Font.BOLD, 12));
		lblBookname.setBounds(10, 11, 103, 14);
		contentPane.add(lblBookname);
		
		JLabel lblAuthor = new JLabel("Title");
		lblAuthor.setFont(new Font("Arial", Font.BOLD, 12));
		lblAuthor.setBounds(10, 36, 65, 14);
		contentPane.add(lblAuthor);
		
		JLabel lblPrice = new JLabel("Edition");
		lblPrice.setFont(new Font("Arial", Font.BOLD, 12));
		lblPrice.setBounds(10, 61, 103, 14);
		contentPane.add(lblPrice);
		
		JLabel lblNumberOfCopies = new JLabel("Publisher Id");
		lblNumberOfCopies.setFont(new Font("Arial", Font.BOLD, 12));
		lblNumberOfCopies.setBounds(10, 86, 103, 14);
		contentPane.add(lblNumberOfCopies);
		
		JLabel lblSupplierid = new JLabel("Supplier Id");
		lblSupplierid.setFont(new Font("Arial", Font.BOLD, 12));
		lblSupplierid.setBounds(10, 186, 103, 14);
		contentPane.add(lblSupplierid);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 9, 127, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(123, 34, 127, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(123, 59, 127, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(123, 84, 127, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(123, 184, 127, 20);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i1 = BookDao.save(textField_1.getText(),textField_2.getText() , Integer.parseInt(textField_3.getText()), Integer.parseInt(textField_4.getText()),Integer.parseInt(textField_6.getText()),Integer.parseInt(textField_7.getText()),Float.parseFloat(textField.getText()),Integer.parseInt(textField_5.getText()),textField_8.getText(),textField_9.getText());
				int i2 = AuthorDao.save(textField_10.getText(), textField_11.getText());
                if (i1 > 0 && i2>0) {
                    JOptionPane.showMessageDialog(BookManager.this, "Books added successfully!");
                    frame.dispose();

                } else {
                    JOptionPane.showMessageDialog(BookManager.this, "Sorry, unable to save!");
                }
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(77, 317, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblRackNumber = new JLabel("Number of pages");
		lblRackNumber.setFont(new Font("Arial", Font.BOLD, 12));
		lblRackNumber.setBounds(10, 111, 103, 14);
		contentPane.add(lblRackNumber);
		
		JLabel lblDeckNumber = new JLabel("Number of Copies");
		lblDeckNumber.setFont(new Font("Arial", Font.BOLD, 12));
		lblDeckNumber.setBounds(10, 136, 103, 14);
		contentPane.add(lblDeckNumber);
		
		textField_6 = new JTextField();
		textField_6.setBounds(123, 109, 127, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(123, 134, 127, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblPublisherId = new JLabel("Price");
		lblPublisherId.setFont(new Font("Arial", Font.BOLD, 12));
		lblPublisherId.setBounds(10, 161, 103, 14);
		contentPane.add(lblPublisherId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(123, 159, 127, 20);
		contentPane.add(textField);
		
		JLabel lblRackNumber_1 = new JLabel("Rack number");
		lblRackNumber_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblRackNumber_1.setBounds(10, 211, 103, 14);
		contentPane.add(lblRackNumber_1);
		
		JLabel lblDeckNumber_1 = new JLabel("Deck Number");
		lblDeckNumber_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblDeckNumber_1.setBounds(10, 236, 103, 14);
		contentPane.add(lblDeckNumber_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(123, 209, 127, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(123, 234, 127, 20);
		contentPane.add(textField_9);
		
		JLabel lblAuthorName = new JLabel("Author name1");
		lblAuthorName.setFont(new Font("Arial", Font.BOLD, 12));
		lblAuthorName.setBounds(10, 261, 103, 14);
		contentPane.add(lblAuthorName);
		
		JLabel lblAuthorName_1 = new JLabel("Author Name 2");
		lblAuthorName_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblAuthorName_1.setBounds(10, 286, 103, 14);
		contentPane.add(lblAuthorName_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(123, 259, 127, 20);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(123, 284, 127, 20);
		contentPane.add(textField_11);
		
	}
}
