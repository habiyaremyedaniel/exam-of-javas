



package testconnections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Connectionmaintenancestaff {
	public static void main(String[] args) {
		Connection co=null;
		PreparedStatement stm=null;
		ResultSet rs=null;
		String sql="SELECT * FROM maintenancestaff ";
		String host="jdbc:mysql://localhost/hostel_management_system";
		String user="root";
		String pass="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			co=DriverManager.getConnection(host,user,pass);
			stm=co.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()) {
				String id =rs.getString("StaffID ");
				String n=rs.getString("  Name ");
				String con=rs.getString("ContactNumber  ");
				String spe=rs.getString("Specialization ");
				String wo=rs.getString("WorkSchedule  ");
				String doe=rs.getString(" DateOfEmployment   ");
				String emc=rs.getString(" EmergencyContact  ");
				System.out.println(id+"\t"+n+"\t"+con+"\t"+spe+"\t"+wo+"\t"+doe+"\t"+emc+"\t");
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
