package com.shafear.notes.mvp.view;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.shafear.notes.global.G;
import com.shafear.notes.mvp.presenter.PAddNote;
import com.shafear.notes.R;
import com.shafear.notes.mvp.presenter.PShowNote;
import com.shafear.notes.mvp.presenter.PShowNotes;
import com.shafear.notes.xnotes.XNotes;



public class VNotesList extends ActionBarActivity {

    private PShowNotes pShowNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        G.ACTIVITY = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vnotes_list);
        pShowNotes = new PShowNotes();
        setListViewOfNotes();
        VAddLib.setColorForActionBarTitleText(this, "#edc437", getString(R.string.title_activity_vlista_notatek));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_vnotes_list, menu);
        return true;
    }

    private void setListViewOfNotes() {
        XNotes xNotes = pShowNotes.loadNotesData();
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, xNotes.getListaNotatek());
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PShowNote pShowNote = new PShowNote();
                pShowNote.showNote(position);
            }
        });
    }

    public boolean addNote(MenuItem menuItem){
        PAddNote pAddNote = new PAddNote();
        pAddNote.choosedAddNote();
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
}
