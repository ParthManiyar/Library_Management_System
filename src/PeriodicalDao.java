import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class PeriodicalDao {
public static int save(String title,String type,int copies,String date,int supplier_id){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("call add_periodical(?,?,?,?,?)");
		ps.setString(1,title);
		ps.setString(2,type);
		ps.setInt(3,copies);
		ps.setString(4,date);
		ps.setInt(5,supplier_id);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int remove(int id,int qty) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
	int status=0;
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("call remove_perio(?,?)");
		ps.setInt(1,id);
		ps.setInt(2,qty);
		status=ps.executeUpdate();
		con.close();

	return status;
}



}