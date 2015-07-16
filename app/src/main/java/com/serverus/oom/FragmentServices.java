package com.serverus.oom;


import android.content.Intent;
import android.content.res.Configuration;
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


    private String[] whySemHeaders = {
            "Targeted Ads",
            "Cost-Effective",
            "Competitive",
            "Quantifiable",
            "24/7 Brand Exposure"
    };

    private String[] whySemDesc = {
            "SEM allows you to target your ads based on user searches. " +
                    "This allows you to advertise to people who would most " +
                    "likely be interested in your products.",

            "Compared to traditional advertising mediums, SEM is more cost-effective. " +
                    "This is because of highly targeted ads that help you maximize your " +
                    "investment in digital marketing.",

            "The global market is extremely competitive. It is hard to stand " +
                    "out when there are multiple of websites that are offering the same products or services. " +
                    "SEM gives your business the attention it deserves.",

            "With SEM, you have the ability to measure and analyse statistics. " +
                    "This gives you the answers you need to modify " +
                    "and enhance your digital marketing campaign.",

            "SEM is an excellent way to get as much exposure for your " +
                    "business as possible. With search engines getting a billion searches per day, " +
                    "getting your brand highlighted can give your business a considerable advantage" +
                    " versus similar competitors.",
    };

    private String[] oomSemAdvHeader = {
            "Holistic Approach",
            "Transparency",
            "Experience",
            "Dedicated Customer Service"
    };

    private String[] oomSemAdvDesc = {
        "As a full-service digital marketing agency, we take a holistic " +
                "approach when it comes to our services. We integrate our" +
                " knowledge of market behaviour as well as our varied specializations " +
                "and expertise to give you the most holistic strategies and solutions.",

        "We value your trust in our services and we express this by " +
                "demonstrating transparency in our operations and " +
                "communications. We keep you updated and on the loop so " +
                "that you can keep track of your campaign.",

        "Experience is a huge factor in determining the right strategy " +
                "for your SEM campaign. Our knowledge and understanding of " +
                "market behaviour will help you in choosing the best approach " +
                "for your SEM campaign.",

        "Our SEM professionals have dedicated customer service which is " +
                "why we are the forerunner in our industry. We are committed in working " +
                "very closely with you to ensure your campaign is a success."
    };


    private String[] whySmmHeaders = {
            "Connect",
            "Engage",
            "Target",
            "Cost-effective",
    };

    private String[] whySmmDesc = {
            "Connect with more than a billion potential customers " +
                    "and increase brand awareness significantly. " +
                    "Social media is an amazing and easy way to " +
                    "reach potential clients.",

            "Engage your customers by promoting your business page and build " +
                    "a community around your business. Interaction with potential " +
                    "customers will increase the reach of your company.",

            "Choose your target audience by location, age, interests, connections, " +
                    "gender, and so much more. Carefully targeting your audience can" +
                    " help you stay on track based on your campaign objectives.",

            "Advertising in social media can be an incredibly " +
                    "cost-effective marketing strategy because " +
                    "it specifically targets your audience.",
    };

    private String[] oomSmmAdvHeader = {
            "Strategy",
            "Social Media Management",
            "Monitor",
            "Ad Optimization",
    };

    private String[] oomSmmAdvDesc = {
            "By prioritising your campaign objectives, we can help you" +
                    " identify what strategies would suit your business. Through creating a " +
                    "clear picture of the different milestones your campaign should to go " +
                    "through, you can easily track the success of your campaign. Skilfully-planned " +
                    "campaign strategies are at the heart of every single OOm campaign.",

            "Our Social Media Experts will help you cultivate loyal fans and followers " +
                    "otherwise known as your future customers. Through consistently delivering " +
                    "fresh and informative content, we help you maintain a brand that is relevant and " +
                    "trustworthy.",

            "Constantly monitoring your campaign permits us to fully optimise your " +
                    "campaign, saving you time and money. Our comprehensive monthly " +
                    "reports allow you to see how your social media campaign is doing.",

            "In identifying your target audience, we will then create ads for" +
                    " your campaign and schedule them to go live. Ads will be periodically " +
                    "tested to gauge its effectiveness with the audience. Ad optimization " +
                    "lowers the cost-per-click of your ad which will save you marketing dollars.",
    };

    private String[] whyContMrktngHeaders = {
            "Original Content",
            "Information rich",
            "Branding",
            "Engage",
            "Content is King"
    };

    private String[] whyContMrktngDesc = {
            "Original content not only engages with the customers but it " +
                    "also distinguishes your content in different search engines. " +
                    "In a highly competitive market, this will make your website easily " +
                    "identifiable compared to similar websites.",

            "Information rich and appealing content will maintain and build audience " +
                    "following. Information rich and appealing content will encourage " +
                    "your customers to share your content which in turn broadens your audience.",

            "Content marketing increases your company’s credibility by " +
                    "establishing your company as an expert in your field. It " +
                    "differentiates your company from similar websites and companies.",

            "Content is the best way to engage and connect with your audience. It is " +
                    "essential to engage with your audience to initiate a consistent " +
                    "audience following.",

            "Without original and desirable content online, marketing " +
                    "campaigns will likely fail because of the audience’s lack of appeal " +
                    "regardless of other design factors."
    };

    private String[] oomContMrktngAdvHeader = {
            "Market Analysis",
            "Market Knowledge",
            "Content Strategy",
            "Lead Generation & Nurturing",
    };

    private String[] oomContMrktngAdvDesc = {
            "In a highly competitive market, it is important to differentiate " +
                    "your company from other similar markets. Market analysis is " +
                    "important to establish what works and what does not work with consumers.",

            "Our knowledge of market behaviour and search engine optimization " +
                    "will ensure that your marketing campaign will be strategized " +
                    "and executed proficiently.",

            "Through market research and our knowledge of market behaviour, we " +
                    "can expertly organize your content strategy. An excellent " +
                    "content strategy will guarantee that your campaign will be successful.",

            "Consistent and interesting content generates potential leads for your company. " +
                    "Once we establish your audience, consistent engagement and interesting content " +
                    "is necessary to keep your company connected to your audience.",
    };

    private String[] whyBannerAdHeaders = {
            "Brand Awareness",
            "High Quality Traffic",
            "ROI Focused Approach",
            "Product Awareness",
            "Maximise Impression",
    };

    private String[] whyBannerAdDesc = {
            "Developing an effective display advertising campaign successfully " +
                    "increases products and services awareness. Maintaining high brand " +
                    "awareness will attract more sales and prospective customers.",

            "The key to conversions is capturing the attention of your visitors." +
                    " Identifying a specific audience can help you achieve positive " +
                    "ROI and reach potential consumers at a relatively low cost.",

            "Designing a banner advertising campaign that is focused on " +
                    "ROI can be an effective approach to determine which ads are s" +
                    "elling and which ads are being ignored.",

            "Provide relevant information to your target audience about your " +
                    "products and services which will play a significant role in " +
                    "their purchase decision process. This is an opportunity for you to " +
                    "highlight the products that you offer.",

            "Even if it seems that your audience is not paying attention, your customers " +
                    "are still exposed to your display ads. Repeated exposure leaves an " +
                    "impression on your consumers and prospective customers by becoming " +
                    "familiar with your brand and your product.",
    };

    private String[] oomBannerAdAdvHeader = {
            "Display Ad Design",
            "Extensive Market Analysis",
            "Proper Branding",
            "Optimized to Maximize Results",
    };

    private String[] oomBannerAdAdvDesc = {
            "Our banner ad design professionals create ads that reinforce " +
                    "your brand and message effectively. We find creative ways for your " +
                    "business to stand out through a personalized and actionable display " +
                    "advertisement.",

            "There are many strategies in accomplishing your goals and objectives " +
                    "through banner ads, but without proper knowledge of market behaviour," +
                    " your efforts will be fruitless. Our task is to provide you with tangible " +
                    "data on your targeted audience that enables you to evaluate the effectiveness" +
                    " of your marketing efforts while also developing tactics " +
                    "that can improve your bottom line.",

            "For you to attract prospective customers with your banner ad, " +
                    "your brand must be relevant to the products and services " +
                    "you offer. Our display advertising experts will help you " +
                    "build a personalized and efficient banner ad campaign that " +
                    "conveys your company’s relevance to your audience.",

            "Our banner advertising specialists create multiple designs" +
                    " and track the response metrics of your specific audience " +
                    "to determine which banner performs best and contributes to your sales."
    };

    private String[] whyWebDevHeaders = {
            "Usability",
            "User Interface",
            "Site Architecture",
            "Design",
            "Conversion Optimization",
    };

    private String[] whyWebDevDesc = {
            "Websites should be fully function and easy to manoeuvre. " +
                    "Usability is a big factor on what makes a website sustainable. " +
                    "Usability makes it easy for visitors or potential customers to " +
                    "access information, services, and products of your company.",

            "A clean and efficient user interface makes it pleasing and " +
                    "easy for your potential customers to visit your site. It encourages " +
                    "consistent online traffic to your website which would increase your " +
                    "brand awareness.",

            "Site architecture essentially lays the ground work for the rest of " +
                    "your website. It makes your website efficient technically, " +
                    "aesthetically, and functionally.",

            "Web design plays a huge factor in web development. A web design that " +
                    "is not aesthetically pleasing will not produce consistent " +
                    "online traffic. A great web design would give a good first and " +
                    "lasting impression of your company.",

            "Conversion optimization is the method of using analytics " +
                    "and user feedback to increase leads and sales without " +
                    "spending money on attracting more potential customers. " +
                    "A high conversion rate means a better return of investment " +
                    "for your campaign.",
    };

    private String[] oomWebDevAdvHeader = {
            "SEO Knowledge",
            "Transparency",
            "Quality",
            "Results"
    };

    private String[] oomWebDevAdvDesc = {
            "One of the numerous advantages of choosing OOm for your " +
                    "web development is our integration of Search Engine " +
                    "Optimization within your website’s architecture. " +
                    "Our understanding of SEO will be exceptionally " +
                    "beneficial for your campaign.",

            "OOm highly supports open communication with our clients." +
                    " We understand the different challenges that are faced with " +
                    "a digital marketing campaign. We work with you to help achieve" +
                    " the objectives and results that you want.",

            "We ensure that your website would have innovative and quality " +
                    "features. Our expertise in web development will guarantee a " +
                    "successfully executed campaign. Our knowledge and understanding " +
                    "of market behaviour will also have a significant " +
                    "impact on the quality of our results.",

            "Through analytics and user feedback, we are able to " +
                    "properly optimize your website. In optimizing your website, we " +
                    "ensure that your investment is properly utilized towards " +
                    "your campaign goals as well as increasing brand awareness" +
                    " towards your company."
    };


    public FragmentServices() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_services, container, false);
        getActivity().setTitle("Services");

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
                bundle.putString(OOM_SERVICE, oomServices[0]);
                bundle.putString(OOM_SERVICE_OVRVIEW, oomServicesOverview[0]);
                bundle.putStringArray(CONTENT_HEADERS, whySeoHeaders);
                bundle.putStringArray(CONTENT_DESC, whySeoDesc);
                bundle.putStringArray(OOM_ADV_HEADER, oomSeoAdvHeader);
                bundle.putStringArray(OOM_ADV_DESC, oomSeoAdvDesc);
                break;

            case R.id.sem_container:
                bundle.putString(OOM_SERVICE, oomServices[1]);
                bundle.putString(OOM_SERVICE_OVRVIEW, oomServicesOverview[1]);
                bundle.putStringArray(CONTENT_HEADERS, whySemHeaders);
                bundle.putStringArray(CONTENT_DESC, whySemDesc);
                bundle.putStringArray(OOM_ADV_HEADER, oomSemAdvHeader);
                bundle.putStringArray(OOM_ADV_DESC, oomSemAdvDesc);
                break;

            case R.id.smm_container:
                bundle.putString(OOM_SERVICE, oomServices[2]);
                bundle.putString(OOM_SERVICE_OVRVIEW, oomServicesOverview[2]);
                bundle.putStringArray(CONTENT_HEADERS, whySmmHeaders);
                bundle.putStringArray(CONTENT_DESC, whySmmDesc);
                bundle.putStringArray(OOM_ADV_HEADER, oomSmmAdvHeader);
                bundle.putStringArray(OOM_ADV_DESC, oomSmmAdvDesc);
                break;

            case R.id.content_mrktng_container:
                bundle.putString(OOM_SERVICE, oomServices[3]);
                bundle.putString(OOM_SERVICE_OVRVIEW, oomServicesOverview[3]);
                bundle.putStringArray(CONTENT_HEADERS, whyContMrktngHeaders);
                bundle.putStringArray(CONTENT_DESC, whyContMrktngDesc);
                bundle.putStringArray(OOM_ADV_HEADER, oomContMrktngAdvHeader);
                bundle.putStringArray(OOM_ADV_DESC, oomContMrktngAdvDesc);
                break;

            case R.id.banner_ad_container:
                bundle.putString(OOM_SERVICE, oomServices[4]);
                bundle.putString(OOM_SERVICE_OVRVIEW, oomServicesOverview[4]);
                bundle.putStringArray(CONTENT_HEADERS, whyBannerAdHeaders);
                bundle.putStringArray(CONTENT_DESC, whyBannerAdDesc);
                bundle.putStringArray(OOM_ADV_HEADER, oomBannerAdAdvHeader);
                bundle.putStringArray(OOM_ADV_DESC, oomBannerAdAdvDesc);
                break;

            case R.id.webdev_content:
                bundle.putString(OOM_SERVICE, oomServices[5]);
                bundle.putString(OOM_SERVICE_OVRVIEW, oomServicesOverview[5]);
                bundle.putStringArray(CONTENT_HEADERS, whyWebDevHeaders);
                bundle.putStringArray(CONTENT_DESC, whyWebDevDesc);
                bundle.putStringArray(OOM_ADV_HEADER, oomWebDevAdvHeader);
                bundle.putStringArray(OOM_ADV_DESC, oomWebDevAdvDesc);

                break;

        }
        intent = new Intent(getActivity(), ServiceActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}
