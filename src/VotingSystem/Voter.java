package VotingSystem;
import java.sql.*;
import java.util.Scanner;

public class Voter {

    public static void registerVoter(String name2, String age, String voterId) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO voter (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Registered successfully.");
            } else {
                System.out.println("❌ Registration failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void vote(String voterId, String candidateName) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        try (Connection con = DatabaseConnection.getConnection()) {
            String checkQuery = "SELECT has_voted FROM voter WHERE email=? AND password=?";
            PreparedStatement checkPst = con.prepareStatement(checkQuery);
            checkPst.setString(1, email);
            checkPst.setString(2, password);
            ResultSet rs = checkPst.executeQuery();

            if (rs.next()) {
                boolean hasVoted = rs.getBoolean("has_voted");
                if (hasVoted) {
                    System.out.println("⚠️ You have already voted.");
                } else {
                    System.out.print("Enter candidate name to vote: ");
                    String candidate = sc.nextLine();

                    // Vote the candidate
                    String voteQuery = "UPDATE candidate SET votes = votes + 1 WHERE name=?";
                    PreparedStatement votePst = con.prepareStatement(voteQuery);
                    votePst.setString(1, candidate);
                    int updated = votePst.executeUpdate();

                    if (updated > 0) {
                        // Update voter's status
                        String updateVoter = "UPDATE voter SET has_voted = TRUE WHERE email=?";
                        PreparedStatement updatePst = con.prepareStatement(updateVoter);
                        updatePst.setString(1, email);
                        updatePst.executeUpdate();

                        System.out.println("🗳️ Vote casted successfully!");
                    } else {
                        System.out.println("❌ Candidate not found.");
                    }
                }
            } else {
                System.out.println("❌ Invalid email or password.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
