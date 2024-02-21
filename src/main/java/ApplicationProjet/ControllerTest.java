package ApplicationProjet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
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

    private BorderPane bp;

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
    public void PageChaine(MouseEvent event) {
        ChargerPage("c  haine");
    }

    @FXML
    public void PageHistorique(MouseEvent event) {
        ChargerPage("historique");
    }

    @FXML
    public void PageStock(MouseEvent event) {
        bp.setCenter(ap);
    }

    @FXML
    public void PageCommande(MouseEvent event) {
        ChargerPage("test_page1");
    }
    public void ChargerPage(String page){
        Parent root = null;
        try{
            root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource(page + ".fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bp.setCenter(root);
    }
    /*
    public void ChargerPage2(String page, String onglet, ActionEvent AE) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page)));
        Stage stage = (Stage) ((Node) AE.getSource()).getScene.getWindow();
    }
    */
}
