package org.example.airlinesystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.example.DatabaseConnection;  // Не забудьте импортировать DatabaseConnection

public class LoginDAO {

    // Метод для проверки данных пользователя
    public boolean validate(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?"; // Ваш SQL запрос для проверки

        try (Connection conn = DatabaseConnection.getConnection();  // Используем getConnection()
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet resultSet = stmt.executeQuery();

            // Если результат не пустой, то пользователь найден
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;  // Если пользователь не найден
    }
}
