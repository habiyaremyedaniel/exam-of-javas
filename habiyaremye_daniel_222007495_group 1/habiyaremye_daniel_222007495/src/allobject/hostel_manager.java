package allobject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class hostel_manager {
private int hostel_manager_id;
	private String name;
	private String email;
	private String password;
	private String phone_number;
	private String role;
	 private String bank_id;
	
public hostel_manager() {}
	public hostel_manager(int hostel_manager_id, String name , String email, String password, String phone_number,
			String role,String  bank_id) {
		super();
		this. hostel_manager_id =  hostel_manager_id;
		this.name = name;
		this.email= email;
		this.password = password;
		this.phone_number = phone_number;
		this.role=role;
		this.bank_id=bank_id;
	}

	
	public hostel_manager( String name, String email, String password, String phone_number,String role,String bank_id,int room_id) {
		this.name = name;
		this.password =email ;
		this.password = password;
		this.phone_number=phone_number;
		this.role=role;
		this.bank_id=bank_id;

	}
	public int getId() {
		return hostel_manager_id ;
	}
	public void setId(int hostel_manager_id) {
	this.hostel_manager_id = hostel_manager_id;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getname() {
		return name;
	}
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getpassword() {
		return password;
	}

		public void setphone_number(String phone_number) {
			this.phone_number = phone_number;
	}
	public String getphone_number() {
		return phone_number;	
	}
	
	
	public String  getrole() {
		return role;
	}
	
	public void setrole(String role) {
		this.role = role;
	}

	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id1(String bank_id) {
		this.bank_id = bank_id;
	}

	
	public void makeconnection() {
	}
	public void insertData(String n,String e_l, String pa_rd,String pho_er,String ro_le,Integer bid) {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
	    String user = "222007495";
	    String password = "222007495";

	    // SQL query to insert data
 String sql ="INSERT INTO hostel_manager(name,email,password,phone_number,role,bank_id) VALUES (?,?, ?, ?, ?,?)";
	
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
				   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, n);
	        preparedStatement.setString(2, e_l);
	        preparedStatement.setString(3, pa_rd);
	        preparedStatement.setString(4, pho_er);
	        preparedStatement.setString(5, ro_le);
	        preparedStatement.setInt(6, bid);
	       
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
	public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
	    String user = "222007495";
	    String password = "222007495";

	    // SQL query to insert data
	    String sql = "INSERT INTO hostel_manager (name,email,password,phone_number,role,bank_id) VALUES (?, ?, ?,?,?,?)";

	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.name);
	        preparedStatement.setString(2, this.email);
	        preparedStatement.setString(3, this.password);
	        preparedStatement.setString(4, this.phone_number);
	        preparedStatement.setString(5, (String) this.role);
	        preparedStatement.setString(6, this.bank_id);
	        
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

	public void readwithID(int inputid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/bithuye";
	    String user = "222007495";
	    String password = "222007495";

	    // SQL query to select all columns from hostel_manager where id = ?
	    String sql = "SELECT * FROM hostel_manager WHERE id = ?";

	    try (
	        // Establish the connection
	        Connection connection = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    ) {
	        // Set the value for the parameterized query
	        //int hostel_managerId = 1; // Readace with the desired hostel_manager id
	        //if()
	    	preparedStatement.setInt(1, inputid);

	        // Execute the query and get the result set
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Process the result set
	        while (resultSet.next()) {
	        	this.setId(resultSet.getInt("hostel_manager_id"));
	           this.setname(resultSet.getString("name"));
	           this.setpassword(resultSet.getString("email"));
	           this.setpassword(resultSet.getString("password"));
	            this.setphone_number(resultSet.getString("phone_number"));
	            this.setrole((String) resultSet.getString("role"));
	            this.setBank_id1(resultSet.getString("bank_id"));
	            
	           
	            }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void update(int inputhostel_managerid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
	    String user = "222007495";
	    String password = "222007495";

	    // SQL query to update data
	    String sql = "UPDATE hostel_managers SET  name= ?, password = ?,password = ?, phone_number = ?, gender=?,room_id=?,course=?,match_id=? WHERE hostel_manager_id = ?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement ad = co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  ad.setString(1, this.getname());
	        ad.setString(2, this.getEmail());
	       ad.setString(3, this.getpassword()); // Assuming there is a column named 'id' for the WHERE clause
	        ad.setString(4, this.getphone_number());
	        ad.setString(5, (String) this.getrole());
	        ad.setString(6, this.getBank_id());
	        ad.setInt(8, inputhostel_managerid);
	        // Execute the update
	        int rowsAffected = ad.executeUpdate();

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
	    String sql = "DELETE FROM hostel_manager WHERE id = ?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement ad = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        ad.setInt(1, inputid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = ad.executeUpdate();

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
	public void setBank_id(String text) {
		// TODO Auto-generated method stub
		
	}
	}


