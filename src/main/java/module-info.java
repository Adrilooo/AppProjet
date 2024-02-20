module example.applicationprojet {
    requires javafx.controls;
    requires javafx.fxml;

    opens ApplicationProjet.Classes;
    exports ApplicationProjet;
    opens ApplicationProjet;
}