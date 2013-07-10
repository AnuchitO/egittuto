import javax.swing.JOptionPane;
import java.sql.*;
public class JDBCCreateTable{
	
	static String userid="scott", password = "tiger";
	static String url = "jdbc:odbc:bob";	// String url = "jdbc:mySubprotocol:myDataSource"; ?
	static Statement stmt;
	static Connection con;
	public static void main(String args[]){

		JOptionPane.showMessageDialog(null,"JDBC Programming showing Creation of Table's");
		int choice = -1;
		
		do{
			choice = getChoice();
			if (choice != 0){
				getSelected(choice);
			}
		}
		while ( choice !=  0);
			System.exit(0);
	}

	public static int getChoice()
	{
		String choice;
		int ch;
		choice = JOptionPane.showInputDialog(null,
			"1. Create Employees Table\n"+
			"2. Create Products Table\n"+
			"0. Exit\n\n"+
			"Enter your choice");
		ch = Integer.parseInt(choice);
		return ch;

	}

	public static void getSelected(int choice){
		if(choice==1){
			createEmployees();
		}
		if(choice==2){
			createOrders();
		}
	}

	public static Connection getConnection()
	{
				
		

		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	//Class.forName("myDriver.ClassName"); ?

		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			con = DriverManager.getConnection(url,
									 userid, password);

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
		return con;
	}
	
	/*CREATE TABLE Employees (
		    Employee_ID INTEGER,
		    Name VARCHAR(30)
		);*/
	public static void createEmployees()
	{
		Connection con = getConnection();
		
		String createString;
		createString = "create table Employees (" +
							"Employee_ID INTEGER, " +
							"Name VARCHAR(30))";
		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(createString);
			stmt.close();
			con.close();

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null,"Employees Table Created");
	}

	/*CREATE TABLE Orders (
		    Prod_ID INTEGER,
		    ProductName VARCHAR(20),
		    Employee_ID INTEGER
		);*/
	
	public static void createOrders()
	{
		Connection con = getConnection();
		
		String createString;
		createString = "create table Orders (" +
							"Prod_ID INTEGER, " +
							"ProductName VARCHAR(20), "+
							"Employee_ID INTEGER )";
		

		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(createString);

			stmt.close();
			con.close();

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null,"Orders Table Created");
	}


}//End of class