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

public class ControllerCommande{

    /**
     * Ancre pour contenir les composants de la page de gestion des commandes.
     */
    @FXML
    private AnchorPane bpCommande;

    /**
     * Bouton pour accéder à la chaîne de production.
     */
    @FXML
    private Button btnCProd;

    /**
     * Bouton pour accéder à la gestion des commandes.
     */
    @FXML
    private Button btnCommande;

    /**
     * Bouton pour accéder à l'historique.
     */
    @FXML
    private Button btnHistorique;

    /**
     * Bouton pour accéder au stock.
     */
    @FXML
    private Button btnStock;

    /**
     * Bouton pour accéder à la simulation de production.
     */
    @FXML
    private Button btnSimulation;

    /**
     * Bouton pour passer une commande sur un élément existant.
     */
    @FXML
    private Button btnAchatEX;

    /**
     * Bouton pour passer une commande sur un nouvel élément.
     */
    @FXML
    private Button btnAchatNew;

    /**
     * Label pour afficher un message après avoir passé une commande sur un élément existant.
     */
    @FXML
    private Label LabelAchat;

    /**
     * Label pour afficher un message après avoir passé une commande sur un nouvel élément.
     */
    @FXML
    private Label LabelAchat2;

    /**
     * Champ de texte pour saisir le code de l'élément existant à commander.
     */
    @FXML
    private TextField saisieCodeEx;

    /**
     * Champ de texte pour saisir le code du nouvel élément à commander.
     */
    @FXML
    private TextField saisieCodeNew;

    /**
     * Champ de texte pour saisir le nom du nouvel élément à commander.
     */
    @FXML
    private TextField saisieNom;

    /**
     * Champ de texte pour saisir le prix d'achat du nouvel élément à commander.
     */
    @FXML
    private TextField saisiePrixAchat;


    /**
     * Champ de texte pour saisir la quantité de l'élément existant à commander.
     */
    @FXML
    private TextField saisieQteEX;

    /**
     * Champ de texte pour saisir la quantité du nouvel élément à commander.
     */
    @FXML
    private TextField saisieQteNew;

    /**
     * Champ de texte pour saisir l'unité du nouvel élément à commander.
     */
    @FXML
    private TextField saisieUnite;

    /**
     * Méthode permettant de charger la page de l'historique.
     */
    @FXML
    private void PageHistorique() {
        ChargerPage("historique.fxml");
    }

    /**
     * Méthode permettant de charger la page de la chaîne de production.
     */
    @FXML
    private void PageChaine() {
        ChargerPage("chaineProd.fxml");
    }

    /**
     * Méthode permettant de charger la page de gestion des commandes.
     */
    @FXML
    private void PageCommande() {
        ChargerPage("commande.fxml");
    }

    /**
     * Méthode permettant de recharger la page Stock.
     */
    @FXML
    private void PageStock() {
        ChargerPage("stock.fxml");
    }

    /**
     * Méthode permettant de charger la page de simulation de production.
     */
    @FXML
    private void PageSimulation(){
        ChargerPage("Comparatif.fxml");
    }

    /**
     * Charge une nouvelle page FXML dans la fenêtre principale.
     *
     * @param page Le nom du fichier FXML à charger.
     */
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

    /**
     * Méthode appelée lorsqu'une commande sur un élément existant est passée.
     *
     * @param event L'événement associé à l'action.
     */
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

    /**
     * Méthode appelée lorsqu'une commande sur un nouvel élément est passée.
     *
     * @param event L'événement associé à l'action.
     */
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
}