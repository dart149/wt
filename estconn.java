import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class estconn{
    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system","3890");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from employee");
            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getInt(2));
                System.out.println(rs.getInt(3));  
            }
            int cnt = st.executeUpdate("update employee set age=25 where name='ffff'");
            System.out.println(cnt);
            int cnti = st.executeUpdate("insert into employee values('viii',18,25) ");
            System.out.println(cnti);

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        

    }
}