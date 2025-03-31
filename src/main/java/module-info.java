module com.example.labstream02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.labstream02 to javafx.fxml;
    exports com.example.labstream02;
}