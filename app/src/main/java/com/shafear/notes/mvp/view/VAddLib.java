package com.shafear.notes.mvp.view;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;

/**
 * Created by shafe_000 on 2015-02-10.
 */
public class VAddLib {
    public static void setColorForActionBarTitleText(ActionBarActivity activity, String htmlColor, String titleText) {
        activity.getSupportActionBar().setTitle(Html.fromHtml("<font color='"+  htmlColor +"'>"+ titleText +" </font>"));
    }
}
