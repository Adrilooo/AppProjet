package ApplicationProjet.Classes;
import java.util.ArrayList;
public class ChaineProduction{
    private int code;
    private String nom;
    private float  NivActivation;

    private  ArrayList<Element> ElementEntree = new ArrayList<Element>();
    private ArrayList<Element> ElementSortie = new ArrayList<Element>();


    public ChaineProduction(int code, String nom){
        this.code=code;
        this.nom=nom;
    }
    public int getCode(){
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
    public void getElementEntree(){

    }
    public void getElementSortie(){

    }

    public float getNivActivation() {
        return NivActivation;
    }
}
