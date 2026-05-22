package fr.sdv.state;

import fr.sdv.builder.Produit;

class EtatAnnulee implements CommandeEtat {

    private final Commande commande;

    EtatAnnulee(Commande commande) {
        this.commande = commande;
    }

    @Override
    public void ajouterProduit(Produit produit) {
        throw new IllegalStateException("La commande a déjà été annulée.");
    }

    @Override
    public void payer() {
        throw new IllegalStateException("La commande a déjà été annulée.");
    }

    @Override
    public void livrer(String adresse) {
        throw new IllegalStateException("La commande a déjà été annulée.");
    }

    @Override
    public void annuler() {
        throw new IllegalStateException("La commande a déjà été annulée.");
    }

    @Override
    public Commande.Statut getStatut() {
        return Commande.Statut.ANNULEE;
    }
}
