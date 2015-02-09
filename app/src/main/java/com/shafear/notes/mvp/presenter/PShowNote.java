package com.shafear.notes.mvp.presenter;

import android.content.Intent;

import com.shafear.notes.global.G;
import com.shafear.notes.mvp.model.MNotes;
import com.shafear.notes.mvp.view.VNote;
import com.shafear.notes.xnotes.XNote;

/**
 * Created by shafe_000 on 2015-02-09.
 */
public class PShowNote {
    public void showNote(int position) {
        MNotes mNotes = new MNotes();
        XNote xNote = mNotes.loadNoteData(position);
        Intent intent = new Intent(G.ACTIVITY.getApplicationContext(), VNote.class);
        intent.putExtra("X_NOTE" ,xNote);
        G.ACTIVITY.startActivity(intent);
    }
}
