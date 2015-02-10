package com.shafear.notes.mvp.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.shafear.notes.R;
import com.shafear.notes.mvp.presenter.PDeleteNote;
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
        contentTextView.setMovementMethod(new ScrollingMovementMethod());
        titleTextView.setMovementMethod(new ScrollingMovementMethod());
        VAddLib.setColorForActionBarTitleText(this, "#edc437", getString(R.string.title_activity_vnote));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_vnote, menu);
        return true;
    }

    public boolean deleteNote(MenuItem menuItem){
        PDeleteNote deleteNote = new PDeleteNote();
        int position = (int) getIntent().getSerializableExtra("POSITION");
        Log.d(new Integer(position).toString(), new Integer(position).toString());
        deleteNote.delete(position);
        finish();
        return true;
    }

}
