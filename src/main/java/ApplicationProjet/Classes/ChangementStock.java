package ApplicationProjet.Classes;

public class ChangementStock {
    private String codeElement;
    private String nomElement;
    private double quantiteModifiee;
    private double prixAchat;
    private double prixVente;
    private String origine;  // Vente, Achat, Production, Sortie, Modification

    public ChangementStock(String codeElement, String nomElement, float quantiteModifiee, float prixAchat, float prixVente, String origine) {
        this.codeElement = codeElement;
        this.nomElement = nomElement;
        this.quantiteModifiee = quantiteModifiee;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.origine = origine;
    }

    public String getCodeElement() {
        return codeElement;
    }

    public String getNomElement() {
        return nomElement;
    }

    public double getQuantiteModifiee() {
        return quantiteModifiee;
    }

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
