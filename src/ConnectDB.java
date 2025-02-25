import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectDB {

    public static Connection getConnection(){
       try{

           // Load the MySQL JDBC driver
           Class.forName("com.mysql.cj.jdbc.Driver");

           // Establish connection with mysql database
           Connection conn =  DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/myJava", "root", "Shamsher@mysql"
           );
           System.out.println("Database connected successfully");

           return  conn;

       }catch(Exception err){
           System.out.println(err);
           return  null;
       }
    }
}
