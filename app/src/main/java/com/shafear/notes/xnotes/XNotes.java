package com.shafear.notes.xnotes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by shafe_000 on 2015-02-08.
 */
public class XNotes implements Serializable{
    public ArrayList<XNote> getListaNotatek() {
        return listaNotatek;
    }

    private ArrayList<XNote> listaNotatek;

    public XNotes(ArrayList<XNote> listaNotatek){
        this.listaNotatek = listaNotatek;
    }

    @Override
    public String toString() {
        return listaNotatek.toString();
    }
}
