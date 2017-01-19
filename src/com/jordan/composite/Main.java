package com.jordan.composite;

import com.jordan.composite.Visitor.CountComposant;
import com.jordan.composite.Visitor.CountSize;
import com.jordan.composite.Visitor.Visitor;

public class Main {

    public static void main(String[] args) {

        final Folder lComposite1 = new Folder("Composite 1");
        final Folder lComposite2 = new Folder("Composite 2");
        final Folder lComposite3 = new Folder("Composite 3");
        final Folder lComposite4 = new Folder("Composite 4");
        final Folder lComposite5 = new Folder("Composite 5");

        // Création des objets "Element"
        final File lElement1 = new File("Element 1",".pdf",440);
        final File lElement2 = new File("Element 2",".doc",680);
        final File lElement3 = new File("Element 3",".png",9760);
        final File lElement4 = new File("Element 4",".png",12876);
        final File lElement5 = new File("Element 5",".txt",35);

        // Ajout des "Composant" afin de constituer l'arborescence
        lComposite1.add(lElement1);
        lComposite1.add(lComposite2);
        lComposite1.add(lElement2);

        lComposite2.add(lComposite3);
        lComposite2.add(lComposite4);

        lComposite3.add(lElement3);
        lComposite3.add(lElement4);

        lComposite4.add(lComposite5);

        lComposite5.add(lElement5);

        lComposite1.display();


        final Folder lCompositeClone = (Folder) lComposite1.clone();
//        lComposite1.setNom("yeaaaaaaaaaaaaaaah");
//        lElement3.setNom("Element 3 yeaaaaaaaaaaaaah");

        System.out.println("--------------------");
        lComposite1.display();
//        System.out.println("--------------------");
//        lCompositeClone.display();

        CountComposant lVisiteurA = new CountComposant();
        CountSize lVisiteurB = new CountSize();

        lComposite1.accept(lVisiteurA);
        lComposite1.accept(lVisiteurB);

        System.out.println(lComposite1.getNom()+" contains: "+ lVisiteurA.getNbFile()+" file(s), "+lVisiteurA.getNbFolder()+" folder(s),"+lVisiteurB.getSize()+" ko.");

    }
}
