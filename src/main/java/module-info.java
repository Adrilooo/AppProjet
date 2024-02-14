module example.applicationprojet {
    requires javafx.controls;
    requires javafx.fxml;


    opens example.applicationprojet to javafx.fxml;
    exports example.applicationprojet;
}