package com.serverus.oom.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.serverus.oom.MainActivity;
import com.serverus.oom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlideServicesFragment extends Fragment {
    private Button servicesBtn;

    public ScreenSlideServicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_screen_slide_services, container, false);

        initViews(view);
        return view;
    }

    public void initViews(View view){
        servicesBtn = (Button) view.findViewById(R.id.services_button);
        servicesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("fragmentClass", "com.serverus.oom.fragments.FragmentServices");
                startActivity(intent);
            }
        });
    }

}
