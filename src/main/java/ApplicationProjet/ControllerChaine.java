package ApplicationProjet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerChaine {

    @FXML
    private Button btnCProd;

    @FXML
    private Button btnCommande;

    @FXML
    private Button btnHistorique;

    @FXML
    private Button btnStock;

    @FXML
    void PageCommande(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/ApplicationProjet/commande.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void PageHistorique(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/ApplicationProjet/historique.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void PageStock(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/ApplicationProjet/stock.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
