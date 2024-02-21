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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.io.IOException;

public class ControllerStock implements Initializable {

    @FXML
    private AnchorPane bpStock;


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
    private TableColumn< Element, Float> colVente;

    @FXML
    private TableView<Element> tableViewStock;

    public void PageStock(ActionEvent event) throws IOException {
        ChargerPage("stock.fxml");
    }

    @FXML
    public void PageChaine(ActionEvent event) throws IOException {
        ChargerPage("chaineProd.fxml");
    }

    @FXML
   public  void PageCommande(ActionEvent event) throws IOException {
        ChargerPage("commande.fxml");
    }

    @FXML
    private void PageHistorique(ActionEvent event) throws IOException {
        ChargerPage("historique.fxml");
    }

    public void ChargerPage(String page) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Main.primaryStage.setScene(scene);
        Main.primaryStage.show();
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