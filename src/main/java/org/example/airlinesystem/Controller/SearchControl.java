package org.example.airlinesystem.Controller;

public class SearchControl {
    private String departureCity;   // Город отправления
    private String arrivalCity;     // Город прибытия
    private String date;            // Дата поиска (можно заменить на LocalDate)
    private int customerId;         // ID клиента, выполняющего поиск

    // Конструктор
    public SearchControl(String departureCity, String arrivalCity, String date, int customerId) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.date = date;
        this.customerId = customerId;
    }

    // Геттеры и сеттеры
    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
