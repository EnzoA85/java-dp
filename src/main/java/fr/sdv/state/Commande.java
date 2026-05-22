package fr.sdv.state;

import fr.sdv.builder.Produit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Commande {

    public enum Statut {
        CREATION,
        PAIEMENT,
        EN_LIVRAISON,
        ANNULEE
    }

    private final List<Produit> produits = new ArrayList<>();
    private CommandeEtat etat;
    private double prixTotal;
    private String adresseLivraison;

    public Commande() {
        this.etat = new EtatCreation(this);
    }

    void setEtat(CommandeEtat etat) {
        this.etat = etat;
    }

    void ajouterProduitInterne(Produit produit) {
        this.produits.add(produit);
    }

    void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    List<Produit> getProduitsInternes() {
        return produits;
    }

    public Statut getStatut() {
        return etat.getStatut();
    }

    public List<Produit> getProduits() {
        return Collections.unmodifiableList(produits);
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void ajouterProduit(Produit produit) {
        etat.ajouterProduit(produit);
    }

    public void payer() {
        etat.payer();
    }

    public void livrer(String adresse) {
        etat.livrer(adresse);
    }

    public void annuler() {
        etat.annuler();
    }
}
