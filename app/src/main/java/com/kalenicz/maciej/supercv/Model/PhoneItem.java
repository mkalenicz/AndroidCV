package com.kalenicz.maciej.supercv.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.kalenicz.maciej.supercv.R;

/**
 * Created by RENT on 2017-06-26.
 */

public class PhoneItem extends CVItem {


    public static final String PHONE_NUMBER = "+48602393632";

    @Override
    public void makeAction(Context context) {
        call(context);
    }

    public PhoneItem (){
        super(R.drawable.ic_phone_black_24dp, PHONE_NUMBER);
    }

    public void call(Context context){
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse("tel:"+PHONE_NUMBER));
        context.startActivity(phoneIntent);
    }
}
