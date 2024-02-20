package ApplicationProjet.Classes;

import java.util.ArrayList;
import java.util.List;

public class Historique {
    private static ArrayList<ChangementStock> changements = new ArrayList<>();

    public static void ajouterChangement(ChangementStock changement) {
        changements.add(changement);
    }

    public static void afficherHistorique() {
        System.out.println("Historique :");
        for (ChangementStock e : changements) {
            System.out.println("Code : " + e.getCodeElement() +
                    ", Nom : " + e.getNomElement() +
                    ", Quantité en stock : " + e.getQuantiteModifiee() +
                    " " + e.getPrixAchat()+", "+e.getPrixVente()+", origine : "+e.getOrigine());
        }
    }
}