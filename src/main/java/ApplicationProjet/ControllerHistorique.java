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

    /**
     * Panneau principal contenant les éléments de l'interface.
     *
     */
    @FXML
    private AnchorPane bpHistorique;

    /**
     * Bouton permettant d'accéder à la chaîne de production.
     *
     */
    @FXML
    private Button btnCProd;

    /**
     * Bouton permettant d'accéder à la gestion des commandes.
     *
     */
    @FXML
    private Button btnCommande;

    /**
     * Bouton permettant d'accéder à l'historique.
     *
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
     *
     */
    @FXML
    private Button btnSimulation;

    /**
     * Colonne du tableau affichant le code de l'élément.
     *
     */
    @FXML
    private TableColumn<ChangementStock, String> colCode;

    /**
     * Colonne du tableau affichant le nom de l'élément.
     *
     */
    @FXML
    private TableColumn<ChangementStock, String> colNom;

    /**
     * Colonne du tableau affichant la quantité modifiée.
     *
     */
    @FXML
    private TableColumn<ChangementStock, Float> colQte;

    /**
     * Colonne du tableau affichant l'unité de mesure.
     *
     */
    @FXML
    private TableColumn<ChangementStock, String> colUnite;

    /**
     * Colonne du tableau affichant le prix d'achat.
     *
     */
    @FXML
    private TableColumn<ChangementStock, Double> colAchat;

    /**
     * Colonne du tableau affichant le prix de vente.
     *
     */
    @FXML
    private TableColumn<ChangementStock, Float> colVente;

    /**
     * Colonne du tableau affichant l'origine du changement.
     *
     */
    @FXML
    private TableColumn<ChangementStock, String> colOrigine;

    /**
     * TableView affichant la liste des changements de stock.
     *
     */
    @FXML
    private TableView<ChangementStock> tableViewStock;

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
     * @param resourceBundle Les ressources utilisées pour localiser l'objet racine, ou null si l'objet racine n'a pas été localisé.
     */
    @Override
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