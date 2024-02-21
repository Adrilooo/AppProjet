package ApplicationProjet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControllerCommande {

    @FXML
    private Button btnCProd;

    @FXML
    private Button btnCommande;

    @FXML
    private Button btnHistorique;

    @FXML
    private Button btnStock;

    @FXML
    public void PageCommande(MouseEvent event) {
        ChargerPage("commande");
    }

    @FXML
    public void PageChaine(MouseEvent event) {
        ChargerPage("chaineProd");
    }

    @FXML
    public void PageHistorique(MouseEvent event) {
        ChargerPage("historique");
    }

    @FXML
    public void PageStock(MouseEvent event) {
        ChargerPage("stock");
    }

    public void ChargerPage(String page){
        Parent root = null;
        try{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page + ".fxml")));
        } catch(IOException e ){
            e.printStackTrace();
        }
    }
}