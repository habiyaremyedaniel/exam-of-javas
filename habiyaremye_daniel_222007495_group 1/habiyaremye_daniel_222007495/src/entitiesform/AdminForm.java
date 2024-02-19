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

import allobject.Admins;
public class AdminForm  implements ActionListener{ 
			JFrame frame;
			JLabel id_lb=new JLabel("admin_id");
			JLabel name_lb=new JLabel("name:");
			JLabel email_lb=new JLabel("email:");
			JLabel pass_lb=new JLabel("Password");
			JLabel phone_lb=new JLabel("Phone_number");
			JLabel role_lb=new JLabel("role");
			JLabel bid_lb=new JLabel("bank_id");
			
		    JTextField id_txf=new JTextField();
			JTextField name_txf=new JTextField();
			JTextField email_txf=new JTextField();
			JTextField pass_txf=new JTextField();
			JTextField phone_txf=new JTextField();
			JTextField role_txf=new JTextField();
			JTextField bid_txf=new JTextField();
		
               //Buttons CRUD
			JButton insert_btn=new JButton("Insert");
			JButton Read_btn=new JButton("View");
			JButton update_tbtn=new JButton("Update");
			JButton delete_btn=new JButton("Delete");
			Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
			int w=(int) screensize.getWidth();
			int h=(int) screensize.getHeight();
			public AdminForm(){
			       createForm();}
			private <insertbtn, delete_btn> void ActionEvent() {
				insert_btn.addActionListener(this);
				Read_btn.addActionListener(this);
				update_tbtn.addActionListener(this);
				delete_btn.addActionListener(this);
			}
			private void createForm() {
				frame=new JFrame();
				frame.setTitle("ADMIN FORM");
				frame.setBounds(10, 10, 400, 400);
				frame.getContentPane().setLayout(null);
				frame.getContentPane().setBackground(Color.GRAY);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(true);
				setLocationandSize();
			}


			private void setLocationandSize() {
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
				
				    //Buttons CRUD
				insert_btn.setBounds(10,300, 85, 30);
				Read_btn.setBounds(100,300, 85, 30);
				update_tbtn.setBounds(190,300, 85, 30);
				delete_btn.setBounds(280,300, 85, 30);
				setFontforall();
				addcomponentforFrame();
				}
			private void setFontforall() {
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
			
				//Buttons CRUD
				Font fonti = new Font("Courier New", Font.ITALIC, 12);

				insert_btn.setFont(fonti);
				Read_btn.setFont(fonti);
				update_tbtn.setFont(fonti);
				delete_btn.setFont(fonti);

			}
			private void addcomponentforFrame() {
				frame.add(id_lb);
				frame.add(name_lb);
				frame.add(email_lb);
				frame.add(pass_lb);
				frame.add(phone_lb);
				frame.add(role_lb);
				frame.add(bid_lb);
			
				//text
				frame.add(id_txf);
				frame.add(name_txf);
				frame.add(email_txf);
				frame.add(pass_txf);
				frame.add(phone_txf);
				frame.add(role_txf);
				frame.add(bid_txf);
				
				//Buttons CRUD
				frame.add(insert_btn);
				frame.add(Read_btn);
				frame.add(update_tbtn);
				frame.add(delete_btn);
				
				ActionEvent();
			}
			@Override
		   public void actionPerformed(ActionEvent e) {
			Admins  ad=new Admins();
			if(e.getSource()==insert_btn) {
				ad.setName(name_txf.getText());
				ad.setEmail(email_txf.getText());
				ad.setPassword( pass_txf.getText());
				ad.setPhone_number(phone_txf.getText());
				ad.setRole(role_txf.getText());
				ad.setBank_id(bid_txf.getText());
				ad.insertData();
			}else if (e.getSource()==Read_btn) {
				int id=Integer.parseInt(id_txf.getText());
				ad.readWithID(id);
				id_txf.setText(String.valueOf(ad.getBank_id()));
				name_txf.setText(ad.getName());
				email_txf.setText(ad.getEmail());
				pass_txf.setText(ad.getPassword());
				phone_txf.setText(ad.getPhone_number());
				role_txf.setText(ad.getRole());
			  bid_txf.setText(ad.getBank_id());
			  
				}else if (e.getSource()==update_tbtn) {
					int id=Integer.parseInt(id_txf.getText());
				ad.setName(name_txf.getText());
				ad.setEmail(email_txf.getText());
				ad.setPassword( pass_txf.getText());
			    ad.setPhone_number(phone_txf.getText());
			    ad.setRole(role_txf.getText());
			    ad.setBank_id(bid_txf.getText());
				ad.update(id);
			}else {
				int id=Integer.parseInt(id_txf.getText());
				ad.delete(id);
			}}

			public static void main(String[] args) {
				AdminForm  adminForm= new AdminForm();
				System.out.println(adminForm);
				}
			public void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}}







