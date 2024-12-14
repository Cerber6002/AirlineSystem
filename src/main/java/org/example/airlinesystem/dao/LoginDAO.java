package org.example.airlinesystem.dao;

import org.example.DatabaseConnection;

import java.sql.*;

public class LoginDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/final_project";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123";


    public boolean validate(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Возвращает true, если найдена запись, соответствующая учетным данным

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
