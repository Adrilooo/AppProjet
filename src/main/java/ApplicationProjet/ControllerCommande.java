package ApplicationProjet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControllerCommande {
    @FXML
    private AnchorPane bpCommande;

    @FXML
    private Button btnCProd;

    @FXML
    private Button btnCommande;

    @FXML
    private Button btnHistorique;

    @FXML
    private Button btnStock;

    @FXML
    public void PageCommande(MouseEvent event) throws IOException {
        ChargerPage("commande.fxml");
    }

    @FXML
    public void PageChaine(MouseEvent event) throws IOException {
        ChargerPage("chaineProd.fxml");
    }

    @FXML
    public void PageHistorique(MouseEvent event) throws IOException {
        ChargerPage("historique.fxml");
    }

    @FXML
    public void PageStock(MouseEvent event) throws IOException {
        ChargerPage("stock.fxml");
    }

    public void ChargerPage(String page) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Main.primaryStage.setScene(scene);
        Main.primaryStage.show();
    }
}