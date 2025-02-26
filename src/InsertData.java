import  java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {

    public static void insertData() throws SQLException {
        try{
            while(true){

                Connection conn = ConnectDB.getConnection();

                String q = "INSERT INTO studentInfo (id, name) VALUES(?,?)";

                assert conn != null;
                PreparedStatement ps = conn.prepareStatement(q);

                Scanner sc = new Scanner(System.in);

                System.out.print("Enter Id: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name  = sc.nextLine();

                ps.setInt(1, id);
                ps.setString(2, name);
                ps.executeUpdate();
                System.out.println("Data Inserted");
            }


        }catch (Exception e){
            System.out.println(e);
        }
    }
}
