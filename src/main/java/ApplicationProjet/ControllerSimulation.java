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
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

import static ApplicationProjet.Main.primaryStage;

public class ControllerSimulation implements Initializable {

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
    private Label Cout1;

    @FXML
    private Label Cout2;

    @FXML
    private Label Cout3;

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
    public void Simuler1(){ /* cout d'achat: 15035 */
        int i = Integer.parseInt(IdChaine1.getText());
        if (0 <= i && i <= 9){
            String message;
            message = String.valueOf(i * 15035);
            Cout1.setText("cout d'achat: " + message);
            ObservableList<Element> dataE = FXCollections.observableArrayList();
            ObservableList<Element> dataS = FXCollections.observableArrayList();
            for (ChaineProduction c : CSV.Chaines){
                if(c.getCode().equals("C001")){
                    ChaineProduction temp = new ChaineProduction("1", "T", new HashMap<Element, Float>(), new HashMap<Element, Float>());
                    for(Element e : c.getElementsEntreeKeys()){
                        e.setQuantite(e.getQuantite()*i);
                        temp.addElemEntree(e);
                    }
                    for(Element e : c.getElementsSortieKeys()){
                        e.setQuantite(e.getQuantite()*i);
                        temp.addElemSortie(e);
                    }
                    dataE.addAll(temp.getElementsEntreeKeys());
                    dataS.addAll(temp.getElementsSortieKeys());
                    System.out.println();
                    TabChaineE1.getItems().clear();
                    TabChaineS1.getItems().clear();
                    TabChaineE1.setItems(dataE);
                    TabChaineS1.setItems(dataS);
                    TabChaineE1.refresh();
                    TabChaineS1.refresh();
                }
            }
        }
    }

    @FXML
    public void Simuler2(){ /* cout d'achat: 35 */
        int i = Integer.parseInt(IdChaine2.getText());
        if (0 <= i && i <= 9){
            String message;
            message = String.valueOf(i * 35);
            Cout2.setText("cout d'achat: " + message);

        }
    }

    @FXML
    public void Simuler3(){ /* cout d'achat: 15470*/
        int i = Integer.parseInt(IdChaine3.getText());
        if (0 <= i && i <= 9){
            String message;
            message = String.valueOf(i * 15470);
            Cout3.setText("cout d'achat: " + message);

        }
    }

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
}