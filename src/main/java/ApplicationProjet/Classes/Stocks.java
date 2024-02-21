package ApplicationProjet.Classes;
import java.util.ArrayList;

public class Stocks {
   public static ArrayList<Element> EStock = new ArrayList<Element>();

   public static void enleverElem(Element e, float n) {
        for (Element a : EStock){
            if (a.getCode().equals(e.getCode())){
                if(a.getQuantite()<n){
                    System.err.println("Stock insuffisant");
                }
                else {
                    a.ajouterQuantite(-n);break;
                }
            }
        }
   }

   public static void ajouterElem(Element e,float n) {
        if (EStock.contains(e)) {
            for (Element a : EStock){
               if (a.getCode().equals(e.getCode())){
                   e.ajouterQuantite(n);break;
               }
            }
        }
        else{
            e.setQuantite(n);
            EStock.add(e);
        }
   }
    public static void afficherStock() {
        System.out.println("Stock actuel :");
        for (Element e : EStock) {
            System.out.println("Code : " + e.getCode() +
                    ", Nom : " + e.getNom() +
                    ", Quantité en stock : " + e.getQuantite() +
                    " " + e.getUniteMesure());
        }
    }
}
