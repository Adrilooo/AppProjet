package ApplicationProjet;

import ApplicationProjet.Classes.Element;
import ApplicationProjet.Classes.Stocks;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class ControllerHistorique {

    @FXML
    private AnchorPane bpHistorique;

    @FXML
    private TableColumn<?, ?> ColOrigine;

    @FXML
    private Button btnCProd;

    @FXML
    private Button btnCommande;

    @FXML
    private Button btnHistorique;

    @FXML
    private Button btnStock;

    @FXML
    private TableColumn<?, ?> colAchat;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colNom;

    @FXML
    private TableColumn<?, ?> colQte;

    @FXML
    private TableColumn<?, ?> colUnite;

    @FXML
    private TableColumn<?, ?> colVente;

    @FXML
    private TableColumn<?, ?> colOrigine;

    @FXML
    private TableView<Element> tableViewStock;


    @FXML
    public void PageHistorique(MouseEvent event) throws IOException {
        ChargerPage("historique.fxml");
    }

    @FXML
    public void PageChaine(MouseEvent event) throws IOException {
        ChargerPage("chaineProd.fxml");
    }

    @FXML
    public void PageCommande(MouseEvent event) throws IOException {
        ChargerPage("commande.fxml");
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

    public void initialize(URL url, ResourceBundle resourceBundle) {

        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colQte.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        colUnite.setCellValueFactory(new PropertyValueFactory<>("uniteMesure"));
        colAchat.setCellValueFactory(new PropertyValueFactory<>("prixAchat"));
        colVente.setCellValueFactory(new PropertyValueFactory<>("prixVente"));
        colOrigine.setCellValueFactory(new PropertyValueFactory<>("Origine"));

        ObservableList<Element> data = FXCollections.observableArrayList();
        for (Element element : Stocks.EStock) {
            data.add(element);
        }
        tableViewStock.setItems(data);
    }
}
