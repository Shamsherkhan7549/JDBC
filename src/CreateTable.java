import java.sql.Connection;
import java.sql.Statement;

public class CreateTable {

    public static   void createTable(){

            try {
                Connection conn = ConnectDB.getConnection();

                // Creating Table in Database
                String q = "CREATE TABLE teacherInfo(id INT PRIMARY KEY, name VARCHAR(30))";

                //Drop Table
                //String q = "DROP TABLE teacherInfo";

                //create statement
                Statement smt = conn.createStatement();

                // execute query
                smt.execute(q);
                System.out.println("Table droped");

                smt.close();
                conn.close();
            }catch (Exception ex){
                System.out.println(ex);
            }


    }
}
