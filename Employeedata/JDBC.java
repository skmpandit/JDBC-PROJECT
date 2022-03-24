package Employeedata;

import java.sql.*;

public class JDBC 
{
	public static Connection connect()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/ardent?characterEncoding=latinl","root","root");
		}
		catch(ClassNotFoundException e2)
		{
			e2.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
