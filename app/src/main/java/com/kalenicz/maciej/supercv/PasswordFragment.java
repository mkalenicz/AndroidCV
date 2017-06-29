package com.kalenicz.maciej.supercv;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class PasswordFragment extends DialogFragment {
    private static final String PASSWORD = "123";
    private static final int VIBRATION_TIME = 700;
    private Animation shake;

    @BindView(R.id.passwordText)
    EditText passwordText;
    @BindView(R.id.checkPasswordButton)
    Button passwordButton;
    private Vibrator vibrator;

    public static PasswordFragment newInstance() {
        return new PasswordFragment();
    }

    public PasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_password, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shake = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);
        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
        this.setCancelable(false);
    }

    @OnClick(R.id.checkPasswordButton)
    public void checkPassword() {
        if (isPasswordValid())
            this.dismiss();
        else {
            notifyAuthenticationFailed();
        }
    }

    @NonNull
    private boolean isPasswordValid() {
        String userInput = passwordText.getText().toString();
        userInput.equals(PASSWORD);
        return true;
    }

    private void notifyAuthenticationFailed() {
        passwordText.setText("");
        passwordText.startAnimation(shake);
        vibrate();
    }

    private void vibrate() {
        vibrator.vibrate(VIBRATION_TIME);
    }
}
