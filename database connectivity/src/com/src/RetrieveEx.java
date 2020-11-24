package com.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class RetrieveEx {
public static void main(String args[]) 
{
	String url="jdbc:mysql://localhost:3306/keerthidb";
	String user="root";
	String password="root";
	try(Connection con=DriverManager.getConnection(url,user,password)) {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(" select * from restaurants");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getInt(5));
		}
		
		System.out.println("end of program");
		
	} catch (ClassNotFoundException  | SQLException e ) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
