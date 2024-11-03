import java.sql.*;
import java.util.*;

public class preparedcall {
    public static void insertRecords(Connection conn, String name, int age, int id) {
        String qu = "insert into employee values(?, ?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(qu);
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setInt(3, id);
            int rows = pst.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateRecord(Connection conn,int id,int age){
        String qu = "update employee set age= ? where id = ?";
        try{
            PreparedStatement pst = conn.prepareStatement(qu);
            pst.setInt(1, age);
            pst.setInt(2, id);
            int row = pst.executeUpdate();
            System.out.println(row);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","3890");
            insertRecords(conn,"vijaa",20,8);
            updateRecord(conn,1,20);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
