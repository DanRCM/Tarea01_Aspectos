module com.edu.espol.observer2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.edu.espol.observer2 to javafx.fxml;
    exports com.edu.espol.observer2;
}
