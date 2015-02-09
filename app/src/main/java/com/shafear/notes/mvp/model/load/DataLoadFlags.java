package com.shafear.notes.mvp.model.load;

/**
 * Created by shafe_000 on 2015-02-09.
 */
public class DataLoadFlags{
    protected boolean TITLE_FLAG;
    protected boolean CONTENT_FLAG;
    protected boolean NOTE_FLAG;
    protected boolean wasLastNoteFlagTrue;
    protected int noteCounter;

    protected DataLoadFlags(){
        TITLE_FLAG = false;
        CONTENT_FLAG = false;
        NOTE_FLAG = false;
        wasLastNoteFlagTrue = false;
        noteCounter = 0;
    }
}
