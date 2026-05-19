package fr.sdv.factory;

public abstract class Element {
    private final String nom;
    private final double valeur;
    private final Unite unite;

    protected Element(String nom, double valeur, Unite unite) {
        this.nom = nom;
        this.valeur = valeur;
        this.unite = unite;
    }

    public String getNom() {
        return nom;
    }

    public double getValeur() {
        return valeur;
    }

    public Unite getUnite() {
        return unite;
    }
}
