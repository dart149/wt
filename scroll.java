import java.sql.*;

public class scroll {

    public static void main(String[] args) {
        try {
            // Establish connection
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "3890");

           
            
            // Create a scrollable and updatable result set
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );

            // Execute query (avoid using SELECT *)
            ResultSet rs = st.executeQuery("SELECT name, age, id FROM employee");

            // Print initial values
            System.out.println("Initial values:");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " " + rs.getInt("age") + " " + rs.getInt("id"));
            }

            // Update the first row
            rs.absolute(1); // Move to the first row
            rs.updateInt("age", 78);
            rs.updateString("name", "VIJAYREDDY");
            rs.updateRow(); // Commit the update to the result set

            // Optional: commit changes if auto-commit is disabled
            conn.commit();

            // Display updated data
            rs.beforeFirst(); // Move cursor to before the first row
            System.out.println("\nUpdated values:");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " " + rs.getInt("age") + " " + rs.getInt("id"));
            }
            rs.last();
            rs.updateInt("age",88);
            rs.updateString("name", "deee");
            rs.updateRow();
            // Close resources
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
