package com.jordan.composite;

import com.jordan.composite.Visitor.Visitor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mariavelle Jordan on 19-01-17.
 */
public class Folder extends Composant{

    List<Composant> composantList = new LinkedList<>();

    public Folder(String nom) {
        super(nom);
    }

    public void add(Composant c){
        composantList.add(c);
    }

    public void remove(Composant c){
        composantList.remove(c);
    }

    public List<Composant> getChildren(){
        return composantList;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "composantList=" + composantList +
                '}';
    }

    @Override
    public void display() {
        System.out.println("Folder "+getNom()+" {");
        final Iterator<Composant> lIterator = composantList.iterator();
        while(lIterator.hasNext()) {
            final Composant lComposant = lIterator.next();
            lComposant.display();
        }
        System.out.println("}");
    }

    @Override
    public Composant clone() {

        Folder f = new Folder(getNom());
        final Iterator<Composant> lIterator = composantList.iterator();
        while(lIterator.hasNext()) {
            final Composant lComposant = lIterator.next();
            f.add(lComposant.clone());
        }

        return f;
    }

    @Override
    public void accept(Visitor v) {
        v.visitFolder(this);
    }
}
