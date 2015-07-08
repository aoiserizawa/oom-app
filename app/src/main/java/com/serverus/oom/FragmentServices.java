package com.serverus.oom;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentServices extends Fragment implements View.OnClickListener {

    private RelativeLayout seoContainer;
    private RelativeLayout semContainer;
    private RelativeLayout smmContainer;
    private RelativeLayout contentMkrtngContainer;
    private RelativeLayout bannerAdContainer;
    private RelativeLayout webDevContainer;
    private RelativeLayout baiduAdContainer;


    public FragmentServices() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_services, container, false);

        initView(view);

        seoContainer.setOnClickListener(this);
        semContainer.setOnClickListener(this);
        smmContainer.setOnClickListener(this);
        contentMkrtngContainer.setOnClickListener(this);
        bannerAdContainer.setOnClickListener(this);
        webDevContainer.setOnClickListener(this);

        return view;
    }

    private void initView(View view){

        seoContainer = (RelativeLayout) view.findViewById(R.id.seo_container);
        semContainer = (RelativeLayout) view.findViewById(R.id.sem_container);
        smmContainer = (RelativeLayout) view.findViewById(R.id.smm_container);
        contentMkrtngContainer = (RelativeLayout) view.findViewById(R.id.content_mrktng_container);
        bannerAdContainer = (RelativeLayout) view.findViewById(R.id.banner_ad_container);
        webDevContainer = (RelativeLayout) view.findViewById(R.id.webdev_content);

    }


    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()){
            case R.id.seo_container:
                intent = new Intent(getActivity(), SeoActivity.class);
                break;
            case R.id.sem_container:
                intent = new Intent(getActivity(), SemActivity.class);
                break;
            case R.id.smm_container:
                intent = new Intent(getActivity(), SmmActivity.class);
                break;
            case R.id.content_mrktng_container:
                intent = new Intent(getActivity(), ContentMrktngActivity.class);
                break;
            case R.id.banner_ad_container:
                intent = new Intent(getActivity(), BannerAdActivity.class);
                break;
            case R.id.webdev_content:
                intent = new Intent(getActivity(), WebDevActivity.class);
                break;

        }

        startActivity(intent);


    }
}
