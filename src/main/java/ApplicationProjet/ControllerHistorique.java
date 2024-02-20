package ApplicationProjet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ControllerHistorique {

    @FXML
    private TableColumn<?, ?> ColOrigine;

    @FXML
    private Button btnCProd;

    @FXML
    private Button btnCommande;

    @FXML
    private Button btnHistorique;

    @FXML
    private Button btnStock;

    @FXML
    private TableColumn<?, ?> colAchat;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colNom;

    @FXML
    private TableColumn<?, ?> colQte;

    @FXML
    private TableColumn<?, ?> colUnite;

    @FXML
    private TableColumn<?, ?> colVente;

    @FXML
    private TableView<?> tableViewStock;

    @FXML
    void PageChaine(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/ApplicationProjet/chaineProd.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

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
