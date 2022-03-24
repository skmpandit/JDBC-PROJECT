package studentdata;
import java.sql.*;
public class JDBC 
{
	public static Connection connect()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/ardent4","root","");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e2)
		{
			e2.printStackTrace();
		}
		return con;
	}
}
