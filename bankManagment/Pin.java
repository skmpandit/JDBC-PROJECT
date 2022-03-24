package bankManagment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JTextField curpin,newpin,repin;
	JButton save,back;
	Pin()
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
		
		
		l1 = new JLabel("CHANGE YOU PIN");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(140, 20, 300, 30);
		add(l1);
		
		l2 = new JLabel("Current PIN :");
		l2.setFont(new Font("Raleway",Font.BOLD,18));
		l2.setBounds(70, 90, 150, 25);
		add(l2);
		
		curpin = new JTextField();
		curpin.setFont(new Font("Raleway",Font.BOLD,18));
		curpin.setBounds(200, 90, 200, 25);
		add(curpin);
		
		l3 = new JLabel("New PIN :");
		l3.setFont(new Font("Raleway",Font.BOLD,18));
		l3.setBounds(70, 150, 150, 25);
		add(l3);
		
		newpin = new JTextField();
		newpin.setFont(new Font("Raleway",Font.BOLD,18));
		newpin.setBounds(200, 150, 200, 25);
		add(newpin);
		
		l4 = new JLabel("Re-enter PIN :");
		l4.setFont(new Font("Raleway",Font.BOLD,18));
		l4.setBounds(70, 210, 150, 25);
		add(l4);
		
		repin = new JTextField();
		repin.setFont(new Font("Raleway",Font.BOLD,18));
		repin.setBounds(200, 210, 200, 25);
		add(repin);
		
		save = new JButton("SAVE");
		save.setFont(new Font("Raleway",Font.BOLD,18));
		save.setBounds(100, 290, 100, 25);
		save.setBorderPainted(false);
		save.setFocusPainted(false);
		save.setBackground(Color.GREEN);
		save.setForeground(Color.WHITE);
		add(save);
		
		
		back = new JButton("BACK");
		back.setFont(new Font("Raleway",Font.BOLD,18));
		back.setBounds(270, 290, 100, 25);
		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setBackground(Color.BLUE);
		back.setForeground(Color.WHITE);
		add(back);
		
		
		save.addActionListener(this);
		back.addActionListener(this);
		
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
			String a = curpin.getText();
			String b = newpin.getText();
			String c = repin.getText();
			
			if(ae.getSource()==save)
			{
				if(curpin.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter the Current PIN");
				}
				if(newpin.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter the New PIN");
				}
				if(repin.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Plase enter the Re-enter PIN");
				}
				if(newpin.getText().equals(repin.getText()))
				{
					Conn c1 = new Conn();
					String q1 = "update bank set pin = '"+b+"' where pin ='"+a+"'";
					String q2 = "update login set pin = '"+b+"' where pin ='"+a+"'";
					String q3 = "update signup3 set pin = '"+b+"' where pen = '"+a+"'";
					c1.s.executeUpdate(q1);
					c1.s.executeUpdate(q2);
					c1.s.executeUpdate(q3);
					JOptionPane.showMessageDialog(null, "PIN Change Successfully");
					new Transactions().setVisible(true);
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "PIN entered doesn't matched");
				}
			}
			else if(ae.getSource()==back)
			{
				new Transactions().setVisible(true);
				setVisible(false);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new Pin().setVisible(true);
	}
}
