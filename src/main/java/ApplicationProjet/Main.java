package ApplicationProjet;

import ApplicationProjet.Classes.CSV;
import ApplicationProjet.Classes.Element;
import ApplicationProjet.Classes.Historique;
import ApplicationProjet.Classes.Stocks;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    protected static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage;
        ChargerPage("stock.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("stock.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
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
        launch(args);
    }
}