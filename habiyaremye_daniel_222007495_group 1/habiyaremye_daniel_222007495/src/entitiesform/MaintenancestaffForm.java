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
import allobject.maintainancestaff;
public class MaintenancestaffForm implements ActionListener{ 
				JFrame frame;
				JLabel id_lb=new JLabel("StaffID");
				JLabel Name_lb=new JLabel("Name");
				JLabel ContactNumber=new JLabel("ContactNumber");
				JLabel Specialization=new JLabel(" Specialization");
				JLabel WorkSchedule=new JLabel("WorkSchedule");
				JLabel DateOfEmployment=new JLabel("DateOfEmployment");
				JLabel Emergency_lb=new JLabel(" EmergencyContact");
				
			    JTextField id_txf=new JTextField();
				JTextField Name_txf=new JTextField();
				JTextField email_txf=new JTextField();
				JTextField pass_txf=new JTextField();
				JTextField phone_txf=new JTextField();
				JTextField DateOfEmployment_txf=new JTextField();
				JTextField bid_txf=new JTextField();
			
	               //Buttons CRUD
				JButton insert_btn=new JButton("Insert");
				JButton Remt_btn=new JButton("View");
				JButton update_tbtn=new JButton("Update");
				JButton delete_btn=new JButton("Delete");
				Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
				int w=(int) screensize.getWidth();
				int h=(int) screensize.getHeight();
				public MaintenancestaffForm(){
				       createForm();}
				private <insertbtn, delete_btn> void ActionEvent() {
					insert_btn.addActionListener(this);
					Remt_btn.addActionListener(this);
					update_tbtn.addActionListener(this);
					delete_btn.addActionListener(this);
				}
				private void createForm() {
					frame=new JFrame();
					frame.setTitle("Maintenancestaff FORM");
					frame.setBounds(10, 10, 700, 400);
					frame.getContentPane().setLayout(null);
					frame.getContentPane().setBackground(Color.GRAY);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setResizable(true);
					setLocationandSize();
				}


				private void setLocationandSize() {
					id_lb.setBounds(10, 10, 100, 30);
					Name_lb.setBounds(10, 50, 100, 30);
					ContactNumber.setBounds(10, 90, 100, 30);
					Specialization.setBounds(10, 130, 100, 30);
					WorkSchedule.setBounds(10, 170, 100, 30);
					DateOfEmployment.setBounds(10, 210, 100, 30);
					Emergency_lb.setBounds(10, 250, 100, 30);
					id_txf.setBounds(200, 10, 130, 30);
					Name_txf.setBounds(200, 50, 130, 30);
					email_txf.setBounds(200, 90, 130, 30);
					pass_txf.setBounds(200, 130, 130, 30);
					phone_txf.setBounds(200, 170, 130, 30);
					DateOfEmployment_txf.setBounds(200, 210, 130, 30);
					bid_txf.setBounds(200, 250, 130, 30);
					
					    //Buttons CRUD
					insert_btn.setBounds(10,290, 85, 30);
					Remt_btn.setBounds(100,290, 85, 30);
					update_tbtn.setBounds(190,290, 85, 30);
					delete_btn.setBounds(280,290, 85, 30);
					setFontforall();
					addcomponentforFrame();
					}
				private void setFontforall() {
					Font font = new Font("Georgia", Font.BOLD, 18);

					id_lb.setFont(font);
					Name_lb.setFont(font);
					ContactNumber.setFont(font);
					Specialization.setFont(font);
					WorkSchedule.setFont(font);
					DateOfEmployment.setFont(font);
					Emergency_lb.setFont(font);
		
					id_txf.setFont(font);
					Name_txf.setFont(font);
					email_txf.setFont(font);
					pass_txf.setFont(font);
					phone_txf.setFont(font);
					DateOfEmployment_txf.setFont(font);
					bid_txf.setFont(font);
				
					//Buttons CRUD
					Font fonti = new Font("Courier New", Font.ITALIC, 12);

					insert_btn.setFont(fonti);
					Remt_btn.setFont(fonti);
					update_tbtn.setFont(fonti);
					delete_btn.setFont(fonti);

				}
				private void addcomponentforFrame() {
					frame.add(id_lb);
					frame.add(Name_lb);
					frame.add(ContactNumber);
					frame.add(Specialization);
					frame.add(WorkSchedule);
					frame.add(DateOfEmployment);
					frame.add(Emergency_lb);
				
					//text
					frame.add(id_txf);
					frame.add(Name_txf);
					frame.add(email_txf);
					frame.add(pass_txf);
					frame.add(phone_txf);
					frame.add(DateOfEmployment_txf);
					frame.add(bid_txf);
					
					//Buttons CRUD
					frame.add(insert_btn);
					frame.add(Remt_btn);
					frame.add(update_tbtn);
					frame.add(delete_btn);
					
					ActionEvent();
				}
				@Override
			   public void actionPerformed(ActionEvent e) {
					maintainancestaff mt=new maintainancestaff();
				if(e.getSource()==insert_btn) {
					mt.setName(Name_txf.getText());
					mt.setContactNumber(email_txf.getText());
					mt.setSpecialization( pass_txf.getText());
					mt.setWorkSchedule(phone_txf.getText());
					mt.setDateOfEmployment(DateOfEmployment_txf.getText());
					mt.setEmergencyContact(bid_txf.getText());
					mt.insertData1() ;
				}else if (e.getSource()==Remt_btn) {
					int id=Integer.parseInt(id_txf.getText());
					mt.readWithID(id);
					id_txf.setText(String.valueOf(mt.getStaffID()));
					Name_txf.setText(mt.getName());
					email_txf.setText(mt.getContactNumber());
					pass_txf.setText(mt.getSpecialization());
					phone_txf.setText(mt.getWorkSchedule());
					DateOfEmployment_txf.setText(mt.getDateOfEmployment());
				  bid_txf.setText(mt.getEmergencyContact());
				  
					}else if (e.getSource()==update_tbtn) {
						mt.setName(Name_txf.getText());
						mt.setContactNumber(email_txf.getText());
						mt.setSpecialization( pass_txf.getText());
						mt.setWorkSchedule(phone_txf.getText());
				mt.setDateOfEmployment(DateOfEmployment_txf.getText());
						mt.setEmergencyContact(bid_txf.getText());
				}else {
					int id=Integer.parseInt(id_txf.getText());
					mt.delete(id);
				}}

				public static void main(String[] args) {
				MaintenancestaffForm MaintenancestaffForm=new MaintenancestaffForm();
				System.out.println(MaintenancestaffForm);
					}}









