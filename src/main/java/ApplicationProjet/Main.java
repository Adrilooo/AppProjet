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
        CSV c = new CSV();
        c.LireChaine();
        Element a= new Element("2","Karmine Corp",8.0F,"km",120,180);
        float T=a.getQuantite();
        System.out.println(T);
        Stocks.ajouterElem(a, 0.0F);
        a.setQuantite(3.0F);
        a.Vendre(a,2.0F);
        float X=a.getQuantite();
        System.out.println(X);
        a.Acheter(a,4.0F);
        float H=a.getQuantite();
        System.out.println(H);
        Element m= new Element("17","Vitality",0.0F,"km",120,180);
        HashMap<Element, Float> ElementEntree = new HashMap<Element, Float>();
        HashMap<Element, Float> ElementSortie = new HashMap<Element, Float>();
        ElementEntree.put(a,2.0F);
        ElementSortie.put(m,1.0F);
        ChaineProduction ch = new ChaineProduction("C010","Propulsion",ElementEntree, ElementSortie);
        ch.valider();


        ch.fin();
        Stocks.afficherStock();
        Historique.afficherHistorique();

    }
}