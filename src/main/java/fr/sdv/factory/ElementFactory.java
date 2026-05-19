package fr.sdv.factory;

public final class ElementFactory {

    private ElementFactory() {
    }

    public static Element createElement(TypeElement typeElement, String nom, double valeur, Unite unite) {
        if (typeElement == null) {
            throw new IllegalArgumentException("Le type d'element ne peut pas etre null");
        }

        switch (typeElement) {
            case INGREDIENT:
                return new Ingredient(nom, valeur, unite);
            case ALLERGENE:
                return new Allergene(nom, valeur, unite);
            case ADDITIF:
                return new Additif(nom, valeur, unite);
            default:
                throw new IllegalArgumentException("Type d'element non gere: " + typeElement);
        }
    }
}
