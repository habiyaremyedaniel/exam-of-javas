package testconnections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class TestconactionofStudent {
public static void main(String[] args) {
			Connection co=null;
			PreparedStatement stm=null;
			ResultSet rs=null;
			String sql="SELECT * FROM student ";
			String host="jdbc:mysql://localhost/hostel_management_system";
			String user="root";
			String pass="";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				co=DriverManager.getConnection(host,user,pass);
				stm=co.prepareStatement(sql);
				rs=stm.executeQuery();
				while(rs.next()) {
					String id =rs.getString("student_id");
					String n=rs.getString(" name");
					String pa=rs.getString("password");
					String cont=rs.getString("phone_number");
					String ge=rs.getString("gender");
					String dob=rs.getString("date_of_birth");
					String cou=rs.getString(" course");
					String yas=rs.getString("year_of_study");
					String ron=rs.getString("room_number");
					String bai=rs.getString("bank_id");
					String roi=rs.getString("room_id");
					System.out.println(id+"\t"+n+"\t"+pa+"\t"+cont+"\t"+ge+"\t"+dob+"\t"+cou+"\t"+yas+"\t"+ron+"\t"+bai+"\t"+roi+"\t");
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
			

		}}

	
