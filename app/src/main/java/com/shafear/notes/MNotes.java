package com.shafear.notes;

import android.content.Context;
import com.shafear.notes.xnotes.XNote;
import com.shafear.notes.xnotes.XNotes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by shafe_000 on 2015-02-08.
 */
public class MNotes {
    public XNotes loadNotesData(Context context) {
        ArrayList<XNote> notesList = new ArrayList<XNote>();
        try {
            String readString = getStringFromFile(context.getFilesDir() + "/notes");
            String notes[] = readString.split("\n");
            int j=0;
            boolean TITLE_FLAG = false;
            boolean CONTENT_FLAG = false;
            boolean NOTE_FLAG = false;
            boolean wasLastNoteFlagTrue = false;
            int noteCounter = 0;
            String title = "";
            String content = "";
            while(j < notes.length){
                System.err.println(notes[j]);
                if(notes[j].contains("</TITLE>")) TITLE_FLAG = false;
                if(TITLE_FLAG){
                    title += notes[j];
                }

                if(notes[j].contains("</CONTENT>")) CONTENT_FLAG = false;
                if(CONTENT_FLAG){
                    content += notes[j];
                }
                if(notes[j].contains("<TITLE>")) {TITLE_FLAG = true;}
                if(notes[j].contains("<CONTENT>")) {CONTENT_FLAG = true;}
                if(notes[j].contains("<NOTE>")) NOTE_FLAG = true;
                if(notes[j].contains("</TITLE>")) TITLE_FLAG = false;
                if(notes[j].contains("</CONTENT>")) CONTENT_FLAG = false;
                if(notes[j].contains("</NOTE>")) {NOTE_FLAG = false; wasLastNoteFlagTrue = true;};

                if((NOTE_FLAG == false)&&(wasLastNoteFlagTrue)){
                    notesList.add(new XNote(noteCounter + ": " + title, content));
                    title = "";
                    content = "";
                    wasLastNoteFlagTrue = false;
                    noteCounter++;
                }
                j++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new XNotes(notesList);
    }

    public void addNote(XNote xNote, Context context){
        String FILENAME = "notes";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<NOTE>\n")
                .append("<TITLE>\n")
                .append(xNote.getTitle())
                .append("\n</TITLE>\n")
                .append("<CONTENT>\n")
                .append(xNote.getContent())
                .append("\n</CONTENT>\n")
                .append("</NOTE>\n");

        String string = stringBuilder.toString();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(context.getFilesDir() + "/notes", true);
            fos.write(string.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    private static String getStringFromFile (String filePath) throws Exception {
        File fl = new File(filePath);
        FileInputStream fin = new FileInputStream(fl);
        String ret = convertStreamToString(fin);
        //Make sure you close all streams.
        fin.close();
        return ret;
    }
}
