package ApplicationProjet.Classes;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class CSV {

    public  void LireElement() {
        String file = System.getProperty("user.dir") + "\\src\\main\\java\\ApplicationProjet\\elements.csv";
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");
                float r2 = Float.parseFloat(row[2]);
                float r4 = Float.parseFloat(row[4]);
                float r5 = Float.parseFloat(row[5]);
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
        String file = System.getProperty("user.dir") + "\\src\\main\\java\\ApplicationProjet\\chaines.csv";
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");
                String r2 = row[2];
                String r3 = row[3];
                r2 = r2.replace("(", "");
                r2 = r2.replace(")", "");
                r3 = toString().replace("(", "");
                r3 = toString().replace(")", "");
                ArrayList <Element> E1 = new ArrayList<>();
                ArrayList <Element> E2 = new ArrayList<>();

                String[] index5 = r2.split(",");



            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
