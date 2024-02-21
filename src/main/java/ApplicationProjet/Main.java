package ApplicationProjet;
import ApplicationProjet.Classes.ChaineProduction;
import ApplicationProjet.Classes.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        CSV b = new CSV();
        b.LireElement();
        Stocks.afficherStock();
        CSV c = new CSV();
        c.LireChaine();
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
        Element m= Element.trouverElement("17");
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
        w.writeHistoriqueCSVFile("src\\main\\java\\ApplicationProjet\\elements.csv",Historique.changements);




    }
}