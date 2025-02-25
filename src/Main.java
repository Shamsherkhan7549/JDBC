import javax.swing.plaf.nimbus.State;


public class Main {
    public static void main(String[] args) {
        try{
            // Database Connection
            //ConnectDB.getConnection();

            // Create Table
            //CreateTable.createTable();

            //Insert Data Into Table
            //InsertData.insertData();

            //Delete Data From Table
            DeleteData.deleteData();

            //Update Data From Table
            //UpdateData.updateData();
        }catch (Exception e){

            System.out.println(e);
        }
    }
}


