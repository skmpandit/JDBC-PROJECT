package bankManagment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.sun.org.apache.xml.internal.security.c14n.helper.C14nHelper;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transactions extends JFrame implements ActionListener
{
	JLabel l1;
	JButton b1,b2,b3,b4,b5,b6,b7;
	
	Transactions()
	{
		setFont(new Font("System",Font.BOLD,22));
		Font f= getFont();
		FontMetrics fm=getFontMetrics(f);
		int x=fm.stringWidth("TRANSACTIONS");
		int y=fm.stringWidth(" ");
		int z=getWidth()-(3*x);
		int w=z/y;
		String pad="";
		//pad= String.format("%"+w+"s",pad);
		setTitle(pad+"TRANSACTIONS");
		
		l1 = new JLabel("Please select your transaction");
		l1.setFont(new Font("System",Font.BOLD,35));
		l1.setBounds(100, 50, 700, 45);
		add(l1);
		
		b1 = new JButton("DEPOSIT");
		b1.setFont(new Font("Raleway",Font.BOLD,18));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(100, 200, 220, 30);
		//b1.setOpaque(false);
		b1.setBorderPainted(false);
		b1.setFocusPainted(false);
		add(b1);
		
		b2 = new JButton("CASH WITHDRAWL");
		b2.setFont(new Font("Raleway",Font.BOLD,18));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(370, 200, 220, 30);
		b2.setBorderPainted(false);
		b2.setFocusPainted(false);
		add(b2);
		
		b3 = new JButton("FAST CASH");
		b3.setFont(new Font("Raleway",Font.BOLD,18));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(100, 275, 220, 30);
		b3.setBorderPainted(false);
		b3.setFocusPainted(false);
		add(b3);
		
		b4 = new JButton("MINI STATEMENT");
		b4.setFont(new Font("Raleway",Font.BOLD,18));
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.setBounds(370, 275, 220, 30);
		b4.setBorderPainted(false);
		b4.setFocusPainted(false);
		add(b4);
		
		b5 = new JButton("PIN CHANGE");
		b5.setFont(new Font("Raleway",Font.BOLD,18));
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.setBounds(100, 350, 220, 30);
		b5.setBorderPainted(false);
		b5.setFocusPainted(false);
		add(b5);
		
		b6 = new JButton("BALANCE ENQUARY");
		b6.setFont(new Font("Raleway",Font.BOLD,18));
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.setBounds(370, 350, 220, 30);
		b6.setBorderPainted(false);
		b6.setFocusPainted(false);
		add(b6);
		
		b7 = new JButton("EXIT");
		b7.setFont(new Font("Raleway",Font.BOLD,18));
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		b7.setBounds(230, 500, 222, 30);
		b7.setBorderPainted(false);
		b7.setFocusPainted(false);
		add(b7);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(700,700);
		setLocation(340,20);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			new Deposit().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b2)
		{
			new Withdrowl().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b3)
		{
			//new FastCash().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b4)
		{
			new Login().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b5)
		{
			new Pin().setVisible(true);
			setVisible(false);
		}
		else if(ae.getSource()==b6)
		{
			String pinn=JOptionPane.showInputDialog("Enter PIN");
			Conn c1 =new Conn();
			try
			{
				ResultSet rs=c1.s.executeQuery("SELECT balance FROM bank ORDER BY pin = '"+pinn+"' DESC LIMIT 1");
				if(rs.next())
				{
					String balance = rs.getString("balance");
					JOptionPane.showMessageDialog(null, "Your Account Balance is "+balance);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==b7)
		{
			System.exit(0);
		}
	}
	public static void main(String[] args) 
	{
		new Transactions().setVisible(true);
	}
}
