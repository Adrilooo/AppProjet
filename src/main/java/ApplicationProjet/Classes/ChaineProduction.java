package ApplicationProjet.Classes;
import java.util.*;

import ApplicationProjet.Classes.Stocks;
import ApplicationProjet.Classes.Element;



public class ChaineProduction {
    private String code;
    private String nom;
    private int NivActivation;


    HashMap<Element, Float> ElementEntree = new HashMap<Element, Float>();
    HashMap<Element, Float> ElementSortie = new HashMap<Element, Float>();


    public ChaineProduction(String code, String nom, HashMap ElementEntree, HashMap ElementSortie) {
        this.code = code;
        this.nom = nom;
        this.ElementEntree = ElementEntree;
        this.ElementSortie = ElementSortie;
        this.NivActivation = 0;
    }

    public Set<Element> getElementsEntreeKeys() {
        return ElementEntree.keySet();
    }

    public Set<Element> getElementsSortieKeys() {
        return ElementSortie.keySet();
    }
    public String getCode() {
        return this.code;
    }

    public String getNom() {
        return this.nom;
    }

    public void addElemEntree(Element e){
        this.ElementEntree.put(e, e.getQuantite());
    }

    public void addElemSortie(Element e){
        this.ElementSortie.put(e, e.getQuantite());
    }


    public void getElementEntree() {
        for (Map.Entry m : ElementEntree.entrySet()) {
            Element p =(Element)m.getKey();
            p.setQuantiteEnProd((Float)m.getValue());
        }


    }

    public void getElementSortie() {
        for (Map.Entry m : ElementSortie.entrySet()) {

            Element p =(Element)m.getKey();
            p.setQuantiteEnProd((Float)m.getValue());
        }

    }

    public int getNivActivation() {
        return NivActivation;
    }

    public void setNivActivation(int Niv) {
        this.NivActivation = Niv;
    }

    public void valider() {
        boolean q = true;
        ArrayList<Boolean> verif = new ArrayList<Boolean>();
        for (HashMap.Entry<Element, Float> m : ElementEntree.entrySet()) {

            for (Element e : Stocks.EStock) {

                if (e == (Element) m.getKey()) {
                    for (int i = 0; i < this.NivActivation; i++) {
                        if (e.getQuantite() < (Float) m.getValue()) {
                            q = false;
                            verif.add(q);
                            System.err.println("erreur stock element entree : " + e.getNom() + " stock : " + e.getQuantite() + " < quantite demande : " + m.getValue());
                        }
                    }
                }
            }
        }
        if (!verif.contains(Boolean.FALSE)) {
            for (HashMap.Entry<Element, Float> m : ElementEntree.entrySet()) {

                for (Element e : Stocks.EStock) {

                    if (e == (Element) m.getKey()) {

                        Stocks.enleverElem((Element) m.getKey(), (Float) m.getValue()*Float.parseFloat(String.valueOf(this.NivActivation)));


                        Historique.ajouterChangement(new ChangementStock(e.getCode(), e.getNom(), (Float) m.getValue()*Float.parseFloat(String.valueOf(this.NivActivation)),e.getUniteMesure(), 0, 0, "Mis en production"));
                    }
                }
            }
            for (Map.Entry<Element,Float> m : ElementSortie.entrySet()) {
                if(Stocks.EStock.contains((Element)m.getKey()) ){
                    for (Element e : Stocks.EStock) {
                        if (e == (Element) m.getKey()) {

                            Stocks.ajouterElem((Element) m.getKey(), (Float) m.getValue()*Float.parseFloat(String.valueOf(this.NivActivation)));


                            Historique.ajouterChangement(new ChangementStock(e.getCode(), e.getNom(), (Float) m.getValue()*Float.parseFloat(String.valueOf(this.NivActivation)),e.getUniteMesure(), 0, 0, "Produit"));
                        }

                    }
                }

                else{
                    Element f = (Element)m.getKey();
                    Stocks.ajouterElem((Element)m.getKey(),(Float) m.getValue()*Float.parseFloat(String.valueOf(this.NivActivation)));
                    Historique.ajouterChangement(new ChangementStock(f.getCode(), f.getNom(), (Float) m.getValue()*Float.parseFloat(String.valueOf(this.NivActivation)),f.getUniteMesure(), 0, 0, "Produit"));
                }
            }
        }
        this.NivActivation = 0;
    }
}




