package ApplicationProjet;

import ApplicationProjet.Classes.CsvWriter;
import ApplicationProjet.Classes.Element;
import ApplicationProjet.Classes.Historique;
import ApplicationProjet.Classes.Stocks;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static ApplicationProjet.Classes.Element.trouverElement;
import static ApplicationProjet.Main.primaryStage;
import static java.lang.String.valueOf;

public class ControllerCommande implements Initializable{
    @FXML
    private AnchorPane bpCommande;

    @FXML
    private Button btnCProd;

    @FXML
    private Button btnCommande;

    @FXML
    private Button btnHistorique;

    @FXML
    private Button btnStock;

    @FXML
    private Button btnSimulation;

    @FXML
    private Button btnAchatEX;

    @FXML
    private Button btnAchatNew;



    @FXML
    private Label LabelAchat;

    @FXML
    private Label LabelAchat2;

    @FXML
    private TextField saisieCodeEx;

    @FXML
    private TextField saisieCodeNew;

    @FXML
    private TextField saisieNom;

    @FXML
    private TextField saisiePrixAchat;

    @FXML
    private TextField saisieQteEX;

    @FXML
    private TextField saisieQteNew;

    @FXML
    private TextField saisieUnite;

    @FXML
    private void PageCommande() {
        ChargerPage("commande.fxml");
    }

    @FXML
    private void PageChaine() {
        ChargerPage("chaineProd.fxml");
    }

    @FXML
    private void PageHistorique() {
        ChargerPage("historique.fxml");
    }

    @FXML
    private void PageStock() {
        ChargerPage("stock.fxml");
    }

    @FXML
    private void PageSimulation(){
        ChargerPage("Comparatif.fxml");
    }

    public void ChargerPage(String page) {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(page)));
        Parent root = null;
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
    public void achatEx(ActionEvent event) {
        Element elem = trouverElement(valueOf(saisieCodeEx.getText()));
        float qte = Float.parseFloat(saisieQteEX.getText());
        elem.Acheter(elem, qte);
        CsvWriter a = new CsvWriter();

        a.clearCSVFile("src/main/java/ApplicationProjet/elements.csv");
        a.writeCSVFile("src/main/java/ApplicationProjet/elements.csv", Stocks.EStock);
        a.clearCSVFile("src/main/java/ApplicationProjet/historique.csv");
        a.writeHistoriqueCSVFile("src/main/java/ApplicationProjet/historique.csv", Historique.changements);
        LabelAchat.setText("Commande passée");
    }

    @FXML
    public void achatNew(ActionEvent event) {
        String code = saisieCodeNew.getText();
        float qte = Float.parseFloat(saisieQteNew.getText());
        for (Element elem : Stocks.EStock){
            if (elem.getCode().equals(code)) {
                elem.Acheter(elem, qte);
                return;
            }
        }
        Element element = new Element(code, saisieNom.getText(), 0, saisieUnite.getText(), Double.parseDouble(saisiePrixAchat.getText()), 0);
        Stocks.ajouterElem(element, 0);
        element.Acheter(element, qte);
        CsvWriter a = new CsvWriter();

        a.clearCSVFile("src/main/java/ApplicationProjet/elements.csv");
        a.writeCSVFile("src/main/java/ApplicationProjet/elements.csv", Stocks.EStock);
        a.clearCSVFile("src/main/java/ApplicationProjet/historique.csv");
        a.writeHistoriqueCSVFile("src/main/java/ApplicationProjet/historique.csv", Historique.changements);
        LabelAchat2.setText("Commande passée");
    }

    public void initialize(URL url, ResourceBundle resourceBundle){

    }
}