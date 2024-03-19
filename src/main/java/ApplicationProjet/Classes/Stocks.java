package ApplicationProjet.Classes;
import java.util.ArrayList;

public class Stocks {
   public static ArrayList<Element> EStock = new ArrayList<Element>();
   public static ArrayList<Element> EStock2 = new ArrayList<Element>();
   public static ArrayList<Element> EStock3 = new ArrayList<Element>();



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
   public static int valeurStock(ArrayList<Element> E){
       int valeur =0;
       for (Element e : E){
           valeur += (int) e.getPrixVente();
       }
       return valeur;
    }
    public static void SimuEnleverElem(Element e, float n, ArrayList <Element> E) {
        for (Element a : E){
            if (a.getCode().equals(e.getCode())){
                if(!(a.getQuantite()<n)) {
                    a.ajouterQuantite(-n);
                }
            }
        }
    }
    public static void SimuAjouterElem(Element e,float n, ArrayList <Element> E) {
        if (E.contains(e)) {
            for (Element a : E){
                if (a.getCode().equals(e.getCode())){
                    a.ajouterQuantite(n);
                }
            }
        }
        else{
            e.setQuantite(n);
            E.add(e);
        }
    }
}
