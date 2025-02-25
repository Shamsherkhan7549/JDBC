import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteData {
    public static void deleteData(){
        try(Connection conn = ConnectDB.getConnection()){

            String q = "DELETE FROM studentInfo WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(q);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Id To Delete The Data: ");
            int id = sc.nextInt();

            ps.setInt(1, id);

            sc.nextLine();

            System.out.print("Do You Really Want To Delete yes/no: ");
            String agree = sc.nextLine();

            if(!agree.equalsIgnoreCase("yes")){
                System.out.println("Data Not Deleted");
                return;
            }
            int rowsAffected = ps.executeUpdate();
            System.out.println("deleted rows = "+ rowsAffected );

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
