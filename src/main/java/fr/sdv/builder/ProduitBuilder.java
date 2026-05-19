package fr.sdv.builder;

import java.util.ArrayList;
import java.util.List;

public class ProduitBuilder {

    private String nom;
    private String grade;
    private String categorieNom;
    private String marqueNom;
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final List<Additif> additifs = new ArrayList<>();
    private final List<Allergene> allergenes = new ArrayList<>();

    public ProduitBuilder avecNom(String nom) {
        this.nom = nom;
        return this;
    }

    public ProduitBuilder avecGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public ProduitBuilder avecCategorie(String nomCategorie) {
        this.categorieNom = nomCategorie;
        return this;
    }

    public ProduitBuilder avecMarque(String nomMarque) {
        this.marqueNom = nomMarque;
        return this;
    }

    public ProduitBuilder ajouterIngredient(String nomIngredient, double qteMilligrammes) {
        this.ingredients.add(new Ingredient(validerTexte(nomIngredient, "nomIngredient"),
                validerQuantite(qteMilligrammes, "qteMilligrammes ingredient")));
        return this;
    }

    public ProduitBuilder ajouterAdditif(String nomAdditif, double qteMilligrammes) {
        this.additifs.add(new Additif(validerTexte(nomAdditif, "nomAdditif"),
                validerQuantite(qteMilligrammes, "qteMilligrammes additif")));
        return this;
    }

    public ProduitBuilder ajouterAllergene(String nomAllergene, double qteMilligrammes) {
        this.allergenes.add(new Allergene(validerTexte(nomAllergene, "nomAllergene"),
                validerQuantite(qteMilligrammes, "qteMilligrammes allergene")));
        return this;
    }

    public Produit build() {
        Produit produit = new Produit();
        produit.setNom(validerTexte(nom, "nom"));
        produit.setGrade(validerTexte(grade, "grade"));
        produit.setCategorie(new Categorie(validerTexte(categorieNom, "categorie")));
        produit.setMarque(new Marque(validerTexte(marqueNom, "marque")));
        produit.setIngredients(new ArrayList<>(ingredients));
        produit.setAdditifs(new ArrayList<>(additifs));
        produit.setAllergenes(new ArrayList<>(allergenes));
        return produit;
    }

    private String validerTexte(String valeur, String champ) {
        if (valeur == null || valeur.trim().isEmpty()) {
            throw new IllegalStateException("Le champ '" + champ + "' est obligatoire");
        }
        return valeur;
    }

    private double validerQuantite(double quantite, String champ) {
        if (quantite < 0) {
            throw new IllegalArgumentException("Le champ '" + champ + "' doit etre >= 0");
        }
        return quantite;
    }
}
