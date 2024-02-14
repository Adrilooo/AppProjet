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

    private  ArrayList<Element> ElementEntree = new ArrayList<Element>();
    private ArrayList<Element> ElementSortie = new ArrayList<Element>();
    private Timer TempsProd = new Timer();

    public ChaineProduction(String code, String nom){
        this.code=code;
        this.nom=nom;
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
        for(Element e:ElementEntree){
            s += e.getNom();
        }

    }
    public void getElementSortie(){
        for(Element e:ElementSortie){
            System.out.println(e);
        }
    }

    public float getNivActivation() {
        return NivActivation;
    }
    public void valider(){
        //cas ou le stock est vide
        for (Element e:this.ElementEntree) {
            for (int i = 0; i < this.NivActivation; i++) {
                Stocks.enleverElem(e);
            }
        }
        int T = this.NivActivation * 6000;
        this.TempsProd.schedule(new TimerTask(){

            @Override
            public void run(){
                fin();
            }

        },T);
        //historique
    }
    public void fin(){
        for (Element e:ElementSortie) {
            for (int i = 0; i < this.NivActivation; i++) {
                Stocks.ajouterElem(e);
            }
        }
        this.NivActivation=0;
        for (Element e:ElementSortie) {
            ElementSortie.remove(e);
        }
        for (Element e:ElementEntree) {
            ElementEntree.remove(e);
        }

    }

}
ntm dzdrien