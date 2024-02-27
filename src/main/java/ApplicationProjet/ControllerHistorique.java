package ApplicationProjet;

import ApplicationProjet.Classes.ChangementStock;
import ApplicationProjet.Classes.Element;
import ApplicationProjet.Classes.Historique;
import ApplicationProjet.Classes.Stocks;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static ApplicationProjet.Classes.Historique.changements;
import static ApplicationProjet.Main.primaryStage;

public class ControllerHistorique implements Initializable {

    @FXML
    private AnchorPane bpHistorique;

    @FXML
    private Button btnCProd;

    @FXML
    private Button btnCommande;

    @FXML
    private Button btnHistorique;

    @FXML
    private Button btnStock;

        @FXML
    private TableColumn<ChangementStock, String> colCode;

    @FXML
    private TableColumn<ChangementStock, String> colNom;

    @FXML
    private TableColumn<ChangementStock, Float> colQte;

    @FXML
    private TableColumn<ChangementStock, String> colUnite;

    @FXML
    private TableColumn<ChangementStock, Double> colAchat;

    @FXML
    private TableColumn<ChangementStock, Float> colVente;

    @FXML
    private TableColumn<ChangementStock, String> colOrigine;

    @FXML
    private TableView<ChangementStock> tableViewStock;


    @FXML
    private void PageHistorique() {
        ChargerPage("historique.fxml");
    }

    @FXML
    private void PageChaine() {
        ChargerPage("chaineProd.fxml");
    }

    @FXML
    private void PageCommande() {
        ChargerPage("commande.fxml");
    }

    @FXML
    private void PageStock() {
        ChargerPage("stock.fxml");
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


    public void initialize(URL url, ResourceBundle resourceBundle) {


        colNom.setCellValueFactory(new PropertyValueFactory<>("codeElement"));
        colCode.setCellValueFactory(new PropertyValueFactory<>("nomElement"));
        colQte.setCellValueFactory(new PropertyValueFactory<>("quantiteModifiee"));
        colUnite.setCellValueFactory(new PropertyValueFactory<>("uniteMesure"));
        colAchat.setCellValueFactory(new PropertyValueFactory<>("prixAchat"));
        colVente.setCellValueFactory(new PropertyValueFactory<>("prixVente"));
        colOrigine.setCellValueFactory(new PropertyValueFactory<>("Origine"));

        ObservableList<ChangementStock> data = FXCollections.observableArrayList();
        data.addAll(Historique.changements);
        tableViewStock.setItems(data);
    }
}