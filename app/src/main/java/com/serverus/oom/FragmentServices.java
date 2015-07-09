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

    private static final String CONTENT_HEADERS = "content_headers" ;
    private static final String CONTENT_DESC = "content_desc";
    private static final String OOM_ADV_HEADER = "oom_advantage_header";
    private static final String OOM_ADV_DESC = "oom_advantage_desc";
    private static final String OOM_SERVICE = "oom_service";
    private static final String OOM_SERVICE_OVRVIEW = "oom_service_overview";

    private RelativeLayout seoContainer;
    private RelativeLayout semContainer;
    private RelativeLayout smmContainer;
    private RelativeLayout contentMkrtngContainer;
    private RelativeLayout bannerAdContainer;
    private RelativeLayout webDevContainer;
    private RelativeLayout baiduAdContainer;

    private String[] oomServices = {
            "Search Engine Optimization",
            "Search Engine Marketing",
            "Social Media Marketing",
            "Content Marketing",
            "Banner Advertising",
            "Web Design and Development"
    };

    private String[] oomServicesOverview = {
            "Search Engine Optimization (SEO) is the process of modifying a website to increase web " +
                    "traffic and visibility in search engines through organic results. " +
                    "Fully optimizing website content and structure creates a site that is conducive " +
                    "to search engine indexing and allows for more visitors and sales.",

            "Search Engine Marketing (SEM) is the process of getting more visibility for " +
                    "your website on search engines. Company visibility is extremely vital " +
                    "in a very competitive global market. SEM allows you to advertise to an " +
                    "audience that can potentially be your customers or clients. By using search engines " +
                    "as a tool to determine who to target ads to, it saves you a lot of time and money.",

            "The power of social media is undeniable. Social media allows brands to engage with " +
                    "consumers on an unprecedented scale. With over one-fourth of the world’s " +
                    "population on various forms of social media, social media gives small and " +
                    "medium enterprises an incredible opportunity. However, social media, in all its " +
                    "varieties, is ever-changing. Formulating a social media strategy, managing, and " +
                    "monitoring all your social pages can be a rigorous task. A social media campaign " +
                    "involves a lot of time and thought that a lot of businesses don’t have.",

            "Content Marketing is quickly becoming an important component " +
                    "of any digital marketing campaign. Customer engagement " +
                    "is especially vital now. Content marketing is about " +
                    "engaging and building a relationship with your audience as " +
                    "well as keeping them well-informed. A successful content marketing " +
                    "campaign establishes you as an expert in your field which increases your " +
                    "company’s credibility and brand.",

            "Banner advertising is a form of advertising that involves embedding " +
                    "a banner ad into a web page. Display ads are image-based advertising. " +
                    "It is an influential tool in attracting a specified audience as well as " +
                    "promoting your products and services while creating brand awareness.",

            "Web Development is an essential component in any digital marketing campaign. " +
                    "It will greatly impact the effectiveness of your marketing campaign. A website " +
                    "is basically your digital business card. A successful website communicates what " +
                    "your brand is all about. It should also boost brand awareness and consistent online traffic. " +
                    "Increase in brand awareness and online traffic would translate to more interest and business " +
                    "for your company."
    };

    private String[] whySeoHeaders = {
            "Brand Exposure",
            "Increased Sales",
            "Targeted Traffic",
            "Connect Through Content",
            "Cost -Effective"
    };

    private String[] whySeoDesc = {
            "Being included in the top ranks suggests that your web page has " +
            "relevant and unique content. Let customers easily reach you by" +
            " increasing your ranking and visibility.",

            "Conversions are not possible without web traffic." +
            " Achieve more sales by generating good traffic " +
            "to your website.",

            "A well developed site provides users with the right and relevant content. " +
            "You can attract users who are in search of specific products, " +
            "services, and information you provide by optimizing your website.",

            "Content plays a huge part in Search Engine Optimization. " +
            "Connect with new and existing customers by developing a " +
            "website that offers a unique user experience to your visitors.",

            "Techniques that offer quick and temporary increase in " +
            "rankings can cost more and only deliver short term success. " +
            "Organic search results provide long term stability and attract more traffic."
    };

    private String[] oomSeoAdvHeader = {"Ethical", "Transparent", "Tailor-made", "Search Engine Certified"};

    private String[] oomSeoAdvDesc = {
            "We achieve your website business goals through ethical optimization methods. " +
            "This means that our SEO practices are in accordance with Google Webmaster" +
            " Guidelines and prevent our customers from being penalized by search engines.",

            "We value your trust in our services and we express this by demonstrating " +
            "transparency in our operations and communications. We keep you updated " +
            "and on the loop so that you can keep track of your campaign.",

            "Our SEO Campaign Consultants provide you with tailor-made strategies that are " +
            "aligned with your business goals. We strategize based on your business " +
            "objectives to get the finest results for your campaign.",

            "We provide SEO services to Baidu, Bing, Google, and Yahoo. OOm " +
            "is a certified partner of Google Adwords and Yahoo Southeast Asia " +
            "Search Marketing. Our certifications and expertise in various search engines " +
            "permit us to get the finest results possible."
    };



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

        Bundle bundle =new Bundle();

        switch (v.getId()){
            case R.id.seo_container:
                intent = new Intent(getActivity(), ServiceActivity.class);
                bundle.putString(OOM_SERVICE, oomServices[0]);
                bundle.putString(OOM_SERVICE_OVRVIEW, oomServicesOverview[0]);
                bundle.putStringArray(CONTENT_HEADERS, whySeoHeaders);
                bundle.putStringArray(CONTENT_DESC, whySeoDesc);
                bundle.putStringArray(CONTENT_DESC, whySeoDesc);
                bundle.putStringArray(OOM_ADV_HEADER, oomSeoAdvHeader);
                bundle.putStringArray(OOM_ADV_DESC, oomSeoAdvDesc);

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
        intent.putExtras(bundle);
        startActivity(intent);


    }
}
