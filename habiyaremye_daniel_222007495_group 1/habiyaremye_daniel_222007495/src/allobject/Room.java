package allobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Room {
    private int Room_id;
    private String room_number;
    private String capacity;
    private String type;
    private String rent;
    private Object facilities;

    public Room() {}

    public Room(int id, String room_number, String capacity, String type, String rent, Object facilities) {
        this.Room_id = id;
        this.room_number = room_number;
        this.capacity = capacity;
        this.type = type;
        this.rent = rent;
        this.facilities = facilities;
    }

    public Room(String room_number, String capacity, String type, String rent, Object facilities) {
        this.room_number = room_number;
        this.capacity = capacity;
        this.type = type;
        this.rent = rent;
        this.facilities = facilities;
    }

    public int getId() {
        return Room_id;
    }

    public void setId(int Room_id) {
        this.Room_id = Room_id;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public void setFacilities(Object facilities) {
        this.facilities = facilities;
    }

    public Object getFacilities() {
        return facilities;
    }

    public void makeConnection() {
        // Implement your connection logic here if needed
    }

    public void insertData() {
        // JDBC URL, username, and password of MySQL server
        String host = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
        String user = "222007495";
        String password = "222007495";

        // SQL query to insert data
        String sql = "INSERT INTO Room (room_number, capacity, type, rent, facilities) VALUES (?, ?, ?, ?, ?)";

        try (
            // Establish the connection
            Connection con = DriverManager.getConnection(host, user, password);

            // Create a prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            // Set the values for the prepared statement
            preparedStatement.setString(1, this.room_number);
            preparedStatement.setString(2, this.capacity);
            preparedStatement.setString(3, this.type);
            preparedStatement.setString(4, this.rent);
            preparedStatement.setObject(5, this.facilities); // Adjust this line based on the actual type of facilities

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Check the result
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
                JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to insert data.");
                JOptionPane.showMessageDialog(null, "Failed to insert data.!", "After insert", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readWithID(int inputid) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
        String user = "222007495";
        String password = "222007495";

        // SQL query to select all columns from room where id = ?
        String sql = "SELECT * FROM room WHERE Room_id = ?";

        try (
            // Establish the connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            // Set the value for the parameterized query
            preparedStatement.setInt(1, inputid);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                this.setId(resultSet.getInt("Room_id"));
                this.setRoom_number(resultSet.getString("room_number"));
                this.setCapacity(resultSet.getString("capacity"));
                this.setType(resultSet.getString("type"));
                this.setRent(resultSet.getString("rent"));
                this.setFacilities(resultSet.getObject("facilities"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int inputroomid) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
        String user = "222007495";
        String password = "222007495";

        // SQL query to update data
        String sql = "UPDATE Room SET room_number = ?, capacity = ?, type = ?, rent = ?, facilities = ? WHERE Room_id = ?";

        try (
            // Establish the connection
            Connection co = DriverManager.getConnection(url, user, password);

            // Create a prepared statement
            PreparedStatement rm = co.prepareStatement(sql);
        ) {
            // Set the new values for the update
            rm.setString(1, this.getRoom_number());
            rm.setString(2, this.getCapacity());
            rm.setString(3, this.getType());
            rm.setString(4, this.getRent());
            rm.setObject(5, this.getFacilities());
            rm.setInt(6, inputroomid);

            // Execute the update
            int rowsAffected = rm.executeUpdate();

            // Check the result
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("Failed to update data. No matching record found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int inputid) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
        String user = "222007495";
        String password = "222007495";

        // SQL query to delete data
        String sql = "DELETE FROM room WHERE Room_id = ?";

        try (
            // Establish the connection
            Connection co = DriverManager.getConnection(url, user, password);

            // Create a prepared statement
            PreparedStatement rm = co.prepareStatement(sql);
        ) {
            // Set the value for the WHERE clause
            rm.setInt(1, inputid);

            // Execute the delete
            int rowsAffected = rm.executeUpdate();

            // Check the result
            if (rowsAffected > 0) {
                System.out.println("Data deleted successfully!");
            } else {
                System.out.println("Failed to delete data. No matching record found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
