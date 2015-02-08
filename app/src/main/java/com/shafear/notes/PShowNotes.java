package com.shafear.notes;

import android.app.Activity;
import android.content.Intent;

import com.shafear.notes.xnotes.XNotes;

/**
 * Created by shafe_000 on 2015-02-08.
 */
public class PShowNotes {
    private Activity activity;

    public PShowNotes(Activity activity){
        this.activity = activity;
        this.choosedShowTheNotes();
    }

    private void choosedShowTheNotes(){
        XNotes xNotes = loadNotesData();
        showNotesListScreen(xNotes);
    }

    private XNotes loadNotesData() {
        MNotes mNotes = new MNotes();
        return mNotes.loadNotesData();
    }

    private void showNotesListScreen(XNotes xNotes){
        Intent intent = new Intent(activity.getApplicationContext(), VNotesList.class);
        intent.putExtra("X_NOTES" ,xNotes);
        activity.startActivity(intent);
    }

}
