package menu;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import allobject.Admins;

public class Admin_SignUp extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField passwordTextField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin_SignUp frame = new Admin_SignUp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Admin_SignUp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 633, 505);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 77, 85, 23);
        contentPane.add(nameLabel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 124, 85, 23);
        contentPane.add(emailLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(97, 73, 180, 33);
        contentPane.add(nameTextField);
        nameTextField.setColumns(10);

        emailTextField = new JTextField();
        emailTextField.setBounds(97, 124, 180, 33);
        contentPane.add(emailTextField);
        emailTextField.setColumns(10);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 183, 77, 23);
        contentPane.add(passwordLabel);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(97, 183, 180, 33);
        contentPane.add(passwordTextField);
        passwordTextField.setColumns(10);

        JButton cancelButton = new JButton("CANCEL");
        cancelButton.setBounds(209, 285, 126, 33);
        contentPane.add(cancelButton);

        JButton signUpButton = new JButton("SIGN UP");
        signUpButton.setBounds(380, 285, 132, 33);
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // LOGIN_ADMINFORM frame = new LOGIN_ADMINFORM(); // You might want to reconsider this line
                // frame.setVisible(true);
                Admins admin = new Admins();
                if (e.getSource() == signUpButton) {
                    admin.setName(nameTextField.getText());
                    admin.setEmail(emailTextField.getText());
                    admin.setPassword(passwordTextField.getText());

                    admin.insertData();
                    System.out.println("Admin created successfully!");
                    System.out.println("Name: " + admin.getName() + ", Email: " + admin.getEmail());
                }
            }
        });
        contentPane.add(signUpButton);
    }
}
