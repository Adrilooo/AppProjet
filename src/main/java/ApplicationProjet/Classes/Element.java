package ApplicationProjet.Classes;
import ApplicationProjet.Classes.Stocks;
import java.util.ArrayList;

public class Element {

    private String code;
    private String nom;
    private float quantite;
    private String uniteMesure;
    private float prixAchat;
    private float prixVente;



    public Element(String code, String nom, float quantite, String uniteMesure,float prixAchat, float prixVente){
        this.code=code;
        this.nom=nom;
        this.quantite=quantite;
        this.uniteMesure=uniteMesure;
        this.prixAchat=prixAchat;
        this.prixVente=prixVente;
    }
    public Element(String code,String nom,float quantite){
        this.code=code;
        this.nom=nom;
        this.quantite=quantite;

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
    public String getUniteMesure(){
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
    public void setPrixVente(float n){
        this.prixVente=n;
    }



    public void Acheter(Element e, float quantiteCommandee){
        float Prix = PrixAchat(e,quantiteCommandee);

        Stocks.ajouterElem(e,quantiteCommandee);
        Historique.ajouterChangement(new ChangementStock(e.getCode(), e.getNom(), quantiteCommandee, Prix,0,"Achat"));
    }
    public void Vendre(Element e, float quantiteVendue){
        for (Element a : Stocks.EStock) {
            if (a.getCode().equals(e.getCode())) {
                boolean b = quantiteVendue > a.getQuantite();
                if (!b) {
                    Stocks.enleverElem(a, quantiteVendue);
                }
            }
        }
        float Prix = PrixVente(e,quantiteVendue);
            Historique.ajouterChangement(new ChangementStock(e.getCode(), e.getNom(), quantiteVendue,0,Prix,"Vente"));
    }

    public float PrixAchat(Element e, float quantite){

            return (e.prixAchat)*(quantite);
    }



        public float PrixVente(Element e, float quantite){

            return (e.prixVente)*(quantite);
    }

}