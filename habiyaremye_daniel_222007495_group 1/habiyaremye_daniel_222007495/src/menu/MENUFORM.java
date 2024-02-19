
package menu;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import entitiesform.AdminForm;
import entitiesform.Bankforms;
import entitiesform.Hostel_managersForm;
import entitiesform.MaintenancestaffForm;
import entitiesform.RoomForm2;
import entitiesform.StudentForm;


public class MENUFORM extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JMenuBar menuBar;
    private JMenu adminMenu;
    private JMenu bankformsMenu;
    private JMenu hostel_managersFormMenu;
    private JMenu maintenancestaffFormMenu;
    private JMenu RoomForm2Menu;
    private JMenu StudentFormMenu;
    private JMenu logoutMenu;

    

    private JMenuItem adminItem;
    private JMenuItem bankformsItem;
    private JMenuItem hostel_managersItem;
    private JMenuItem maintenancestaffFormItem;
    private JMenuItem roomForm2Item;
    private JMenuItem studentFormItem;
    private JMenuItem logoutItem;
   
    private String loggedInUser;

    public MENUFORM(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create menu items
        adminMenu = new JMenu("Admin");
        adminItem = new JMenuItem("admin Form");
        adminItem.addActionListener(this);

        bankformsMenu = new JMenu("bank");
        bankformsItem = new JMenuItem("bank Form");
        bankformsItem.addActionListener(this);

        hostel_managersFormMenu = new JMenu("hostel_manager");
        hostel_managersItem = new JMenuItem("hostel_manager Form");
        hostel_managersItem.addActionListener(this);

        maintenancestaffFormMenu = new JMenu("maintenance_staff");
        maintenancestaffFormItem = new JMenuItem("maintenance_staff Form");
        maintenancestaffFormItem.addActionListener(this);

        RoomForm2Menu = new JMenu("Room");
        roomForm2Item = new JMenuItem("Room Form");
        roomForm2Item.addActionListener(this);

        StudentFormMenu = new JMenu("student");
        studentFormItem = new JMenuItem("student Form");
        studentFormItem.addActionListener(this);
        
       
        logoutMenu = new JMenu("Logout");
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to respective menus
        adminMenu.add(adminItem);
        bankformsMenu.add(bankformsItem);
        hostel_managersFormMenu.add(hostel_managersItem);
        maintenancestaffFormMenu.add(maintenancestaffFormItem);
        RoomForm2Menu.add(roomForm2Item);
        StudentFormMenu.add(studentFormItem);
        logoutMenu.add(logoutItem);

        // Add menus to menu bar
        menuBar.add(adminMenu);
        menuBar.add(bankformsMenu);
        menuBar.add(hostel_managersFormMenu);
        menuBar.add(maintenancestaffFormMenu);
        menuBar.add(RoomForm2Menu);
        menuBar.add(StudentFormMenu);
       
        menuBar.add(logoutMenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME"+loggedInUser+"TO habiyaremye_daniel_hms");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.ITALIC, 50));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminItem) {
            new AdminForm();
        } else if (e.getSource() == bankformsItem) {
            new Bankforms();
        } else if (e.getSource() == hostel_managersItem) {
            new Hostel_managersForm();
        } else if (e.getSource() == maintenancestaffFormItem) {
            new MaintenancestaffForm();
        } else if (e.getSource() == roomForm2Item) {
            new RoomForm2();
        } else if (e.getSource() == studentFormItem) {
            new StudentForm();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MENUFORM("TO habiyaremye_daniel_hms"));
    }}
