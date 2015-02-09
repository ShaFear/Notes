package com.shafear.notes.mvp.view;

import android.app.Activity;
import android.os.Bundle;

import com.shafear.notes.global.G;
import com.shafear.notes.mvp.presenter.PShowNotes;
import com.shafear.notes.R;


public class VEntryScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //set global ACTIVITY for using activity class futures in future
        G.ACTIVITY = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventry_screen);
        showIntroScreenForMiliSeconds(1500);
        new PShowNotes();
        finish();
    }

    private void showIntroScreenForMiliSeconds(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
