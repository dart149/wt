import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class scroll {
    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system","3890");
            PreparedStatement st = conn.prepareStatement("select * from employee",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery();
            rs.absolute(1);
            rs.updateString(1, "vijayl");
            rs.updateRow();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
