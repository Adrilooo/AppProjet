package ApplicationProjet.Classes;

import java.util.ArrayList;
import java.util.List;
/**
 * Cette classe enregistre les changements apportés au stock.
 *
 * @author Adrilo
 */
public class Historique {
    /**
     * Liste contenant les changements stockés.
     */
    public static ArrayList<ChangementStock> changements = new ArrayList<>();
    /**
     * Ajoute un changement à l'historique.
     *
     * @param changement Le changement à ajouter à l'historique.
     */
    public static void ajouterChangement(ChangementStock changement) {
        changements.add(changement);
    }

}