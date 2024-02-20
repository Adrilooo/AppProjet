package ApplicationProjet;

import ApplicationProjet.Classes.Element;
import ApplicationProjet.Classes.Stocks;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button Historique;

    @FXML
    private Button btnCProc;

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


    public void PageStock(){

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
        System.out.println("Nombre d'éléments dans la TableView : " + data.size());
        System.out.println("Taille de Stocks.EStock : " + Stocks.EStock.size());

    }
}