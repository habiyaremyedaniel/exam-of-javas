package allobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Student {
    private int student_id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private String gender;
    private String date_of_birth;
    private String course;
    private String year_of_study;
    private String room_number;
    private String bank_id;
    private String room_id;

    public Student() {
    }

    public Student(int student_id, String name, String email, String password, String phone_number, String gender,
            String date_of_birth, String course, String year_of_study, String room_number, String bank_id,
            String room_id) {
        super();
        this.student_id = student_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.gender = gender;
        this.room_id = room_id;
        this.course = course;
        this.setDate_of_birth(date_of_birth);
    }

    public String getgender() {
        return gender;
    }

    public void setgender(String selectedOption) {
        this.gender = selectedOption;
    }

    public Student(String name, String email, String password, String phone_number, String gender,
            String date_of_birth, String course, String year_of_study, String room_number, String bank_id,
            String room_id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.course = course;
        this.year_of_study = year_of_study;
        this.room_number = room_number;
        this.bank_id = bank_id;
        this.room_id = room_id;
    }

    public int getId() {
        return student_id;
    }

    public void setId(int student_id) {
        this.student_id = student_id;
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

    public String getTelephone() {
        return phone_number;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String string) {
        this.date_of_birth = string;
    }

    public void setcourse(String course) {
        this.course = course;
    }

    public String getcourse() {
        return course;
    }

    public String getYear_of_study() {
        return year_of_study;
    }

    public void setYear_of_study(String string) {
        this.year_of_study = string;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String string) {
        this.room_number = string;
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String string) {
        this.bank_id = string;
    }

    public void setroom_id(String string) {
        this.room_id = string;
    }

    public String getroom_id() {
        return room_id;
    }

    public void makeconnection() {
    }

    public void insertData(String n, String e_l, String pa_rd, String pho_er, Object ge_er, String dob, String co_se,
            Integer yos, Integer ro_ber, Integer ba_id, String ro_id) {
        // JDBC URL, username, and password of MySQL server
        String host = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
        String user = "222007495";
        String password = "222007495";

        // SQL query to insert data
        String sql = "INSERT INTO student (name, email, password, phone_number, gender, date_of_birth, course, year_of_study, room_number, bank_id, room_id) VALUES (?, ?, ?, ?,?,?,?,?,?,?,?)";

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
            preparedStatement.setObject(5, ge_er);
            preparedStatement.setString(6, dob);
            preparedStatement.setString(7, co_se);
            preparedStatement.setInt(8, yos);
            preparedStatement.setInt(9, ro_ber);
            preparedStatement.setInt(10, ba_id);
            preparedStatement.setString(11, ro_id);

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

    public void insertData() {
        // JDBC URL, username, and password of MySQL server
        String host = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
        String user = "222007495";
        String password = "222007495";

        // SQL query to insert data
        String sql = "INSERT INTO student (name,email,password,phone_number,gender,date_of_birth,course,year_of_study,room_number, bank_id,room_id) VALUES ( ?, ?, ?,?, ?, ?, ?,?,?,?,?)";

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
            preparedStatement.setString(5, this.gender);
            preparedStatement.setString(6, this.date_of_birth);
            preparedStatement.setString(7, this.course);
            preparedStatement.setString(8, this.year_of_study);
            preparedStatement.setString(9, this.room_number);
            preparedStatement.setString(10, this.bank_id);
            preparedStatement.setString(11, this.room_id);

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

    public void readwithID(int inputid) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
        String user = "222007495";
        String password = "222007495";

        // SQL query to select all columns from student where id = ?
        String sql = "SELECT * FROM student WHERE student_id = ?";

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
                this.setId(resultSet.getInt("student_id"));
                this.setname(resultSet.getString("name"));
                this.setpassword(resultSet.getString("email"));
                this.setpassword(resultSet.getString("password"));
                this.setphone_number(resultSet.getString("phone_number"));
                this.setgender(resultSet.getString("gender"));
                this.setDate_of_birth(resultSet.getString("date_of_birth"));
                this.setcourse(resultSet.getString("course"));
                this.setYear_of_study(resultSet.getString("year_of_study"));
                this.setRoom_number(resultSet.getString("room_number"));
                this.setBank_id(resultSet.getString("bank_id"));
                this.setroom_id(resultSet.getString("room_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int inputstudentid) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost/habiyaremye_daniel_hms";
        String user = "222007495";
        String password = "222007495";

        // SQL query to update data
        String sql = "UPDATE student SET name = ?, email = ?, password = ?, phone_number = ?, gender = ?, date_of_birth = ?, course = ?, year_of_study = ?, room_number = ?, bank_id = ?, room_id = ? WHERE student_id = ?";

        try (
            // Establish the connection
            Connection co = DriverManager.getConnection(url, user, password);

            // Create a prepared statement
            PreparedStatement pl = co.prepareStatement(sql);
        ) {
            // Set the new values for the update
            pl.setString(1, this.getname());
            pl.setString(2, this.getEmail());
            pl.setString(3, this.getpassword());
            pl.setString(4, this.getTelephone());
            pl.setString(5, this.getgender());
            pl.setString(6, this.getDate_of_birth());
            pl.setString(7, this.getcourse());
            pl.setString(8, this.getYear_of_study());
            pl.setString(9, this.getRoom_number());
            pl.setString(10, this.getBank_id());
            pl.setString(11, this.getroom_id());
            pl.setInt(12, inputstudentid);

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
        String sql = "DELETE FROM student WHERE student_id = ?";

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
        }
    }
}
