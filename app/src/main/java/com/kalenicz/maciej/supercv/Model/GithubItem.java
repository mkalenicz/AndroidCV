package com.kalenicz.maciej.supercv.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.kalenicz.maciej.supercv.R;

/**
 * Created by maciej on 29.06.2017.
 */

public class GithubItem extends CVItem {
    private final String address;

    public GithubItem(String address) {
        super(R.drawable.ic_github_icon, address);
        this.address = address;
    }

    @Override
    public void makeAction(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(address));
        context.startActivity(intent);
    }
}
