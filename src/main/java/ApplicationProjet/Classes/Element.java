package ApplicationProjet.Classes;
import ApplicationProjet.Classes.Stocks;

import java.security.cert.CertificateRevokedException;
import java.util.ArrayList;

public class Element {

    private final String code;
    private final String nom;
    private float quantite;
    private final String uniteMesure;
    private final double prixAchat;
    private double prixVente;



    public Element(String code, String nom, float quantite, String uniteMesure,double prixAchat, double prixVente){
        this.code=code;
        this.nom=nom;
        this.quantite=quantite;
        this.uniteMesure=uniteMesure;
        this.prixAchat=prixAchat;
        this.prixVente=prixVente;
    }
    public static Element trouverElement(String code){
        for (Element e : Stocks.EStock){
            if(e.getCode().equals(code))
                return e;
        }
        return null;
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
    public double getPrixAchat(){
        return this.prixAchat;
    }
    public double getPrixVente(){
        return this.prixVente;
    }
    public void setQuantite(float n){
        this.quantite=n;
    }


    public void ajouterQuantite(float n){this.quantite+=n;}

    public void setPrixVente(float n){
        this.prixVente=n;
    }



    public void Acheter(Element e, float quantiteCommandee){
        double Prix = PrixAchat(e,quantiteCommandee);

        Stocks.ajouterElem(e,quantiteCommandee);
        Historique.ajouterChangement(new ChangementStock(e.getCode(), e.getNom(), quantiteCommandee, e.getUniteMesure(),Prix,0,"Achat"));
    }
    public static void Vendre(Element e, float quantiteVendue){
        for (Element a : Stocks.EStock) {
            if (a.getCode().equals(e.getCode())) {
                    Stocks.enleverElem(a, quantiteVendue);

            }
        }
        AjouterHistorique(e, quantiteVendue);
    }

    public static void AjouterHistorique(Element e, float quantiteVendue){

        double Prix = (e.prixVente)*(quantiteVendue);

        Historique.ajouterChangement(new ChangementStock(e.getCode(), e.getNom(), quantiteVendue,e.getUniteMesure(),0,Prix,"Vente"));
    }

    public double PrixAchat(Element e, float quantite){

            return (e.prixAchat)*(quantite);
    }

        public double PrixVente(Element e, float quantite){
            return (e.prixVente)*(quantite);
    }
}
