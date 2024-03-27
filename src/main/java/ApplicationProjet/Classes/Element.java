package ApplicationProjet.Classes;
import ApplicationProjet.Classes.Stocks;

import java.security.cert.CertificateRevokedException;
import java.util.ArrayList;
/**
 * Cette classe représente un élément (produit) du stock.
 * Elle stocke les informations suivantes :
 *  - code unique de l'élément
 *  - nom de l'élément
 *  - quantité en stock
 *  - unité de mesure (pièce, kg, litre, etc.)
 *  - prix d'achat unitaire
 *  - prix de vente unitaire
 *  - quantité en cours de production (facultatif)
 *
 * La classe fournit également des méthodes pour :
 *  - obtenir les informations de l'élément
 *  - modifier la quantité en stock
 *  - acheter un élément en mettant à jour le stock et l'historique
 *  - vendre un élément en mettant à jour le stock et l'historique
 *  - calculer le prix d'achat d'une quantité donnée d'un élément
 *
 * @author Adrilo
 */
public class Element {
    /**
     * Code unique de l'élément.
     */
    private final String code;
    /**
     * Nom de l'élément.
     */
    private final String nom;
    /**
     * Quantité en stock de l'élément.
     */
    private float quantite;
    /**
     * Unité de mesure de l'élément (pièce, kg, litre, etc.).
     */
    private final String uniteMesure;
    /**
     * Prix d'achat unitaire de l'élément.
     */
    private final double prixAchat;
    /**
     * Prix de vente unitaire de l'élément.
     */
    private double prixVente;
    /**
     * Quantité de l'élément en production.
     */
    private float quantiteEnProd;

    /**
     * Constructeur de la classe `Element`.
     *
     * @param code Code unique de l'élément.
     * @param nom Nom de l'élément.
     * @param quantite Quantité initiale en stock.
     * @param uniteMesure Unité de mesure de l'élément.
     * @param prixAchat Prix d'achat unitaire.
     * @param prixVente Prix de vente unitaire.
     */
    public Element(String code, String nom, float quantite, String uniteMesure, double prixAchat, double prixVente) {
        this.code = code;
        this.nom = nom;
        this.quantite = quantite;
        this.uniteMesure = uniteMesure;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
    }
    /**
     * Recherche un élément dans le stock à l'aide de son code unique.
     *
     * @param code Code unique de l'élément à rechercher.
     * @return L'élément trouvé, ou null si aucun élément ne correspond au code.
     */
    public static Element trouverElement(String code) {
        for (Element e : Stocks.EStock) {
            if (e.getCode().equals(code))
                return e;
        }
        return null;
    }
    // Getters (accesseurs) pour les attributs privés

    public String getCode() {
        return this.code;
    }

    public String getNom() {
        return this.nom;
    }

    public float getQuantite() {
        return this.quantite;
    }

    public String getUniteMesure() {
        return this.uniteMesure;
    }

    public double getPrixAchat() {
        return this.prixAchat;
    }

    public double getPrixVente() {
        return this.prixVente;
    }
    // Setters (modificateurs) pour certains attributs
    public void setQuantite(float n) {
        this.quantite = n;
    }

    public void setQuantiteEnProd(float quantiteEnProd) {
        this.quantiteEnProd = quantiteEnProd;
    }
    /**
     * Ajoute une quantité à la quantité en stock de l'élément.
     *
     * @param n Quantité à ajouter.
     */
    public void ajouterQuantite(float n) {
        this.quantite += n;
    }

    /**
     * Achète un élément en mettant à jour le stock et l'historique des changements.
     *
     * @param e L'élément à acheter.
     * @param quantiteCommandee La quantité à acheter.
     */
    public void Acheter(Element e, float quantiteCommandee) {
        double Prix = PrixAchat(e, quantiteCommandee);

        Stocks.ajouterElem(e, quantiteCommandee);
        Historique.ajouterChangement(new ChangementStock(e.getCode(), e.getNom(), quantiteCommandee, e.getUniteMesure(), Prix, 0, "Achat"));
    }
    /**
     * Vend un élément en mettant à jour le stock et l'historique des changements.
     *
     * @param e L'élément à vendre.
     * @param quantiteVendue La quantité à vendre.
     */
    public static void Vendre(Element e, float quantiteVendue) {
        for (Element a : Stocks.EStock) {
            if (a.getCode().equals(e.getCode())) {
                Stocks.enleverElem(a, quantiteVendue);

            }
        }
        AjouterHistorique(e, quantiteVendue);
    }
    /**
     * Ajoute un enregistrement d'historique de vente d'un élément.
     *
     * @param e L'élément vendu.
     * @param quantiteVendue La quantité vendue.
     */
    public static void AjouterHistorique(Element e, float quantiteVendue) {

        double Prix = (e.prixVente) * (quantiteVendue);

        Historique.ajouterChangement(new ChangementStock(e.getCode(), e.getNom(), quantiteVendue, e.getUniteMesure(), 0, Prix, "Vente"));
    }
    /**
     * Calcule le prix d'achat d'une quantité donnée d'un élément.
     *
     * @param e L'élément.
     * @param quantite La quantité.
     * @return Le prix d'achat total.
     */
    public double PrixAchat(Element e, float quantite) {

        return (e.prixAchat) * (quantite);
    }
}