package dbcon;
import java.sql.*;  
public class ConnectionDB {
	private static Connection con;
	public static Connection conn(){  
	try{  
		

		
		
		Class.forName("com.mysql.cj.jdbc.Driver");  
		 con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/party_reservation_db","root","1");   
		
	}
		catch(Exception e){ System.out.println(e);
		}  
	return con;
	}  
	public static void close(Connection con) throws SQLException {  
		con.close();  
	}
}
