 package interfaces;
 import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JFrame;
 public class DigitalWatch extends JFrame
 {
	 Calendar calendar;
	 SimpleDateFormat timeFormat;
	 SimpleDateFormat dayFormat;
	 SimpleDateFormat dateFormat;
	 
	 JLabel timeLabel;
	 JLabel dayLabel;
	 JLabel dateLabel;
	 String time;
	 String day;
	 String date;
	 DigitalWatch()
	 {
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setTitle("My Digital Clock");
		 this.setLayout(new FlowLayout());
		 this.setSize(350,250);
		 this.setResizable(false);
		 
		 timeFormat=new SimpleDateFormat("hh:mm:ss a");
		 dayFormat=new SimpleDateFormat("EEEEE");
		 dateFormat=new SimpleDateFormat("dd MMMM yyyy");
		 
		 timeLabel=new JLabel();
		 timeLabel.setFont(new Font("Vendana",Font.PLAIN,60));
		 
		 timeLabel.setForeground(new Color(0x00FF00));
		 timeLabel.setBackground(Color.black);
		 timeLabel.setOpaque(true);
		 
		 dayLabel=new JLabel();
		 dayLabel.setFont(new Font("Vendana",Font.PLAIN,35));
		 
		 dateLabel=new JLabel();
		 dateLabel.setFont(new Font("Vendana",Font.PLAIN,25));
		 
		 this.add(timeLabel);
		 this.add(dayLabel);
		 this.add(dateLabel);
		 this.setVisible(true);
		 
		 setTime();
	 }
	 public void setTime()
	 {
		 while(true)
		 {
			 time=timeFormat.format(Calendar.getInstance().getTime());
			 timeLabel.setText(time);
			 
			 day=dayFormat.format(Calendar.getInstance().getTime());
			 dayLabel.setText(day);
			 
			 date=dateFormat.format(Calendar.getInstance().getTime());
			 dateLabel.setText(date);
			 
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
 }