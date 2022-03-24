package bankManagment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Deposit extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JTextField amount,pin;
	JButton deposit,back,exit;
	Deposit()
	{
		setFont(new Font("System",Font.BOLD,22));
		Font f= getFont();
		FontMetrics fm=getFontMetrics(f);
		int x=fm.stringWidth("DEPOSIT");
		int y=fm.stringWidth(" ");
		int z=getWidth()-(3*x);
		int w=z/y;
		String pad="";
		//pad= String.format("%"+w+"s",pad);
		setTitle(pad+"DEPOSIT");
		
		l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(120, 80, 600, 30);
		add(l1);
		
		amount = new JTextField();
		amount.setBounds(170, 200, 330, 30);
		add(amount);
		
		l2 = new JLabel("Enter PIN");
		l2.setFont(new Font("Raleway",Font.BOLD,15));
		l2.setBounds(530, 10, 80, 20);
		add(l2);
		
		pin = new JTextField();
		pin.setBounds(630, 10, 40, 20);
		add(pin);
		
		deposit = new JButton("DEPOSIT");
		deposit.setFont(new Font("Raleway",Font.BOLD,15));
		deposit.setBounds(170, 280, 150, 35);
		deposit.setFocusPainted(false);
		deposit.setBorderPainted(false);
		deposit.setBackground(Color.GREEN);
		deposit.setForeground(Color.WHITE);
		add(deposit);
		
		back = new JButton("BACK");
		back.setFont(new Font("Raleway",Font.BOLD,15));
		back.setBounds(350, 280, 150, 35);
		back.setBackground(Color.YELLOW);
		back.setForeground(Color.WHITE);
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		add(back);
		
		exit = new JButton("EXIT");
		exit.setFont(new Font("Raleway",Font.BOLD,15));
		exit.setBounds(260, 370, 150, 35);
		exit.setBackground(Color.RED);
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setForeground(Color.WHITE);
		add(exit);
		
		
		deposit.addActionListener(this);
		back.addActionListener(this);
		exit.addActionListener(this);
		
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(700,700);
		setLocation(340,20);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			String a = amount.getText();
			String b = pin.getText();
			
			if(ae.getSource()==deposit)
			{
				if(amount.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
				}
				else
				{
					Conn c1 = new Conn();
					ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+b+"' ");
					double balance=0;
					if(rs.next())
					{
						String pin= rs.getString("pin");
						balance = rs.getDouble("balance");
						double d = Double.parseDouble(a);
						balance+=d;
						String q1= "insert into bank values('"+pin+"','"+d+"',null,'"+balance+"')";
						c1.s.executeUpdate(q1);
					}
					JOptionPane.showMessageDialog(null,"Rs. '"+a+"' Deposit SuccessFully");
					new Transactions().setVisible(true);	
					setVisible(false);
				}
			}
			else if(ae.getSource()==back)
			{
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
		new Deposit().setVisible(true);
	}
}
