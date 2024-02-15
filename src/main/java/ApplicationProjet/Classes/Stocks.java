package ApplicationProjet.Classes;
import java.util.ArrayList;

public class Stocks {
   public static ArrayList<Element> EStock = new ArrayList<Element>();

   public static void enleverElem(Element e, float n) {
        for (Element a : EStock){
            if (a.getCode().equals(e.getCode())){
                a.setQuantite(-n);
            }
        }
   }

   public static void ajouterElem(Element e,float n) {
        if (EStock.contains(e)) {
            for (Element a : EStock){
               if (a.getCode().equals(e.getCode())){
                   a.setQuantite(n);
               }
            }
        }
        else{
            e.setQuantite(n);
            EStock.add(e);
        }
   }
}
