package com.serverus.oom.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.serverus.oom.R;
import com.serverus.oom.fragments.FragmentAgency;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment implements View.OnClickListener {

    private final String FRAGMENT_TAG = "myfragmenttag";

    private RelativeLayout digitalFrontier;
    private RelativeLayout forwardThinkers;
    private RelativeLayout preferedActions;

    private FrameLayout fragmentDefault;
    private Fragment fragmentAgency = null;

    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(savedInstanceState != null){
            getActivity().getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        }

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initViews(view);


        return view;
    }

    private void initViews(View view){
        digitalFrontier = (RelativeLayout) view.findViewById(R.id.digital_frontier);
        forwardThinkers = (RelativeLayout) view.findViewById(R.id.forward_thinkers);
        preferedActions = (RelativeLayout) view.findViewById(R.id.prefered_actions);

        fragmentDefault = (FrameLayout) view.findViewById(R.id.flContent);

        digitalFrontier.setOnClickListener(this);
        forwardThinkers.setOnClickListener(this);
        preferedActions.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.prefered_actions ||
                v.getId() == R.id.forward_thinkers ||
                v.getId() == R.id.digital_frontier){

            fragmentAgency = new FragmentAgency();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flContent, fragmentAgency, FRAGMENT_TAG).addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();

        }
    }

}
