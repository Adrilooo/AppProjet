package ApplicationProjet.Classes;
import java.util.*;

import ApplicationProjet.Classes.Stocks;
import ApplicationProjet.Classes.Element;



public class ChaineProduction {
    private String code;
    private String nom;
    private int NivActivation = 1;


    Map<Element, Float> ElementEntree;
    Map<Element, Float> ElementSortie;


    public ChaineProduction(String code, String nom, HashMap ElementEntree, HashMap ElementSortie) {
        this.code = code;
        this.nom = nom;
        this.ElementEntree = new HashMap<Element, Float>();
        this.ElementSortie = new HashMap<Element, Float>();
    }

    public String getCode() {
        return this.code;
    }

    public String getNom() {
        return this.nom;
    }


    public String getElementEntree() {
        String s = "";
        for (Map.Entry m : ElementEntree.entrySet()) {
            s += m.getKey();
            s += '|';
        }
        return s;

    }

    public String getElementSortie() {
        String s = "";
        for (Map.Entry m : ElementSortie.entrySet()) {
            s += m.getKey();
            s += '|';
        }
        return s;

    }

    public int getNivActivation() {
        return NivActivation;
    }

    public void setNivActivation(int Niv) {
        this.NivActivation = Niv;
    }

    public void valider() {
        for (Map.Entry m : ElementEntree.entrySet()) {
            for (Element e : Stocks.EStock) {
                if (e == (Element) m.getKey())
                    Historique.ajouterChangement(new ChangementStock(e.getCode(), e.getNom(), (Float) m.getValue(), 0, 0, "Mis en production"));
            }
            for (int i = 0; i < this.NivActivation; i++) {

                Stocks.enleverElem((Element) m.getKey(), (Float) m.getValue());
            }


        }
    }
    public void fin () {
        for (Map.Entry m : ElementSortie.entrySet()) {
            for (Element e : Stocks.EStock) {
                if (e == (Element) m.getKey())
                    Historique.ajouterChangement(new ChangementStock(e.getCode(), e.getNom(), (Float) m.getValue(), 0, 0, "Produit"));

            }
            for (int i = 0; i < this.NivActivation; i++) {

                Stocks.enleverElem((Element) m.getKey(), (Float) m.getValue());
            }

        }

        this.NivActivation = 0;
        ElementEntree.clear();
        ElementSortie.clear();


    }

}



