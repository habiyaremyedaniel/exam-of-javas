package allobject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Banks {
	    private int bank_id;
	    private String name;
	    private String address;
	    private String contact_number;
	    private String account_number;

	    public Banks() {}

	    // Constructor with necessary attributes
	    public Banks(int bank_id, String name, String address, String contact_number, String account_number) {
	        this.bank_id = bank_id;
	        this.name = name;
	        this.address = address;
	        this.contact_number = contact_number;
	        this.account_number = account_number;
	    }

	    // Constructor without ID (assuming auto-incremented in the database)
	    public Banks(String name, String address, String contact_number, String account_number) {
	        this.name = name;
	        this.address = address;
	        this.contact_number = contact_number;
	        this.account_number = account_number;
	    }

	    // Getters and Setters

	    public int getBank_id() {
			return bank_id;
		}

		public void setBank_id(int bank_id) {
			this.bank_id = bank_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getContact_number() {
			return contact_number;
		}

		public void setContact_number(String contact_number) {
			this.contact_number = contact_number;
		}

	
		public String getAccount_number() {
			return account_number;
		}

		public void setAccount_number(String account_number) {
			this.account_number = account_number;
		}

		public void makeConnection() {
	        // Implement this method based on your database setup
	    }

	    public void insertData(String name, String address, String contact_number, String account_number) {
	        String host = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
	        String user = "222007495";
	        String password = "222007495";

	        String sql = "INSERT INTO bank (name, address, contact_number, account_number) VALUES (?, ?, ?, ?)";

	        try (
	                Connection con = DriverManager.getConnection(host, user, password);
	                PreparedStatement preparedStatement = con.prepareStatement(sql);
	        ) {
	            preparedStatement.setString(1, name);
	            preparedStatement.setString(2, address);
	            preparedStatement.setString(3, contact_number);
	            preparedStatement.setString(4, account_number);

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

	    public void insertData() {
	        insertData(this.name, this.address, this.contact_number, this.account_number);
	    }

	    public void readWithID(int inputId) {
	        String host = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
	        String user = "222007495";
	        String password = "222007495";

	        String sql = "SELECT * FROM bank WHERE bank_id = ?";

	        try (
	                Connection connection = DriverManager.getConnection(host, user, password);
	                PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        ) {
	            preparedStatement.setInt(1, inputId);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                this.bank_id = resultSet.getInt("bank_id");
	                this.name = resultSet.getString("name");
	                this.address = resultSet.getString("address");
	                this.contact_number = resultSet.getString("contact_number");
	                this.account_number = resultSet.getString("account_number");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void update(int inputBankId) {
	        String host = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
	        String user = "222007495";
	        String password = "222007495";

	        String sql = "UPDATE bank SET name = ?, address = ?, contact_number = ?, account_number = ? WHERE bank_id = ?";

	        try (
	                Connection connection = DriverManager.getConnection(host, user, password);
	                PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        ) {
	            preparedStatement.setString(1, this.name);
	            preparedStatement.setString(2, this.address);
	            preparedStatement.setString(3, this.contact_number);
	            preparedStatement.setString(4, this.account_number);
	            preparedStatement.setInt(5, inputBankId);

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

	        String sql = "DELETE FROM bank WHERE bank_id = ?";

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

		public String getaccount_number() {
			// TODO Auto-generated method stub
			return null;
		}
	}

