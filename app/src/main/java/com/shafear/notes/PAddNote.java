package com.shafear.notes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.shafear.notes.xnotes.XNote;

/**
 * Created by shafe_000 on 2015-02-08.
 */
public class PAddNote {
    private Activity activity;

    public PAddNote(Activity activity) {
        this.activity = activity;
    }

    public void choosedAddNote() {
        showAddNoteScreen();
    }

    public void choosedSubmitNote(XNote xNote){
        MNotes mNotes = new MNotes();
        mNotes.addNote(xNote, activity);
        new PShowNotes(activity);

    }

    private void showAddNoteScreen() {
        Intent intent = new Intent(activity.getApplicationContext(), VAddNote.class);
        activity.startActivity(intent);
    }



}
