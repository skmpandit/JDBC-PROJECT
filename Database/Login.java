package Database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField userpassword;
	Connection con=(Connection) JDBC.connect();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(148, 11, 151, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(72, 151, 95, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("User Name");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(72, 95, 95, 25);
		contentPane.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setBounds(165, 95, 172, 25);
		contentPane.add(username);
		username.setColumns(10);
		
		userpassword = new JPasswordField();
		userpassword.setBounds(165, 151, 172, 25);
		contentPane.add(userpassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Sonu Kumar Mahto\\Pictures\\sign.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String un=username.getText().toString();
					String up=userpassword.getPassword().toString();
					PreparedStatement st=(PreparedStatement) con.prepareStatement("select * from ardentdatabase where username=? and password=?");
					ResultSet r=(ResultSet) st.executeQuery();
					if(r.next())
					{
						successpage s=new successpage();
						 s.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Incorrect id or password");
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(169, 209, 168, 59);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("redio");
		rdbtnNewRadioButton.setBounds(174, 275, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnRedio = new JRadioButton("redio 1");
		rdbtnRedio.setBounds(323, 275, 109, 23);
		contentPane.add(rdbtnRedio);
	}
}
