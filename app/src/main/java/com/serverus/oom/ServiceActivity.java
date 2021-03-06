package com.serverus.oom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ServiceActivity extends AppCompatActivity {


    private static final String CONTENT_HEADERS = "content_headers" ;
    private static final String CONTENT_DESC = "content_desc";
    private static final String OOM_ADV_HEADER = "oom_advantage_header";
    private static final String OOM_ADV_DESC = "oom_advantage_desc";
    private static final String OOM_SERVICE = "oom_service";
    private static final String OOM_SERVICE_OVRVIEW = "oom_service_overview";

    private String oomServiceHeader;
    private String oomServiceOvrview;
    private String[] contentHeaders;
    private String[] contentDesc;
    private String[] oomAdvantageHeader;
    private String[] oomAdvantageDesc;

    private LinearLayout serviceContent;

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

         toolbar = (Toolbar) findViewById(R.id.app_bar);
        // display it in the xml


        Bundle bundle = this.getIntent().getExtras();

        serviceContent = (LinearLayout) findViewById(R.id.service_content);

        contentHeaders = bundle.getStringArray(CONTENT_HEADERS);
        contentDesc = bundle.getStringArray(CONTENT_DESC);
        oomAdvantageHeader = bundle.getStringArray(OOM_ADV_HEADER);
        oomAdvantageDesc = bundle.getStringArray(OOM_ADV_DESC);
        oomServiceHeader = bundle.getString(OOM_SERVICE);
        oomServiceOvrview = bundle.getString(OOM_SERVICE_OVRVIEW);

            TextView oomService = new TextView(this);
            TextView oomServiceOverView = new TextView(this);
            TextView whyService = new TextView(this);
            TextView oomAdvantage = new TextView(this);

            oomService.setText(oomServiceHeader);
            oomService.setTextAppearance(this, android.R.style.TextAppearance_Large);
            oomService.setGravity(Gravity.CENTER_HORIZONTAL);
            serviceContent.addView(oomService);

            oomServiceOverView.setText(oomServiceOvrview);
            oomServiceOverView.setPadding(25, 25, 25, 25);
            serviceContent.addView(oomServiceOverView);

            whyService.setText("Why " + oomServiceHeader + " ?");
            whyService.setTextAppearance(this, android.R.style.TextAppearance_Large);
            whyService.setGravity(Gravity.CENTER_HORIZONTAL);
            whyService.setPadding(25, 25, 25, 25);
            serviceContent.addView(whyService);

            TextView[] serviceHeader = new TextView[contentHeaders.length];
            TextView[] serviceDesc = new TextView[contentHeaders.length];
            TextView[] oomAdvHeaders = new TextView[oomAdvantageHeader.length];
            TextView[] oomAdvDesc = new TextView[oomAdvantageHeader.length];

            int counter = 0;
        for (String contentHeader : contentHeaders) {
            serviceHeader[counter]= new TextView(this);
            serviceHeader[counter].setText(contentHeader);
            serviceHeader[counter].setTextAppearance(this, android.R.style.TextAppearance_Large);
            serviceHeader[counter].setTextColor(getResources().getColor(R.color.primaryColor));
            serviceHeader[counter].setPadding(5, 5, 5, 5);
            serviceContent.addView(serviceHeader[counter]);

            serviceDesc[counter] = new TextView(this);
            serviceDesc[counter].setText(contentDesc[counter]);
            serviceDesc[counter].setPadding(25, 25, 25, 25);
            serviceContent.addView(serviceDesc[counter]);
            counter++;
        }

        oomAdvantage.setText("The OOm Advantage");
        oomAdvantage.setTextAppearance(this, android.R.style.TextAppearance_Large);
        oomAdvantage.setGravity(Gravity.CENTER_HORIZONTAL);
        oomAdvantage.setPadding(25, 25, 25, 25);
        serviceContent.addView(oomAdvantage);

            int counter2 = 0;
        for (String oomAdvantageHeaders : oomAdvantageHeader) {
            oomAdvHeaders[counter2]= new TextView(this);
            oomAdvHeaders[counter2].setText(oomAdvantageHeaders);
            oomAdvHeaders[counter2].setTextAppearance(this, android.R.style.TextAppearance_Large);
            oomAdvHeaders[counter2].setTextColor(getResources().getColor(R.color.primaryColor));
            oomAdvHeaders[counter2].setPadding(5, 5, 5, 5);
            serviceContent.addView(oomAdvHeaders[counter2]);

            oomAdvDesc[counter2] = new TextView(this);
            oomAdvDesc[counter2].setText(oomAdvantageDesc[counter2]);
            oomAdvDesc[counter2].setPadding(25, 25, 25, 25);
            serviceContent.addView(oomAdvDesc[counter2]);
            counter2++;
        }

        toolbar.setTitle(oomServiceHeader);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == android.R.id.home){
            // emulate the back hardware press of the device
            super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

}
