package JDBC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JDBCDemo extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JPasswordField password;
	private JComboBox gendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDBCDemo frame = new JDBCDemo();
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
	Connection con=null;
	public JDBCDemo() {
		con=(Connection) JDBC.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(71, 99, 93, 27);
		contentPane.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setBounds(186, 41, 167, 27);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(71, 39, 93, 27);
		contentPane.add(lblNewLabel_1);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(186, 99, 167, 27);
		contentPane.add(email);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(71, 156, 93, 27);
		contentPane.add(lblNewLabel_3);
		
		password = new JPasswordField();
		password.setBounds(186, 156, 167, 25);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Gender");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(71, 202, 93, 27);
		contentPane.add(lblNewLabel_3_1);
		
		final JComboBox gendar = new JComboBox();
		gendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		gendar.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gendar.setBounds(186, 206, 167, 27);
		contentPane.add(gendar);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(71, 261, 93, 27);
		contentPane.add(lblAddress);
		
		final JTextArea address = new JTextArea();
		address.setBounds(186, 261, 167, 63);
		contentPane.add(address);
		address.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String n=name.getText();
					String el=email.getText();
					String p=password.getText();
					String g=(String) gendar.getSelectedItem();
					String a=address.getText();
						PreparedStatement pst=(PreparedStatement) con.prepareStatement("insert into signupdata(name,email,password,gender,address) values(?,?,?,?,?)");
						pst.setString(1, n);
						pst.setString(2, el);
						pst.setString(3,p);
						pst.setString(4, g);
						pst.setString(5, a);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Date added");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setBounds(186, 352, 167, 27);
		contentPane.add(btnNewButton);
		
	}
}
