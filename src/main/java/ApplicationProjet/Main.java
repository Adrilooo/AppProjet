package ApplicationProjet;
import ApplicationProjet.Classes.ChaineProduction;
import ApplicationProjet.Classes.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.HashMap;
import java.util.Map;
public class Main extends Application {

    protected static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage;
        ChargerPage("stock.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("stock.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
        primaryStage.setTitle("Usine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void ChargerPage(String page) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
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

    public static Stage getPrimaryStage(){
        return primaryStage;
    }

    public static void main(String[] args) {
        CSV b = new CSV();
        b.LireElement();
        Stocks.afficherStock();
        CSV c = new CSV();
        c.LireChaine();
        CSV d = new CSV();
        d.LireHistorique();
        Element a= Element.trouverElement("2");
        Stocks.ajouterElem(a, 8.0F);
        float l=a.getQuantite();
        System.out.println(l);
        Stocks.ajouterElem(a, 3.0F);
        float p=a.getQuantite();
        System.out.println(p);
        a.Vendre(a,2.0F);
        float X=a.getQuantite();
        System.out.println(X);
        a.Acheter(a,4.0F);
        float H=a.getQuantite();
        System.out.println(H);
        Element m= Element.trouverElement("3");
        HashMap<Element, Float> ElementEntree = new HashMap<Element, Float>();
        HashMap<Element, Float> ElementSortie = new HashMap<Element, Float>();
        ElementEntree.put(a,2.0F);
        ElementSortie.put(m,1.0F);

        ChaineProduction ch = new ChaineProduction("MDR","RLCS",ElementEntree, ElementSortie);
        ch.valider();
        Stocks.afficherStock();
        Historique.afficherHistorique();
        CsvWriter w = new CsvWriter();
        w.clearCSVFile("src\\main\\java\\ApplicationProjet\\elements.csv");
        w.writeCSVFile("src\\main\\java\\ApplicationProjet\\elements.csv",Stocks.EStock);
        w.clearCSVFile("src\\main\\java\\ApplicationProjet\\historique.csv");
        w.writeHistoriqueCSVFile("src\\main\\java\\ApplicationProjet\\historique.csv",Historique.changements);

        launch();
    }
}