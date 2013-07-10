import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDriverInformation {
	static String userid="root", password = "1234";
	static String url = "jdbc:odbc:bob";	

	static Connection con = null;
	public static void main(String[] args) throws Exception {
	    Connection con = getOracleJDBCConnection();
	    if(con!= null){
	       System.out.println("Got Connection.");
	       DatabaseMetaData meta = con.getMetaData();
	       System.out.println("Driver Name : "+meta.getDriverName());
	       System.out.println("Driver Version : "+meta.getDriverVersion());

	    }else{
		    System.out.println("Could not Get Connection");
	    }
	}

	public static Connection getOracleJDBCConnection(){

		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	

		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
		   con = DriverManager.getConnection(url, userid, password);
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		return con;
	}

}
