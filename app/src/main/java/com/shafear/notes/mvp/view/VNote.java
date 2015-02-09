package com.shafear.notes.mvp.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.shafear.notes.R;
import com.shafear.notes.xnotes.XNote;

public class VNote extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vnote);
        XNote xNote = (XNote) getIntent().getSerializableExtra("X_NOTE");
        TextView titleTextView = (TextView) findViewById(R.id.textView4);
        TextView contentTextView = (TextView) findViewById(R.id.textView6);
        titleTextView.setText(xNote.getTitle());
        contentTextView.setText(xNote.getContent());
    }
}
