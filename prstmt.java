import java.sql.*;

public class prstmt {
    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE ", "system", "3890");
            PreparedStatement inst = conn.prepareStatement("insert into employee values(? , ? , ?)");
            inst.setString(1,"alice");
            inst.setInt(2, 55);
            inst.setInt(3, 47);
            int ro = inst.executeUpdate();
            System.out.println(ro);
            PreparedStatement upst = conn.prepareStatement("update employee set age=? where name=?");
            upst.setInt(1, 1);
            upst.setString(2, "VIJAYREDDY");
            ro = upst.executeUpdate();
            System.out.println(ro);
            PreparedStatement dst = conn.prepareStatement("delete employee where name=?");
            dst.setString(1, "ffff");
            ro  =dst.executeUpdate();
            System.out.println(ro);
            // String procedureSQL = "{CALL update_student_age(?, ?)}"; // Assume a stored procedure
            // CallableStatement cstmt = conn.prepareCall(procedureSQL);
            // cstmt.setInt(1, 102); // ID of the student
            // cstmt.setInt(2, 25);  // New age
            // cstmt.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
