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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static ApplicationProjet.Main.primaryStage;

public class ControllerChaine implements Initializable {

    /**
     * Ancre pour contenir les composants de la page de gestion des chaînes de production.
     */
    @FXML
    private AnchorPane bpChaine;

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
     * Bouton pour valider la commande de la première chaîne de production.
     */
    @FXML
    private Button BtnV1;

    /**
     * Bouton pour valider la commande de la deuxième chaîne de production.
     */
    @FXML
    private Button BtnV2;

    /**
     * Bouton pour valider la commande de la troisième chaîne de production.
     */
    @FXML
    private Button BtnV3;

    /**
     * Label pour afficher le coût de la commande de la première chaîne de production.
     */
    @FXML
    private Label Cout1;

    /**
     * Label pour afficher le coût de la commande de la deuxième chaîne de production.
     */
    @FXML
    private Label Cout2;

    /**
     * Label pour afficher le coût de la commande de la troisième chaîne de production.
     */
    @FXML
    private Label Cout3;

    /**
     * Label pour afficher les erreurs lors de la validation de la commande de la première chaîne de production.
     */
    @FXML
    private Label Erreur1;

    /**
     * Label pour afficher les erreurs lors de la validation de la commande de la deuxième chaîne de production.
     */
    @FXML
    private Label Erreur2;

    /**
     * Label pour afficher les erreurs lors de la validation de la commande de la troisième chaîne de production.
     */
    @FXML
    private Label Erreur3;

    /**
     * Champ de texte pour saisir l'identifiant de la première chaîne de production.
     */
    @FXML
    private TextField IdChaine1;

    /**
     * Champ de texte pour saisir l'identifiant de la deuxième chaîne de production.
     */
    @FXML
    private TextField IdChaine2;

    /**
     * Champ de texte pour saisir l'identifiant de la troisième chaîne de production.
     */
    @FXML
    private TextField IdChaine3;

    /**
     * Tableau pour afficher les éléments d'entrée de la première chaîne de production.
     */
    @FXML
    private TableView<Element> TabChaineE1;


    /**
     * Tableau pour afficher les éléments d'entrée de la deuxième chaîne de production.
     */
    @FXML
    private TableView<Element> TabChaineE2;

    /**
     * Tableau pour afficher les éléments d'entrée de la troisième chaîne de production.
     */
    @FXML
    private TableView<Element> TabChaineE3;

    /**
     * Tableau pour afficher les éléments de sortie de la première chaîne de production.
     */
    @FXML
    private TableView<Element> TabChaineS1;

    /**
     * Tableau pour afficher les éléments de sortie de la deuxième chaîne de production.
     */
    @FXML
    private TableView<Element> TabChaineS2;

    /**
     * Tableau pour afficher les éléments de sortie de la troisième chaîne de production.
     */
    @FXML
    private TableView<Element> TabChaineS3;

    /**
     * Colonne pour afficher le nom des éléments d'entrée de la première chaîne de production.
     */
    @FXML
    private TableColumn<Element, String> colNomE1;

    /**
     * Colonne pour afficher le nom des éléments d'entrée de la deuxième chaîne de production.
     */
    @FXML
    private TableColumn<Element, String> colNomE2;

    /**
     * Colonne pour afficher le nom des éléments d'entrée de la troisième chaîne de production.
     */
    @FXML
    private TableColumn<Element, String> colNomE3;

    /**
     * Colonne pour afficher le nom des éléments de sortie de la première chaîne de production.
     */
    @FXML
    private TableColumn<Element, String> colNomS1;

    /**
     * Colonne pour afficher le nom des éléments de sortie de la deuxième chaîne de production.
     */
    @FXML
    private TableColumn<Element, String> colNomS2;

    /**
     * Colonne pour afficher le nom des éléments de sortie de la troisième chaîne de production.
     */
    @FXML
    private TableColumn<Element, String> colNomS3;

    /**
     * Colonne pour afficher la quantité des éléments d'entrée de la première chaîne de production.
     */
    @FXML
    private TableColumn<Element, Float> colQE1;

    /**
     * Colonne pour afficher la quantité des éléments d'entrée de la deuxième chaîne de production.
     */
    @FXML
    private TableColumn<Element, Float> colQE2;

    /**
     * Colonne pour afficher la quantité des éléments d'entrée de la troisième chaîne de production.
     */
    @FXML
    private TableColumn<Element, Float> colQE3;

    /**
     * Colonne pour afficher la quantité des éléments de sortie de la première chaîne de production.
     */
    @FXML
    private TableColumn<Element, Float> colQS1;

    /**
     * Colonne pour afficher la quantité des éléments de sortie de la deuxième chaîne de production.
     */
    @FXML
    private TableColumn<Element, Float> colQS2;

    /**
     * Colonne pour afficher la quantité des éléments de sortie de la troisième chaîne de production.
     */
    @FXML
    private TableColumn<Element, Float> colQS3;


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
     * Initialise le contrôleur après que son contenu a été complètement chargé.
     * Cette méthode est appelée automatiquement après que le fichier FXML
     * associé a été chargé.
     *
     * @param url            L'URL utilisée pour rechercher le fichier FXML.
     * @param resourceBundle Les ressources localisées.
     */
    public void initialize(URL url, ResourceBundle resourceBundle){
        colNomE1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colNomE2.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colNomE3.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colNomS1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colNomS2.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colNomS3.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colQE1.setCellValueFactory(new PropertyValueFactory<>("quantiteEnProd"));
        colQE2.setCellValueFactory(new PropertyValueFactory<>("quantiteEnProd"));
        colQE3.setCellValueFactory(new PropertyValueFactory<>("quantiteEnProd"));
        colQS1.setCellValueFactory(new PropertyValueFactory<>("quantiteEnProd"));
        colQS2.setCellValueFactory(new PropertyValueFactory<>("quantiteEnProd"));
        colQS3.setCellValueFactory(new PropertyValueFactory<>("quantiteEnProd"));

        ObservableList<Element> dataE1 = FXCollections.observableArrayList();
        ObservableList<Element> dataE2 = FXCollections.observableArrayList();
        ObservableList<Element> dataE3 = FXCollections.observableArrayList();
        ObservableList<Element> dataS1 = FXCollections.observableArrayList();
        ObservableList<Element> dataS2 = FXCollections.observableArrayList();
        ObservableList<Element> dataS3 = FXCollections.observableArrayList();

        for (ChaineProduction c : CSV.Chaines){
            if(c.getCode().equals("C001")){
                dataE1.addAll(c.getElementsEntreeKeys());
                dataS1.addAll(c.getElementsSortieKeys());
                TabChaineE1.setItems(dataE1);
                TabChaineS1.setItems(dataS1);
            }
            if(c.getCode().equals("C002")){
                dataE2.addAll(c.getElementsEntreeKeys());
                dataS2.addAll(c.getElementsSortieKeys());
                TabChaineE2.setItems(dataE2);
                TabChaineS2.setItems(dataS2);
            }
            if(c.getCode().equals("C003")){
                dataE3.addAll(c.getElementsEntreeKeys());
                dataS3.addAll(c.getElementsSortieKeys());
                TabChaineE3.setItems(dataE3);
                TabChaineS3.setItems(dataS3);
            }
        }
    }


    /**
     * Valide la commande de la première chaîne de production.
     */
    public void Valider1(){
        int i = Integer.parseInt(IdChaine1.getText());
        if (0 <= i && i <= 9){
            for (ChaineProduction c : CSV.Chaines) {
                if(c.getCode().equals("C001")) {
                    c.setNivActivation(i);

                    if (!c.valider()){
                        Erreur1.setText("Stock insuffisant");
                    }
                    else{
                        Erreur1.setText("Commande validée");


                    }
                }

            }
            CsvWriter a = new CsvWriter();

            a.clearCSVFile("src/main/java/ApplicationProjet/elements.csv");
            a.writeCSVFile("src/main/java/ApplicationProjet/elements.csv", Stocks.EStock);
            a.clearCSVFile("src/main/java/ApplicationProjet/historique.csv");
            a.writeHistoriqueCSVFile("src/main/java/ApplicationProjet/historique.csv", Historique.changements);
        }
        else {
            Erreur1.setText("Niveau d'activation incorrect");
        }


    }

    /**
     * Valide la commande de la deuxième chaîne de production.
     */
    public void Valider2(){
        int i = Integer.parseInt(IdChaine2.getText());
        if (0 <= i && i <= 9){
            for (ChaineProduction c : CSV.Chaines) {
                if(c.getCode().equals("C002")) {
                    c.setNivActivation(i);
                    if (!c.valider()) {
                        Erreur2.setText("Stock insuffisant");
                    } else {
                        Erreur2.setText("Commande validée");
                    }
                }
            }
            CsvWriter a = new CsvWriter();

            a.clearCSVFile("src/main/java/ApplicationProjet/elements.csv");
            a.writeCSVFile("src/main/java/ApplicationProjet/elements.csv", Stocks.EStock);
            a.clearCSVFile("src/main/java/ApplicationProjet/historique.csv");
            a.writeHistoriqueCSVFile("src/main/java/ApplicationProjet/historique.csv", Historique.changements);


        }
        else {
            Erreur2.setText("Niveau d'activation incorrect");
        }
    }

    /**
     * Valide la commande de la troisième chaîne de production.
     */
    public void Valider3(){
        int i = Integer.parseInt(IdChaine3.getText());
        if (0 <= i && i <= 9){
            for (ChaineProduction c : CSV.Chaines) {
                if(c.getCode().equals("C003")) {
                    c.setNivActivation(i);
                    if (!c.valider()) {
                        Erreur3.setText("Stock insuffisant");
                    } else {
                        Erreur3.setText("Commande validée");
                    }
                }

            }
            CsvWriter a = new CsvWriter();

            a.clearCSVFile("src/main/java/ApplicationProjet/elements.csv");
            a.writeCSVFile("src/main/java/ApplicationProjet/elements.csv", Stocks.EStock);
            a.clearCSVFile("src/main/java/ApplicationProjet/historique.csv");
            a.writeHistoriqueCSVFile("src/main/java/ApplicationProjet/historique.csv", Historique.changements);

        }
        else {
            Erreur3.setText("Niveau d'activation incorrect");
        }
    }
}