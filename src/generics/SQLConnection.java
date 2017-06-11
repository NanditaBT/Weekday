package generics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gargoylesoftware.htmlunit.html.FormFieldWithNameHistory;

public class SQLConnection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con=null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("loaded");
		
 con=DriverManager.getConnection("jdbc:mysql://localhost:3036/selenium","root","hellosql");
System.out.println("connected to db");
		}
		catch(Exception e)
		{
			System.out.println("could not connect to database");
			//throw new SkipException("Could not establish connection"); 
		}


     Statement stmt = con.createStatement(); 
   PreparedStatement pstmt = con.prepareStatement(sql);
   pstmt.setString(parameterIndex, x);
//     ResultSet rs = stmt.executeQuery("select * from seleniumuser");

//while(rs.next())
//{
//	System.out.println(rs.t);
//}

	}

}
