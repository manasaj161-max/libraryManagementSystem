package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import util.DBConnection;

public class UserDAO {

    // Add User
    public void addUser(User user) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO users(name, email, password, phone) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("User added successfully!");
            } else {
                System.out.println("Failed to add user!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // View All Users
    public void viewUsers() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("User ID  : " + rs.getInt("user_id"));
                System.out.println("Name     : " + rs.getString("name"));
                System.out.println("Email    : " + rs.getString("email"));
                System.out.println("Phone    : " + rs.getString("phone"));
                System.out.println("---------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
