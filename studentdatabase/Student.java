package studentdatabase;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Student extends JFrame {

	private JPanel contentPane;
	private JTextField studentname;
	private JTextField fathername;
	private JTextField rollnumber;
	private JTextField email;
	private JPasswordField password;
	private JTextArea address;
	Connection con=(Connection) JDBC.connect();
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Student() {
		setTitle("Student Data Managment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel1=new JLabel("Student Name");
		lblNewLabel1.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel1.setBounds(79, 34, 110, 25);
		contentPane.add(lblNewLabel1);
		
		studentname=new JTextField();
		studentname.setBounds(219, 34, 200, 28);
		contentPane.add(studentname);
		studentname.setColumns(10);
		
		JLabel lblNewLabel2=new JLabel("Father Name");
		lblNewLabel2.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel2.setBounds(79, 84, 110, 25);
		contentPane.add(lblNewLabel2);
		
		fathername=new JTextField();
		fathername.setBounds(219, 84, 200, 28);
		contentPane.add(fathername);
		fathername.setColumns(10);
		
		JLabel lblNewLabel3=new JLabel("Roll Number");
		lblNewLabel3.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel3.setBounds(79, 134, 110, 25);
		contentPane.add(lblNewLabel3);
		
		rollnumber=new JTextField();
		rollnumber.setBounds(219, 134, 200, 28);
		contentPane.add(rollnumber);
		fathername.setColumns(10);
		
		JLabel lblNewLabel4=new JLabel("E-mail");
		lblNewLabel4.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel4.setBounds(79, 184, 110, 25);
		contentPane.add(lblNewLabel4);
		
		email=new JTextField();
		email.setBounds(219, 184, 200, 28);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserName.setBounds(79, 234, 110, 25);
		contentPane.add(lblUserName);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(219, 234, 200, 28);
		contentPane.add(username);
		
		JLabel lblNewLabel5=new JLabel("Password");
		lblNewLabel5.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel5.setBounds(79, 284, 110, 25);
		contentPane.add(lblNewLabel5);
		
		password=new JPasswordField();
		password.setBounds(219, 284, 200, 28);
		contentPane.add(password);
		email.setColumns(10);
		
		JLabel lblNewLabel6=new JLabel("Stream");
		lblNewLabel6.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel6.setBounds(79, 334, 110, 25);
		contentPane.add(lblNewLabel6);
		
		final JComboBox stream=new JComboBox();
		stream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		stream.setModel(new DefaultComboBoxModel(new String[] {"BCA","BBA","BTECH","MTECH","MCA"}));
		stream.setBounds(219, 334, 200, 28);
		contentPane.add(stream);
		
		JLabel lblNewLabel7=new JLabel("Semester");
		lblNewLabel7.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel7.setBounds(79, 384, 110, 25);
		contentPane.add(lblNewLabel7);
		
		final JComboBox semester=new JComboBox();
		semester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		semester.setModel(new DefaultComboBoxModel(new String[] {"1ST","2ND","3RD","4TH","5TH","6TH","7TH","8TH"}));
		semester.setBounds(219, 384, 200, 28);
		contentPane.add(semester);
		
		JLabel lblNewLabel8=new JLabel("Address");
		lblNewLabel8.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel8.setBounds(79, 434, 110, 25);
		contentPane.add(lblNewLabel8);
		
		
		address=new JTextArea();
		address.setBounds(219, 434, 200, 100);
		contentPane.add(address);
		address.setColumns(10);
		
		JButton btnNewButton=new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String sn=studentname.getText().toString();
				String fn=fathername.getText().toString();
				String rn=rollnumber.getText().toString();
				String eml=email.getText().toString();
				String un=username.getText().toString();
				String p=password.getPassword().toString();
				String st=stream.getSelectedItem().toString();
				String sm=semester.getSelectedItem().toString();
				String as=address.getText().toString();
				try
				{
					String sql="insert into ardent5 (studentname, fathername, rollnumber, email, username, password, stream, semester, address) value('"+sn+"','"+fn+"','"+rn+"','"+eml+"','"+un+"','"+p+"','"+st+"','"+sm+"','"+as+"')";
					Statement stmt=(Statement) con.createStatement();
					int sr=stmt.executeUpdate(sql);
					if(sr==1)
					{
						JOptionPane.showMessageDialog(null, "Data inserted");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Data not inserted");
					}
					studentname.setText("");
					fathername.setText("");
					rollnumber.setText("");
					email.setText("");
					username.setText("");
					password.setText("");
					stream.setSelectedItem("");
					semester.setSelectedItem("");
					address.setText("");
				}
				catch(Exception e3)
				{
					
				}
			}
		});
		btnNewButton.setBounds(219, 566, 200, 28);
		contentPane.add(btnNewButton);
		
	}
}
