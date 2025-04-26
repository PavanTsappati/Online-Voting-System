package VotingSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) throws SQLException, Exception {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            // Displaying the main menu
            System.out.println("Welcome to the Online Voting System");
            System.out.println("1. Admin Login");
            System.out.println("2. Voter Registration");
            System.out.println("3. Vote");
            System.out.println("4. View Results");
            System.out.println("5. Exit");
            System.out.print("Please choose an option (1-5): ");
            
            int choice = sc.nextInt(); // User's menu choice
            sc.nextLine();  // To clear the buffer

            switch (choice) {
                case 1:
                    // Admin Login
                    adminLogin(sc);  // Admin login functionality
                    break;
                case 2:
                    // Voter Registration
                    voterRegistration(sc);  // Voter registration functionality
                    break;
                case 3:
                    // Voting
                    castVote(sc);  // Voting functionality
                    break;
                case 4:
                    // View Results (Admin view)
                    viewResults();  // View voting results functionality
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    sc.close();
                    System.exit(0);  // Exit the program
                    break;
                default:
                    System.out.println("Invalid option! Please choose a valid option (1-5).");
            }
        }
    }

    // Admin login logic
    private static void adminLogin(Scanner sc) throws SQLException, Exception {
        System.out.print("Enter admin username: ");
        String username = sc.nextLine();
        System.out.print("Enter admin password: ");
        String password = sc.nextLine();

        if (Admin.login(username, password)) {
            System.out.println("Login successful!");
            // You can add more admin functionality here
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    // Voter registration logic
    private static void voterRegistration(Scanner sc) {
        System.out.print("Enter voter name: ");
        String name = sc.nextLine();
        System.out.print("Enter voter age: ");
        String age = sc.nextLine();
        System.out.print("Enter voter ID: ");
        String voterId = sc.nextLine();

        Voter.registerVoter(name, age, voterId);
    }

    // Vote casting logic
    private static void castVote(Scanner sc) {
        System.out.print("Enter your voter ID: ");
        String voterId = sc.nextLine();
        System.out.print("Enter the candidate's name you want to vote for: ");
        String candidateName = sc.nextLine();

        Voter.vote(voterId, candidateName);
    }

    // Admin view results functionality
    private static void viewResults() {
       try (Connection con = DatabaseConnection.getConnection()) {
	        String query = "SELECT name, votes FROM candidate ORDER BY votes DESC";
	        PreparedStatement pst = con.prepareStatement(query);
	        ResultSet rs = pst.executeQuery();

	        System.out.println("----------------------------------");
	        System.out.println("| Candidate Name | Votes Received |");
	        System.out.println("----------------------------------");

	        boolean resultsFound = false;
	        while (rs.next()) {
	            String name = rs.getString("name");
	            int votes = rs.getInt("votes");
	            System.out.printf("| %-15s | %-14d |\n", name, votes);
	            resultsFound = true;
	        }

	        System.out.println("----------------------------------");

	        if (!resultsFound) {
	            System.out.println("No voting results found.");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }
}
