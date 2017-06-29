package com.kalenicz.maciej.supercv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kalenicz.maciej.supercv.Model.CVItem;
import com.kalenicz.maciej.supercv.Model.GithubItem;
import com.kalenicz.maciej.supercv.Model.MailItem;
import com.kalenicz.maciej.supercv.Model.NoActionItem;
import com.kalenicz.maciej.supercv.Model.PhoneItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactFragment extends Fragment {
    @BindView(R.id.contactFragmentContainer)
    LinearLayout container;

    public ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();
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
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
                ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final PhoneItem phoneItem = new PhoneItem();
        final MailItem mailItem = new MailItem();
//        final NoActionItem noItem = new NoActionItem ();
        final GithubItem githubItem = new GithubItem ("http://github.com/mkalenicz/");

        CvRow mailRow = new CvRow(getActivity(), mailItem);
        CvRow phoneRow = new CvRow(getActivity(), phoneItem);
//        CvRow noRow = new CvRow (getActivity(), noItem);
        CvRow githubRow = new CvRow (getActivity(), githubItem);
        container.addView(phoneRow);
        container.addView(mailRow);
//        container.addView(noRow);
        container.addView(githubRow);
    }

}
