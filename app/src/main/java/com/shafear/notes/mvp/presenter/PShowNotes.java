package com.shafear.notes.mvp.presenter;

import android.content.Intent;

import com.shafear.notes.global.G;
import com.shafear.notes.mvp.model.MNotes;
import com.shafear.notes.mvp.view.VNotesList;
import com.shafear.notes.xnotes.XNotes;

/**
 * Created by shafe_000 on 2015-02-08.
 */
public class PShowNotes {

    public PShowNotes(){
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
        Intent intent = new Intent(G.ACTIVITY.getApplicationContext(), VNotesList.class);
        intent.putExtra("X_NOTES" ,xNotes);
        G.ACTIVITY.startActivity(intent);
    }

}
