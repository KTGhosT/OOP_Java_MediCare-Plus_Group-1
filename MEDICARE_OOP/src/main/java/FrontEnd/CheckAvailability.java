package FrontEnd;

import FrontEnd.JavaMailSender;
import FrontEnd.Outofstock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CheckAvailability {
    public static void checkAllMedicines(String pharmacistEmail) {
        
        
        String query = "SELECT name FROM pharmacy WHERE availa < 5"; 
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
             
            boolean stocklow = false;
            StringBuilder medicineList = new StringBuilder();
            
            while (rs.next()) {
                stocklow = true;
                medicineList.append(rs.getString("name")).append("\n");
            }

            if (stocklow) {
                System.out.println("Some medicines are out of stock! Sending email...");
                Outofstock.sendEmail("KT_Ghosty@hotmail.com", "Out of Stock Medicines," +
                    " The following medicines are out of stock:\n" + medicineList.toString());
            } else {
                System.out.println("All medicines are in stock.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        checkAllMedicines("KT_Ghosty@hotmail.com"); // Replace with real pharmacist email
    }
}
