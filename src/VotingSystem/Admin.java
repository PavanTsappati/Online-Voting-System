package VotingSystem;
import java.sql.*;
import java.util.Scanner;

public class Admin {
	
    public static boolean login(String username, String password) throws SQLException, Exception {
        try (Connection con = DatabaseConnection.getConnection()) {
            // SQL query to check if the username and password match
            String query = "SELECT * FROM admin WHERE username=? AND password=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            // If a matching record is found, return true
            return rs.next();
        }catch (Exception e) {
            e.printStackTrace();
            return false;  // If any error occurs, return false
        }
    }
 // Method to add a candidate to the database
    public static void addCandidate(String name, String party) {
        try (Connection con = DatabaseConnection.getConnection()) {
            // SQL query to insert candidate details into the candidate table
            String query = "INSERT INTO candidate (name, party) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, party);
            pst.executeUpdate();  // Executes the insert query
            System.out.println("Candidate added successfully.");
        } catch (Exception e) {
            e.printStackTrace();  // Print error if something goes wrong
        }
    }


	public static void main(String[] args) throws SQLException, Exception {
		Scanner sc = new Scanner(System.in);

        // Admin login
        System.out.print("Enter admin username: ");
        String username = sc.next();
        System.out.print("Enter admin password: ");
        String password = sc.next();

        // Validate login
        if (login(username, password)) {
            System.out.println("Admin Login Successful!");

            // Add Candidate
            System.out.print("Enter candidate name: ");
            sc.nextLine();  // Consume newline character
            String candidateName = sc.nextLine();
            System.out.print("Enter party: ");
            String party = sc.nextLine();
            addCandidate(candidateName, party);

        } else {
            System.out.println("Invalid credentials.");
        }

        sc.close();  // Close scanner
	}

}
