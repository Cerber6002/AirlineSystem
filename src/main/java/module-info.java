module org.example.airlinesystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens org.example.airlinesystem to javafx.fxml;
    exports org.example.airlinesystem;
}