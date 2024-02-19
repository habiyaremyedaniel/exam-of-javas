package othercode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Selectdataroom {

	public static void main(String[] args) {
	
				        // JDBC URL, username, and password of MySQL server
				        String url = "jdbc:mysql://localhost/hostel_management_system";
				        String user = "root";
				        String password = "";

				        // SQL query to select all columns from student where id = ?
				        String sql = "SELECT * FROM room WHERE room_id = ?";

				        try (
				            // Establish the connection
				            Connection connection = DriverManager.getConnection(url, user, password);

				            // Create a prepared statement
				            PreparedStatement preparedStatement = connection.prepareStatement(sql);
				        ) {
				            // Set the value for the parameterized query
				            int room_id = 1; // Replace with the desired student id
				            preparedStatement.setInt(1, room_id);

				            // Execute the query and get the result set
				            ResultSet resultSet = preparedStatement.executeQuery();

				            // Process the result set
				            while (resultSet.next()) {
				                int id = resultSet.getInt("room_id");
				                String rn = resultSet.getString("room_number");
				                String ca= resultSet.getString("capacity");
				                String ty= resultSet.getString("type");
				                String re= resultSet.getString("rent");
				                String fa= resultSet.getString("facilities");
				                 // Print or use the retrieved data
				                System.out.println("room_id: " + id);
				                System.out.println("room_number " + rn);
				                System.out.println("capacity: " + ca);
				                System.out.println("type: " + ty);
				                System.out.println("rent: " + re);
				                System.out.println("facilities: " + fa);
				             
				            }

				        } catch (SQLException e) {
				            e.printStackTrace();
				        }
				    }}


