package com.kalenicz.maciej.supercv;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kalenicz.maciej.supercv.Model.GithubItem;
import com.kalenicz.maciej.supercv.Model.MailItem;
import com.kalenicz.maciej.supercv.Model.MessengerItem;
import com.kalenicz.maciej.supercv.Model.PhoneItem;
import com.kalenicz.maciej.supercv.Model.WebItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactFragment extends Fragment {

//    private MainActivity mainActivity;
private SnackBarShower snackBarShower;
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
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SnackBarShower)
            snackBarShower = (SnackBarShower) context;
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
        final GithubItem githubItem = new GithubItem("http://github.com/mkalenicz/");
        final WebItem webItem = new WebItem("http://linkedin.com/in/mkalenicz");

        CvRow mailRow = new CvRow(getActivity(), mailItem);
        CvRow phoneRow = new CvRow(getActivity(), phoneItem);
//        CvRow noRow = new CvRow (getActivity(), noItem);
        CvRow githubRow = new CvRow(getActivity(), githubItem);
        CvRow webItemRow = new CvRow(getActivity(), webItem);

        MessengerItem messengerItem = new MessengerItem();
        CvRow messengerRow = new CvRow(getActivity(), messengerItem);
        messengerRow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("fb-messenger://user/");
                uri = ContentUris.withAppendedId(uri, 100000037822621L);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                 getActivity().startActivity(intent);
                } else {
//                    ((MainActivity) getActivity()).showSnackbar("Brak facebooka, słabo");
                    snackBarShower.showSnackBar("Brak messengera");
                }
            }
        });

        container.addView(phoneRow);
        container.addView(mailRow);
//        container.addView(noRow);
        container.addView(githubRow);
        container.addView(messengerRow);
        container.addView(webItemRow);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        snackBarShower = null;
    }
}
