package ApplicationProjet.Classes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stocks {
   public static ArrayList<Element> EStock = new ArrayList<Element>();
   public static HashMap<Element, Float> StockTmp = new HashMap<Element, Float>();

   public static void copieStock(){
    for (Element e : EStock){
        StockTmp.put(e,e.getQuantite());
    }
   }

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
   public static int valeurStock(){
       int valeur =0;
       for (Element e : EStock){
           valeur += e.getPrixVente()*e.getQuantite();
       }
       return valeur;
    }

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
    public static void SimuEnleverElem(Element e, float n) {
        for (Map.Entry<Element, Float> a : StockTmp.entrySet()) {

                if (a.getKey().equals(e)) {
                    if (!(e.getQuantite() < n)) {
                        a.setValue(a.getValue() - n);

                    }
                }

        }
    }
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

