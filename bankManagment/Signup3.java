package bankManagment;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JRadioButton r1,r2,r3,r4;
	JButton b1,b2;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JTextField t1;
	
	Signup3()
	{
		setFont(new Font("System",Font.BOLD,22));
		Font f=getFont();
		FontMetrics fm=getFontMetrics(f);
		int x=fm.stringWidth("NEW ACCOUNT APLICATION FORM - PAGE 3");
		int y=fm.stringWidth(" ");
		int z=getWidth()/2-(x/2);
		int w=z/y;
		String pad="";
		//for (int i=0; i!=w; i++) pad +=" "; 
		//pad =String.format("%"+w+"s",pad);
		setTitle(pad+"NEW ACCOUNT APLICATION FORM - PAGE 3");
		
		l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280, 40, 400, 40);
		add(l1);
		
		l2 = new JLabel("Account Type:");
		l2.setFont(new Font("Raleway",Font.BOLD,18));
		l2.setBounds(100, 120, 200, 30);
		add(l2);
		
		l3 = new JLabel("Card Number:");
		l3.setFont(new Font("Raleway",Font.BOLD,18));
		l3.setBounds(100, 270, 200,30);
		add(l3);
		
		l4 = new JLabel("XXXX-XXXX-XXXX-4102");
		l4.setFont(new Font("Raleway",Font.BOLD,18));
		l4.setBounds(330, 270, 250, 30);
		add(l4);
		
		l5 = new JLabel("Your 16-digit Card Number");
		l5.setFont(new Font("Raleway",Font.BOLD,12));
		l5.setBounds(100, 300, 200, 30);
		add(l5);
		
		l6 = new JLabel("If would appear on ATM Card/Check Book and Statements");
		l6.setFont(new Font("Raleway",Font.BOLD,12));
		l6.setBounds(330, 300, 500, 30);
		add(l6);
		
		l7 = new JLabel("PIN:");
		l7.setFont(new Font("Raleway",Font.BOLD,18));
		l7.setBounds(100, 340, 200, 30);
		add(l7);
		
		l8 = new JLabel("XXXX");
		l8.setFont(new Font("Raleway",Font.BOLD,18));
		l8.setBounds(330, 340, 200, 30);
		add(l8);
		
		l9 = new JLabel("4-digit password");
		l9.setFont(new Font("Raleway",Font.BOLD,12));
		l9.setBounds(100, 370, 200, 30);
		add(l9);
		
		l10 = new JLabel("Services Required");
		l10.setFont(new Font("Raleway",Font.BOLD,18));
		l10.setBounds(100, 420, 200, 30);
		add(l10);
		
		l11 = new JLabel("Form No:");
		l11.setFont(new Font("Raleway",Font.BOLD,14));
		l11.setBounds(700, 10, 70, 30);
		add(l11);
		
		b1 = new JButton("Submit");
		b1.setFont(new Font("Raleway",Font.BOLD,14));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(300, 650, 100, 30);
		b1.setFocusPainted(false);
		b1.setBorderPainted(false);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setFont(new Font("Raleway",Font.BOLD,14));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(420, 650, 100, 30);
		b2.setFocusPainted(false);
		b2.setBorderPainted(false);
		add(b2);
		
		c1 = new JCheckBox("ATM CARD");
		c1.setFont(new Font("Raleway",Font.BOLD,16));
		c1.setBackground(Color.WHITE);
		c1.setBounds(100, 470, 200, 30);
		c1.setFocusPainted(false);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setFont(new Font("Raleway",Font.BOLD,16));
		c2.setBackground(Color.WHITE);
		c2.setBounds(350, 470, 200, 30);
		c2.setFocusPainted(false);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setFont(new Font("Raleway",Font.BOLD,16));
		c3.setBackground(Color.WHITE);
		c3.setBounds(100, 520, 200, 30);
		c3.setFocusPainted(false);
		add(c3);
		
		c4 = new JCheckBox("EMAIL Alert");
		c4.setFont(new Font("Raleway",Font.BOLD,16));
		c4.setBackground(Color.WHITE);
		c4.setBounds(350, 520, 200, 30);
		c4.setFocusPainted(false);
		add(c4);
		
		c5 = new JCheckBox("Check Book");
		c5.setFont(new Font("Raleway",Font.BOLD,16));
		c5.setBackground(Color.WHITE);
		c5.setBounds(100, 570, 200, 30);
		c5.setFocusPainted(false);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setFont(new Font("Raleway",Font.BOLD,16));
		c6.setBackground(Color.WHITE);
		c6.setBounds(350, 570, 200, 30);
		c6.setFocusPainted(false);
		add(c6);
		
		c7 = new JCheckBox("I hereby declares that the above entered details correct to the best of my knowladge.",true);
		c7.setFont(new Font("Raleway",Font.BOLD,12));
		c7.setBackground(Color.WHITE);
		c7.setBounds(100, 600, 600, 20);
		c7.setFocusPainted(false);
		add(c7);
		
		r1 = new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway",Font.BOLD,16));
		r1.setBackground(Color.WHITE);
		r1.setBounds(100, 160, 150, 30);
		r1.setFocusPainted(false);
		add(r1);
		
		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway",Font.BOLD,16));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350, 160, 300, 30);
		r2.setFocusPainted(false);
		add(r2);
		
		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway",Font.BOLD,16));
		r3.setBackground(Color.WHITE);
		r3.setBounds(100, 200, 250, 30);
		r3.setFocusPainted(false);
		add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Raleway",Font.BOLD,16));
		r4.setBackground(Color.WHITE);
		r4.setBounds(350, 200, 250, 30);
		r4.setFocusPainted(false);
		add(r4);
		
		ButtonGroup group=new ButtonGroup();
		group.add(r1);
		group.add(r2);
		group.add(r3);
		group.add(r4);
		
		t1 = new JTextField();
		t1.setFont(new Font("Raleway",Font.BOLD,12));
		t1.setBounds(770, 10, 50, 30);
		add(t1);
		
		setLayout(null);
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(300,0);
		setVisible(true);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String a=null;
		if(r1.isSelected())
		{
			a="Saving Account";
		}
		else if(r2.isSelected())
		{
			a="Fixed Deposit Account";
		}
		else if(r3.isSelected())
		{
			a="Current Account";
		}
		else if(r4.isSelected())
		{
			a="Recurring Deposit Accoun";
		}
		
		Random ran = new Random();
		long first7=(ran.nextLong()%90000000L)+5040936000000000L;
		long first8=Math.abs(first7);
		
		long first3=(ran.nextLong()%9000L)-1000L;
		long first4=Math.abs(first3);
		
		String b="";
		if(c1.isSelected())
		{
			b= b+" ATM Card";
		}
		else if(c2.isSelected())
		{
			b= b+" Internet Banking";
		}
		else if(c3.isSelected())
		{
			b= b+" Mobile Banking";
		}
		else if(c4.isSelected())
		{
			b= b+" EMAIL Alerts";
		}
		else if(c5.isSelected())
		{
			b= b+" Check Book";
		}
		
		String c=t1.getText();
		
		try
		{
			if(ae.getSource()==b1)
			{
				if(b.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Fill all the required fields");
				}
				else
				{
					Conn c1=new Conn();
					String q1="insert into signup3 values('"+a+"','"+first8+"','"+first4+"','"+b+"','"+c+"')";
					String q2="insert into login values('"+first8+"','"+first4+"')";
					c1.s.executeUpdate(q1);
					c1.s.executeUpdate(q2);
					JOptionPane.showMessageDialog(null, "Card Number: "+first8+"\nPin: "+first4);
					
					//new Deposit().setVisible(true);
					setVisible(false);
				}
			}
			else if(ae.getSource()==b2)
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
		new Signup3().setVisible(true);
	}	
}
