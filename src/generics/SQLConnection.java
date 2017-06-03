package generics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gargoylesoftware.htmlunit.html.FormFieldWithNameHistory;

public class SQLConnection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("loaded");
		
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3036/emp");

     Statement stmt = con.createStatement(); 
     ResultSet rs = stmt.executeQuery("select * from employee");

//while(rs.next())
//{
//	System.out.println(rs.t);
//}

	}

}
