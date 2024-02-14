package ApplicationProjet.Classes;

public enum Unite {
    KG ("Kilogramme"),
    U ("Unité"),
    L ("Litre");

    private String mesure;
    Unite(String mesure){
        this.mesure=mesure;
    }
}
