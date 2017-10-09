package com.kalenicz.maciej.supercv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kalenicz.maciej.supercv.Adapters.AdapterExperience;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ExperienceFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ExperienceItems> experienceItemsList;

@BindView(R.id.experienceFragmentContainer)
    LinearLayout container;

    public ExperienceFragment() {
        // Required empty public constructor
    }

    public static ExperienceFragment newInstance() {
        ExperienceFragment fragment = new ExperienceFragment();
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
        View view = inflater.inflate(R.layout.fragment_experience, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.experienceRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        experienceItemsList = new ArrayList<>();

        experienceItemsList.add(new ExperienceItems("Dru3ek (AIP)", "Co - Founder", "2016 - 2017", R.drawable.logo_dru3ek));
        experienceItemsList.add(new ExperienceItems("PWR Racing Team", "Marketing and Management", "2013 - 2014", R.drawable.logo_pwr_racing));
        experienceItemsList.add(new ExperienceItems("Invenio Sp Z O. O.", "Inspector of quality", "2012 (2 months)", R.drawable.logo_invenio));
        experienceItemsList.add(new ExperienceItems("AIESEC", "Organizing Careers Fair", "2011 - 2012", R.drawable.logo_aiesec));
       experienceItemsList.add(new ExperienceItems("Call Center Inter Galactica", "Renew Customer – Orange Mobile Contracts", "2010 (2 months)", R.drawable.logo_ccig));

        adapter = new AdapterExperience(experienceItemsList, getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

}
