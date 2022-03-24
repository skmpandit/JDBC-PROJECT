package Mysql;

import java.sql.*;

public class UserMaganer {
	public static void main(String[] args) throws Exception
	{
		
		String url="jdbc:mysql://localhost:3306/ardent";
		String username="root";
		String password="root";
			Connection connection=DriverManager.getConnection(url, username, password);
			if(connection != null)
			{
				System.out.println("Connected to the database");
				connection.close();
			}
	}
}
