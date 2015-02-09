package com.shafear.notes.mvp.presenter;

import com.shafear.notes.mvp.model.MNotes;
import com.shafear.notes.xnotes.XNotes;

/**
 * Created by shafe_000 on 2015-02-09.
 */
public class PDeleteNote {
    public void delete(int position) {
        MNotes mNotes = new MNotes();
        XNotes xNotes = mNotes.loadNotesData();
        xNotes.getListaNotatek().remove(position);
        mNotes.saveAllNotesFrom(xNotes);
        PShowNotes pShowNotes = new PShowNotes();
        pShowNotes.showNotesListScreen();
    }
}
