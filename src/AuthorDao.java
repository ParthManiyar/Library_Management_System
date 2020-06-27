import java.sql.Connection;
import java.sql.PreparedStatement;

public class AuthorDao {
public static int save(String name1,String name2){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("call add_author(?)");
		ps.setString(1,name1);
		PreparedStatement ps1=con.prepareStatement("call add_author(?)");
		ps1.setString(1,name2);
		PreparedStatement p2=con.prepareStatement("call add_bookauthor((select max(book_id) from book),(select author_id from author where name=?))");
		p2.setString(1,name1);
		PreparedStatement p3=con.prepareStatement("call add_bookauthor((select max(book_id) from book),(select author_id from author where name=?))");
		p3.setString(1,name2);
		status=ps.executeUpdate();
		status=ps1.executeUpdate();
		status=p2.executeUpdate();
		status=p3.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}