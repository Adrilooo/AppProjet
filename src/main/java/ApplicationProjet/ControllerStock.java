package ApplicationProjet;

import ApplicationProjet.Classes.Element;
import ApplicationProjet.Classes.Stocks;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerStock implements Initializable {

    @FXML
    private Button btnCProd;

    @FXML
    private Button btnCommande;

    @FXML
    private Button btnHistorique;

    @FXML
    private Button btnStock;

    @FXML
    private TableColumn<Element, Float> colAchat;

    @FXML
    private TableColumn<Element, String> colCode;

    @FXML
    private TableColumn<Element, String> colNom;

    @FXML
    private TableColumn<Element, Float> colQte;

    @FXML
    private TableColumn<Element, String> colUnite;

    @FXML
    private TableColumn<Element, Float> colVente;

    @FXML
    private TableView<Element> tableViewStock;

    @FXML
    public void PageChaine(MouseEvent event) {
        ChargerPage("chaineProd");
    }

    @FXML
   public  void PageCommande(MouseEvent event) {
        ChargerPage("commande");
    }

    @FXML
    private void PageHistorique(MouseEvent event) {
        ChargerPage("historique");
    }
    public void ChargerPage(String page){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        } catch(IOException e ){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colAchat.setCellValueFactory(new PropertyValueFactory<>("prixAchat"));
        colVente.setCellValueFactory(new PropertyValueFactory<>("prixVente"));
        colQte.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        colUnite.setCellValueFactory(new PropertyValueFactory<>("uniteMesure"));

        ObservableList<Element> data = FXCollections.observableArrayList();
        for (Element element : Stocks.EStock) {
            data.add(element);
        }


        tableViewStock.setItems(data);
    }
}