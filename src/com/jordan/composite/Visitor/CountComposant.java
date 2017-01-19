package com.jordan.composite.Visitor;

import com.jordan.composite.Composant;
import com.jordan.composite.File;
import com.jordan.composite.Folder;

import java.util.Iterator;

/**
 * Created by Mariavelle Jordan on 19-01-17.
 */
public class CountComposant implements Visitor{

    int nbFile;
    int nbFolder;

    @Override
    public void visitFile(File f) {
        nbFile++;
    }

    @Override
    public void visitFolder(Folder f) {
        nbFolder++;

        Iterator<Composant> ite = f.getChildren().iterator();
        while(ite.hasNext()){
            Composant c = ite.next();
            c.accept(this);
        }
    }

    public int getNbFile() {
        return nbFile;
    }

    public int getNbFolder() {
        return nbFolder;
    }
}
