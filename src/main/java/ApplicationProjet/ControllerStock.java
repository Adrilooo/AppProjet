package ApplicationProjet;

import ApplicationProjet.Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.io.IOException;

import static ApplicationProjet.Classes.Element.trouverElement;
import static ApplicationProjet.Classes.Historique.ajouterChangement;
import static ApplicationProjet.Main.primaryStage;
import static java.lang.String.valueOf;

public class ControllerStock implements Initializable {

    /**
     * Bouton permettant d'accéder à la chaîne de production.
     */
    @FXML
    private Button btnCProd;

    /**
     * Bouton permettant d'accéder à la gestion des commandes.
     */
    @FXML
    private Button btnCommande;

    /**
     * Bouton permettant d'accéder à l'historique.
     */
    @FXML
    private Button btnHistorique;

    /**
     * Bouton permettant d'accéder au stock .
     */
    @FXML
    private Button btnStock;

    /**
     * Bouton permettant d'accéder à la simulation de production.
     */
    @FXML
    private Button btnSimulation;

    /**
     * Bouton permettant de vendre des éléments du stock.
     */
    @FXML
    private Button btnVendre;

    /**
     * Champ de texte permettant de saisir le code de l'élément à vendre.
     */
    @FXML
    private TextField InputCode;

    /**
     * Champ de texte permettant de saisir la quantité à vendre.
     */
    @FXML
    private TextField InputQ;

    /**
     * Label affichant un message d'erreur si la quantite est invalide lors de la vente.
     */
    @FXML
    private  Label ErreurVendre;

    /**
     * Colonne du tableau affichant le prix d'achat.
     */
    @FXML
    private TableColumn<Element, Float> colAchat;

    /**
     * Colonne du tableau affichant le code de l'élément.
     */
    @FXML
    private TableColumn<Element, String> colCode;

    /**
     * Colonne du tableau affichant le nom de l'élément.
     */
    @FXML
    private TableColumn<Element, String> colNom;

    /**
     * Colonne du tableau affichant la quantité disponible.
     */
    @FXML
    private TableColumn<Element, Float> colQte;

    /**
     * Colonne du tableau affichant l'unité de mesure.
     */
    @FXML
    private TableColumn<Element, String> colUnite;

    /**
     * Colonne du tableau affichant le prix de vente.
     */
    @FXML
    private TableColumn< Element, Float> colVente;

    /**
     * TableView affichant la liste des éléments du stock.
     */
    @FXML
    private TableView<Element> tableViewStock;

    /**
     * Méthode permettant de recharger la page Stock.
     */
    public void PageStock() {
        ChargerPage("stock.fxml");
    }

    /**
     * Méthode permettant de charger la page de la chaîne de production.
     */
    @FXML
    public void PageChaine() {
        ChargerPage("chaineProd.fxml");
    }

    /**
     * Méthode permettant de charger la page de gestion des commandes.
     */
    @FXML
    public void PageCommande() {
        ChargerPage("commande.fxml");
    }

    /**
     * Méthode permettant de charger la page de l'historique des actions.
     */
    @FXML
    public void PageHistorique() {
        ChargerPage("historique.fxml");
    }

    /**
     * Méthode permettant de charger la page de simulation de production.
     */
    @FXML
    private void PageSimulation(){
        ChargerPage("Comparatif.fxml");
    }

    /**
     * Méthode gérant la vente d'éléments du stock.
     *
     * @param event L'événement déclenché par le clic sur le bouton "Vendre".
     */
    public void StockVendre(ActionEvent event){
        float quantiteVente = Float.parseFloat(InputQ.getText());
        Element e = trouverElement(valueOf(InputCode.getText()));
        if (quantiteVente > e.getQuantite()){
            ErreurVendre.setText("Stock insuffisant");
        }
        else {
            ErreurVendre.setText(" ");
        }
        Element.Vendre(e, quantiteVente);
        tableViewStock.refresh();
        CsvWriter a = new CsvWriter();

        a.clearCSVFile("src/main/java/ApplicationProjet/elements.csv");
        a.writeCSVFile("src/main/java/ApplicationProjet/elements.csv", Stocks.EStock);
        a.clearCSVFile("src/main/java/ApplicationProjet/historique.csv");
        a.writeHistoriqueCSVFile("src/main/java/ApplicationProjet/historique.csv", Historique.changements);

    }

    /**
     * Méthode permettant de charger une page FXML spécifique.
     *
     * @param page Le chemin du fichier FXML à charger.
     */
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

    /**
     * Méthode d'initialisation du contrôleur.
     *
     * @param url  L'emplacement utilisé pour résoudre les chemins relatifs pour l'objet racine, ou null si l'emplacement est inconnu.
     * @param resourceBundle  Les ressources utilisées pour localiser l'objet racine, ou null si l'objet racine n'a pas été localisé.
     */
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