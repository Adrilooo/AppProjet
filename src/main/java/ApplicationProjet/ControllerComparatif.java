package ApplicationProjet;

import ApplicationProjet.Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;

import static ApplicationProjet.Main.primaryStage;

public class ControllerComparatif {

    /**
     * Champ de texte pour le code du premier élément.
     */
    @FXML
    private TextField Code;

    /**
     * Champ de texte pour le code du deuxième élément.
     */
    @FXML
    private TextField Code2;

    /**
     * Label pour afficher le montant d'achat du premier élément.
     */
    @FXML
    private Label LabelAchat;

    /**
     * Label pour afficher le montant d'achat du deuxième élément.
     */
    @FXML
    private Label LabelAchat2;

    /**
     * Champ de texte pour le niveau d'activation du premier élément.
     */
    @FXML
    private TextField NivAct;

    /**
     * Champ de texte pour le niveau d'activation du deuxième élément.
     */
    @FXML
    private TextField NivAct2;

    /**
     * Champ de texte pour la valeur d'achat du premier élément.
     */
    @FXML
    private TextField Vachat;


    /**
     * Champ de texte pour la valeur d'achat du deuxième élément.
     */
    @FXML
    private TextField Vachat2;

    /**
     * Champ de texte pour la valeur du stock du premier élément.
     */
    @FXML
    private TextField Vstock;

    /**
     * Champ de texte pour la valeur du stock du deuxième élément.
     */
    @FXML
    private TextField Vstock2;

    /**
     * Bouton pour valider la première valeur.
     */
    @FXML
    private Button BtnV1;

    /**
     * Bouton pour valider la deuxième valeur.
     */
    @FXML
    private Button BtnV2;

    /**
     * Bouton pour comparer les deux valeurs.
     */
    @FXML
    private Button BtnV3;

    /**
     * Label pour afficher la rentabilité du premier élément.
     */
    @FXML
    private Label R;

    /**
     * Label pour afficher la rentabilité du deuxième élément.
     */
    @FXML
    private Label R2;

    /**
     * Label pour afficher la valeur d'achat du premier élément.
     */
    @FXML
    private Label VA;

    /**
     * Label pour afficher la valeur d'achat du deuxième élément.
     */
    @FXML
    private Label VA2;

    /**
     * Label pour afficher la valeur du stock final du premier élément.
     */
    @FXML
    private Label VSF;

    /**
     * Label pour afficher la valeur du stock final du deuxième élément.
     */
    @FXML
    private Label VSF2;

    /**
     * Label pour afficher la valeur du stock initial du première élément.
     */
    @FXML
    private Label VSI;

    /**
     * Label pour afficher la valeur du stock initial du deuxième élément.
     */
    @FXML
    private Label VSI2;

    /**
     * Champ de texte pour l'identifiant de la première chaîne.
     */
    @FXML
    private TextField IdChaine1;

    /**
     * Champ de texte pour l'identifiant de la deuxième chaîne.
     */
    @FXML
    private TextField IdChaine2;

    /**
     * Champ de texte pour l'identifiant de la troisième chaîne.
     */
    @FXML
    private TextField IdChaine3;

    /**
     * Tableau pour afficher les éléments de la première chaîne d'éléments.
     */
    @FXML
    private TableView<Element> TabChaineE1;

    /**
     * Tableau pour afficher les éléments de la deuxième chaîne d'éléments.
     */
    @FXML
    private TableView<Element> TabChaineE2;

    /**
     * Tableau pour afficher les éléments de la troisième chaîne d'éléments.
     */
    @FXML
    private TableView<Element> TabChaineE3;

    /**
     * Tableau pour afficher les éléments de la première chaîne de stock.
     */
    @FXML
    private TableView<Element> TabChaineS1;

    /**
     * Tableau pour afficher les éléments de la deuxième chaîne de stock.
     */
    @FXML
    private TableView<Element> TabChaineS2;

    /**
     * Tableau pour afficher les éléments de la troisième chaîne de stock.
     */
    @FXML
    private TableView<Element> TabChaineS3;

    /**
     * Ancre pour contenir les composants de la chaîne.
     */
    @FXML
    private AnchorPane bpChaine;

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
    private Button btnComparer;


    /**
     * Colonne pour afficher le nom des éléments dans la première chaîne d'éléments.
     */
    @FXML
    private TableColumn<Element, String> colNomE1;

    /**
     * Colonne pour afficher le nom des éléments dans la deuxième chaîne d'éléments.
     */
    @FXML
    private TableColumn<Element, String> colNomE2;

    /**
     * Colonne pour afficher le nom des éléments dans la troisième chaîne d'éléments.
     */
    @FXML
    private TableColumn<Element, String> colNomE3;

    /**
     * Colonne pour afficher le nom des éléments dans la première chaîne de stock.
     */
    @FXML
    private TableColumn<Element, String> colNomS1;

    /**
     * Colonne pour afficher le nom des éléments dans la deuxième chaîne de stock.
     */
    @FXML
    private TableColumn<Element, String> colNomS2;

    /**
     * Colonne pour afficher le nom des éléments dans la troisième chaîne de stock.
     */
    @FXML
    private TableColumn<Element, String> colNomS3;

    /**
     * Colonne pour afficher la quantité des éléments dans la première chaîne d'éléments.
     */
    @FXML
    private TableColumn<Element, Float> colQE1;

    /**
     * Colonne pour afficher la quantité des éléments dans la deuxième chaîne d'éléments.
     */
    @FXML
    private TableColumn<Element, Float> colQE2;

    /**
     * Colonne pour afficher la quantité des éléments dans la troisième chaîne d'éléments.
     */
    @FXML
    private TableColumn<Element, Float> colQE3;

    /**
     * Colonne pour afficher la quantité des éléments dans la première chaîne de stock.
     */
    @FXML
    private TableColumn<Element, Float> colQS1;

    /**
     * Colonne pour afficher la quantité des éléments dans la deuxième chaîne de stock.
     */
    @FXML
    private TableColumn<Element, Float> colQS2;

    /**
     * Colonne pour afficher la quantité des éléments dans la troisième chaîne de stock.
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
     * Méthode appelée lorsqu'on souhaite comparer deux éléments.
     * Elle récupère les données des éléments, effectue les calculs nécessaires
     * et met à jour les vues en conséquence.
     */
    public void Comparer(){
        String code = Code.getText();
        String na = NivAct.getText();

        String code2 = Code2.getText();
        String na2 = NivAct2.getText();

        double tmp = Stocks.valeurStock();
        VSI.setText("valeur stock initial : " + tmp);
        VSI2.setText("valeur stock initial : " + tmp);

        System.out.println(Stocks.valeurStockFinal());
        double va = Vachat(na,code);



        VA.setText("valeur d'achat :" + va);
        double tmp2 = Stocks.valeurStockFinal();
        VSF.setText("valeur stock final : " + tmp2);
        Stocks.StockTmp.clear();
        Stocks.copieStock();
        double va2 = Vachat(na2,code2);
        VA2.setText("valeur d'achat :" + va2);
        double tmp3 = Stocks.valeurStockFinal();
        VSF2.setText("valeur stock final : " + tmp3);
        Double valeur = (1-(Stocks.valeurStock()/tmp2-va))*100;
        Double valeur2 = (1-(Stocks.valeurStock()/tmp3-va2))*100;
        DecimalFormat df = new DecimalFormat("0.00"); // Définition du motif pour arrondir au centième près
        String valeurArrondieStr = df.format(valeur); // Formatage de la valeur

        String valeurArrondie = valeurArrondieStr+ "%";
        DecimalFormat df2 = new DecimalFormat("0.00"); // Définition du motif pour arrondir au centième près
        String valeurArrondieStr2 = df2.format(valeur2); // Formatage de la valeur

        String valeurArrondie2 = valeurArrondieStr2+ "%"; // Conversion de la chaîne formatée en double
        R.setText("Rentabilité : "+valeurArrondie);
        R2.setText("Rentabilité : "+valeurArrondie2);


    }

    /**
     * Calcule la valeur d'achat d'un élément en fonction de son niveau d'activation
     * et de son code.
     *
     * @param na   Le niveau d'activation de l'élément.
     * @param code Le code de l'élément.
     * @return La valeur d'achat calculée.
     */
    public double Vachat(String na,String code){

    double achat = 0;
        if (0 <= Integer.parseInt(na) && Integer.parseInt(na) <= 9) {
        for (ChaineProduction c : CSV.Chaines) {
            if (c.getCode().equals(code)) {
                c.setNivActivation(Integer.parseInt(na));
                achat = c.simuler();

            }
        }
    }
        return achat;
}

}