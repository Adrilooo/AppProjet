package ApplicationProjet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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
        ChargerPage("PageChaine");
    }

    @FXML
    public void PageHistorique(MouseEvent event) {
        ChargerPage("PageHistorique");
    }

    @FXML
    public void PageStock(MouseEvent event) {
        bp.setCenter(ap);
    }

    @FXML
    public void PageCommande(MouseEvent event) {
        ChargerPage("test_page1");
    }
    private void ChargerPage(String page){
        Parent root = null;
        try{
            root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource(page + ".fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bp.setCenter(root);
    }
}
