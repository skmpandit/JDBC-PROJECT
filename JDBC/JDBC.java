package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC 
{
	Connection con=null;
	java.sql.PreparedStatement pst;
	public static Connection dbconnect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/ardent4","root","");
			return conn;
		}
		catch(Exception e2)
		{
			System.out.println(e2);
			return null;
		}
	}
	
}
