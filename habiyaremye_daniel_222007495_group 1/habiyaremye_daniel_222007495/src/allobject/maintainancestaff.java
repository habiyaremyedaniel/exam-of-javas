package allobject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class maintainancestaff  {
	private int StaffID;
	private String Name;
	private String  ContactNumber;
	private String Specialization;
	private String WorkSchedule;
	private String DateOfEmployment;
	private String EmergencyContact ;
	public maintainancestaff() {}
	public maintainancestaff(int StaffID, String Name , String  ContactNumber, String Specialization, String WorkSchedule ,String DateOfEmployment ,String EmergencyContact) {
		this. StaffID =  StaffID;
		this.Name = Name;
		this. ContactNumber =  ContactNumber;
		this.Specialization = Specialization;
		this.WorkSchedule = WorkSchedule;
		this.DateOfEmployment=DateOfEmployment;
		this.EmergencyContact=EmergencyContact;
		
	}
	public maintainancestaff( String Name, String ContactNumber, String Specialization,String WorkSchedule ,String DateOfEmployment,String EmergencyContact) {
		this.Name = Name;
		this. ContactNumber = ContactNumber;
		this.Specialization = Specialization;
		this.WorkSchedule=WorkSchedule ;
		this.DateOfEmployment=DateOfEmployment;
		this.EmergencyContact=EmergencyContact;
		}
	
	public int getStaffID() {
		return StaffID;
	}
	public void setStaffID(int staffID) {
		StaffID = staffID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	public String getWorkSchedule() {
		return WorkSchedule;
	}
	public void setWorkSchedule(String workSchedule) {
		WorkSchedule = workSchedule;
	}
	public String getDateOfEmployment() {
		return DateOfEmployment;
	}
	public void setDateOfEmployment(String dateOfEmployment) {
		DateOfEmployment = dateOfEmployment;
	}
	public String getEmergencyContact() {
		return EmergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		EmergencyContact = emergencyContact;
	}
	public void makeconnection() {
	}
	public void insertData1() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
	    String user = "222007495";
	    String password = "222007495";

	    // SQL query to insert data
	    String sql = "INSERT INTO maintenancestaff (Name, ContactNumber,Specialization,WorkSchedule,DateOfEmployment,EmergencyContact) VALUES ( ?,?, ?, ?,?,?)";

	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.Name);
	        preparedStatement.setString(2, this. ContactNumber);
	        preparedStatement.setString(3, this.Specialization);
	        preparedStatement.setString(4, this.WorkSchedule);
	        preparedStatement.setString(5, this.DateOfEmployment);
	        preparedStatement.setString(6, this.EmergencyContact);
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data inserted successfully!");
	            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	}

	public void readWithID(int inputID) {
	    // JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
	    String user = "222007495";
	    String password = "222007495";

	    // SQL query to select all columns from maintenancestaff where StaffID = ?
	    String sql = "SELECT * FROM maintenancestaff WHERE StaffID = ?";

	    try (
	        // Establish the connection
	        Connection connection = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    ) {
	        // Set the value for the parameterized query
	        preparedStatement.setInt(1, inputID);

	        // Execute the query and get the result set
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Process the result set
	        while (resultSet.next()) {
	            this.setStaffID(resultSet.getInt("StaffID"));
	            this.setName(resultSet.getString("name"));
	            this.setContactNumber(resultSet.getString("ContactNumber"));
	            this.setSpecialization(resultSet.getString("Specialization"));
	            this.setWorkSchedule(resultSet.getString("WorkSchedule"));
	            this.setEmergencyContact(resultSet.getString("EmergencyContact"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void update1(int inputmaintenancestaffid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
	    String user = "222007495";
	    String password = "222007495";

	    // SQL query to update data
	    String sql = "UPDATE maintenancestaff SET  Name= ?,  ContactNumber = ?,Specialization = ?, WorkSchedule = ?,DateOfEmployment=? WHERE StaffID = ?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  pl.setString(1, this.getName());
	        pl.setString(2, this.getContactNumber());
	       pl.setString(3, this.getSpecialization()); // Assuming there is a column named 'id' for the WHERE clause
	        pl.setString(4, this.getContactNumber());
	        pl.setString(5, this.getDateOfEmployment());
	        pl.setString(4, this.getEmergencyContact());
	        pl.setInt(6, inputmaintenancestaffid);
	        // Execute the update
	        int rowsAffected = pl.executeUpdate();

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
	    String sql = "DELETE FROM maintenancestaff WHERE StaffID = ?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}} 
	
	

