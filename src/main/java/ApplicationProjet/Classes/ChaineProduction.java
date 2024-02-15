package ApplicationProjet.Classes;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import ApplicationProjet.Classes.Stocks;
import ApplicationProjet.Classes.Element;



public class ChaineProduction{
    private String code;
    private String nom;
    private int NivActivation;

    private ArrayList <Element> ElementEntree;
    private ArrayList <Element> ElementSortie;

    public ChaineProduction(String code, String nom, ArrayList ElementEntree, ArrayList ElementSortie){
        this.code=code;
        this.nom=nom;
        this.ElementEntree = new ArrayList <Element>();
        this.ElementSortie = new ArrayList <Element>();
    }
    public String getCode(){
        return this.code;
    }
    public String getNom(){
        return this.nom;
    }
    public void addElemEntree(Element e){
        ElementEntree.add(e);


    }
    public void addElementSortie(Element e){
        ElementSortie.add(e);

    }
    public void removeElemEntree(Element e){
        if(!ElementEntree.remove(e)){
            System.err.println("Tentative de retirer un élément non contenu dans la chaîne");
        };
    }
    public void removeElemSortie(Element e){
        if(!ElementSortie.remove(e)){
            System.err.println("Tentative de retirer un élément non contenu dans la chaîne");
        };
    }
    public String getElementEntree(){
        String s = "";
        for(Element e:ElementEntree) {
            s += e;
            s+='|';
        }
        return s;

    }
    public void getElementSortie(){
        for(Element e:ElementSortie){
            System.out.println(e);
        }
    }
    public int getNivActivation() {
        return NivActivation;
    }
    public void setNivActivation(int Niv) {
        this.NivActivation=Niv;
    }
    public void valider(){
        for (Element e:this.ElementEntree) {
            for (int i = 0; i < this.NivActivation; i++) {
                Stocks.enleverElem(e,e.getQuantite());
            }
        }
        for (Element e:ElementEntree) {
            Historique.ajouterChangement(new ChangementStock(e.getCode(), e.getNom(), e.getQuantite(), 0,0,"Mis en production"));
        }

    }
    public void fin(){
        for (Element e:ElementSortie) {
            for (int i = 0; i < this.NivActivation; i++) {
                Stocks.ajouterElem(e,e.getQuantite());
            }
        }
        this.NivActivation=0;
        for (Element e:ElementSortie) {
            ElementSortie.remove(e);
        }
        for (Element e:ElementEntree) {
            ElementEntree.remove(e);
        }
        for (Element e:ElementSortie) {
            Historique.ajouterChangement(new ChangementStock(e.getCode(), e.getNom(), e.getQuantite(), 0,0,"Production"));
        }


    }


}
