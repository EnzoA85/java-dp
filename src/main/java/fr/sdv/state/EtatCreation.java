package fr.sdv.state;

import fr.sdv.builder.Produit;

class EtatCreation implements CommandeEtat {

    private final Commande commande;

    EtatCreation(Commande commande) {
        this.commande = commande;
    }

    @Override
    public void ajouterProduit(Produit produit) {
        commande.ajouterProduitInterne(produit);
    }

    @Override
    public void payer() {
        double total = commande.getProduitsInternes().size() * 0.5;
        commande.setPrixTotal(total);
        commande.setEtat(new EtatPaiement(commande));
    }

    @Override
    public void livrer(String adresse) {
        throw new IllegalStateException("La commande doit être payée avant la livraison.");
    }

    @Override
    public void annuler() {
        commande.setEtat(new EtatAnnulee(commande));
    }

    @Override
    public Commande.Statut getStatut() {
        return Commande.Statut.CREATION;
    }
}
