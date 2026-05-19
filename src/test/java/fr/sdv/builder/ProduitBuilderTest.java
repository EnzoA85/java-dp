package fr.sdv.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProduitBuilderTest {

    private static final double DELTA = 0.0000001;

    @Test
    public void testBuildNominal() {
        Produit produit = new ProduitBuilder()
                .avecNom("Pizza 4 fromages")
                .avecGrade("A")
                .avecCategorie("Plats prepares")
                .avecMarque("Maison Test")
                .ajouterIngredient("Fromage", 125.0)
                .ajouterIngredient("Farine", 340.0)
                .ajouterAdditif("E300", 1.2)
                .ajouterAllergene("Lait", 90.0)
                .build();

        assertNotNull(produit);
        assertEquals("Pizza 4 fromages", produit.getNom());
        assertEquals("A", produit.getGrade());
        assertEquals("Plats prepares", produit.getCategorie().getNom());
        assertEquals("Maison Test", produit.getMarque().getNom());
        assertEquals(2, produit.getIngredients().size());
        assertEquals(1, produit.getAdditifs().size());
        assertEquals(1, produit.getAllergenes().size());
        assertEquals(125.0, produit.getIngredients().get(0).getQteMilligrammes(), DELTA);
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildSansNom() {
        new ProduitBuilder()
                .avecGrade("B")
                .avecCategorie("Epicerie")
                .avecMarque("Marque X")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildSansCategorie() {
        new ProduitBuilder()
                .avecNom("Produit sans categorie")
                .avecGrade("C")
                .avecMarque("Marque Y")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouterIngredientQuantiteNegative() {
        new ProduitBuilder()
                .avecNom("Produit test")
                .avecGrade("D")
                .avecCategorie("Snacks")
                .avecMarque("Marque Z")
                .ajouterIngredient("Sel", -1.0);
    }
}
