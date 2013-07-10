import java.sql.*;

public class JavaMysqlInsertExample
{

  public static void main(String[] args)
  {
    try
    {
      // create a mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/javatest";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
      
      Statement st = conn.createStatement();

      // note that i'm leaving "date_created" out of this insert statement
      st.executeUpdate("INSERT INTO java (name, surname) "+"VALUES ('Fred', 'Flinstone')");

      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }

  }
}