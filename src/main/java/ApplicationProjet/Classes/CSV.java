package ApplicationProjet.Classes;

import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CSV {

    public void LireElement() {
        String file = "C:\\Users\\adrie\\Documents\\ApplicationProjet\\src\\main\\java\\ApplicationProjet\\elements.csv";
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
        String file = "C:\\Users\\adrie\\Documents\\ApplicationProjet\\src\\main\\java\\ApplicationProjet\\chaines.csv";
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

                StringReader reader2 = new StringReader(r2);
                String line2 = "";
                String[] row2 = r2.split(",");
                while (line2 = reader2.read() != null){

                }











                for (String index : row){
                    if (r2.equals(index)){
                        StringReader
                        while ((r2 = reader.readLine()) != null) {
                                String[] row2 = line.split(",");
                            for (String index2 : row2) {

                            }
                        }
                    }
                    if (r3.equals(index)){
                        String[] row2 = line.split(",");
                    }
                }
                ChaineProduction CP = new ChaineProduction(row[0], row[1],"","");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
