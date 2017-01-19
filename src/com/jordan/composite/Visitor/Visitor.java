package com.jordan.composite.Visitor;

import com.jordan.composite.File;
import com.jordan.composite.Folder;

/**
 * Created by Mariavelle Jordan on 19-01-17.
 */
public interface Visitor {

    void visitFile(File f);

    void visitFolder(Folder f);
}
