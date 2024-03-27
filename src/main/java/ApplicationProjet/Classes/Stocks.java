package ApplicationProjet.Classes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Cette classe gère les stocks d'articles. Elle permet d'ajouter, de supprimer et de simuler des ajouts/suppressions
 * d'articles en stock, tout en calculant la valeur totale du stock.
 *
 * @author Adrilo
 */
public class Stocks {
    /**
     * Liste contenant les éléments en stock.
     */
   public static ArrayList<Element> EStock = new ArrayList<Element>();
    /**
     * HashMap temporaire utilisé pour simuler les ajouts/suppressions
     * sans modifier la liste principale EStock.
     */
   public static HashMap<Element, Float> StockTmp = new HashMap<Element, Float>();
    /**
     * Copie le contenu de EStock dans StockTmp pour une simulation.
     */
   public static void copieStock(){
    for (Element e : EStock){
        StockTmp.put(e,e.getQuantite());
    }
   }
    /**
     * Supprime une quantité `n` d'un élément identifié par son code.
     * Si la quantité en stock est insuffisante, un message d'erreur est affiché sur la console d'erreurs.
     *
     * @param e L'élément à supprimer.
     * @param n La quantité à supprimer.
     */
   public static void enleverElem(Element e, float n) {
        for (Element a : EStock){
            if (a.getCode().equals(e.getCode())){
                if(a.getQuantite()<n){
                    System.err.println("Stock insuffisant");
                }
                else {
                    a.ajouterQuantite(-n);
                }
            }
        }
   }
    /**
     * Ajoute une quantité `n` d'un élément identifié par son code.
     * Si l'élément existe déjà, la quantité est ajoutée. Sinon, un nouvel élément est créé et ajouté à la liste.
     *
     * @param e L'élément à ajouter ou à mettre à jour.
     * @param n La quantité à ajouter.
     */
   public static void ajouterElem(Element e,float n) {
        if (EStock.contains(e)) {
            for (Element a : EStock){
               if (a.getCode().equals(e.getCode())){
                   a.ajouterQuantite(n);
               }
            }
        }
        else{
            e.setQuantite(n);
            EStock.add(e);
        }
   }
    /**
     * Calcule la valeur totale du stock en multipliant la quantité de chaque élément par son prix de vente
     * et en sommant les résultats.
     *
     * @return La valeur totale du stock.
     */
   public static int valeurStock(){
       int valeur =0;
       for (Element e : EStock){
           valeur += e.getPrixVente()*e.getQuantite();
       }
       return valeur;
    }
    /**
     * Calcule la valeur totale du stock en utilisant le HashMap temporaire StockTmp,
     * simulant des ajouts/suppressions sans modifier la liste principale EStock.
     *
     * @return La valeur totale du stock simulé.
     */
    public static int valeurStockFinal(){
       int valeur =0;
       double q=0;
       for (Map.Entry<Element, Float> a : StockTmp.entrySet()) {
           for (Element e : EStock) {
               if (e == (Element) a.getKey()) {
                   q = e.getPrixVente();
                   break;
               }
           }
           valeur += a.getValue() * q;
       }


       return valeur;

   }
    /**
     * Simule la suppression d'une quantité `n` d'un élément identifié par son code
     * en utilisant le HashMap temporaire StockTmp.
     *
     * @param e L'élément à supprimer (simulation).
     * @param n La quantité à supprimer (simulation).
     */
    public static void SimuEnleverElem(Element e, float n) {
        for (Map.Entry<Element, Float> a : StockTmp.entrySet()) {

                if (a.getKey().equals(e)) {
                    if (!(e.getQuantite() < n)) {
                        a.setValue(a.getValue() - n);

                    }
                }

        }
    }
    /**
     * Simule l'ajout d'une quantité `n` d'un élément identifié par son code
     * en utilisant le HashMap temporaire StockTmp.
     *
     * @param e L'élément à ajouter (simulation).
     * @param n La quantité à ajouter (simulation).
     */
    public static void SimuAjouterElem(Element e,float n) {
        if (StockTmp.containsKey(e)) {
            for (Map.Entry<Element, Float> a : StockTmp.entrySet()) {
                if (a.getKey().equals(e)){
                    a.setValue(a.getValue()+n);
                }
            }
        }
        else{
            StockTmp.put(e,n);
        }
    }
}

