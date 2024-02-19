package entitiesform;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import allobject.Student;
public class StudentForm  implements ActionListener{ 
			JFrame frame;
			JLabel id_lb=new JLabel("student_id");
			JLabel name_lb=new JLabel("Names:");
			JLabel email_lb=new JLabel("Email:");
			JLabel pass_lb=new JLabel("Password");
			JLabel phone_lb=new JLabel("Phone_number");
			JLabel gender_lb=new JLabel("Gender");
			JLabel dob_lb=new JLabel("date_of_birth");
			JLabel co_lb=new JLabel("course");
			JLabel yos_lb=new JLabel("year_of_study");
			JLabel room_lb=new JLabel("room_number");
			JLabel bank_lb=new JLabel("bank_id");
			JLabel roomid_lb=new JLabel("room_id");
		    JTextField id_txf=new JTextField();
			JTextField name_txf=new JTextField();
			JTextField email_txf=new JTextField();
			JTextField pass_txf=new JTextField();
			JTextField phone_txf=new JTextField();
			JTextField gender_txf=new JTextField();
			JTextField dob_txf=new JTextField();
			JTextField co_txf=new JTextField();
			JTextField yos_txf=new JTextField();
			JTextField room_txf=new JTextField();
			JTextField bank_txf=new JTextField();
			JTextField roomid_txf=new JTextField();
			String []gender={"Male","Female"};
			JComboBox<String> genderBox = new JComboBox<>(gender);
               //Buttons CRUD
			JButton insert_btn=new JButton("Insert");
			JButton Read_btn=new JButton("View");
			JButton update_tbtn=new JButton("Update");
			JButton delete_btn=new JButton("Delete");
			Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
			int w=(int) screensize.getWidth();
			int h=(int) screensize.getHeight();
			public StudentForm(){
			       createForm();}
			private <insertbtn, delete_btn> void ActionEvent() {
				insert_btn.addActionListener(this);
				Read_btn.addActionListener(this);
				update_tbtn.addActionListener(this);
				delete_btn.addActionListener(this);
			}
			private void createForm() {
				frame=new JFrame();
				frame.setTitle("STUDENT FORM");
				frame.setBounds(10, 10, 600, 600);
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
				gender_lb.setBounds(10, 210, 100, 30);
				dob_lb.setBounds(10, 250, 100, 30);
				co_lb.setBounds(10, 290, 100, 30);
				yos_lb.setBounds(10, 330, 100, 30);
				room_lb.setBounds(10, 370, 100, 30);
				bank_lb.setBounds(10, 410, 100, 30);
				roomid_lb.setBounds(10, 450, 100, 30);
				id_txf.setBounds(200, 10, 130, 30);
				name_txf.setBounds(200, 50, 130, 30);
				email_txf.setBounds(200, 90, 130, 30);
				pass_txf.setBounds(200, 130, 130, 30);
				phone_txf.setBounds(200, 170, 130, 30);
				genderBox.setBounds(200, 210, 130, 30);
				dob_txf.setBounds(200, 250, 130, 30);
				co_txf.setBounds(200, 290, 130, 30);
				yos_txf.setBounds(200, 330, 130, 30);
				room_txf.setBounds(200, 370, 130, 30);
				bank_txf.setBounds(200, 410, 130, 30);
				roomid_txf.setBounds(200, 450, 130, 30);
				    //Buttons CRUD
				insert_btn.setBounds(10,500, 85, 30);
				Read_btn.setBounds(100,500, 85, 30);
				update_tbtn.setBounds(190,500, 85, 30);
				delete_btn.setBounds(280,500, 85, 30);
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
				gender_lb.setFont(font);
				dob_lb.setFont(font);
				co_lb.setFont(font);
				yos_lb.setFont(font);
				bank_lb.setFont(font);
                 room_lb.setFont(font);
				id_txf.setFont(font);
				name_txf.setFont(font);
				email_txf.setFont(font);
				pass_txf.setFont(font);
				phone_txf.setFont(font);
				genderBox.setFont(font);
				dob_txf.setFont(font);
				co_txf.setFont(font);
				yos_txf.setFont(font);
				room_txf.setFont(font);
				bank_txf.setFont(font);
				roomid_lb.setFont(font);
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
				frame.add(gender_lb);
				frame.add(dob_lb);
				frame.add(co_lb);
				frame.add(yos_lb);
				frame.add(room_lb);
				frame.add(bank_lb);
				frame.add(roomid_lb);
				//text
				frame.add(id_txf);
				frame.add(name_txf);
				frame.add(email_txf);
				frame.add(pass_txf);
				frame.add(phone_txf);
				frame.add(genderBox);
				frame.add(dob_txf);
				frame.add(co_txf);
				frame.add(yos_txf);
				frame.add(room_txf);
				frame.add(bank_txf);
				frame.add(roomid_txf);
				//Buttons CRUD
				frame.add(insert_btn);
				frame.add(Read_btn);
				frame.add(update_tbtn);
				frame.add(delete_btn);
				frame.add(room_txf);
				frame.add(bank_txf);
				frame.add(roomid_txf);
				ActionEvent();
			}
			@Override
		   public void actionPerformed(ActionEvent e) {
				Student  st=new Student();
				if(e.getSource()==insert_btn) {
					st.setname(name_txf.getText());
					st.setEmail(email_txf.getText());
					st.setpassword(pass_txf.getText());
					st.setphone_number(phone_txf.getText());
					st.setgender((String) genderBox.getSelectedItem());
					st.setDate_of_birth(dob_txf.getText());
					st.setcourse(co_txf.getText());
					st.setYear_of_study(yos_txf.getText());
					st.setRoom_number(room_txf.getText());
					st.setBank_id(bank_txf.getText());
					st.setroom_id(roomid_txf.getText());
					st.insertData();
				}else if (e.getSource()==Read_btn) {
					int id=Integer.parseInt(id_txf.getText());
					st.readwithID(id);
					id_txf.setText(String.valueOf(st.getId()));
					name_txf.setText(st.getname());
					email_txf.setText(st.getEmail());
					pass_txf.setText(st.getpassword());
					phone_txf.setText(st.getTelephone());
					gender_txf.setText(st.getgender());
					dob_txf.setText(st.getDate_of_birth());
					co_txf.setText(st.getcourse());
					yos_txf.setText(st.getYear_of_study());
					room_txf.setText(st.getRoom_number());
					bank_txf.setText(st.getBank_id());
					roomid_txf.setText(st.getroom_id());
					
					
					st.setgender(st.getgender());
				    }else if (e.getSource()==update_tbtn) {
					int id=Integer.parseInt(id_txf.getText());
					st.setname(name_txf.getText());
					st.setEmail(email_txf.getText());
					st.setpassword(pass_txf.getText());
					st.setphone_number(phone_txf.getText());
					st.setgender(gender_txf.getText());
					st.setDate_of_birth(dob_txf.getText());
					st.setcourse(co_txf.getText());
					st.setYear_of_study(yos_txf.getText());
					st.setRoom_number(room_txf.getText());
					st.setBank_id(bank_txf.getText());
					st.setroom_id(room_txf.getText());
					
					
					
					st.setgender((String)genderBox.getSelectedItem());
					st.update(id);
				}else {
					int id=Integer.parseInt(id_txf.getText());
					st.delete(id);
				}}
			public static void main(String[] args) {
			StudentForm  studentForm= new StudentForm();
			System.out.println(studentForm);
			}}







