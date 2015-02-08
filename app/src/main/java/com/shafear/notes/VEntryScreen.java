package com.shafear.notes;

import android.app.Activity;
import android.os.Bundle;


public class VEntryScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventry_screen);
        GlobalVariables.FILES_INTERNAL_PATH = getFilesDir();
        //System.err.print(GlobalVariables.FILES_INTERNAL_PATH.toString());
        showIntroScreenForMiliSeconds(1500);
        new PShowNotes(this);
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
