package webMvcStudy;

import java.sql.*;

public class Dbconnect {
	Statement stmt;
	Connection con;
	public Dbconnect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webmvc","root","");
		 stmt = con.createStatement();
		
	}
	
//	public void update(String query) throws SQLException {
//		stmt.executeUpdate(query);
//	}
	public ResultSet getdata(String query) throws SQLException {
		ResultSet rs = stmt.executeQuery(query);
		return rs;
		
	}
}
