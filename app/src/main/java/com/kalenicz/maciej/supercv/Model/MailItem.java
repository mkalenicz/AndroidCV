package com.kalenicz.maciej.supercv.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.kalenicz.maciej.supercv.Constants;
import com.kalenicz.maciej.supercv.R;

/**
 * Created by RENT on 2017-06-26.
 */

public class MailItem extends CVItem {

//    public static final String MAIL = "maciej.kalenicz@gmail.com";
    public static final String TAG_MAIL_TO = "mailto:";
    public static final String TAG_SUBJECT = "Mail z mojego CV";

    @Override
    public void makeAction(Context context) {
        mail(context);
    }

    public  MailItem () {
            super(R.drawable.ic_email_black_24dp, Constants.EMAIL);
        }


    public void mail(Context context){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse(TAG_MAIL_TO));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{Constants.EMAIL});
        intent.putExtra(Intent.EXTRA_SUBJECT, TAG_SUBJECT);
        context.startActivity(intent);
    }

}
