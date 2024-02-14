package ApplicationProjet.Classes;

public class Element {
    private String code;
    private String nom;
    private float quantite;
    private Unite UniteMesure;
    private float prixAchat;
    private float prixVente;



    public Element(String code, String nom, float quantite, Unite uniteMesure,float prixAchat, float prixVente){
        this.code=code;
        this.nom=nom;
        this.quantite=quantite;
        this.uniteMesure=uniteMesure;
        this.prixAchat=prixAchat;
        this.prixVente=prixVente;
    }
    public String getCode(){
        return this.code;
    }
    public String getNom(){
        return this.nom;
    }
    public float getQuantite(){
        return this.quantite;
    }
    public Unite getUniteMesure(){
        return this.uniteMesure;
    }
    public float getPrixAchat(){
        return this.prixAchat;
    }
    public float getPrixVente(){
        return this.prixVente;
    }
    public void setQuantite(float n){
        this.quantite+=n;
    }
    public float calculerPrixAchat(Element e){
        return (e.prixAchat)*(e.quantite);
    }
    public float calculerPrixVente(Element e){
        return (e.prixVente)*(e.quantite);
    }
}
