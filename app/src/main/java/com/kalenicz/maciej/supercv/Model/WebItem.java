package com.kalenicz.maciej.supercv.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.kalenicz.maciej.supercv.R;

/**
 * Created by RENT on 2017-06-26.
 */

public class WebItem extends CVItem {

    private final String address;

    public WebItem(String address) {
        super(R.drawable.ic_linkedin_logo, address);
        this.address = address;
    }

    @Override
    public void makeAction(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(address));
        context.startActivity(intent);
    }
}
