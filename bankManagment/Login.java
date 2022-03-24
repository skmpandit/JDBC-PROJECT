package bankManagment;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	JLabel l1,l2,l3;
	JTextField card;
	JPasswordField pin;
	JButton sign,clear,signup;
	Login()
	{
		setFont(new Font("System",Font.BOLD,22));
		Font f=getFont();
		FontMetrics fm=getFontMetrics(f);
		int x=fm.stringWidth("AUTOMATED TELLER MACHINE");
		int y=fm.stringWidth(" ");
		int z=getWidth()-x;
		int w=z/y;
		String pad="";
		//pad = String.format("%"+w+"s",pad);
		setTitle(pad+"AUTOMATED TELLER MACHINE");
		
		
		l1 = new JLabel("WELCOME OT ATM");
		l1.setFont(new Font("Raleway",Font.BOLD,35));
		l1.setBounds(170, 50, 450, 40);
		add(l1);
		
		l2 = new JLabel("CARD NO :");
		l2.setFont(new Font("Raleway",Font.BOLD,25));
		l2.setBounds(70, 170, 200, 30);
		add(l2);
		
		card = new JTextField();
		card.setBounds(260, 170, 300, 30);
		card.setFont(new Font("Raleway",Font.BOLD,25));
		add(card);
		 
		
		l3 = new JLabel("PIN :");
		l3.setFont(new Font("Raleway",Font.BOLD,25));
		l3.setBounds(70, 240, 200, 30);
		add(l3);
		
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,25));
		pin.setBounds(260, 240, 300, 30);
		add(pin);
		 
		
		sign=new JButton("SIGN IN");
		sign.setFont(new Font("Arial",Font.BOLD,14));
		sign.setBounds(300, 400, 100, 30);
		sign.setBackground(Color.GREEN);
		sign.setForeground(Color.WHITE);
		sign.setBorderPainted(false);
		sign.setFocusPainted(false);
		add(sign);
		
		clear=new JButton("CLEAR");
		clear.setFont(new Font("Arial",Font.BOLD,14));
		clear.setBounds(430, 400, 100, 30);
		clear.setBackground(Color.RED);
		clear.setForeground(Color.WHITE);
		clear.setBorderPainted(false);
		clear.setFocusPainted(false);
		add(clear);
		
		signup=new JButton("SIGN UP");
		signup.setFont(new Font("Arial",Font.BOLD,14));
		signup.setBounds(300, 450, 230, 30);
		signup.setBackground(Color.BLUE);
		signup.setForeground(Color.WHITE);
		signup.setBorderPainted(false);
		signup.setFocusPainted(false);
		add(signup);
		
		setLayout(null);
		
		
		sign.addActionListener(this);
		clear.addActionListener(this);
		signup.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(700,700);
		setLocation(340,20);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			Conn c1=new Conn();
			String a=card.getText();
			String b=pin.getPassword().toString();
			
			if(ae.getSource()==sign)
			{
				String q="select * from login where cardno='"+a+"' and pin='"+b+"'";
				ResultSet rs=c1.s.executeQuery(q);
				if(rs.next())
				{
					new Transactions().setVisible(true);
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect card number or password");
				}
			}
			else if(ae.getSource()==clear)
			{
				card.setText(null);
				pin.setText(null);
			}
			else if(ae.getSource()==signup)
			{
				new Signup().setVisible(true);
				setVisible(false);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error"+e);
		}
	}
	public static void main(String[] args)
	{
		new Login().setVisible(true);
	}
}
