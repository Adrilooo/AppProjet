package ApplicationProjet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerTest {

    @FXML
    private Stage primaryStage;

    @FXML
    private BorderPane bp;

    @FXML
    private AnchorPane ap;

    @FXML
    private Button btnCProd;

    @FXML
    private Button btnCommande;

    @FXML
    private Button btnHistorique;

    @FXML
    private Button btnStock;

    @FXML
    public void PageChaine(MouseEvent event) throws IOException {
        ChargerPage("chaine.fxml");
    }

    @FXML
    public void PageHistorique(MouseEvent event) throws IOException {
        ChargerPage("historique.fxml");
    }

    @FXML
    public void PageStock(MouseEvent event) throws IOException {
        ChargerPage("stock.fxml");
    }

    @FXML
    public void PageCommande(ActionEvent event) throws IOException {
        ChargerPage("commande.fxml");
    }
    public void ChargerPage(String page) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage primary = Main.getPrimaryStage();
        primary.setScene(scene);
        primary.show();
    }
}
