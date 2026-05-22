package fr.sdv.state;

import fr.sdv.builder.Produit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommandeTest {

    @Test
    public void testAjouterProduitEnCreation() {
        Commande commande = new Commande();
        commande.ajouterProduit(new Produit());

        assertEquals(Commande.Statut.CREATION, commande.getStatut());
        assertEquals(1, commande.getProduits().size());
    }

    @Test
    public void testPayerTransition() {
        Commande commande = new Commande();
        commande.ajouterProduit(new Produit());

        commande.payer();

        assertEquals(Commande.Statut.PAIEMENT, commande.getStatut());
        assertEquals(0.5, commande.getPrixTotal(), 0.0);
    }

    @Test
    public void testLivrerTransition() {
        Commande commande = new Commande();
        commande.ajouterProduit(new Produit());
        commande.payer();
        commande.livrer("123 rue de Test");

        assertEquals(Commande.Statut.EN_LIVRAISON, commande.getStatut());
        assertEquals("123 rue de Test", commande.getAdresseLivraison());
    }

    @Test
    public void testAnnulerEnCreation() {
        Commande commande = new Commande();
        commande.annuler();

        assertEquals(Commande.Statut.ANNULEE, commande.getStatut());
    }

    @Test
    public void testAnnulerEnPaiement() {
        Commande commande = new Commande();
        commande.ajouterProduit(new Produit());
        commande.payer();
        commande.annuler();

        assertEquals(Commande.Statut.ANNULEE, commande.getStatut());
    }

    @Test(expected = IllegalStateException.class)
    public void testAnnulerEnLivraisonEstImpossible() {
        Commande commande = new Commande();
        commande.ajouterProduit(new Produit());
        commande.payer();
        commande.livrer("adresse");
        commande.annuler();
    }

    @Test(expected = IllegalStateException.class)
    public void testAnnulerDejaAnnuleeEstImpossible() {
        Commande commande = new Commande();
        commande.annuler();
        commande.annuler();
    }
}
