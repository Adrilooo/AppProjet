package ApplicationProjet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

import static ApplicationProjet.Main.primaryStage;

public class ControllerSimulation {

    @FXML
    private Button BtnV1;

    @FXML
    private Button BtnV2;

    @FXML
    private Button BtnV3;

    @FXML
    private TextField IdChaine1;

    @FXML
    private TextField IdChaine2;

    @FXML
    private TextField IdChaine3;

    @FXML
    private TableView<?> TabChaineE1;

    @FXML
    private TableView<?> TabChaineE2;

    @FXML
    private TableView<?> TabChaineE3;

    @FXML
    private TableView<?> TabChaineS1;

    @FXML
    private TableView<?> TabChaineS2;

    @FXML
    private TableView<?> TabChaineS3;

    @FXML
    private AnchorPane bpChaine;

    @FXML
    private Button btnCProd;

    @FXML
    private Button btnCommande;

    @FXML
    private Button btnHistorique;

    @FXML
    private Button btnSimulation;

    @FXML
    private Button btnStock;

    @FXML
    private TableColumn<?, ?> colNomE1;

    @FXML
    private TableColumn<?, ?> colNomE2;

    @FXML
    private TableColumn<?, ?> colNomE3;

    @FXML
    private TableColumn<?, ?> colNomS1;

    @FXML
    private TableColumn<?, ?> colNomS2;

    @FXML
    private TableColumn<?, ?> colNomS3;

    @FXML
    private TableColumn<?, ?> colQE1;

    @FXML
    private TableColumn<?, ?> colQE2;

    @FXML
    private TableColumn<?, ?> colQE3;

    @FXML
    private TableColumn<?, ?> colQS1;

    @FXML
    private TableColumn<?, ?> colQS2;

    @FXML
    private TableColumn<?, ?> colQS3;

    @FXML
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

    @FXML
    private void PageSimulation(){
        ChargerPage("Simulation.fxml");
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

    @FXML
    void Valider1(ActionEvent event) {

    }

    @FXML
    void Valider2(ActionEvent event) {

    }

    @FXML
    void Valider3(ActionEvent event) {

    }
}