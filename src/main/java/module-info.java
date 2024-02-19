module example.applicationprojet {
    requires javafx.controls;
    requires javafx.fxml;

    opens ApplicationProjet.Classes;
    opens ApplicationProjet to javafx.fxml;
    exports ApplicationProjet;
}