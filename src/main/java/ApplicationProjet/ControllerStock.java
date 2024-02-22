package ApplicationProjet;

import ApplicationProjet.Classes.Element;
import ApplicationProjet.Classes.Stocks;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.io.IOException;

import static ApplicationProjet.Main.primaryStage;

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
    private Button btnVendre;

    @FXML
    private TextField InputCode;

    @FXML
    private TextField InputQ;

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
    private TableColumn< Element, Float> colVente;

    @FXML
    private TableView<Element> tableViewStock;

    public void PageStock() {
        ChargerPage("stock.fxml");
    }

    @FXML
    public void PageChaine() {
        ChargerPage("chaineProd.fxml");
    }

    @FXML
    public void PageCommande() {
        ChargerPage("commande.fxml");
    }

    @FXML
    public void PageHistorique() {
        ChargerPage("historique.fxml");
    }


    public void StockVendre(ActionEvent event){

        float f = Float.parseFloat((InputQ.getText()));
        Element e;
        e = (Element.trouverElement(String.valueOf(InputCode)));
        Element.Vendre(e, f);
    }









    public void ChargerPage(String page) {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(page)));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colAchat.setCellValueFactory(new PropertyValueFactory<>("prixAchat"));
        colVente.setCellValueFactory(new PropertyValueFactory<>("prixVente"));
        colQte.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        colUnite.setCellValueFactory(new PropertyValueFactory<>("uniteMesure"));

        ObservableList <Element> data = FXCollections.observableArrayList();
        data.addAll(Stocks.EStock);
        tableViewStock.setItems(data);
    }
}