package com.shafear.notes.xnotes;

import java.io.Serializable;

/**
 * Created by shafe_000 on 2015-02-08.
 */
public class XNote implements Serializable{
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    private String title;
    private String content;

    public XNote(String title, String content){
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return title;
    }
}
