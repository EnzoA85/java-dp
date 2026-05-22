package fr.sdv.state;

import fr.sdv.builder.Produit;

interface CommandeEtat {

    void ajouterProduit(Produit produit);

    void payer();

    void livrer(String adresse);

    void annuler();

    Commande.Statut getStatut();
}
