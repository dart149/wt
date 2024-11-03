import java.sql.*;

public class metadata {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            // Establish connection to the database
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "3890");

            // Retrieve Database Metadata
            DatabaseMetaData dbMetaData = conn.getMetaData();

            // Display general database metadata
            System.out.println("Database Product Name: " + dbMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbMetaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " + dbMetaData.getDriverName());
            System.out.println("Driver Version: " + dbMetaData.getDriverVersion());
            System.out.println("JDBC URL: " + dbMetaData.getURL());
            System.out.println("User Name: " + dbMetaData.getUserName());
            

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
