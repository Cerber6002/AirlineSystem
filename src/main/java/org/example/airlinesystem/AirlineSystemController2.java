package org.example.airlinesystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AirlineSystemController2 {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}