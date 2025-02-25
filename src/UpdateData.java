import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateData {
    public static void updateData(){
        try(Connection conn = ConnectDB.getConnection()) {

            String q = "UPDATE studentInfo SET  name = ? WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(q);

            Scanner sc = new Scanner(System.in);


            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Id: ");
            int id = sc.nextInt();

            ps.setString(1,name);
            ps.setInt(2,id);

            int affectedRows = ps.executeUpdate();
            System.out.println("Updated row = " + affectedRows);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
