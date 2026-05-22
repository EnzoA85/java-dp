package fr.sdv.state;

import fr.sdv.builder.Produit;

class EtatPaiement implements CommandeEtat {

    private final Commande commande;

    EtatPaiement(Commande commande) {
        this.commande = commande;
    }

    @Override
    public void ajouterProduit(Produit produit) {
        throw new IllegalStateException("Impossible d'ajouter un produit lorsque la commande est en paiement.");
    }

    @Override
    public void payer() {
        throw new IllegalStateException("La commande est déjà au statut paiement.");
    }

    @Override
    public void livrer(String adresse) {
        commande.setAdresseLivraison(adresse);
        commande.setEtat(new EtatEnLivraison(commande));
    }

    @Override
    public void annuler() {
        commande.setEtat(new EtatAnnulee(commande));
    }

    @Override
    public Commande.Statut getStatut() {
        return Commande.Statut.PAIEMENT;
    }
}
