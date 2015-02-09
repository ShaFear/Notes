package com.shafear.notes.mvp.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.shafear.notes.mvp.presenter.PAddNote;
import com.shafear.notes.R;
import com.shafear.notes.xnotes.XNote;

public class VAddNote extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vadd_note);
    }

    public void saveNewNote(View view) {
        PAddNote pAddNote = new PAddNote();
        XNote xNewNote = getNewNoteInformationFromEditTextFields();
        pAddNote.choosedSubmitNote(xNewNote);
        finish();
    }

    private XNote getNewNoteInformationFromEditTextFields() {
        EditText titleEditText = (EditText) findViewById(R.id.editText);
        EditText contentEditText = (EditText) findViewById(R.id.editText2);
        String title = titleEditText.getText().toString();
        String content = contentEditText.getText().toString();
        return new XNote(title, content);
    }
}
