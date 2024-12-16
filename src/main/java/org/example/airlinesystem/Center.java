package org.example.airlinesystem;

import org.example.airlinesystem.dao.FlightsDAO;
import org.example.airlinesystem.dao.TicketDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.airlinesystem.Controller.FlightsControl;
import org.example.airlinesystem.Controller.TicketControl;

import java.sql.SQLException;
import java.util.List;

public class Center {

    // Search Tab
    @FXML
    private TextField departureField; // Поле для ввода города отправления
    @FXML
    private TextField arrivalField; // Поле для ввода города прибытия
    @FXML
    private DatePicker datePicker; // Поле для выбора даты
    @FXML
    private TableView<FlightsControl> searchTableView; // Таблица для отображения рейсов
    @FXML
    private TableColumn<FlightsControl, String> departureColumn; // Столбец для города отправления
    @FXML
    private TableColumn<FlightsControl, String> arrivalColumn; // Столбец для города прибытия
    @FXML
    private TableColumn<FlightsControl, String> dateColumn; // Столбец для даты рейса
    @FXML
    private TableColumn<FlightsControl, Double> priceColumn; // Столбец для стоимости рейса
    @FXML
    private RadioButton economyRadioButton; // Кнопка для выбора эконом-класса
    @FXML
    private RadioButton businessRadioButton; // Кнопка для выбора бизнес-класса
    @FXML
    private RadioButton firstClassRadioButton; // Кнопка для выбора первого класса

    // Flights Tab
    @FXML
    private TableView<FlightsControl> flightsTableView; // Таблица для отображения всех рейсов
    @FXML
    private TableColumn<FlightsControl, String> flightIdColumn; // Столбец для ID рейса
    @FXML
    private TableColumn<FlightsControl, String> flightNumberColumn; // Столбец для номера рейса
    @FXML
    private TableColumn<FlightsControl, String> depCityColumn; // Столбец для города отправления
    @FXML
    private TableColumn<FlightsControl, String> arrCityColumn; // Столбец для города прибытия
    @FXML
    private TableColumn<FlightsControl, String> depTimeColumn; // Столбец для времени отправления
    @FXML
    private TableColumn<FlightsControl, String> arrTimeColumn; // Столбец для времени прибытия

    // Ticket Tab
    @FXML
    private TextField ticketIdField; // Поле для ввода Ticket ID
    @FXML
    private TableView<TicketControl> ticketTableView; // Таблица для отображения информации о билетах
    @FXML
    private TableColumn<TicketControl, String> ticketIdColumn; // Столбец для ID билета
    @FXML
    private TableColumn<TicketControl, String> flightIdTicketColumn; // Столбец для ID рейса
    @FXML
    private TableColumn<TicketControl, String> customerIdColumn; // Столбец для ID клиента
    @FXML
    private TableColumn<TicketControl, String> seatNumberColumn; // Столбец для номера места
    @FXML
    private TableColumn<TicketControl, String> issueDateColumn; // Столбец для даты выпуска
    @FXML
    private TableColumn<TicketControl, String> departureDateColumn; // Столбец для даты отправления
    @FXML
    private TableColumn<TicketControl, String> statusColumn; // Столбец для статуса билета

    // Метод для поиска рейсов в "Search" Tab
    @FXML
    private void onSearchFlights() {
        String departure = departureField.getText();
        String arrival = arrivalField.getText();
        String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "";

        FlightsDAO flightsDAO = new FlightsDAO();
        try {
            List<FlightsControl> flights = flightsDAO.searchFlights(departure, arrival, date);
            ObservableList<FlightsControl> observableFlights = FXCollections.observableArrayList(flights);
            searchTableView.setItems(observableFlights);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для загрузки всех рейсов в "Flights" Tab
    @FXML
    private void loadAllFlights() {
        FlightsDAO flightsDAO = new FlightsDAO();
        try {
            List<FlightsControl> flights = flightsDAO.searchFlights("", "", "");  // Пустые параметры для получения всех рейсов
            ObservableList<FlightsControl> observableFlights = FXCollections.observableArrayList(flights);
            flightsTableView.setItems(observableFlights);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для поиска билетов в "Ticket" Tab
    @FXML
    private void onSearchTicket() {
        String ticketId = ticketIdField.getText();

        TicketDAO ticketDAO = new TicketDAO();
        try {
            List<TicketControl> tickets = ticketDAO.searchTicket(Integer.parseInt(ticketId));
            ObservableList<TicketControl> observableTickets = FXCollections.observableArrayList(tickets);
            ticketTableView.setItems(observableTickets);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
