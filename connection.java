import java.sql.*;
import java.sql.SQLException;
public class connection {

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","3890");
            st = conn.createStatement();
            int rs = st.executeUpdate("update employee set name='adf' where name='sd'" );
            System.out.println(rs);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}