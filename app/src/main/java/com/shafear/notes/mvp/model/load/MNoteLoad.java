package com.shafear.notes.mvp.model.load;

import com.shafear.notes.xnotes.XNote;
import com.shafear.notes.xnotes.XNotes;

/**
 * Created by shafe_000 on 2015-02-09.
 */
public class MNoteLoad {
    public XNote loadNoteData(int position) {
        MNotesLoad mNotesLoad = new MNotesLoad();
        XNotes xNotes = mNotesLoad.loadNotesData();
        return xNotes.getListaNotatek().get(position);
    }
}
