package entitiesform;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import allobject.Hostel_managers;

public class Hostel_managersForm implements ActionListener {
    JFrame frame;
    JLabel id_lb = new JLabel("hostel_manager_id");
    JLabel name_lb = new JLabel("name:");
    JLabel email_lb = new JLabel("email:");
    JLabel pass_lb = new JLabel("Password");
    JLabel phone_lb = new JLabel("Phone_number");
    JLabel role_lb = new JLabel("role");
    JLabel bid_lb = new JLabel("bank_id");

    JTextField id_txf = new JTextField();
    JTextField name_txf = new JTextField();
    JTextField email_txf = new JTextField();
    JTextField pass_txf = new JTextField();
    JTextField phone_txf = new JTextField();
    JTextField role_txf = new JTextField();
    JTextField bid_txf = new JTextField();

    // Buttons CRUD
    JButton insert_btn = new JButton("Insert");
    JButton read_btn = new JButton("View");
    JButton update_btn = new JButton("Update");
    JButton delete_btn = new JButton("Delete");

    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getHeight();

    public Hostel_managersForm() {
        createForm();
    }

    private void ActionEvent() {
        insert_btn.addActionListener(this);
        read_btn.addActionListener(this);
        update_btn.addActionListener(this);
        delete_btn.addActionListener(this);
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("HOSTEL_MANAGER FORM");
        frame.setBounds(10, 10, 700, 400);
        frame.getContentPane().setLayout(null); // Consider using layout managers
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        setLocationAndSize();
    }

    private void setLocationAndSize() {
        id_lb.setBounds(10, 10, 100, 30);
        name_lb.setBounds(10, 50, 100, 30);
        email_lb.setBounds(10, 90, 100, 30);
        pass_lb.setBounds(10, 130, 100, 30);
        phone_lb.setBounds(10, 170, 100, 30);
        role_lb.setBounds(10, 210, 100, 30);
        bid_lb.setBounds(10, 250, 100, 30);
        id_txf.setBounds(200, 10, 130, 30);
        name_txf.setBounds(200, 50, 130, 30);
        email_txf.setBounds(200, 90, 130, 30);
        pass_txf.setBounds(200, 130, 130, 30);
        phone_txf.setBounds(200, 170, 130, 30);
        role_txf.setBounds(200, 210, 130, 30);
        bid_txf.setBounds(200, 250, 130, 30);

        // Buttons CRUD
        insert_btn.setBounds(10, 290, 85, 30);
        read_btn.setBounds(100, 290, 85, 30);
        update_btn.setBounds(190, 290, 85, 30);
        delete_btn.setBounds(280, 290, 85, 30);
        setFontForAll();
        addComponentsForFrame();
    }

    private void setFontForAll() {
        Font font = new Font("Georgia", Font.BOLD, 18);

        id_lb.setFont(font);
        name_lb.setFont(font);
        email_lb.setFont(font);
        pass_lb.setFont(font);
        phone_lb.setFont(font);
        role_lb.setFont(font);
        bid_lb.setFont(font);

        id_txf.setFont(font);
        name_txf.setFont(font);
        email_txf.setFont(font);
        pass_txf.setFont(font);
        phone_txf.setFont(font);
        role_txf.setFont(font);
        bid_txf.setFont(font);

        // Buttons CRUD
        Font fonti = new Font("Courier New", Font.ITALIC, 12);

        insert_btn.setFont(fonti);
        read_btn.setFont(fonti);
        update_btn.setFont(fonti);
        delete_btn.setFont(fonti);
    }

    private void addComponentsForFrame() {
        frame.add(id_lb);
        frame.add(name_lb);
        frame.add(email_lb);
        frame.add(pass_lb);
        frame.add(phone_lb);
        frame.add(role_lb);
        frame.add(bid_lb);

        // Text fields
        frame.add(id_txf);
        frame.add(name_txf);
        frame.add(email_txf);
        frame.add(pass_txf);
        frame.add(phone_txf);
        frame.add(role_txf);
        frame.add(bid_txf);

        // Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);

        ActionEvent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Hostel_managers ad = new Hostel_managers();
        if (e.getSource() == insert_btn) {
            ad.setName(name_txf.getText());
            ad.setEmail(email_txf.getText());
            ad.setPassword(pass_txf.getText());
            ad.setPhone_number(phone_txf.getText());
            ad.setRole(role_txf.getText());
            ad.setBank_id(bid_txf.getText());
            ad.insertData();
        } else if (e.getSource() == read_btn) {
            try {
                int id = Integer.parseInt(id_txf.getText());
                ad.readWithID(id);
                id_txf.setText(String.valueOf(ad.getId()));
                name_txf.setText(ad.getName());
                email_txf.setText(ad.getEmail());
                pass_txf.setText(ad.getPassword());
                phone_txf.setText(ad.getPhone_number());
                role_txf.setText(ad.getRole());
                bid_txf.setText(ad.getBank_id());
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == update_btn) {
            ad.setName(name_txf.getText());
            ad.setEmail(email_txf.getText());
            ad.setPassword(pass_txf.getText());
            ad.setPhone_number(phone_txf.getText());
            ad.setRole(role_txf.getText());
            ad.setBank_id(bid_txf.getText());
            // Uncomment and use the appropriate method
            // ad.update(id);
        } else if (e.getSource() == delete_btn) {
            try {
                int id = Integer.parseInt(id_txf.getText());
                ad.delete(id);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Hostel_managersForm hostel_managerForm = new Hostel_managersForm();
        System.out.println(hostel_managerForm);
    }
}
