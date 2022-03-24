package Database;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class JDBCPROJECT extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JPasswordField password;
	Connection con=(Connection) JDBC.connect();
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDBCPROJECT frame = new JDBCPROJECT();
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
	public JDBCPROJECT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(69, 34, 93, 25);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(199, 34, 190, 28);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1=new JLabel("E-mail");
		lblNewLabel_1.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(69, 84, 93, 25);
		contentPane.add(lblNewLabel_1);
		
		email=new JTextField();
		email.setBounds(199, 84, 190, 28);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_2=new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(69, 185, 93, 25);
		contentPane.add(lblNewLabel_2);
		
		password=new JPasswordField();
		password.setBounds(199, 184, 190, 28);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_4=new JLabel("Gendar");
		lblNewLabel_4.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(69, 244, 93, 25);
		contentPane.add(lblNewLabel_4);
		
		final JComboBox gendar=new JComboBox();
		gendar.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e)
		 {
			 
		 }
		});
		gendar.setModel(new DefaultComboBoxModel(new String[] {"Male","Female"}));
		gendar.setBounds(199, 243, 190, 28);
		contentPane.add(gendar);
		
		JLabel lblNewLabel_3=new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Tahoma",Font.BOLD,13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(69, 305, 93, 25);
		contentPane.add(lblNewLabel_3);
		
		final JTextArea address=new JTextArea();
		address.setBounds(199, 305, 190, 64);
		contentPane.add(address);
		
		JButton btnNewJButton=new JButton("Register");
		btnNewJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String n=name.getText().toString();
				String el=email.getText().toString();
				String un=username.getText().toString();
				String p=password.getPassword().toString();
				String g=gendar.getSelectedItem().toString();
				String a=address.getText().toString();
				try
				{
					String sql="insert into ardent2 (name, email, username, password, gendar, address) value('"+n+"','"+el+"','"+un+"','"+p+"','"+g+"','"+a+"')";
					Statement st=(Statement) con.createStatement();
					int sr=st.executeUpdate(sql);
					if(sr==1)
					{
						JOptionPane.showMessageDialog(null, "Date Inserted");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Date not Inserted");
					}
					name.setText("");
					email.setText("");
					username.setText("");
					password.setText("");
					gendar.setSelectedItem("");
					address.setText("");
				}
				catch(Exception e3)
				{
					
				}
			}
		});
		btnNewJButton.setBounds(199, 398 ,190, 28);
		contentPane.add(btnNewJButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("User Name");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(69, 132, 93, 25);
		contentPane.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(199, 131, 190, 28);
		contentPane.add(username);
		
	}
}
