package org.example.airlinesystem.Controller;

public class TicketControl {
    private String ticketId;         // ID билета
    private String flightId;         // ID рейса
    private String customerId;       // ID клиента
    private String seatNumber;       // Номер места
    private String issueDate;        // Дата выпуска билета
    private String departureDate;    // Дата отправления
    private String status;           // Статус билета (например, "выкуплен", "отменен" и т.д.)

    // Конструктор
    public TicketControl(int ticketId, int flightId, int customerId,
                         String seatNumber, String issueDate, String departureDate, String status) {
        this.ticketId = String.valueOf(ticketId);
        this.flightId = String.valueOf(flightId);
        this.customerId = String.valueOf(customerId);
        this.seatNumber = seatNumber;
        this.issueDate = issueDate;
        this.departureDate = departureDate;
        this.status = status;
    }

    // Геттеры и сеттеры
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
