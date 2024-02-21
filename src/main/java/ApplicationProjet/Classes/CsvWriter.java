package ApplicationProjet.Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvWriter {

    public static void clearCSVFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Écriture d'une chaîne vide pour effacer le contenu
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de l'effacement du fichier CSV : " + filePath);
        }
    }

    public static void writeCSVFile(String filePath, ArrayList<Element>Stock){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Écriture des données de l'ArrayList dans le fichier CSV
            for (Element element : Stock) {
                // Construire la ligne CSV à partir des attributs de l'objet Element
                String csvLine = element.getCode() + ";" + element.getNom() + ";" + element.getQuantite() + ";" + element.getUniteMesure()+";"+element.getPrixAchat()+";"+element.getPrixVente();

                writer.write(csvLine);
                writer.newLine();
            }
            System.out.println("Données de l'ArrayList reportées dans le fichier CSV : " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur lors du report des données dans le fichier CSV : " + filePath);
        }
    }
    public static void writeHistoriqueCSVFile(String filePath, ArrayList<ChangementStock>Historique){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (ChangementStock data : Historique) {

                String csvLine = data.getCodeElement() + ";" + data.getNomElement() + ";" + data.getQuantiteModifiee() +";"+data.getUniteMesure()+";"+data.getPrixAchat()+";"+data.getPrixVente()+";"+data.getOrigine();

                writer.write(csvLine);
                writer.newLine();
            }
            System.out.println("Données de l'ArrayList reportées dans le fichier CSV : " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur lors du report des données dans le fichier CSV : " + filePath);
        }
    }


}
