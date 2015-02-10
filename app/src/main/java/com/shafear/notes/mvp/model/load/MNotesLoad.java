package com.shafear.notes.mvp.model.load;

import com.shafear.notes.global.G;
import com.shafear.notes.myutils.IOUtils;
import com.shafear.notes.xnotes.XNote;
import com.shafear.notes.xnotes.XNotes;

import java.util.ArrayList;

/**
 * Created by shafe_000 on 2015-02-09.
 */
public class MNotesLoad {
    public XNotes loadNotesData() {
        ArrayList<XNote> notesList = new ArrayList<>();
        try {
            String notes[] = getFileContentInStrings("notes");
            addNotesFromFileFormatStrings(notesList, notes);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new XNotes(notesList);
    }

    private void addNotesFromFileFormatStrings(ArrayList<XNote> notesList, String[] notes) {
        DataLoadFlags dlf = new DataLoadFlags();
        String title = "";
        String content = "";
        for(int j=0; j < notes.length; j++){
            if(notes[j].contains("</TITLE>")) {
                if(title.length() > 0)
                    title = title.substring(0, title.length()-1);
                dlf.TITLE_FLAG = false;
            }
            if(dlf.TITLE_FLAG){
                title += notes[j] + "\n";
            }

            if(notes[j].contains("</CONTENT>")) {
                if(content.length() > 0)
                    content = content.substring(0, content.length()-1);
                dlf.CONTENT_FLAG = false;
            }
            if(dlf.CONTENT_FLAG){
                content += notes[j] + "\n";
            }
            if(notes[j].contains("<TITLE>")) {dlf.TITLE_FLAG = true;}
            if(notes[j].contains("<CONTENT>")) {dlf.CONTENT_FLAG = true;}
            if(notes[j].contains("<NOTE>")) dlf.NOTE_FLAG = true;
            if(notes[j].contains("</NOTE>")) {dlf.NOTE_FLAG = false; dlf.wasLastNoteFlagTrue = true;};

            if((dlf.NOTE_FLAG == false)&&(dlf.wasLastNoteFlagTrue)){
                notesList.add(new XNote(title, content));
                title = "";
                content = "";
                dlf.wasLastNoteFlagTrue = false;
                dlf.noteCounter++;
            }
        }
    }

    private String[] getFileContentInStrings(String fileName) throws Exception {
        String readString = IOUtils.getStringFromFile(G.ACTIVITY.getFilesDir() + "/" + fileName);
        return readString.split("\n");
    }
}
