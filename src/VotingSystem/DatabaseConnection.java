package VotingSystem;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	// Database connection method
    public static Connection getConnection() throws Exception {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Create a connection to the database
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/voting_system",  // URL to your DB
            "root",  // Username (default for MySQL)
            "Pavan#123%"  // Password you set during MySQL installation
            );
	   }

	public static void main(String[] args) {
		try {
            // Attempting to get connection from the DatabaseConnection class
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Connection Successful!");
            con.close();  // Closing the connection
        } catch (Exception e) {
            // If error occurs, print the error message
            System.out.println("Connection Failed: " + e.getMessage());
        }

	}

}
