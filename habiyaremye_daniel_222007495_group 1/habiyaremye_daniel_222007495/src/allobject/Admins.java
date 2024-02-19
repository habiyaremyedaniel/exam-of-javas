 package allobject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Admins {
	    private int admin_id;
	    private String name;
	    private String email;
	    private String password;
	    private String phone_number;
	    private String role;
	    private String bank_id;
 
	    public Admins() {}

	    // Constructor with necessary attributes
	    public Admins(String name, String email, String password, String phone_number, String role, String bank_id) {
	        this.name = name;
	        this.email = email;
	        this.password = password;
	        this.phone_number = phone_number;
	        this.role = role;
	        this.bank_id = bank_id;
	    }
	    

	    // Getters and Setters

	    public int getAdmin_id() {
			return admin_id;
		}

		public void setAdmin_id(int admin_id) {
			this.admin_id = admin_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhone_number() {
			return phone_number;
		}

		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getBank_id() {
			return bank_id;
		}

		public void setBank_id(String bank_id) {
			this.bank_id = bank_id;
		}

		public void makeConnection() {
	        // Implement this method based on your database setup
	    }

	    public void insertData() {
	        String host = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
	        String user = "222007495";
	        String password = "222007495";

	        String sql = "INSERT INTO admin (name, email, password, phone_number, role, bank_id) VALUES (?, ?, ?, ?, ?, ?)";

	        try (
	                Connection con = DriverManager.getConnection(host, user, password);
	                PreparedStatement preparedStatement = con.prepareStatement(sql);
	        ) {
	            preparedStatement.setString(1, this.name);
	            preparedStatement.setString(2, this.email);
	            preparedStatement.setString(3, this.password);
	            preparedStatement.setString(4, this.phone_number);
	            preparedStatement.setString(5, this.role);
	            preparedStatement.setString(6, this.bank_id);

	            int rowsAffected = preparedStatement.executeUpdate();

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

	    public void readWithID(int inputId) {
	        String host = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
	        String user = "222007495";
	        String password = "222007495";

	        String sql = "SELECT * FROM admin WHERE admin_id = ?";

	        try (
	                Connection connection = DriverManager.getConnection(host, user, password);
	                PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        ) {
	            preparedStatement.setInt(1, inputId);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                this.admin_id = resultSet.getInt("admin_id");
	                this.name = resultSet.getString("name");
	                this.email = resultSet.getString("email");
	                this.password = resultSet.getString("password");
	                this.phone_number = resultSet.getString("phone_number");
	                this.role = resultSet.getString("role");
	                this.bank_id = resultSet.getString("bank_id");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void update(int inputAdminId) {
	        String host = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
	        String user = "222007495";
	        String password = "222007495";

	        String sql = "UPDATE admin SET name = ?, email = ?, password = ?, phone_number = ?, role = ?, bank_id = ? WHERE admin_id = ?";

	        try (
	                Connection connection = DriverManager.getConnection(host, user, password);
	                PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        ) {
	            preparedStatement.setString(1, this.name);
	            preparedStatement.setString(2, this.email);
	            preparedStatement.setString(3, this.password);
	            preparedStatement.setString(4, this.phone_number);
	            preparedStatement.setString(5, this.role);
	            preparedStatement.setString(6, this.bank_id);
	            preparedStatement.setInt(7, inputAdminId);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Data updated successfully!");
	            } else {
	                System.out.println("Failed to update data. No matching record found.");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void delete(int inputId) {
	        String host = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
	        String user = "222007495";
	        String password = "222007495";

	        String sql = "DELETE FROM admin WHERE admin_id = ?";

	        try (
	                Connection connection = DriverManager.getConnection(host, user, password);
	                PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        ) {
	            preparedStatement.setInt(1, inputId);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Data deleted successfully!");
	            } else {
	                System.out.println("Failed to delete data. No matching record found.");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	
			public void login() {
			       
		        if (isValidUser(email, password)) {
		            System.out.println("Login successful");
		        } else {
		            System.out.println("Invalid username or password");
		        }
		    }
		    
		    private boolean isValidUser(String email, String password) {
		        // TODO: Implement your user validation logic here
		        // This could involve checking credentials against a database, file, or other storage
		        
		        // Example validation (replace with your actual logic):
		        return email.equals("admin") && password.equals("password");
		    }
		

		
	
		}
	

