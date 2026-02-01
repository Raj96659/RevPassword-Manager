package com.passwordmanager.dao;

import com.passwordmanager.model.User;
import com.passwordmanager.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    // Save new user (registration)
    public void saveUser(User user) {
        String sql = "INSERT INTO users(name, email, master_password) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getMasterPassword());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Find user by email & encrypted password (login)
    public User findByEmailAndPassword(String email, String encryptedPassword) {

        String sql = "SELECT * FROM users WHERE email = ? AND master_password = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, encryptedPassword);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMasterPassword(rs.getString("master_password"));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User findByEmail(String email) {

        String sql = "SELECT * FROM users WHERE email=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateMasterPassword(int userId, String encryptedPassword) {

        String sql = "UPDATE users SET master_password=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, encryptedPassword);
            ps.setInt(2, userId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateProfile(int userId, String name, String email) {

        String sql = "UPDATE users SET name=?, email=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, userId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}

