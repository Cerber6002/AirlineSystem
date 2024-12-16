package org.example.airlinesystem.dao;
import org.example.airlinesystem.Controller.TicketControl;
import org.example.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    public List<TicketControl> searchTicket(int ticketId) throws SQLException {
        List<TicketControl> tickets = new ArrayList<>();
        String query = "SELECT * FROM tickets WHERE ticket_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, ticketId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tickets.add(new TicketControl(
                        resultSet.getInt("ticket_id"),
                        resultSet.getInt("flight_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getString("seat_number"),
                        resultSet.getString("issue_date"),
                        resultSet.getString("departure_date"),
                        resultSet.getString("status")
                ));
            }
        }
        return tickets;
    }
}
