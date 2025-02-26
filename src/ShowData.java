import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ShowData {
    public static void showData(){
        try(Connection conn = ConnectDB.getConnection()){

            String q = "SELECT * FROM studentInfo WHERE id = ? ";

            PreparedStatement ps = conn.prepareStatement(q);

            Scanner sc = new Scanner(System.in);
            System.out.print("Search Data To Enter Id: ");
            int id = sc.nextInt();
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            // Check if data exists before looping
            if (!rs.isBeforeFirst()) { // isBeforeFirst() returns true if there is any data
                System.out.println("Data Not Found");
                return;
            }

            while(rs.next()){
                System.out.println("Id: " + id + "  Name: " + rs.getString("name"));
            }
            System.out.println("Data on the table");

        }catch (Exception e){
            System.out.println(e);
        }
    };

    //Name
    public static void showData(String name) {
        try (Connection conn = ConnectDB.getConnection()) {

            String q = "SELECT * FROM studentInfo WHERE name = ? ";

            PreparedStatement ps = conn.prepareStatement(q);

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            // Check if data exists before looping
            if (!rs.isBeforeFirst()) { // isBeforeFirst() returns true if there is any data
                System.out.println("Data Not Found");
                return;
            }

            while (rs.next()) {

                System.out.println("Id: " + rs.getString("id") + "  Name: " + rs.getString("name"));
            };

            System.out.println("Data on the table");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
