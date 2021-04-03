package dbcon;
import java.sql.*;  

public class AccessDb {

	Database db = new Database();
	//private String sql = "";
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public AccessDb() {}
	
	public ResultSet doquery(String query) {
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			return rs;
		}catch(SQLException | ClassNotFoundException e) {
			return null;
		}
	}
	
	public void closeconn() {
		try {
			con.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
