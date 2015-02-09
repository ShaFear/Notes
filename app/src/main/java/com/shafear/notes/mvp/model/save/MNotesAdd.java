package com.shafear.notes.mvp.model.save;

import com.shafear.notes.global.G;
import com.shafear.notes.xnotes.XNote;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by shafe_000 on 2015-02-09.
 */
public class MNotesAdd {
    public void addNote(XNote xNote) {
        String string = getFileNotationForNote(xNote);
        try {
            writeToFile("notes", string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(String fileName, String string) throws IOException {
        FileOutputStream fos;
        fos = new FileOutputStream(G.ACTIVITY.getFilesDir() + "/" + fileName, true);
        fos.write(string.getBytes());
        fos.close();
    }

    private String getFileNotationForNote(XNote xNote) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<NOTE>\n")
                .append("<TITLE>\n")
                .append(xNote.getTitle())
                .append("\n</TITLE>\n")
                .append("<CONTENT>\n")
                .append(xNote.getContent())
                .append("\n</CONTENT>\n")
                .append("</NOTE>\n");
        return  stringBuilder.toString();
    }
}
