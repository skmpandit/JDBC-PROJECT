package Employeedata;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Employee extends JFrame {

	private JPanel contentPane;
	private JTextField employeename;
	private JTextField employeeid;
	private JTextField email;
	private JTextField username;
	private JPasswordField password;
	private JTextArea address;
	Connection con=JDBC.connect();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
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
	public Employee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Employee Data Managment");
		setBounds(100, 30, 650, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(79, 52, 125, 28);
		contentPane.add(lblNewLabel);
		
		employeename = new JTextField();
		employeename.setBounds(249, 52, 179, 28);
		contentPane.add(employeename);
		employeename.setColumns(10);
		
		JLabel lblNewLabel1=new JLabel("Employee Id");
		lblNewLabel1.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel1.setBounds(79, 102, 125, 28);
		contentPane.add(lblNewLabel1);
		
		employeeid =new JTextField();
		employeeid.setBounds(249, 102, 179, 28);
		contentPane.add(employeeid);
		employeeid.setColumns(10);
		
		JLabel lblNewLabel2 = new JLabel("Department");
		lblNewLabel2.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel2.setBounds(79, 152, 125, 28);
		contentPane.add(lblNewLabel2);
		
		final JComboBox department = new JComboBox();
		department.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		department.setModel(new DefaultComboBoxModel(new String[] {"Manager","Worker","HR","CEO","Helper"}));
		department.setBounds(249, 152, 179, 28);
		contentPane.add(department);
		
		JLabel lblNewLabel3 = new JLabel("E-mail");
		lblNewLabel3.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel3.setBounds(79, 202, 125, 28);
		contentPane.add(lblNewLabel3);
		
		email = new JTextField();
		email.setBounds(249, 202, 179, 28);
		contentPane.add(email);
		
		JLabel lblNewLabel4 = new JLabel("User Name");
		lblNewLabel4.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel4.setBounds(79, 252 , 125, 28);
		contentPane.add(lblNewLabel4);
		
		username = new JTextField();
		username.setBounds(249, 252, 179, 28);
		contentPane.add(username);
		
		JLabel lblNewLabel5 = new JLabel("Password");
		lblNewLabel5.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel5.setBounds(79, 302, 125, 28);
		contentPane.add(lblNewLabel5);
		
		password = new JPasswordField();
		password.setBounds(249, 302, 179, 28);
		contentPane.add(password);
		
		JLabel lblNewLabel6 = new JLabel("Address");
		lblNewLabel6.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel6.setBounds(79, 352, 125, 28);
		contentPane.add(lblNewLabel6);
		
		address = new JTextArea();
		address.setBounds(249, 352, 179, 100);
		contentPane.add(address);
		
		JButton button = new JButton("Register");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String en=employeename.getText().toString();
				String ei=employeeid.getText().toString();
				String dp=department.getSelectedItem().toString();
				String eml=email.getText().toString();
				String un=username.getText().toString();
				String p=password.getPassword().toString();
				String a=address.getText().toString();
				try
				{
					String sql="insert into ardent (employeename, employeeid, department, email, username, password, address) value('"+en+"','"+ei+"','"+dp+"','"+eml+"','"+un+"','"+p+"','"+a+"')";
					Statement stmnt=(Statement) con.createStatement();
					int sr=stmnt.executeUpdate(sql);
					if(sr==1)
					{
						JOptionPane.showMessageDialog(null, "Date Inserted");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Date not Inserted");
					}
					employeename.setText("");
					employeeid.setText("");
					department.setSelectedItem("");
					email.setText("");
					username.setText("");
					password.setText("");
					address.setText("");
				}
				catch(Exception e3)
				{
					 
				}
			}
		});
		button.setBounds(249, 475, 179, 28);
		contentPane.add(button);
		
	}

}
