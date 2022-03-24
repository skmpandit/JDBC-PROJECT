package bankManagment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Withdrowl extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JButton withdrowl,back,exit;
	JTextField pin,withdrowl1;
	Withdrowl()
	{
		setFont(new Font("System",Font.BOLD,22));
		Font f= getFont();
		FontMetrics fm=getFontMetrics(f);
		int x=fm.stringWidth("WITHDROWL");
		int y=fm.stringWidth(" ");
		int z=getWidth()-(3*x);
		int w=z/y;
		String pad="";
		//pad= String.format("%"+w+"s",pad);
		setTitle(pad+"WITHDROWL");
		
		l3 = new JLabel("YOUR DIALY TRANSACTION LIMIT IS 10,000");
		l3.setFont(new Font("Raleway",Font.BOLD,22));
		l3.setBounds(120, 80, 600, 30);
		add(l3);
		
		l1 = new JLabel("ENTER AMOUNT YOU WANT TO WITHDROWL");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(120, 150, 600, 30);
		add(l1);
		
		withdrowl1 = new JTextField();
		withdrowl1.setBounds(170, 250, 330, 30);
		add(withdrowl1);
		
		l2 = new JLabel("Enter PIN");
		l2.setFont(new Font("Raleway",Font.BOLD,15));
		l2.setBounds(530, 10, 80, 20);
		add(l2);
		
		pin = new JTextField();
		pin.setBounds(630, 10, 40, 20);
		add(pin);
		
		withdrowl = new JButton("WITHDROWL");
		withdrowl.setFont(new Font("Raleway",Font.BOLD,15));
		withdrowl.setBounds(170, 330, 150, 35);
		withdrowl.setFocusPainted(false);
		withdrowl.setBorderPainted(false);
		withdrowl.setBackground(Color.GREEN);
		withdrowl.setForeground(Color.WHITE);
		add(withdrowl);
		
		back = new JButton("BACK");
		back.setFont(new Font("Raleway",Font.BOLD,15));
		back.setBounds(350, 330, 150, 35);
		back.setBackground(Color.YELLOW);
		back.setForeground(Color.WHITE);
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		add(back);
		
		exit = new JButton("EXIT");
		exit.setFont(new Font("Raleway",Font.BOLD,15));
		exit.setBounds(260, 420, 150, 35);
		exit.setBackground(Color.RED);
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setForeground(Color.WHITE);
		add(exit);
		
		withdrowl.addActionListener(this);
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
			String a = withdrowl1.getText();
			String b = pin.getText();
			
			if(ae.getSource()==withdrowl)
			{
				if(withdrowl.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please enter the Amount to you want to Withdrowl");
				}
				else
				{
					Conn c1 = new Conn();
					ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+b+"'");
					double balance=0;
					if(rs.next())
					{
						String pin = rs.getString("pin");
						balance = rs.getDouble("balance");
						double d=Double.parseDouble(a);
						balance-=d;
						String q1 = "insert into bank values('"+pin+"',null,'"+d+"','"+balance+"')";
						c1.s.executeUpdate(q1);
					}
					JOptionPane.showMessageDialog(null, "Rs "+a+" Debited Successfully");
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
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	public static void main(String[] args)
	{
		new Withdrowl().setVisible(true);
	}
	
}
