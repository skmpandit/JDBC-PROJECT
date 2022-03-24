package Universitymanagement;

import java.awt.*;
import javax.swing.*;

public class Splash 
{
	public static void main(String s[])
	{
        Frame f = new Frame("IQCT MEDICALE COLLAGE"); 
        f.setVisible(true); 
        int i;
        int x=1;
        for(i=2;i<=650;i+=4,x+=1){
            f.setLocation((550-((i+x)/2) ),330-(i/2));
            f.setSize(i+3*x,i+x/2);
            try
            {
                Thread.sleep(10);
            }
            catch(Exception e) 
            { 
            	e.printStackTrace();
            }
        }
    }
}
class Frame extends JFrame implements Runnable
{
    Thread t1;
    Frame(String s)
    {
        super(s);
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon("C:\\Users\\Sonu Kumar Mahto\\Documents\\icons\\iqct.jpg");
        Image i1 = c1.getImage().getScaledInstance(1200, 700,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel m1 = new JLabel(i2);
        add(m1);
        t1 = new Thread(this);
        t1.start();
    }
    public void run()
    {
        try
        {
            Thread.sleep(5000);
            this.setVisible(false);
            Login f1 = new Login();   
        }
        catch(Exception e)
        {
            e.printStackTrace(); 
        }
    }
}