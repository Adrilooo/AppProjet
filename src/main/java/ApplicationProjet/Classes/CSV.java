package ApplicationProjet.Classes;

import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSV {

    public  void LireElement() {
        String file = "src/main/java/ApplicationProjet/elements.csv";

        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");
                float r2 = Float.parseFloat(row[2]);
                double r4 = Double.parseDouble(row[4]);
                double r5 = Double.parseDouble(row[5]);
                Element elem = new Element(row[0],row[1], r2, row[3], r4, r5);
                Stocks.ajouterElem(elem, r2);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void LireChaine() {
        String file = "src/main/java/ApplicationProjet/chaines.csv";
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");

                HashMap<Element, Float> ElementEntree = new HashMap<Element, Float>();
                String [] elementEntree = row[2].split(",");
                for ( String data : elementEntree){
                    data = data.replaceAll("[()\\s]+","");
                    String[] info = data.split(":");
                    String code = info[0];
                    float quantite=Float.parseFloat(info[1]);
                    Element e = Element.trouverElement(code);
                    ElementEntree.put(e,quantite);

                }
                HashMap<Element, Float> ElementSortie = new HashMap<Element, Float>();
                String [] elementSortie = row[3].split(",");
                for ( String data : elementSortie){
                    data = data.replaceAll("[()\\s]+","");
                    String[] info = data.split(":");
                    String code = info[0];
                    float quantite=Float.parseFloat(info[1]);
                    Element e = Element.trouverElement(code);
                    ElementSortie.put(e,quantite);

                }



                ChaineProduction chaine = new ChaineProduction(row[0],row[1],ElementEntree,ElementSortie);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public  void LireHistorique() {
        String file = "src/main/java/ApplicationProjet/historique.csv";
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");
                float r2 = Float.parseFloat(row[2]);
                double r4 = Double.parseDouble(row[4]);
                double r5 = Double.parseDouble(row[5]);
                ChangementStock ch = new ChangementStock(row[0],row[1], r2, row[3], r4, r5,row[6]);
                Historique.ajouterChangement(ch);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
