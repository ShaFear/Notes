package com.shafear.notes.mvp.presenter;

import android.content.Intent;

import com.shafear.notes.global.G;
import com.shafear.notes.mvp.model.MNotes;
import com.shafear.notes.mvp.view.VAddNote;
import com.shafear.notes.xnotes.XNote;

/**
 * Created by shafe_000 on 2015-02-08.
 */
public class PAddNote {
    public void choosedAddNote() {
        showAddNoteScreen();
    }

    public void choosedSubmitNote(XNote xNote){
        MNotes mNotes = new MNotes();
        mNotes.addNote(xNote);
        new PShowNotes();

    }

    private void showAddNoteScreen() {
        Intent intent = new Intent(G.ACTIVITY.getApplicationContext(), VAddNote.class);
        G.ACTIVITY.startActivity(intent);
    }



}
