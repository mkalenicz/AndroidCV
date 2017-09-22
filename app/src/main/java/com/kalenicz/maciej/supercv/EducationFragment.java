package com.kalenicz.maciej.supercv;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class EducationFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<EducationItems> educationItemsList;

    @BindView(R.id.EducationFragmentContainer)
    LinearLayout container;

    public EducationFragment() {
        // Required empty public constructor
    }

    public static EducationFragment newInstance() {
        EducationFragment fragment = new EducationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_education, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.educationRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        educationItemsList = new ArrayList<>();
        educationItemsList.add(new EducationItems("Android Studio", "Android ", "Android", "2017-2018", R.drawable.ic_linkedin_logo));

        adapter = new AdapterEducation(educationItemsList, getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

}
