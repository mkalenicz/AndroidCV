package com.kalenicz.maciej.supercv;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.kalenicz.maciej.supercv.Model.CVItem;
import com.kalenicz.maciej.supercv.Model.MailItem;
import com.kalenicz.maciej.supercv.Model.PhoneItem;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class CvRow extends LinearLayout {

    private final Context context;
    private final DisplayMetrics metrics;
    private final Resources resources;
    private final CVItem cvItem;

    public CvRow(final Context context, final CVItem cvItem) {
        super(context);
        this.context = context;
        this.cvItem = cvItem;
        resources = context.getResources();
        metrics = resources.getDisplayMetrics();
        setupMainLayout();
        ImageView imageView = setupImageView();
        TextView textView = setupTextView();
        addViews(imageView, textView);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cvItem.makeAction(context);
            }
        });
    }

    private void addViews(ImageView imageView, TextView textView) {
        this.addView(imageView);
        this.addView(textView);
    }

    @NonNull
    private TextView setupTextView() {
        TextView textView = new TextView(context);
        textView.setText(cvItem.getName());
        LayoutParams textParams =
                new LayoutParams(MATCH_PARENT, MATCH_PARENT);
        textView.setLayoutParams(textParams);
        textView.setTextSize(16);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setPadding(dpToPx(32), 0, 0, 0);
        return textView;
    }

    @NonNull
    private ImageView setupImageView() {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(cvItem.getImageId());
        LayoutParams imageParams = new LayoutParams(dpToPx(24), dpToPx(24));
        imageParams.gravity = Gravity.CENTER_VERTICAL;
        imageView.setLayoutParams(imageParams);
        return imageView;
    }

    private void setupMainLayout() {
        LayoutParams params = new LayoutParams(MATCH_PARENT, dpToPx(48));
        this.setLayoutParams(params);
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setPadding(dpToPx(16), 0, dpToPx(16), 0);
    }

    private int dpToPx(int dp) {
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) px;
    }
}