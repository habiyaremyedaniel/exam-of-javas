package othercode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ReadandSavedataroom {
public static void main(String[] args) {
		
				        // JDBC URL, username, and password of MySQL server
				        String url = "jdbc:mysql://localhost/hostel_management_system";
				        String user = "root";
				        String password = "";

				        // SQL query to retrieve data
				        String sql = "SELECT room_number,capacity, type,rent, FROM room";

				        try (
				            // Establish the 
				            Connection co = DriverManager.getConnection(url, user, password);

				            // Create a prepared statement
				            PreparedStatement stm = co.prepareStatement(sql);
				            
				            // Execute the query and get the result set
				            ResultSet resultSet = stm.executeQuery();
				        ) {
				            // Get the number of rows in the result set
				            resultSet.last();
				            int rowCount = resultSet.getRow();
				            resultSet.beforeFirst();

				            // Define a 2D array of objects
				            Object[][] data = new Object[rowCount][5];

				            // Process the result set and save data into the array
				            int row = 0;
				            while (resultSet.next()) {
				                String column1Value = resultSet.getString("room_number");
				                String column2Value = resultSet.getString("capacity");
				                String column3Value = resultSet.getString("type");
				                String column4Value = resultSet.getString("rent");
				                String column5Value = resultSet.getString("facilities");
				              // Save data into the 2D array
				                data[row][0] = column1Value;
				                data[row][1] = column2Value;
				                data[row][2] = column3Value;
				                data[row][3] = column4Value;
				                data[row][4] = column5Value;
				              row++;
				            }

				            // Print or use the data from the 2D array
				            for (Object[] rowArray : data) {
				                for (Object value : rowArray) {
				                    System.out.print(value + " ");
				                }
				                System.out.println();
				            }

				        } catch (SQLException e) {
				            e.printStackTrace();
				        }
				    }}


