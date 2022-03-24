package bankManagment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JTextField pin;
	JButton b100,b500,b1000,b2000,b5000,b10000,exit;
	
	
	FastCash()
	{
		setFont(new Font("System",Font.BOLD,22));
		Font f= getFont();
		FontMetrics fm=getFontMetrics(f);
		int x=fm.stringWidth("FAST CASH");
		int y=fm.stringWidth(" ");
		int z=getWidth()-(3*x);
		int w=z/y;
		String pad="";
		//pad= String.format("%"+w+"s",pad);
		setTitle(pad+"FAST CASH");
		
		l2 = new JLabel("Enter PIN");
		l2.setFont(new Font("Raleway",Font.BOLD,13));
		l2.setBounds(360, 10, 80, 20);
		add(l2);
		
		pin = new JTextField();
		pin.setBounds(430, 10, 40, 20);
		add(pin);
		
		l1 = new JLabel("SELECT WITHDROWL AMOUNT");
		l1.setFont(new Font("Raleway",Font.BOLD,25));
		l1.setBounds(50, 50, 500, 35);
		add(l1);
		
		b100 = new JButton("Rs 100");
		b100.setFont(new Font("Raleway",Font.BOLD,18));
		b100.setBounds(80, 110, 120, 30);
		b100.setBackground(Color.BLUE);
		b100.setForeground(Color.WHITE);
		b100.setBorderPainted(false);
		b100.setFocusPainted(false);
		add(b100);
		
		b500 = new JButton("Rs 500");
		b500.setFont(new Font("Raleway",Font.BOLD,18));
		b500.setBounds(270, 110, 120, 30);
		b500.setBackground(Color.BLUE);
		b500.setForeground(Color.WHITE);
		b500.setFocusPainted(false);
		b500.setBorderPainted(false);
		add(b500);
		
		b1000 = new JButton("Rs 1000");
		b1000.setFont(new Font("Raleway",Font.BOLD,18));
		b1000.setBounds(80, 170, 120, 30);
		b1000.setBackground(Color.BLUE);
		b1000.setForeground(Color.WHITE);
		b1000.setBorderPainted(false);
		b1000.setFocusPainted(false);
		add(b1000);
		
		b2000 = new JButton("Rs 2000");
		b2000.setFont(new Font("Raleway",Font.BOLD,18));
		b2000.setBounds(270, 170, 120, 30);
		b2000.setBackground(Color.BLUE);
		b2000.setForeground(Color.WHITE);
		b2000.setBorderPainted(false);
		b2000.setFocusPainted(false);
		add(b2000);
		
		b5000 = new JButton("Rs 5000");
		b5000.setFont(new Font("Raleway",Font.BOLD,18));
		b5000.setBounds(80, 230, 120, 30);
		b5000.setBackground(Color.BLUE);
		b5000.setForeground(Color.WHITE);
		b5000.setBorderPainted(false);
		b5000.setFocusPainted(false);
		add(b5000);
		
		b10000 = new JButton("Rs 10000");
		b10000.setFont(new Font("Raleway",Font.BOLD,18));
		b10000.setBounds(270, 230, 120, 30);
		b10000.setBackground(Color.BLUE);
		b10000.setForeground(Color.WHITE);
		b10000.setBorderPainted(false);
		b10000.setFocusPainted(false);
		add(b10000);
		
		exit = new JButton("EXIT");
		exit.setFont(new Font("Raleway",Font.BOLD,18));
		exit.setBounds(180, 300, 120, 30);
		exit.setBackground(Color.GREEN);
		exit.setForeground(Color.WHITE);
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		add(exit);
		
		b100.addActionListener(this);
		b500.addActionListener(this);
		b1000.addActionListener(this);
		b2000.addActionListener(this);
		b5000.addActionListener(this);
		b10000.addActionListener(this);
		exit.addActionListener(this);
		
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(500,500);
		setLocation(340,20);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			String a = pin.getText();
			double balance = 0;
			if(ae.getSource()==b100)
			{
				Conn c1= new Conn();
				ResultSet rs= c1.s.executeQuery("select * from bank where pin='"+a+"'");
				if(rs.next())
				{
					String pin=rs.getString("pin");
					balance = rs.getDouble("balance");
					balance-=100;
					String q1 = "insert into bank values('"+pin+"',null,100,'"+balance+"')";
					c1.s.executeUpdate(q1);
				}
				JOptionPane.showMessageDialog(null, "Rs. "+100+" Debited Successfully");
				new Transactions().setVisible(true);
				setVisible(false);
			}
			else if(ae.getSource()==b500)
			{
				Conn c1 = new Conn();
				ResultSet rs = c1.s.executeQuery("select * from bank where pin='"+a+"'");
				if(rs.next())
				{
					String pin = rs.getString("pin");
					balance = rs.getDouble("balance");
					balance-=500;
					String q1 = "insert into bank values('"+pin+"',null,500,'"+balance+"')";
					c1.s.executeUpdate(q1);
				}
				JOptionPane.showMessageDialog(null, "Rs. "+500+" Debited Successfully");
				new Transactions().setVisible(true);
				setVisible(false);
			}
			else if(ae.getSource()==b1000)
			{
				Conn c1 = new Conn();
				ResultSet rs = c1.s.executeQuery("select * from bank where pin='"+a+"'");
				if(rs.next())
				{
					String pin = rs.getString("pin");
					balance = rs.getDouble("balance");
					balance-=1000;
					String q1 = "insert into bank values('"+pin+"',null,1000,'"+balance+"')";
					c1.s.executeUpdate(q1);
				}
				JOptionPane.showMessageDialog(null, "Rs. "+1000+" Debited Successfully");
				new Transactions().setVisible(true);
				setVisible(false);
			}
			else if(ae.getSource()==b2000)
			{
				Conn c1 = new Conn();
				ResultSet rs = c1.s.executeQuery("select * from bank where pin='"+a+"'");
				if(rs.next())
				{
					String pin = rs.getString("pin");
					balance = rs.getDouble("balance");
					balance-=2000;
					String q1 = "insert into bank values('"+pin+"',null,2000,'"+balance+"')";
					c1.s.executeUpdate(q1);
				}
				JOptionPane.showMessageDialog(null, "Rs. "+2000+" Debited Successfully");
				new Transactions().setVisible(true);
				setVisible(false);
			}
			else if(ae.getSource()==b5000)
			{
				Conn c1 = new Conn();
				ResultSet rs = c1.s.executeQuery("select * from bank where pin='"+a+"'");
				if(rs.next())
				{
					String pin = rs.getString("pin");
					balance = rs.getDouble("balance");
					balance-=5000;
					String q1 = "insert into bank values('"+pin+"',null,5000,'"+balance+"')";
					c1.s.executeUpdate(q1);
				}
				JOptionPane.showMessageDialog(null, "Rs. "+5000+" Debited Successfully");
				new Transactions().setVisible(true);
				setVisible(false);
			}
			else if(ae.getSource()==b10000)
			{
				Conn c1 = new Conn();
				ResultSet rs = c1.s.executeQuery("select * from bank where pin='"+a+"'");
				if(rs.next())
				{
					String pin = rs.getString("pin");
					balance = rs.getDouble("balance");
					balance-=10000;
					String q1 = "insert into bank values('"+pin+"',null,10000,'"+balance+"')";
					c1.s.executeUpdate(q1);
				}
				JOptionPane.showMessageDialog(null, "Rs. "+10000+" Debited Successfully");
				new Transactions().setVisible(true);
				setVisible(false);
			}
			else if(ae.getSource()==exit)
			{
				System.exit(0);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new FastCash().setVisible(true);
	}
}
