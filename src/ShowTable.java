import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ShowTable {

    public static void showTable(){
        try{
          Connection  conn = ConnectDB.getConnection();
             // Query to fetch all records from the "students" table
            String q = "SELECT * FROM students";

            //Create statement
            Statement smt = conn.createStatement();

            // Execute query
            ResultSet rs = smt.executeQuery(q);

            //Print Result
            while (rs.next()){

                int roll_no = rs.getInt("roll_no");
                String name = rs.getString("name");
                String city = rs.getString("city");
                int marks = rs.getInt("marks");
                String grade = rs.getString("grade");

                System.out.println("Roll No = " + roll_no + " name= " + name +
                        " city= " + city + " marks= " + marks + " grade= " + grade);

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
