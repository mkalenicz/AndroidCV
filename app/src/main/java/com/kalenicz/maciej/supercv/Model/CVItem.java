package com.kalenicz.maciej.supercv.Model;


import android.content.Context;

/**
 * Created by RENT on 2017-06-26.
 */

public abstract class CVItem {


    private int imageId;
    private String name;

    public CVItem(int imageId, String name){
        this.imageId = imageId;
        this.name = name;

    }
    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public abstract void makeAction (Context context);
}
