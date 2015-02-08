package com.shafear.notes;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.shafear.notes.xnotes.XNotes;



public class VNotesList extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vnotes_list);
        setListViewOfNotes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_vlista_notatek, menu);
        return true;
    }

    private void setListViewOfNotes() {
        XNotes xNotes = (XNotes) getIntent().getSerializableExtra("X_NOTES");
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, xNotes.getListaNotatek());
        listView.setAdapter(arrayAdapter);
    }
}
