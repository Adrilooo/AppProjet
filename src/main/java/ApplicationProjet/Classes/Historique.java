package ApplicationProjet.Classes;

import java.util.ArrayList;
import java.util.List;

public class Historique {
    private static List<ChangementStock> changements = new ArrayList<>();

    public static void ajouterChangement(ChangementStock changement) {
        changements.add(changement);
    }


}