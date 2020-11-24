package com.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentEx {
	public static void main(String args[]) 
	{
		
		String url="jdbc:mysql://localhost:3306/studentmanagementdb";
		String user="root";
		String password="root";
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		do {
			
			System.out.println("1.insert");
			System.out.println("2.update");
			System.out.println("3.delete");
			System.out.println("4.select");
			System.out.println("5.exit");
			
		
		
		try(Connection con=DriverManager.getConnection(url,user,password)) {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			switch(ch)
			{
			case 1:
			{
				String sql="insert into student  (sid,sname,scollege,sbranch)"
						+"values('4','keerthi','AITS','EEE')";
						Statement st= con.createStatement();
						int rows=st.executeUpdate(sql);
						if(rows>0)	
						{
							System.out.println("insert success");
						}
						else
						{
							System.out.println("insert failed");
						}
						break;
			}
			case 2:
			{
				Statement st= con.createStatement();
				int rows1=st.executeUpdate("update student set sname ='teja' where sid='3'");
				if(rows1>0)	
				{
					System.out.println("update success");
				}
				else
				{
					System.out.println("update failed");
				}
				break;
			}
			case 3:
			{
				Statement st= con.createStatement();
				int rows2=st.executeUpdate("delete from student where sid='4'");
				System.out.println("deleted Successfully");	
				break;
			}
			case 4:
			{
				Statement st= con.createStatement();
				ResultSet rs=st.executeQuery(" select * from student");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4));
				}
				break;
			}
			case 5:
			{
				System.out.println("end of program");
				break;
			}
			}
			
			
		}
		catch ( SQLException e ) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}while(ch<0);
	

}
}
