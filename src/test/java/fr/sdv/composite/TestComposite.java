package fr.sdv.composite;

import org.junit.Assert;
import org.junit.Test;

public class TestComposite {

    @Test
    public void shouldComputeTotalSalaryForServiceHierarchy() {
        Employe directeur = new Employe("RASPEY", "Cécile", 10000);
        Employe architecte = new Employe("BECHKAR", "Bilel", 8000);
        Employe chefBigData = new Employe("RANMEY", "JB", 7500);
        Employe concepteur = new Employe("DOE", "Jane", 3500);
        Employe chefJavaDev = new Employe("GUINEAU", "Kevin", 7500);
        Employe leadDev = new Employe("MARTIN", "Paul", 3500);

        Service bigData = new Service("Big Data");
        Service javaDev = new Service("Java Dev");
        Service dsin = new Service("DSIN");

        bigData.ajouterElement(chefBigData);
        bigData.ajouterElement(concepteur);

        javaDev.ajouterElement(chefJavaDev);
        javaDev.ajouterElement(leadDev);

        dsin.ajouterElement(directeur);
        dsin.ajouterElement(architecte);
        dsin.ajouterElement(bigData);
        dsin.ajouterElement(javaDev);

        Assert.assertEquals(11000.0, bigData.calculerSalaire(), 0.0001);
        Assert.assertEquals(11000.0, javaDev.calculerSalaire(), 0.0001);
        Assert.assertEquals(40000.0, dsin.calculerSalaire(), 0.0001);
    }
}
