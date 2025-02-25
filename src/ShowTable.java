import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ShowTable {

    public static void showTable(){
        try{
          Connection  conn = ConnectDB.getConnection();
             // Query to fetch all records from the "students" table
            String q = "SELECT * FROM studentInfo";

            //Create statement
            Statement smt = conn.createStatement();

            // Execute query
            ResultSet rs = smt.executeQuery(q);

            //Print Result
            while (rs.next()){

                int id = rs.getInt("id");
                String name = rs.getString("name");


                System.out.println("Id = " + id + " Name = " + name);
            };

            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
