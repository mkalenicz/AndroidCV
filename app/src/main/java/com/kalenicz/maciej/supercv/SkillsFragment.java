package com.kalenicz.maciej.supercv;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SkillsFragment extends Fragment {


    public SkillsFragment() {
        // Required empty public constructor
    }

    public static SkillsFragment newInstance() {

        Bundle args = new Bundle();

        SkillsFragment fragment = new SkillsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skills, container, false);
    }

}