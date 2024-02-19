package othercode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Updatedataroom {
public static void main(String[] args) {
		 // JDBC URL, username, and password of MySQL server
				        String url = "jdbc:mysql://localhost/hostel_management_system";
				        String user = "root";
				        String password = "";
                         // SQL query to update data
				        String sql = "UPDATE student SET  room_number= ?, capacity= ?,type= ?,  rent = ?,  facilities=? WHERE room_id = ?";

				        try (
				            // Establish the con
				            Connection con = DriverManager.getConnection(url, user, password);

				            // Create a prepared statement
				            PreparedStatement stm = con.prepareStatement(sql);
				        ) {
				            // Set the new values for the update
				            stm.setInt(1, 101);
				            stm.setInt(2, 9);
				            stm.setString(3, "Single"); // Assuming there is a column named 'id' for the WHERE clause
				            stm.setInt(4, 1200);
				            stm.setString(5, "wifi");
				            stm.setInt(6, 2);
				            // Execute the update
				            int rowsAffected = stm.executeUpdate();

				            // Check the result
				            if (rowsAffected > 0) {
				                System.out.println("Data updated successfully!");
				            } else {
				                System.out.println("Failed to update data. No matching record found.");
				            }

				        } catch (SQLException e) {
				            e.printStackTrace();
				        }
				    }}


