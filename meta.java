import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class meta {
    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system","3890");
            DatabaseMetaData md = conn.getMetaData();
            System.out.println(md.getDatabaseProductName());
            System.out.println(md.getDatabaseProductVersion());
            System.out.println(md.getDriverName());
            System.out.println(md.getDriverVersion());
            System.out.println(md.getUserName());
            System.out.println(md.getURL());
            ResultSet tables = md.getTables(null, null, null, new String[]{"TABLE"});
            while(tables.next()){
                System.out.println(tables.getString("TABLE_NAME"));
                
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
