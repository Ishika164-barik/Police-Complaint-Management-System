import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComplaintManager {

    // Add complaint
    public void addComplaint(Complaint c) {
        String sql = "INSERT INTO complaints(name, email, phone, address, complaint) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getPhone());
            ps.setString(4, c.getAddress());
            ps.setString(5, c.getComplaintText());

            ps.executeUpdate();
            System.out.println("✅ Complaint Saved Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View all complaints
    public List<Complaint> getAllComplaints() {
        List<Complaint> complaints = new ArrayList<>();
        String sql = "SELECT * FROM complaints";

        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Complaint c = new Complaint(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("complaint")
                );
                complaints.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return complaints;
    }

    // Delete complaint by ID
    public void deleteComplaint(int id) {
        String sql = "DELETE FROM complaints WHERE id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("✅ Complaint Deleted");
            else System.out.println("❌ Complaint ID Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
