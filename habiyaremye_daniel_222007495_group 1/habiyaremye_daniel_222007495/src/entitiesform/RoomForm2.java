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

import allobject.Room;
public class RoomForm2 implements ActionListener{ 
			JFrame frame;
			JLabel Room_id_lb=new JLabel("Room_id");
			JLabel room_number_lb=new JLabel("room_number:");
			JLabel capacity_lb=new JLabel("capacity:");
			JLabel type_lb=new JLabel("type");
			JLabel rent_lb=new JLabel("rent");
			JLabel facilities_lb=new JLabel("facilities");
			
		    JTextField room_id_txf=new JTextField();
			JTextField room_number_txf=new JTextField();
			JTextField capacity_txf=new JTextField();
			JTextField type_txf=new JTextField();
			JTextField rent_txf=new JTextField();
			JTextField facilities_txf=new JTextField();
			
		
               //Buttons CRUD
			JButton insert_btn=new JButton("Insert");
			JButton Read_btn=new JButton("View");
			JButton update_tbtn=new JButton("Update");
			JButton delete_btn=new JButton("Delete");
			Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
			int w=(int) screensize.getWidth();
			int h=(int) screensize.getHeight();
			public RoomForm2(){
			       createForm();}
			private <insertbtn, delete_btn> void ActionEvent() {
				insert_btn.addActionListener(this);
				Read_btn.addActionListener(this);
				update_tbtn.addActionListener(this);
				delete_btn.addActionListener(this);
			}
			private void createForm() {
				frame=new JFrame();
				frame.setTitle("RoomForm");
				frame.setBounds(10, 10, 400, 400);
				frame.getContentPane().setLayout(null);
				frame.getContentPane().setBackground(Color.GRAY);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(true);
				setLocationandSize();
			}


			private void setLocationandSize() {
				Room_id_lb.setBounds(10, 10, 100, 30);
				room_number_lb.setBounds(10, 50, 100, 30);
				capacity_lb.setBounds(10, 90, 100, 30);
				type_lb.setBounds(10, 130, 100, 30);
				rent_lb.setBounds(10, 170, 100, 30);
				facilities_lb.setBounds(10, 210, 100, 30);
				
				
				room_id_txf.setBounds(200, 10, 130, 30);
				room_number_txf.setBounds(200, 50, 130, 30);
				capacity_txf.setBounds(200, 90, 130, 30);
				type_txf.setBounds(200, 130, 130, 30);
				rent_txf.setBounds(200, 170, 130, 30);
				facilities_txf.setBounds(200, 210, 130, 30);
				
				
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

				Room_id_lb.setFont(font);
				room_number_lb.setFont(font);
				capacity_lb.setFont(font);
				type_lb.setFont(font);
				rent_lb.setFont(font);
				facilities_lb.setFont(font);
				
	
				room_id_txf.setFont(font);
				room_number_txf.setFont(font);
				capacity_txf.setFont(font);
				rent_txf.setFont(font);
				rent_txf.setFont(font);
				facilities_txf.setFont(font);
				
				
			
				//Buttons CRUD
				Font fonti = new Font("Courier New", Font.ITALIC, 12);

				insert_btn.setFont(fonti);
				Read_btn.setFont(fonti);
				update_tbtn.setFont(fonti);
				delete_btn.setFont(fonti);

			}
			private void addcomponentforFrame() {
				frame.add(Room_id_lb);
				frame.add(room_number_lb);
				frame.add(capacity_lb);
				frame.add(type_lb);
				frame.add(rent_lb);
				frame.add(facilities_lb);
				
			
				//text
				frame.add(room_id_txf);
				frame.add(room_number_txf);
				frame.add(capacity_txf);
				frame.add(type_txf);
				frame.add(rent_txf);
				frame.add(facilities_txf);
				
				//Buttons CRUD
				frame.add(insert_btn);
				frame.add(Read_btn);
				frame.add(update_tbtn);
				frame.add(delete_btn);
				
				ActionEvent();
			}
			@Override
		   public void actionPerformed(ActionEvent e) {
			Room  ad=new Room();
			if(e.getSource()==insert_btn) {
				ad.setRoom_number(room_number_txf.getText());
				ad.setCapacity((capacity_txf.getText()));
				ad.setType(( type_txf.getText()));
				ad.setRent((rent_txf.getText()));
				ad.setFacilities((facilities_txf.getText()));
				ad.insertData();
				
			}else if (e.getSource()==Read_btn) {
				int id=Integer.parseInt(room_id_txf.getText());
				ad.readWithID(id);
				room_id_txf.setText(String.valueOf(ad.getRoom_number()));
				room_number_txf.setText(ad.getRoom_number());
				capacity_txf.setText(ad.getCapacity());
				type_txf.setText(ad.getType());
				rent_txf.setText(ad.getRent());
				facilities_txf.setText((String) ad.getFacilities());
			 
			  
				}else if (e.getSource()==update_tbtn) {
					int id=Integer.parseInt(room_id_txf.getText());
				ad.setRoom_number((room_number_txf.getText()));
				ad.setCapacity((capacity_txf.getText()));
				ad.setType(( type_txf.getText()));
			    ad.setRent((rent_txf.getText()));
			    ad.setFacilities((facilities_txf.getText()));
			    
				ad.update(id);
			}else {
				int id=Integer.parseInt(room_id_txf.getText());
				ad.delete(id);
			}}

			public static void main(String[] args) {
				RoomForm2  roomn= new RoomForm2();
				System.out.println(roomn);
				}}







