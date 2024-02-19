
package testconnections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Connectionsadmin  {
	public static void main(String[] args) {
		Connection co=null;
		PreparedStatement stm=null;
		ResultSet rs=null;
		String sql="SELECT * FROM admin ";
		String host="jdbc:mysql://localhost/hostel_management_system";
		String user="root";
		String pass="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			co=DriverManager.getConnection(host,user,pass);
			stm=co.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()) {
				String id =rs.getString("admin_id");
				String n=rs.getString(" name");
				String em=rs.getString("email ");
				String pa=rs.getString("password ");
				String ph=rs.getString("phone_number ");
				String ro=rs.getString(" role  ");
				String bi=rs.getString("  bank_id  ");
				System.out.println(id+"\t"+n+"\t"+em+"\t"+pa+"\t"+ph+"\t"+ro+"\t"+bi+"\t");
			}
		}catch (ClassNotFoundException e) {
			System.out.println("An error occurred while loading the JDBC driver");
		} catch (SQLException e) {
			System.out.println("There was an error accessing the database.");
		}finally {
			try {
				if (co != null) {
					co.close();
				}
			} catch (SQLException e) {
				System.out.println("There was an error accessing the database.");
			}
		}
		

	}

}
