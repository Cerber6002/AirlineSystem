package org.example.airlinesystem.dao;

import org.example.airlinesystem.Controller.FlightsControl;
import org.example.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchDAO {

    public List<FlightsControl> searchFlights(String departure, String arrival, String date, int customerId) throws SQLException {
        List<FlightsControl> flights = new ArrayList<>();
        String query = "SELECT * FROM flights WHERE departure_city LIKE ? AND arrival_city LIKE ? AND departure_date LIKE ? AND customer_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Подстановка параметров в запрос
            statement.setString(1, departure.isEmpty() ? "%" : departure);
            statement.setString(2, arrival.isEmpty() ? "%" : arrival);
            statement.setString(3, date.isEmpty() ? "%" : date);
            statement.setInt(4, customerId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                flights.add(new FlightsControl(
                        resultSet.getString("flight_id"),
                        resultSet.getString("departure_city"),
                        resultSet.getString("arrival_city"),
                        resultSet.getString("departure_time"),
                        resultSet.getString("arrival_time"),
                        resultSet.getDouble("price")
                ));
            }
        }
        return flights;
    }
}
