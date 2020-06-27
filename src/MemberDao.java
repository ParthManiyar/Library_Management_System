import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDao {
public static int save(String name_1,String name_2,String type){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("call add_member(?,?,?)");
		ps.setString(1,name_1);
		ps.setString(2,name_2);
		ps.setString(3,type);
		
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int remove(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
	int status=0;
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("call remove_member(?)");
		ps.setInt(1,id);
		status=ps.executeUpdate();
		con.close();

	return status;
}



}