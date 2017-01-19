package com.jordan.composite;

import com.jordan.composite.Visitor.Acceptor;

/**
 * Created by Mariavelle Jordan on 19-01-17.
 */
public abstract class Composant implements Cloneable, Acceptor {

    String nom;

    public Composant(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public abstract void display();

    public abstract Composant clone();
}
