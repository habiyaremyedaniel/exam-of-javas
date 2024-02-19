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
import allobject.Banks;

public class Bankforms implements ActionListener {
    JFrame frame;
    JLabel id_lb = new JLabel("bank_id");
    JLabel name_lb = new JLabel("name");
    JLabel address_lb = new JLabel("address");
    JLabel contact_number_lb = new JLabel("contact_number");
    JLabel account_number_lb = new JLabel("account_number");

    JTextField id_txf = new JTextField();
    JTextField name_txf = new JTextField();
    JTextField address_txf = new JTextField();
    JTextField contact_number_txf = new JTextField();
    JTextField account_number_txf = new JTextField();

    JButton insert_btn = new JButton("Insert");
    JButton read_btn = new JButton("View");
    JButton update_btn = new JButton("Update");
    JButton delete_btn = new JButton("Delete");

    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getHeight();

    public  Bankforms() {
        createForm();
    }
    private <insertbtn, delete_btn> void ActionEvent() {
        insert_btn.addActionListener(this);
        read_btn.addActionListener(this);
        update_btn.addActionListener(this);
        delete_btn.addActionListener(this);
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("BANK FORM");
        frame.setBounds(10, 10, w - 200, h - 200);
        frame.getContentPane().setLayout(null); // Change layout manager if needed
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Use dispose() instead of EXIT_ON_CLOSE
        frame.setResizable(true);
        setLocationandSize();
        
    }
private void setLocationandSize() {
		id_lb.setBounds(10, 10, 100, 30);
		name_lb.setBounds(10, 50, 100, 30);
		address_lb.setBounds(10, 90, 100, 30);
		contact_number_lb.setBounds(10, 130, 100, 30);
		account_number_lb.setBounds(10, 170, 100, 30);
		
		id_txf.setBounds(200, 10, 130, 30);
		name_txf.setBounds(200, 50, 130, 30);
		address_txf.setBounds(200, 90, 130, 30);
		contact_number_txf.setBounds(200, 130, 130, 30);
		account_number_txf.setBounds(200, 170, 130, 30);
		
		
		    //Buttons CRUD
		insert_btn.setBounds(10,209, 85, 30);
		read_btn.setBounds(100,209, 85, 30);
		update_btn.setBounds(190,209, 85, 30);
		delete_btn.setBounds(280,209, 85, 30);
		setFontforall();
		addcomponentforFrame();
		}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		id_lb.setFont(font);
		name_lb.setFont(font);
		address_lb.setFont(font);
		contact_number_lb.setFont(font);
		account_number_lb.setFont(font);
		

		id_txf.setFont(font);
		name_txf.setFont(font);
		address_txf.setFont(font);
		contact_number_txf.setFont(font);
		account_number_txf.setFont(font);
		
	
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(id_lb);
		frame.add(name_lb);
		frame.add(address_lb);
		frame.add(contact_number_lb);
		frame.add(account_number_lb);
		
	
		//text
		frame.add(id_txf);
		frame.add(name_txf);
		frame.add(address_txf);
		frame.add(contact_number_txf);
		frame.add(account_number_txf);
		
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		ActionEvent();
	}


	@Override
   public void actionPerformed(ActionEvent e) {
	Banks ad=new Banks();
	if(e.getSource()==insert_btn) {
		ad.setName(name_txf.getText());
		ad.setAddress(address_txf.getText());
		ad.setContact_number( contact_number_txf.getText());
		ad.setAccount_number(account_number_txf.getText());
		
		ad.insertData();
	}else if (e.getSource()==read_btn) {
		int id=Integer.parseInt(id_txf.getText());
		ad.readWithID(id);
		id_txf.setText(String.valueOf(ad.getBank_id()));
		name_txf.setText(ad.getName());
		address_txf.setText(ad.getAddress());
		contact_number_txf.setText(ad.getContact_number());
		account_number_txf.setText(ad.getAccount_number());
		
		}else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(id_txf.getText());
		ad.setName(name_txf.getText());
		ad.setAddress(address_txf.getText());
		ad.setContact_number( contact_number_txf.getText());
	    ad.setAccount_number(account_number_txf.getText());
	    
		ad.update(id);
	}else {
		int id=Integer.parseInt(id_txf.getText());
		ad.delete(id);
	}}

	public static void main(String[] args) {
		Bankforms  bankf= new Bankforms();
		System.out.println(bankf);
		}}








    
    
   