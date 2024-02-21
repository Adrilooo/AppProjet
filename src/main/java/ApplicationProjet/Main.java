package ApplicationProjet;

import ApplicationProjet.Classes.CSV;
import ApplicationProjet.Classes.Element;
import ApplicationProjet.Classes.Historique;
import ApplicationProjet.Classes.Stocks;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader FXMLLoader = new FXMLLoader(Main.class.getResource("stock.fxml"));
        Scene scene = new Scene(FXMLLoader.load(), 320, 240);
        stage.setTitle("UsineSimplifiée");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        CSV b = new CSV();
        b.LireElement();
        Element a= new Element("2","Karmine Corp",8.0F);
        float T=a.getQuantite();
        System.out.println(T);
        a.setQuantite(3.0F);
        Stocks.ajouterElem(a, a.getQuantite());
        a.Vendre(a,2.0F);
        float X=a.getQuantite();
        System.out.println(X);
        a.Acheter(a,4.0F);
        float H=a.getQuantite();
        System.out.println(H);
        Stocks.afficherStock();
        Historique.afficherHistorique();
        launch();

    }
}