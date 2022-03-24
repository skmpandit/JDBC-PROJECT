package bankManagment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener
{

	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JButton b;
	JRadioButton r1,r2,r3,r4;
	JTextField pan,aadhar,form;
	JComboBox religion,category,income,education,occupation;
	
	Signup2()
	{
		setFont(new Font("System",Font.BOLD,22));
		Font f=getFont();
		FontMetrics fm=getFontMetrics(f);
		int x=fm.stringWidth("NEW ACCOUNT APLICATION FORM - PAGE 2");
		int y=fm.stringWidth(" ");
		int z=getWidth()/2-(x/2);
		int w=z/y;
		String pad="";
		//for (int i=0; i!=w; i++) pad +=" "; 
		//pad =String.format("%"+w+"s",pad);
		setTitle(pad+"NEW ACCOUNT APLICATION FORM - PAGE 2");
		
		l1 = new JLabel("Page 2: Additional Details");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280, 30, 600, 40);
		add(l1);
		
		
		l2 = new JLabel("Religion:");
		l2.setFont(new Font("Raleway",Font.BOLD,18));
		l2.setBounds(100, 120, 100, 30);
		add(l2);
	
		
		l3 = new JLabel("Category:");
		l3.setFont(new Font("Raleway",Font.BOLD,18));
		l3.setBounds(100, 170, 100, 30);
		add(l3);
		
		
		l4 = new JLabel("Income:");
		l4.setFont(new Font("Raleway",Font.BOLD,18));
		l4.setBounds(100, 220, 100, 30);
		add(l4);
		
		l5 = new JLabel("Educational");
		l5.setFont(new Font("Ralway",Font.BOLD,18));
		l5.setBounds(100, 270, 150, 30);
		add(l5);
		
		l11 = new JLabel("Qualification:");
		l11.setFont(new Font("Raleway",Font.BOLD,18));
		l11.setBounds(100, 290, 150, 30);
		add(l11);
		
		l6 = new JLabel("Occupation:");
		l6.setFont(new Font("Raleway",Font.BOLD,18));
		l6.setBounds(100, 340, 150, 30);
		add(l6);
		
		l7 = new JLabel("Pan Number:");
		l7.setFont(new Font("Raleway",Font.BOLD,18));
		l7.setBounds(100, 390, 150, 30);
		add(l7);
		
		l8 = new JLabel("Aadhar Number:");
		l8.setFont(new Font("Raleway",Font.BOLD,18));
		l8.setBounds(100, 440, 180, 30);
		add(l8);
		
		l9 = new JLabel("Senior Citizon");
		l9.setFont(new Font("Raleway",Font.BOLD,18));
		l9.setBounds(100, 490, 150, 30);
		add(l9);
		
		l10 = new JLabel("Existing Account");
		l10.setFont(new Font("Raleway",Font.BOLD,18));
		l10.setBounds(100, 540, 150, 30);
		add(l10);
		
		
		l12 = new JLabel("Form No:");
		l12.setFont(new Font("Raleway",Font.BOLD,13));
		l12.setBounds(700, 10, 60, 30);
		add(l12);
		
		b = new JButton("Next");
		b.setFont(new Font("Raleway",Font.BOLD,14));
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		b.setBounds(570, 600, 100, 30);
		add(b);
		
		pan = new JTextField();
		pan.setFont(new Font("Raleway",Font.BOLD,14));
		pan.setBounds(350, 390, 320, 30);
		add(pan);
		
		aadhar = new JTextField();
		aadhar.setFont(new Font("Raleway",Font.BOLD,14));
		aadhar.setBounds(350, 440, 320, 30);
		add(aadhar);
		
		form = new JTextField();
		form.setFont(new Font("Raleway",Font.BOLD,13));
		form.setBounds(760, 10, 60, 30);
		add(form);
		
		r1 = new JRadioButton("Yes");
		r1.setFont(new Font("Raleway",Font.BOLD,14));
		r1.setBackground(Color.WHITE);
		r1.setBounds(350, 490, 100, 30);
		r1.setFocusPainted(false);
		add(r1);
		
		r2 = new JRadioButton("No");
		r2.setFont(new Font("Raleway",Font.BOLD,14));
		r2.setBackground(Color.WHITE);
		r2.setBounds(460, 490, 100, 30);
		r2.setFocusPainted(false);
		add(r2);
		
		ButtonGroup group=new ButtonGroup();
		group.add(r1);
		group.add(r2);
		
		r3 = new JRadioButton("Yes");
		r3.setFont(new Font("Raleway",Font.BOLD,14));
		r3.setBackground(Color.WHITE);
		r3.setBounds(350, 540, 100, 30);
		r3.setFocusPainted(false);
		add(r3);
		
		r4 = new JRadioButton("No");
		r4.setFont(new Font("Raleway",Font.BOLD,14));
		r4.setBackground(Color.WHITE);
		r4.setBounds(460, 540, 100, 30);
		r4.setFocusPainted(false);
		add(r4);
		
		ButtonGroup group1=new ButtonGroup();
		group1.add(r3);
		group1.add(r4);
		
		
		String religion1[] = {"Hindu","Muslim","Sikh","Christion","Other"};
		religion = new JComboBox(religion1);
		religion.setBackground(Color.WHITE);
		religion.setFont(new Font("Raleway",Font.BOLD,14));
		religion.setBounds(350 ,120, 320, 30);
		add(religion);
		
		String category1[] = {"General","ST","OBC","SC","Other"};
		category = new JComboBox(category1);
		category.setBackground(Color.WHITE);
		category.setFont(new Font("Raleway",Font.BOLD,14));
		category.setBounds(350, 170, 320, 30);
		add(category);
		
		String income1[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
		income = new JComboBox(income1);
		income.setBackground(Color.WHITE);
		income.setFont(new Font("Raleway",Font.BOLD,14));
		income.setBounds(350, 220, 320, 30);
		add(income);
		
		String education1[] = {"Non Graduate","Graduate","Post-Graduate","Doctrate","Others"};
		education = new JComboBox(education1);
		education.setBackground(Color.WHITE);
		education.setFont(new Font("Raleway",Font.BOLD,14));
		education.setBounds(350, 270, 320, 30);
		add(education);
		
		String occupation1[] = {"Salaried","Self-Employeed","Business","Student","Retired","Others"};
		occupation = new JComboBox(occupation1);
		occupation.setBackground(Color.WHITE);
		occupation.setFont(new Font("Raleway",Font.BOLD,14));
		occupation.setBounds(350, 340, 320, 30);
		add(occupation);
		
		setLayout(null);
	
		b.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,850);
		setLocation(300,0);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String a=(String)religion.getSelectedItem();
		String b=(String)category.getSelectedItem();
		String c=(String)income.getSelectedItem();
		String d=(String)education.getSelectedItem();
		String e=(String)occupation.getSelectedItem();
		
		String f=pan.getText();
		String g=aadhar.getText();
		
		String h=null;
		if(r1.isSelected())
		{
			h="Yes";
		}
		else if(r2.isSelected())
		{
			h="No";
		}
		
		String i=null;
		if(r3.isSelected())
		{
			i="Yes";
		}
		else if(r4.isSelected())
		{
			i="No";
		}
		
		String j=form.getText();
		
		try
		{
			if(aadhar.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Fill all the requared fields");
			}
			else
			{
				Conn c1=new Conn();
				String q1="insert into signup2 values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"')";
				c1.s.executeUpdate(q1);
				
				new Signup3().setVisible(true);
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
		new Signup2().setVisible(true);
	}
}
