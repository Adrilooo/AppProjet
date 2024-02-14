module example.applicationprojet {
    requires javafx.controls;
    requires javafx.fxml;


    opens ApplicationProjet to javafx.fxml;
    exports ApplicationProjet;
}