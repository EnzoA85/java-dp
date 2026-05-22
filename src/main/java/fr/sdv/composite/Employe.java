package fr.sdv.composite;

public class Employe implements IElement {
    private final String nom;
    private final String prenom;
    private final double salaire;

    public Employe(String nom, String prenom, double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public double getSalaire() {
        return salaire;
    }

    @Override
    public double calculerSalaire() {
        return salaire;
    }

    @Override
    public String toString() {
        return String.format("Employe{name='%s %s', salaire=%.2f}", prenom, nom, salaire);
    }
}
