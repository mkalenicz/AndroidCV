package com.kalenicz.maciej.supercv.Model;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by RENT on 2017-06-28.
 */

public class DialogItem extends CVItem {

    private String text;

    public DialogItem(int imageId, String name, String text) {
        super(imageId, name);
        this.text = text;
    }

    @Override
    public void makeAction(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(name)
                .setIcon(imageId)
                .setMessage(text);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}