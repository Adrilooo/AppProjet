package ApplicationProjet.Classes;


/**
 * Cette classe représente un changement de stock d'un élément.
 * Elle stocke les informations concernant l'élément, la quantité modifiée,
 * les prix d'achat et de vente, l'unité de mesure, et l'origine du changement.
 *
 * @author Adrilo
 */
public class ChangementStock {
    /**
     * Code unique de l'élément concerné par le changement.
     */
    private String codeElement;
    /**
     * Nom de l'élément concerné.
     */
    private String nomElement;
    /**
     * Quantité modifiée de l'élément.
     */
    private float quantiteModifiee;
    /**
     * Unité de mesure de l'élément.
     */
    private String uniteMesure;
    /**
     * Prix d'achat unitaire de l'élément.
     */
    private double prixAchat;
    /**
     * Prix de vente unitaire de l'élément.
     */
    private double prixVente;
    /**
     * Origine du changement (achat, vente, production, sortie, modification).
     */
    private String origine;  // Vente, Achat, Production, Sortie, Modification
    /**
     * Constructeur de la classe ChangementStock.
     *
     * @param codeElement Code unique de l'élément.
     * @param nomElement Nom de l'élément.
     * @param quantiteModifiee Quantité modifiée.
     * @param uniteMesure Unité de mesure.
     * @param prixAchat Prix d'achat unitaire.
     * @param prixVente Prix de vente unitaire.
     * @param origine Origine du changement.
     */
    public ChangementStock(String codeElement, String nomElement, float quantiteModifiee, String uniteMesure,double prixAchat, double prixVente, String origine) {
        this.codeElement = codeElement;
        this.nomElement = nomElement;
        this.quantiteModifiee = quantiteModifiee;
        this.uniteMesure=uniteMesure;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.origine = origine;
    }
// Getters (accesseurs) pour les attributs privés

    public String getCodeElement() {
        return codeElement;
    }

    public String getNomElement() {
        return nomElement;
    }

    public float getQuantiteModifiee() {
        return quantiteModifiee;
    }

    public String getUniteMesure(){return uniteMesure;}

    public double getPrixAchat() {
        return prixAchat;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public String getOrigine() {
        return origine;
    }

}
