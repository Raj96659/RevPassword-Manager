package com.passwordmanager.dao;

import com.passwordmanager.model.SecurityQuestion;
import com.passwordmanager.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SecurityQuestionDao {

    public void addQuestion(SecurityQuestion sq) {

        String sql = "INSERT INTO security_questions(user_id, question, answer) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, sq.getUserId());
            ps.setString(2, sq.getQuestion());
            ps.setString(3, sq.getAnswer());

            ps.executeUpdate();
            System.out.println("✅ Security question added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SecurityQuestion> getQuestionsByUser(int userId) {

        List<SecurityQuestion> list = new ArrayList<>();
        String sql = "SELECT * FROM security_questions WHERE user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SecurityQuestion sq = new SecurityQuestion();
                sq.setQuestion(rs.getString("question"));
                sq.setAnswer(rs.getString("answer"));
                list.add(sq);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
