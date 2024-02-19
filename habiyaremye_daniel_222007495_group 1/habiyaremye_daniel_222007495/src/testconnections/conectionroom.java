package testconnections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class conectionroom {
	public static void main(String[] args) {
		Connection co=null;
		PreparedStatement stm=null;
		ResultSet rs=null;
		String sql="SELECT * FROM room ";
		String host="jdbc:mysql://localhost/hostel_management_system";
		String user="root";
		String pass="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			co=DriverManager.getConnection(host,user,pass);
			stm=co.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()) {
				String id =rs.getString("room_id");
				String rn=rs.getString(" room_number");
				String ca=rs.getString("capacity");
				String ty=rs.getString("type");
				String re=rs.getString("rent");
				String fa=rs.getString("facilities");
				
				System.out.println(id+"\t"+rn+"\t"+ca+"\t"+ty+"\t"+re+"\t"+fa+"\t");
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
