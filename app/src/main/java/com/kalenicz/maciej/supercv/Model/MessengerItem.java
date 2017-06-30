package com.kalenicz.maciej.supercv.Model;

import android.content.Context;
import android.os.Messenger;

import com.kalenicz.maciej.supercv.R;

/**
 * Created by RENT on 2017-06-30.
 */

public class MessengerItem extends CVItem {

    private static final String MESSENGER = "Messenger";

    public MessengerItem() {
        super(R.drawable.ic_messenger_24dp, MESSENGER);
    }

    @Override
    public void makeAction(Context context) {

    }
}
