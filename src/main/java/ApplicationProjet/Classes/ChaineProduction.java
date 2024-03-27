package ApplicationProjet.Classes;
import java.util.*;

import ApplicationProjet.Classes.Stocks;
import ApplicationProjet.Classes.Element;

/**
 * Cette classe représente une chaîne de production dans le système.
 * Elle stocke les informations sur les éléments d'entrée et de sortie de la chaîne,
 * ainsi que son activation et sa simulation.
 *
 * @author Adrilo
 */

public class ChaineProduction {
    /**
     * Code unique de la chaîne de production.
     */
    private String code;
    /**
     * Nom de la chaîne de production.
     */
    private String nom;
    /**
     * Niveau d'activation de la chaîne (nombre de cycles à produire).
     */
    private int NivActivation;
    /**
     * Liste des éléments d'entrée de la chaîne et leurs quantités respectives.
     */
    HashMap<Element, Float> ElementEntree = new HashMap<Element, Float>();
    /**
     * Liste des éléments de sortie de la chaîne et leurs quantités respectives.
     */
    HashMap<Element, Float> ElementSortie = new HashMap<Element, Float>();

    /**
     * Constructeur de la classe ChaineProduction.
     *
     * @param code Code unique de la chaîne.
     * @param nom Nom de la chaîne.
     * @param ElementEntree Liste des éléments d'entrée et leurs quantités.
     * @param ElementSortie Liste des éléments de sortie et leurs quantités.
     */
    public ChaineProduction(String code, String nom, HashMap ElementEntree, HashMap ElementSortie) {
        this.code = code;
        this.nom = nom;
        this.ElementEntree = ElementEntree;
        this.ElementSortie = ElementSortie;
        this.NivActivation = 0;
    }
    /**
     * Renvoie un ensemble contenant les clés (codes) des éléments d'entrée de la chaîne de production.
     *
     * @return Un ensemble contenant les codes uniques des éléments d'entrée' de la chaîne.
     */
    public Set<Element> getElementsEntreeKeys() {
        return ElementEntree.keySet();
    }
    /**
     * Renvoie un ensemble contenant les clés (codes) des éléments de sortie de la chaîne de production.
     *
     * @return Un ensemble contenant les codes uniques des éléments de sortie de la chaîne.
     */
    public Set<Element> getElementsSortieKeys() {
        return ElementSortie.keySet();
    }
    /**
     * Renvoie le code unique de la chaîne de production.
     *
     * @return Le code unique de la chaîne de production sous forme de String.
     */
    public String getCode() {
        return this.code;
    }
    /**
     * Calcule le coût supplémentaire d'achat des éléments manquants dans le stock pour répondre aux besoins de production basés sur le niveau d'activation.
     *
     * @param E Une HashMap contenant les éléments et leurs quantités requises pour la simulation.
     * @return Le coût total d'achat des éléments manquants pour la production.
     */
    public float CoupAchatManquant(HashMap<Element, Float> E) {
        float AchatSup = 0.0F;
        for (Map.Entry<Element, Float> o : E.entrySet()) {
            for (Element e : Stocks.EStock) {
                if (o.getKey() == e) {
                    if (e.getQuantite() < o.getValue() * this.NivActivation) {
                        AchatSup += (o.getValue() * this.NivActivation - e.getQuantite()) * e.getPrixAchat();
                    }
                }
            }
        }
        return AchatSup;
    }
    /**
     * Définit le niveau d'activation de la chaîne de production, indiquant le nombre de cycles de production à effectuer.
     *
     * @param Niv Le niveau d'activation désiré (nombre entier).
     */
    public void setNivActivation(int Niv) {
        this.NivActivation = Niv;
    }
    /**
     * Valide et exécute le processus de production pour le niveau d'activation actuel.
     *
     * @return true si la production a été réalisée avec succès, false si les éléments en stock étaient insuffisants.
     */
    public Boolean valider() {
        for (HashMap.Entry<Element, Float> m : ElementEntree.entrySet()) {
            for (Element e : Stocks.EStock) {
                if (e == (Element) m.getKey()) {
                    if (e.getQuantite() < (Float) m.getValue() * this.NivActivation) {

                        return false;
                    }
                }
            }
        }
        for (HashMap.Entry<Element, Float> m : ElementEntree.entrySet()) {
            for (Element e : Stocks.EStock) {
                if (e == (Element) m.getKey()) {
                    Stocks.enleverElem((Element) m.getKey(), (Float) m.getValue() * Float.parseFloat(String.valueOf(this.NivActivation)));
                    Historique.ajouterChangement(new ChangementStock(e.getCode(), e.getNom(), (Float) m.getValue() * Float.parseFloat(String.valueOf(this.NivActivation)), e.getUniteMesure(), 0, 0, "Mis en production"));
                }
            }
        }
        for (Map.Entry<Element, Float> m : ElementSortie.entrySet()) {
            if (Stocks.EStock.contains((Element) m.getKey())) {
                for (Element e : Stocks.EStock) {
                    if (e == (Element) m.getKey()) {
                        Stocks.ajouterElem((Element) m.getKey(), (Float) m.getValue() * Float.parseFloat(String.valueOf(this.NivActivation)));
                        Historique.ajouterChangement(new ChangementStock(e.getCode(), e.getNom(), (Float) m.getValue() * Float.parseFloat(String.valueOf(this.NivActivation)), e.getUniteMesure(), 0, 0, "Produit"));
                    }
                }
            } else {
                Element f = (Element) m.getKey();
                Stocks.ajouterElem((Element) m.getKey(), (Float) m.getValue() * Float.parseFloat(String.valueOf(this.NivActivation)));
                Historique.ajouterChangement(new ChangementStock(f.getCode(), f.getNom(), (Float) m.getValue() * Float.parseFloat(String.valueOf(this.NivActivation)), f.getUniteMesure(), 0, 0, "Produit"));
            }
        }

        this.NivActivation = 0;
        return true;
    }

    /**
     * Simule le processus de production pour le niveau d'activation actuel sans modifier le stock réel.
     *
     * @return Le coût total d'achat des éléments manquants pour cette simulation de production.
     */
    public double simuler() {
        double achat = 0;
        HashMap<Element, Float> Chaine = new HashMap<Element, Float>();
        for (HashMap.Entry<Element, Float> m : ElementEntree.entrySet()) {
            for (Element e : Stocks.EStock) {
                if (e == (Element) m.getKey()) {
                    if (e.getQuantite() < (Float) m.getValue() * this.NivActivation) {
                        Chaine.put(m.getKey(),m.getValue());
                    }
                }
            }
        }
        achat = CoupAchatManquant(Chaine);
        for (HashMap.Entry<Element, Float> m : ElementEntree.entrySet()) {
            for (Element e : Stocks.EStock) {
                if (e == (Element) m.getKey()) {
                    Stocks.SimuEnleverElem((Element) m.getKey(), (Float) m.getValue() * Float.parseFloat(String.valueOf(this.NivActivation)));
                }
            }
        }
        for (Map.Entry<Element, Float> m : ElementSortie.entrySet()) {
            if (Stocks.EStock.contains((Element) m.getKey())) {
                for (Element e : Stocks.EStock) {
                    if (e == (Element) m.getKey()) {
                        Stocks.SimuAjouterElem((Element) m.getKey(), (Float) m.getValue() * Float.parseFloat(String.valueOf(this.NivActivation)));

                    }
                }
            } else {
                Element f = (Element) m.getKey();
                Stocks.SimuAjouterElem((Element) m.getKey(), (Float) m.getValue() * Float.parseFloat(String.valueOf(this.NivActivation)));
                  }
        }

        this.NivActivation = 0;
        return achat;
    }
}