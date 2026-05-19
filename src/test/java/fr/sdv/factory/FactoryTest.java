package fr.sdv.factory;

import org.junit.Assert;
import org.junit.Test;

public class FactoryTest {

    @Test
    public void shouldCreateIngredient() {
        Element element = ElementFactory.createElement(TypeElement.INGREDIENT, "Sucre", 12.5, Unite.MILLI_GRAMMES);

        Assert.assertTrue(element instanceof Ingredient);
        Assert.assertEquals("Sucre", element.getNom());
        Assert.assertEquals(12.5, element.getValeur(), 0.0001);
        Assert.assertEquals(Unite.MILLI_GRAMMES, element.getUnite());
    }

    @Test
    public void shouldCreateAllergene() {
        Element element = ElementFactory.createElement(TypeElement.ALLERGENE, "Gluten", 0.8, Unite.MICRO_GRAMMES);

        Assert.assertTrue(element instanceof Allergene);
        Assert.assertEquals("Gluten", element.getNom());
        Assert.assertEquals(0.8, element.getValeur(), 0.0001);
        Assert.assertEquals(Unite.MICRO_GRAMMES, element.getUnite());
    }

    @Test
    public void shouldCreateAdditif() {
        Element element = ElementFactory.createElement(TypeElement.ADDITIF, "E202", 2.2, Unite.MILLI_GRAMMES);

        Assert.assertTrue(element instanceof Additif);
        Assert.assertEquals("E202", element.getNom());
        Assert.assertEquals(2.2, element.getValeur(), 0.0001);
        Assert.assertEquals(Unite.MILLI_GRAMMES, element.getUnite());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenTypeIsNull() {
        ElementFactory.createElement(null, "X", 1.0, Unite.MILLI_GRAMMES);
    }
}
