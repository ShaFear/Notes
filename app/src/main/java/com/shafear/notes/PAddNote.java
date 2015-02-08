package com.shafear.notes;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by shafe_000 on 2015-02-08.
 */
public class PAddNote {
    private Activity activity;

    public PAddNote(Activity activity) {
        this.activity = activity;
        choosedAddNote();
    }

    private void choosedAddNote() {
        showAddNoteScreen();
    }

    private void showAddNoteScreen() {
        Intent intent = new Intent(activity.getApplicationContext(), VAddNoteScreen.class);
        activity.startActivity(intent);
    }
}
