package fr.sdv.state;

import fr.sdv.builder.Produit;

class EtatEnLivraison implements CommandeEtat {

    private final Commande commande;

    EtatEnLivraison(Commande commande) {
        this.commande = commande;
    }

    @Override
    public void ajouterProduit(Produit produit) {
        throw new IllegalStateException("Impossible d'ajouter un produit lorsque la commande est en cours de livraison.");
    }

    @Override
    public void payer() {
        throw new IllegalStateException("La commande est déjà en cours de livraison.");
    }

    @Override
    public void livrer(String adresse) {
        throw new IllegalStateException("La commande est déjà en cours de livraison.");
    }

    @Override
    public void annuler() {
        throw new IllegalStateException("La commande est déjà en cours de livraison et ne peut plus être annulée.");
    }

    @Override
    public Commande.Statut getStatut() {
        return Commande.Statut.EN_LIVRAISON;
    }
}
