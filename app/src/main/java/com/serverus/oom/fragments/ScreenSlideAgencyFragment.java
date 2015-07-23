package com.serverus.oom.fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.serverus.oom.MainActivity;
import com.serverus.oom.R;
import com.serverus.oom.ServiceActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlideAgencyFragment extends Fragment {
    private Button agencyBtn;

    public ScreenSlideAgencyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_agency, container, false);

        initViews(rootView);

        return rootView;
    }

    public void initViews(ViewGroup rootView){
        agencyBtn = (Button) rootView.findViewById(R.id.agency_button);

        agencyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("aoi", "button selected");

                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("fragmentClass", "com.serverus.oom.fragments.FragmentAgency");
                startActivity(intent);
            }
        });
    }


}
