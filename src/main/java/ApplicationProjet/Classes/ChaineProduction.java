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
    public HashMap<Element,Float> getElementEntree(){
        return ElementEntree;
    }
    public HashMap<Element,Float> getElementSortie(){
        return ElementSortie;
    }

    public void addElemEntree(Element e){
        this.ElementEntree.put(e, e.getQuantite());
    }

    public void addElemSortie(Element e){
        this.ElementSortie.put(e, e.getQuantite());
    }



    public Float CoupAchatManquant (HashMap <Element,Float> E){
        float AchatSup = 0.0F ;
        for (Map.Entry <Element,Float> o : E.entrySet()) {
            for (Element e : Stocks.EStock) {
                if (e == (Element) o.getKey()) {
                    if (e.getQuantite() < (Float) o.getValue() * this.NivActivation) {
                        AchatSup+= (float) (((Float) o.getValue() * this.NivActivation - e.getQuantite())*e.getPrixVente());
                    }
                }
            }
        }
        return AchatSup;
    }

    public void setNivActivation(int Niv) {
        this.NivActivation = Niv;
    }

    public Boolean valider() {
        for (HashMap.Entry<Element, Float> m : ElementEntree.entrySet()) {
            for (Element e : Stocks.EStock) {
                if (e == (Element) m.getKey()) {
                    if (e.getQuantite() < (Float) m.getValue()*this.NivActivation) {

                        return false;
                    }
                }
            }
        }
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

        this.NivActivation = 0;
        return true;
    }
}
