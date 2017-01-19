package com.jordan.composite;

import com.jordan.composite.Visitor.Visitor;

/**
 * Created by Mariavelle Jordan on 19-01-17.
 */
public class File extends Composant{

    String extension;
    int size;

    public File(String nom, String extension, int size) {
        super(nom);
        this.extension = extension;
        this.size = size;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public Composant clone() {
        return new File(getNom(), getExtension(), getSize());
    }

    @Override
    public String toString() {
        return "File{" +
                "nom='" + nom + '\'' +
                "extension='" + extension + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public void accept(Visitor v) {
        v.visitFile(this);
    }
}
