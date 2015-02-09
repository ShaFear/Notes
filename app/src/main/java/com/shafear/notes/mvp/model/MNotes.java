package com.shafear.notes.mvp.model;

import com.shafear.notes.mvp.model.load.MNoteLoad;
import com.shafear.notes.mvp.model.load.MNotesLoad;
import com.shafear.notes.mvp.model.save.MNotesAdd;
import com.shafear.notes.xnotes.XNote;
import com.shafear.notes.xnotes.XNotes;


/**
 * Created by shafe_000 on 2015-02-08.
 */
public class MNotes {
    public XNotes loadNotesData() {
        MNotesLoad mNotesLoad = new MNotesLoad();
        return mNotesLoad.loadNotesData();
        }

    public void addNote(XNote xNote){
        MNotesAdd mNotesAdd = new MNotesAdd();
        mNotesAdd.addNote(xNote);
    }

    public XNote loadNoteData(int position) {
        MNoteLoad mNoteLoad = new MNoteLoad();
        return mNoteLoad.loadNoteData(position);
    }
}
