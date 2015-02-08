package com.shafear.notes;

import android.app.Activity;

import com.shafear.notes.xnotes.XNote;
import com.shafear.notes.xnotes.XNotes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Created by shafe_000 on 2015-02-08.
 */
public class MNotes {
    public XNotes loadNotesData() {
        ArrayList<XNote> notesList = new ArrayList<XNote>();
        notesList.add(new XNote("Notatka o bardzo długim tytule takim, że hohohohohoh dłuuuuuuuuuuuuuuuuuga notatka", "notatkowa"));
        return new XNotes(notesList);
    }

    public void addNote(XNote xNote){
        
    }
}
