package othercode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Insertdataofroom {
	public static void main(String[] args) {
	        // JDBC URL, username, and password of MySQL server
	        String host = "jdbc:mysql://localhost/hostel_management_system";
	        String user = "root";
	        String password = "";

	        // SQL query to insert data
	        String sql = "INSERT INTO room ( room_number,capacity, type,rent,facilities,country,match_id) VALUES (?, ?, ?, ?, ?)";

	        try (
	            // Establish the connection
	            Connection con = DriverManager.getConnection(host, user, password);

	            // Create a prepared statement
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	        ) {
	            // Set the values for the prepared statement
	            preparedStatement.setString(1, " room_number");
	            preparedStatement.setString(2, "capacity");
	            preparedStatement.setString(3, " type");
	            preparedStatement.setString(4, "rent");
	            preparedStatement.setString(5, "facilities");
	            // Execute the query
	            int rowsAffected = preparedStatement.executeUpdate();

	            // Check the result
	            if (rowsAffected > 0) {
	                System.out.println("Data inserted successfully!");
	            } else {
	                System.out.println("Failed to insert data.");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
