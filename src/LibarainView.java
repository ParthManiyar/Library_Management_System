import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LibarainView extends JFrame {

	private JPanel contentPane;
	static LibarainView frame1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 = new LibarainView();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public LibarainView() {
		setTitle("LibarainView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_1 = new JButton("Add Book");
		btn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BookManager.main(new String[] {});
			}
		});
		btn_1.setFont(new Font("Arial", Font.BOLD, 12));
		btn_1.setBounds(10, 27, 132, 23);
		contentPane.add(btn_1);
		
		JButton btn_2 = new JButton("Add Member");
		btn_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MemberManager.main(new String[] {});
			}
		});
		btn_2.setFont(new Font("Arial", Font.BOLD, 12));
		btn_2.setBounds(152, 27, 132, 23);
		contentPane.add(btn_2);
		
		JButton btn_3 = new JButton("Add Supplier");
		btn_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SupplyManager.main(new String[] {});
			}
		});
		btn_3.setFont(new Font("Arial", Font.BOLD, 12));
		btn_3.setBounds(292, 27, 132, 23);
		contentPane.add(btn_3);
		
		JButton btn_4 = new JButton("Issue Book");
		btn_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				IssueBook.main(new String[] {});
			}
		});
		btn_4.setFont(new Font("Arial", Font.BOLD, 12));
		btn_4.setBounds(10, 197, 132, 23);
		contentPane.add(btn_4);
		
		JButton btn_5 = new JButton("Return Book");
		btn_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ReturnBook.main(new String[] {});
			}
		});
		btn_5.setFont(new Font("Arial", Font.BOLD, 12));
		btn_5.setBounds(10, 227, 132, 23);
		contentPane.add(btn_5);
		
		JButton btnAddPeriodical = new JButton("Add Periodical");
		btnAddPeriodical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddPeriodical.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPeriodical.main(new String[]{});
			}
		});
		btnAddPeriodical.setBounds(601, 28, 132, 23);
		contentPane.add(btnAddPeriodical);
		
		JButton btnRemovePeriodical = new JButton("Remove periodical");
		btnRemovePeriodical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRemovePeriodical.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemovePeriodical.main(new String[]{});
			}
		});
		btnRemovePeriodical.setBounds(601, 129, 147, 23);
		contentPane.add(btnRemovePeriodical);
		
		JButton btnIssuePeriodical = new JButton("Issue Periodical");
		btnIssuePeriodical.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IssuePeriodical.main(new String[]{});
			}
		});
		btnIssuePeriodical.setBounds(601, 163, 132, 23);
		contentPane.add(btnIssuePeriodical);
		
		JButton btnReturnPeriodical = new JButton("Return Periodical");
		btnReturnPeriodical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReturnPeriodical.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReturnPeriodical.main(new String[]{});
			}
		});
		btnReturnPeriodical.setBounds(601, 198, 132, 23);
		contentPane.add(btnReturnPeriodical);
		
		JButton btnSearchPeriodical = new JButton("Search periodical");
		btnSearchPeriodical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearchPeriodical.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchPeriodical.main(new String[]{});
			}
		});
		btnSearchPeriodical.setBounds(601, 62, 142, 23);
		contentPane.add(btnSearchPeriodical);
		
		JButton btnAddMember = new JButton("Remove Book");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemoveBook.main(new String[]{});
			}
		});
		btnAddMember.setBounds(10, 129, 132, 23);
		contentPane.add(btnAddMember);
		
		JButton btnRemoveMember = new JButton("Remove Member");
		btnRemoveMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRemoveMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMember.main(new String[]{});
			}
		});
		btnRemoveMember.setBounds(152, 129, 132, 23);
		contentPane.add(btnRemoveMember);
		
		JButton btnSearchMember = new JButton("Search Member");
		btnSearchMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearchMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchMember.main(new String[]{});
			}
		});
		btnSearchMember.setBounds(152, 62, 132, 23);
		contentPane.add(btnSearchMember);
		
		JButton btnAddSupplier = new JButton("Search Book");
		btnAddSupplier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Search_Book.main(new String[]{});
			}
		});
		btnAddSupplier.setBounds(10, 61, 132, 23);
		contentPane.add(btnAddSupplier);
		
		JButton btnAddNewspaper = new JButton("Add Newspaper");
		btnAddNewspaper.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddNewspaper.main(new String[]{});
			}
		});
		btnAddNewspaper.setBounds(434, 28, 153, 23);
		contentPane.add(btnAddNewspaper);
		
		JButton btnBookFinePayment = new JButton("Book Fine Payment");
		btnBookFinePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBookFinePayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BookFinePayment.main(new String[]{});
			}
		});
		btnBookFinePayment.setBounds(10, 163, 142, 23);
		contentPane.add(btnBookFinePayment);
		
		JButton btnPeriodicalFinePayment = new JButton("Periodical Fine Payment");
		btnPeriodicalFinePayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PeriodicalFineManagement.main(new String[]{});
			}
		});
		btnPeriodicalFinePayment.setBounds(601, 228, 181, 23);
		contentPane.add(btnPeriodicalFinePayment);
		
		JButton btnViewBooks = new JButton("View Books");
		btnViewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnViewBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewBooks.main(new String[]{});
			}
		});
		btnViewBooks.setBounds(10, 95, 132, 23);
		contentPane.add(btnViewBooks);
		
		JButton btnNewButton = new JButton("Search Supplier");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SerachSupplier.main(new String[] {});
			}
		});
		
		btnNewButton.setBounds(292, 61, 132, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search Newspaper");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SearchNewspaper.main(new String[] {});
			}
		});
		btnNewButton_1.setBounds(434, 62, 153, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnViewPeriodical = new JButton("View Periodical");
		btnViewPeriodical.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewPeriodical.main(new String[] {});
			}
		});
		btnViewPeriodical.setBounds(601, 95, 153, 23);
		contentPane.add(btnViewPeriodical);
		
		JButton btnViewSupplier = new JButton("View Supplier");
		btnViewSupplier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewSupplier.main(new String[] {});
			}
		});
		btnViewSupplier.setBounds(292, 96, 147, 23);
		contentPane.add(btnViewSupplier);
		
		JButton btnViewNewspaper = new JButton("View Newspaper");
		btnViewNewspaper.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewNewspaper.main(new String[] {});
			}
		});
		btnViewNewspaper.setBounds(444, 96, 147, 23);
		contentPane.add(btnViewNewspaper);
		
		JButton btnViewMember = new JButton("View Member");
		btnViewMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewMember.main(new String[] {});
			}
		});
		btnViewMember.setBounds(152, 96, 132, 23);
		contentPane.add(btnViewMember);
		
		JButton btnQurey = new JButton("Qurey");
		btnQurey.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Qurey.main(new String[] {});
			}
		});
		btnQurey.setBounds(220, 208, 89, 23);
		contentPane.add(btnQurey);
	}
}
