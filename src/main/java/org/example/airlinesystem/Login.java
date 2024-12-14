package org.example.airlinesystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.airlinesystem.dao.LoginDAO;

public class Login {

    @FXML
    private Button loginButton; // Кнопка для входа

    @FXML
    private TextField enterEmail; // Поле для ввода email

    @FXML
    private PasswordField passwordField; // Поле для ввода пароля

    @FXML
    private Label errorLabel; // Метка для отображения ошибок

    private LoginDAO loginDAO = new LoginDAO(); // Экземпляр LoginDAO

    // Метод, вызываемый при нажатии на кнопку "Login"
    @FXML
    void onLoginButtonClick(ActionEvent event) {
        String email = enterEmail.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Все поля должны быть заполнены!");
            errorLabel.setStyle("-fx-text-fill: red;");
        } else {
            boolean isValid = loginDAO.validate(email, password);
            if (isValid) {
                errorLabel.setText("Вход выполнен успешно!");
                errorLabel.setStyle("-fx-text-fill: green;");
                // Здесь можно добавить логику перехода на следующий экран
            } else {
                errorLabel.setText("Неверный email или пароль!");
                errorLabel.setStyle("-fx-text-fill: red;");
            }
        }
    }
}
