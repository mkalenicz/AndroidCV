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

import java.util.ArrayList;
import java.util.List;


public class SkillsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<SkillsItems> skillsItemsList;

//private RecyclerView recyclerView;
//    private RecyclerView.Adapter adapter;
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
//        RecyclerView rv = new RecyclerView(getContext());
//        rv.setLayoutManager(new LinearLayoutManager(getContext()));
//        rv.setAdapter(new AdapterSkills());
View view = inflater.inflate(R.layout.fragment_skills, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.sklillsRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//        skillsItemsList = new ArrayList<>();


        skillsItemsList = new ArrayList<>();
        skillsItemsList.add(new SkillsItems("Android Studio"));
        skillsItemsList.add(new SkillsItems("InteliJ"));
        skillsItemsList.add(new SkillsItems("Git"));
        skillsItemsList.add(new SkillsItems("Java"));
        skillsItemsList.add(new SkillsItems("Android"));
        skillsItemsList.add(new SkillsItems("xml"));
        skillsItemsList.add(new SkillsItems("html"));
        skillsItemsList.add(new SkillsItems("Wordpress"));
        skillsItemsList.add(new SkillsItems("Illustrator"));
        skillsItemsList.add(new SkillsItems("Photoshop"));
        skillsItemsList.add(new SkillsItems("AutoCAD"));
        skillsItemsList.add(new SkillsItems("Inventor"));
        skillsItemsList.add(new SkillsItems("LabVIEW"));
        skillsItemsList.add(new SkillsItems("Windows"));
        skillsItemsList.add(new SkillsItems("Linux"));
        skillsItemsList.add(new SkillsItems("macOS"));
        skillsItemsList.add(new SkillsItems("Team work"));
        skillsItemsList.add(new SkillsItems("Driving licence cat. B2"));



//        for (int i = 0; i<=10; i++){
//            SkillsItems skillsItems = new SkillsItems("Skill"  + (i+1));
//            skillsItemsList.add(skillsItems);
//        }

        adapter = new AdapterSkills(skillsItemsList, getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

}