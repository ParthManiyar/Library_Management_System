import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDao {
public static int save(String isbn_no,String title,int edition,int publisher_id,int no_pages,int no_of_copies,float price,int supplier_id, String rack ,String deck){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("call add_book(?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1,isbn_no);
		ps.setString(2,title);
		ps.setInt(3,edition);
		ps.setInt(4,publisher_id);
		ps.setInt(5,no_pages);
		ps.setInt(6,no_of_copies);
		ps.setFloat(7,price);
		ps.setInt(8,supplier_id);
		ps.setString(9,rack);
		ps.setString(10,deck);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int remove(int id,int qty) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
	int status=0;
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("call remove_book(?,?)");
		ps.setInt(1,id);
		ps.setInt(2,qty);
		
		status=ps.executeUpdate();
		con.close();

	return status;
}



}