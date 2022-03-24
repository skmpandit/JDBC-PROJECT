package bankManagment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	JTextField name,fname,email,address,city,pcode,state;
	JRadioButton r1,r2,r3,r4,r5;
	JComboBox date,mounth,year;
	JButton b;
	
	Random ran=new Random();
	long first4=(ran.nextLong() % 9000L)+1000L;
	long first=Math.abs(first4);
	Signup()
	{
		setFont(new Font("System",Font.BOLD,22));
		Font f=getFont();
		FontMetrics fm=getFontMetrics(f);
		int x=fm.stringWidth("NEW ACCOUNT APLICATION FORM");
		int y=fm.stringWidth(" ");
		int z=getWidth()-x;
		int w=z/y;
		String pad="";
		//for (int i=0; i!=w; i++) pad +=" "; 
		//pad =String.format("%"+w+"s",pad);
		setTitle(pad+"NEW ACCOUNT APLICATION FORM");
		
		l1=new JLabel("APPLICATION FORM - PAGE 1");
		l1.setFont(new Font("Raleway",Font.BOLD,30));
		l1.setBounds(180, 20, 600, 40);
		l1.setForeground(Color.BLUE);
		add(l1);
		
		l2=new JLabel("Page 1: Personal Details");
		l2.setFont(new Font("Rateway",Font.BOLD,22));
		l2.setBounds(290, 70, 600, 30);
		add(l2);
		
		l3=new JLabel("Name:");
		l3.setFont(new Font("Rateway",Font.BOLD,20));
		l3.setBounds(100, 140, 100, 30);
		add(l3);
		
		l4=new JLabel("Father's Name:");
		l4.setFont(new Font("Raleway",Font.BOLD,20));
		l4.setBounds(100, 190, 200, 30);
		add(l4);
		
		l5=new JLabel("Date of Birthday:");
		l5.setFont(new Font("Raleway",Font.BOLD,20));
		l5.setBounds(100, 240, 200, 30);
		add(l5);
		
		l6=new JLabel("Gender:");
		l6.setFont(new Font("Raleway:",Font.BOLD,20));
		l6.setBounds(100, 290, 200, 30);
		add(l6);
		
		l7=new JLabel("Email Address:");
		l7.setFont(new Font("Raleway",Font.BOLD,20));
		l7.setBounds(100, 340, 200, 30);
		add(l7);
		
		l8=new JLabel("Marital Status:");
		l8.setFont(new Font("Raleway",Font.BOLD,20));
		l8.setBounds(100, 390, 200, 30);
		add(l8);
		
		l9=new JLabel("Address:");
		l9.setFont(new Font("Raleway",Font.BOLD,20));
		l9.setBounds(100, 440, 200, 30);
		add(l9);
		
		l10=new JLabel("City:");
		l10.setFont(new Font("Raleway",Font.BOLD,20));
		l10.setBounds(100, 490, 200, 30);
		add(l10);
		
		l11=new JLabel("Pin Code:");
		l11.setFont(new Font("Raleway",Font.BOLD,20));
		l11.setBounds(100, 540, 200, 30);
		add(l11);
		
		l12=new JLabel("State:");
		l12.setFont(new Font("Raleway",Font.BOLD,20));
		l12.setBounds(100, 590, 200, 30);
		add(l12);

		l13=new JLabel("Date:");
		l13.setFont(new Font("Raleway",Font.BOLD,14));
		l13.setBounds(300, 240, 40, 30);
		add(l13);
		
		l14=new JLabel("Mounth:");
		l14.setFont(new Font("Raleway",Font.BOLD,14));
		l14.setBounds(425, 240, 58, 30);
		add(l14);
		
		l15=new JLabel("Year:");
		l15.setFont(new Font("Raleway",Font.BOLD,14));
		l15.setBounds(590, 240, 40, 30);
		add(l15);
		
		name=new JTextField();
		name.setFont(new Font("Raleway",Font.BOLD,14));
		name.setBounds(300, 140, 400, 30);
		name.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLUE));
		add(name);
		
		fname=new JTextField();
		fname.setFont(new Font("Raleway",Font.BOLD,14));
		fname.setBounds(300, 190, 400, 30);
		fname.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		add(fname);
		
		email=new JTextField();
		email.setFont(new Font("Raleway",Font.BOLD,14));
		email.setBounds(300, 340, 400, 30);
		email.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		add(email);
		
		address=new JTextField();
		address.setFont(new Font("Raleway",Font.BOLD,14));
		address.setBounds(300, 440, 400, 30);
		address.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		add(address);
		
		city=new JTextField();
		city.setFont(new Font("Raleway",Font.BOLD,14));
		city.setBounds(300, 490, 400, 30);
		city.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		add(city);
		
		pcode=new JTextField();
		pcode.setFont(new Font("Raleway",Font.BOLD,14));
		pcode.setBounds(300, 540, 400, 30);
		pcode.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		add(pcode);
		
		state=new JTextField();
		state.setFont(new Font("Raleway",Font.BOLD,14));
		state.setBounds(300, 590, 400, 30);
		state.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
		add(state);
		
		b=new JButton("Next");
		b.setFont(new Font("Raleway",Font.BOLD,14));
		b.setBackground(Color.BLUE);
		b.setForeground(Color.WHITE);
		b.setBounds(620, 660, 80, 30);
		b.setBorderPainted(false);
		b.setFocusPainted(false);
		add(b);
		
		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Raleway",Font.BOLD,14));
		r1.setBackground(Color.WHITE);
		r1.setFocusPainted(false);
		r1.setBounds(300, 290, 60, 30);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Raleway",Font.BOLD,14));
		r2.setBackground(Color.WHITE);
		r2.setFocusPainted(false);
		r2.setBounds(450, 290, 90, 30);
		add(r2);
		
		ButtonGroup group=new ButtonGroup();
		group.add(r1);
		group.add(r2);
		
		r3 = new JRadioButton("Married");
		r3.setFont(new Font("Raleway",Font.BOLD,14));
		r3.setBackground(Color.WHITE);
		r3.setFocusPainted(false);
		r3.setBounds(300, 390, 100, 30);
		add(r3);
		
		r4 = new JRadioButton("Unmaried");
		r4.setFont(new Font("Raleway",Font.BOLD,14));
		r4.setBackground(Color.WHITE);
		r4.setFocusPainted(false);
		r4.setBounds(450, 390, 100, 30);
		add(r4);
		
		r5 = new JRadioButton("Other");
		r5.setFont(new Font("Raleway",Font.BOLD,14));
		r5.setBackground(Color.WHITE);
		r5.setFocusPainted(false);
		r5.setBounds(635, 390, 100, 30);
		add(r5);
		
		ButtonGroup group1=new ButtonGroup();
		group1.add(r3);
		group1.add(r4);
		group1.add(r5);
		
		String date1[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		date = new JComboBox(date1);
		date.setBackground(Color.WHITE);
		date.setBounds(340, 240, 60, 30);
		add(date);
		
		String mounth1[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		mounth = new JComboBox(mounth1);
		mounth.setBackground(Color.WHITE);
		mounth.setBounds(485, 240, 90, 30);
		add(mounth);
		
		String year1[] = {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002"};
		year = new JComboBox(year1);
		year.setBackground(Color.WHITE);
		year.setBounds(630, 240, 70, 30);
		add(year);
		
		setLayout(null);
		
		b.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,800);
		setLocation(300,5);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String a=name.getText();
		String b=fname.getText();
		
		String ac=(String)date.getSelectedItem();
		String bc=(String)mounth.getSelectedItem();
		String cc=(String)year.getSelectedItem();
		
		String d=null;
		if(r1.isSelected())
		{
			d="Male";
		}
		else if(r2.isSelected())
		{
			d="Female";
		}
		 
		String e=email.getText();
		
		String f=null;
		if(r3.isSelected())
		{
			f="Married";
		}
		else if(r4.isSelected())
		{
			f="Unmarried";
		}
		else if(r5.isSelected())
		{
			f="Other";
		}
		
		String g=address.getText();
		String h=city.getText();
		String i=pcode.getText();
		String j=state.getText();
		
		try
		{
			if(pcode.getText().equals("") && city.getText().equals("") && address.getText().equals("") && name.getText().equals("") && fname.getText().equals("") && state.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Fill all the required fields");
			}
			else
			{
				Conn c1=new Conn();
				String q1="insert into signup values('"+a+"','"+b+"','"+ac+"','"+bc+"','"+cc+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"',)";
				c1.s.executeUpdate(q1);
				
				new Signup2().setVisible(true);
				setVisible(false);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new Signup().setVisible(true);
	}
}
