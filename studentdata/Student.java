package studentdata;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;

public class Student extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	Connection con=(Connection) JDBC.connect();

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 508);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(108, 59, 72, 24);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(214, 59, 172, 24);
		name.setBorder(null);
		name.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			}
		});
		contentPane.add(name);
		name.setColumns(10);
		
		
		JLabel lblNewLabel2=new JLabel("Gendar");
		lblNewLabel2.setBounds(108, 99, 72, 24);
		lblNewLabel2.setFont(new Font("Tahoma",Font.BOLD,12));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel2);
		
		final JRadioButton male = new JRadioButton("Male");
		male.setBounds(221, 100, 77, 23);
		male.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(male);
		
		final JRadioButton female = new JRadioButton("Female");
		female.setBounds(300, 99, 77, 23);
		female.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(female);
		
		final ButtonGroup gendar=new ButtonGroup();
		gendar.add(male);
		gendar.add(female);
		
		JLabel lblPLanguage = new JLabel("P Language");
		lblPLanguage.setBounds(108, 143, 82, 24);
		lblPLanguage.setHorizontalAlignment(SwingConstants.LEFT);
		lblPLanguage.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblPLanguage);
		
		JCheckBox corejava = new JCheckBox("Java");
		corejava.setBounds(221, 143, 65, 24);
		corejava.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(corejava);
		
		JCheckBox python = new JCheckBox("Python");
		python.setBounds(300, 143, 65, 24);
		python.setFont(new Font("Tahoma",Font.PLAIN, 12));
		contentPane.add(python);
		
		JCheckBox c = new JCheckBox("C");
		c.setBounds(377, 143, 65, 24);
		c.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(c);
		
		JCheckBox Cp=new JCheckBox("C++");
		Cp.setBounds(439, 143, 65, 24);
		Cp.setFont(new Font("Tahoma",Font.PLAIN,12));
		contentPane.add(Cp);
		
		final ButtonGroup planguage=new ButtonGroup();
		planguage.add(corejava);
 		planguage.add(python);
		planguage.add(c);
		planguage.add(Cp);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(108, 193, 82, 24);
		lblSubject.setHorizontalAlignment(SwingConstants.LEFT);
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblSubject);
		
		final JComboBox subject = new JComboBox();
		subject.setBounds(214, 193, 172, 24);
		subject.setModel(new DefaultComboBoxModel(new String[] {"Empty","Math", "English", "Chemistry","Computer Graphics","Operating System","C++"}));
		contentPane.add(subject);
		
		JLabel lblNewLabel3 =new JLabel("Address");
		lblNewLabel3.setBounds(108, 243, 82, 24);
		lblNewLabel3.setFont(new Font("Tahoma",Font.BOLD,12));
		lblNewLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel3);
		
		final JTextArea address = new JTextArea();
		address.setBounds(214, 243, 172, 70);
		contentPane.add(address);
		
		JButton register=new JButton("Register");
		register.setBounds(214, 340, 172, 24);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String n=name.getText().toString();
				String g=gendar.getSelection().toString();
				String c=planguage.getSelection().toString();
				String s=subject.getSelectedItem().toString();
				String a=address.getText().toString();
				try
				{
					String sql="insert into ardent4 (name, gendar, planguage, subject, address) value('"+n+"','"+g+"''"+c+"','"+s+"','"+a+"')";
					Statement st=(Statement) con.createStatement();
					int rs=st.executeUpdate(sql);
					if(rs==1)
					{
						JOptionPane.showMessageDialog(null ,"Data inserted");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Data not inserted");
					}
				}
				catch(Exception e3)
				{
					
				}
			}
		});
		contentPane.add(register);
		
	}
}
