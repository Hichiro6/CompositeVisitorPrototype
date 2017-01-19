package com.jordan.composite.Visitor;

import com.jordan.composite.Composant;
import com.jordan.composite.File;
import com.jordan.composite.Folder;

import java.util.Iterator;

/**
 * Created by Mariavelle Jordan on 19-01-17.
 */
public class CountSize implements Visitor{

    int size;

    @Override
    public void visitFile(File f) {
        size+= f.getSize();
    }

    @Override
    public void visitFolder(Folder f) {
        Iterator<Composant> ite = f.getChildren().iterator();
        while(ite.hasNext()){
            Composant c = ite.next();
            c.accept(this);
        }
    }

    public int getSize() {
        return size;
    }
}
