package com.shafear.notes;

import com.shafear.notes.xnotes.XNote;
import com.shafear.notes.xnotes.XNotes;

import java.util.ArrayList;

/**
 * Created by shafe_000 on 2015-02-08.
 */
public class MNotes {
    public XNotes loadNotesData() {
        ArrayList<XNote> notesList = new ArrayList<XNote>();
        notesList.add(new XNote("Notatka o bardzo długim tytule takim, że hohohohohoh dłuuuuuuuuuuuuuuuuuga notatka", "notatkowa"));
        notesList.add(new XNote("Notatka 2", "notatkowa"));
        notesList.add(new XNote("Notatka 3", "notatkowa"));
        notesList.add(new XNote("Notatka 2a", "notatkowa"));
        return new XNotes(notesList);
    }

    public void addNote(XNote xNote){

    }
}
