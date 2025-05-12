module com.crowdle {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.crowdle to javafx.fxml;
    exports com.crowdle;
}