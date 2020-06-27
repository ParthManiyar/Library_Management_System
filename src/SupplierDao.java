
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SupplierDao {
public static int save(String gst_no,String name,String contact,String email) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	int status=0;
	
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("call add_supplier(?,?,?,?)");
		ps.setString(1,gst_no);
		ps.setString(2,name);
		ps.setString(3,contact);
		ps.setString(4,email);
		
		status=ps.executeUpdate();
		con.close();
	return status;
}
}