package ApplicationProjet.Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Cette classe permet d'écrire des données dans des fichiers CSV (Comma-Separated Values).
 * Elle fournit des méthodes pour :
 *  - effacer le contenu d'un fichier CSV existant
 *  - écrire les données d'une ArrayList d'éléments dans un fichier CSV
 *  - écrire les données d'une ArrayList d'objets ChangementStock dans un fichier CSV
 *
 * @author Adrilo
 */
public class CsvWriter {
    /**
     * Efface le contenu d'un fichier CSV existant.
     *
     * @param filePath Le chemin d'accès au fichier CSV.
     * @throws IOException Une exception d'entrée/sortie peut être levée en cas d'erreur d'écriture.
     */
    public static void clearCSVFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Écriture d'une chaîne vide pour effacer le contenu
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de l'effacement du fichier CSV : " + filePath);
        }
    }
    /**
     * Écrit les données d'une ArrayList d'éléments dans un fichier CSV.
     *
     * @param filePath Le chemin d'accès au fichier CSV.
     * @param Stock L'ArrayList d'éléments à écrire dans le fichier.
     * @throws IOException Une exception d'entrée/sortie peut être levée en cas d'erreur d'écriture.
     */
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
    /**
     * Écrit les données d'une ArrayList d'objets ChangementStock dans un fichier CSV.
     *
     * @param filePath Le chemin d'accès au fichier CSV.
     * @param Historique L'ArrayList d'objets ChangementStock à écrire dans le fichier.
     * @throws IOException Une exception d'entrée/sortie peut être levée en cas d'erreur d'écriture.
     */
    public static void writeHistoriqueCSVFile(String filePath, ArrayList <ChangementStock> Historique){
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
