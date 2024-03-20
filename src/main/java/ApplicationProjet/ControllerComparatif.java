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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;

import static ApplicationProjet.Main.primaryStage;

public class ControllerComparatif {

    @FXML
    private TextField Code;

    @FXML
    private TextField Code2;

    @FXML
    private Label LabelAchat;

    @FXML
    private Label LabelAchat2;

    @FXML
    private TextField NivAct;

    @FXML
    private TextField NivAct2;

    @FXML
    private TextField Vachat;

    @FXML
    private TextField Vachat2;

    @FXML
    private TextField Vstock;

    @FXML
    private TextField Vstock2;

    @FXML
    private Button BtnV1;

    @FXML
    private Button BtnV2;

    @FXML
    private Button BtnV3;

    @FXML
    private Label R;

    @FXML
    private Label R2;

    @FXML
    private Label VA;

    @FXML
    private Label VA2;

    @FXML
    private Label VSF;

    @FXML
    private Label VSF2;

    @FXML
    private Label VSI;

    @FXML
    private Label VSI2;

    @FXML
    private TextField IdChaine1;

    @FXML
    private TextField IdChaine2;

    @FXML
    private TextField IdChaine3;

    @FXML
    private TableView<Element> TabChaineE1;

    @FXML
    private TableView<Element> TabChaineE2;

    @FXML
    private TableView<Element> TabChaineE3;

    @FXML
    private TableView<Element> TabChaineS1;

    @FXML
    private TableView<Element> TabChaineS2;

    @FXML
    private TableView<Element> TabChaineS3;

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
    private Button btnComparer;

    @FXML
    private TableColumn<Element, String> colNomE1;

    @FXML
    private TableColumn<Element, String> colNomE2;

    @FXML
    private TableColumn<Element, String> colNomE3;

    @FXML
    private TableColumn<Element, String> colNomS1;

    @FXML
    private TableColumn<Element, String> colNomS2;

    @FXML
    private TableColumn<Element, String> colNomS3;

    @FXML
    private TableColumn<Element, Float> colQE1;

    @FXML
    private TableColumn<Element, Float> colQE2;

    @FXML
    private TableColumn<Element, Float> colQE3;

    @FXML
    private TableColumn<Element, Float> colQS1;

    @FXML
    private TableColumn<Element, Float> colQS2;

    @FXML
    private TableColumn<Element, Float> colQS3;

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
        ChargerPage("Comparatif.fxml");
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

    ArrayList<Element> EStock2 = new ArrayList<Element>(Stocks.EStock);
    ArrayList<Element> EStock3 = new ArrayList<Element>(Stocks.EStock);
    public void Comparer(){
        String code = Code.getText();
        String na = NivAct.getText();

        String code2 = Code2.getText();
        String na2 = NivAct2.getText();

        double tmp = Stocks.valeurStock(Stocks.EStock);
        VSI.setText("valeur stock initial : " + tmp);
        VSI2.setText("valeur stock initial : " + tmp);
        System.out.println(Stocks.valeurStock(EStock2));

        double va = Vachat(na,code,EStock2);
        double va2 = Vachat(na2,code2,EStock3);


        VA.setText("valeur d'achat :" + va);
        VA2.setText("valeur d'achat :" + va2);
        System.out.println(Stocks.valeurStock(EStock2));




        double tmp2 = Stocks.valeurStock(EStock2);
        VSF.setText("valeur stock final : " + tmp2);
        double tmp3 = Stocks.valeurStock(EStock3);
        VSF2.setText("valeur stock final : " + tmp3);

        String tmp4 = ((Stocks.valeurStock(Stocks.EStock))/Stocks.valeurStock(EStock2)-1)*100 + " %";
        String tmp5 = ((Stocks.valeurStock(Stocks.EStock))/Stocks.valeurStock(EStock3)-1)*100 + " %";
        R.setText("Rentabilité : "+tmp4);
        R2.setText("Rentabilité : "+tmp5);


    }
    public double Vachat(String na,String code,ArrayList <Element> E){

    double achat = 0;
        if (0 <= Integer.parseInt(na) && Integer.parseInt(na) <= 9) {
        for (ChaineProduction c : CSV.Chaines) {
            if (c.getCode().equals(code)) {
                c.setNivActivation(Integer.parseInt(na));
                achat = c.simuler(E);

            }
        }
    }
        return achat;
}

}