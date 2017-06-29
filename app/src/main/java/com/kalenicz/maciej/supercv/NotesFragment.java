package com.kalenicz.maciej.supercv;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.SharedPreferencesCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NotesFragment extends Fragment {

    public static final String TAG = NotesFragment.class.getSimpleName();
    public static final String NOTE_KEY = "notatka";

    private SharedPreferences sharedPreferences;

    @BindView(R.id.notesEditText)
    EditText editText;

    public static NotesFragment newInstance() {
        return new NotesFragment();
    }

    public NotesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getActivity().getSharedPreferences("notatki", Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        editText.setText(sharedPreferences.getString(NOTE_KEY, ""));
    }

    @Override
    public void onPause() {
        super.onPause();
        String costam = editText.getText().toString();
        saveToSharedPreferences(costam);
    }

    private void saveToSharedPreferences(String costam) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("notatki", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NOTE_KEY, costam);
        editor.apply();
    }
}