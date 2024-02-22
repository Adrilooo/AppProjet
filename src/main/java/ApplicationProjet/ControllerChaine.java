package ApplicationProjet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static ApplicationProjet.Main.primaryStage;

public class ControllerChaine implements Initializable {

    @FXML
    private AnchorPane bpChaine;

    @FXML
    private Button btnCProd;
    @FXML
    private Button btnCommande;
    @FXML
    private Button btnHistorique;
    @FXML
    private Button btnStock;
    @FXML
    public void PageCommande() {
        ChargerPage("commande.fxml");

    }

    @FXML
    private void PageHistorique() {
        ChargerPage("historique.fxml");
    }
    @FXML
    private void PageStock() {
        ChargerPage("stock.fxml");
    }

    @FXML
    private void PageChaine() {
        ChargerPage("chaineProd.fxml");
    }

    public void ChargerPage(String page) {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(page)));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initialize(URL url, ResourceBundle resourceBundle){

    }
}