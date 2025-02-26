import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateData {
    public static void updateData(){
        try(Connection conn = ConnectDB.getConnection()) {

            String q = "UPDATE studentInfo SET  name = ? WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(q);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Id: ");
            int id = sc.nextInt();
            System.out.print("Enter New Name: ");
            String name = sc.nextLine();


            ps.setString(1,name);
            ps.setInt(2,id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows>0){
                System.out.println("Updated row = " + affectedRows);
                return;
            }
            System.out.println("Data Not Found On This Id");

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
