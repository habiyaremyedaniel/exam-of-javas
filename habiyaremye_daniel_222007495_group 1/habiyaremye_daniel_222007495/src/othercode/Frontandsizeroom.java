package othercode;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class Frontandsizeroom {

	public static void main(String[] args) {
	
				        JFrame frame = new JFrame("Font and Table room");
				        frame.setSize(400, 100);
				        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				        // Font Example
				        JLabel label = new JLabel("room");
				        Font customFont = new Font("Times New Roma", Font.ITALIC, 10);
				        label.setFont(customFont);

				        // Table Example
				        String[] columnNames = {"room_id", "room_number","capacity","type","rent"," facilities"};
				        Object[][] data = {
				                {1,2,3,"Single",8,"Wifi"}
				               };
JTable table = new JTable(new DefaultTableModel(data, columnNames));

				        // Add components to the frame
				        frame.setLayout(new GridLayout(3, 2));
				        frame.add(label);
				        frame.add(new JScrollPane(table)); // Use JScrollPane for the table

				        frame.setVisible(true);
	}}
