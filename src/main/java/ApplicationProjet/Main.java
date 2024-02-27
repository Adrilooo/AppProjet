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
        b.LireHistorique();
        b.LireChaine();
        launch();
    }
}