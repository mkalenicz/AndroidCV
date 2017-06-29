package com.kalenicz.maciej.supercv.Model;

import android.content.Context;

import com.kalenicz.maciej.supercv.R;

/**
 * Created by RENT on 2017-06-26.
 */

public class NoActionItem extends CVItem {


    public NoActionItem () {
        super(R.drawable.ic_adb_black_24dp, "zgoda");
    }
    @Override
    public void makeAction(Context context) {
    }
}
