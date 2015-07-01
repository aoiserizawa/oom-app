package com.serverus.oom;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.content.res.Configuration;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar mToolBar;
    private NavigationView mDrawer;
    private ActionBarDrawerToggle mdrawerToggle;
    private DrawerLayout mDrawerLayout;

    private RelativeLayout digitalFrontier;
    private RelativeLayout forwardThinkers;
    private RelativeLayout preferedActions;

    private LinearLayout innerParent;

    public String viewVar;

    public Fragment fragment = null;
    public Class fragmentClass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
//        digitalFrontier.setOnClickListener(this);
//        forwardThinkers.setOnClickListener(this);
//        preferedActions.setOnClickListener(this);

        fragmentClass = FragmentHome.class;
        fragmentReplace(fragmentClass);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mdrawerToggle.onConfigurationChanged(newConfig);
    }

    private void initViews(){
        mToolBar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolBar);
        mDrawer = (NavigationView) findViewById(R.id.main_drawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_parent);
        mdrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mToolBar,
                R.string.drawer_open,
                R.string.drawer_close);

        mDrawerLayout.setDrawerListener(mdrawerToggle);
        // indicator based on whether the drawerlayout is in open or closed
        mdrawerToggle.syncState();

        digitalFrontier = (RelativeLayout) findViewById(R.id.digital_frontier);
        forwardThinkers = (RelativeLayout) findViewById(R.id.forward_thinkers);
        preferedActions = (RelativeLayout) findViewById(R.id.prefered_actions);

        innerParent = (LinearLayout) findViewById(R.id.inner_parent);

        setupDrawerContent(mDrawer);
        //mDrawer.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.digital_frontier || v.getId() == R.id.forward_thinkers ||
                v.getId() == R.id.prefered_actions ){

            detailActivity(v);
        }

    }


    private void detailActivity(View view){


        switch (view.getId()){
            case R.id.digital_frontier:
                viewVar = "digital frontier";
                break;
            case R.id.forward_thinkers:
                viewVar = "forward thinkers";
                break;
            case R.id.prefered_actions:

                viewVar = "prefered actions";
                break;
        }

        Snackbar.make(mDrawerLayout, viewVar , Snackbar.LENGTH_LONG).show();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {


        // Create a new fragment and specify the planet to show based on
        // position
        switch(menuItem.getItemId()) {
            case R.id.agency_menu_item:
                fragmentClass = FragmentAgency.class;
                break;
        }



        fragmentReplace(fragmentClass);

        // Highlight the selected item, update the title, and close the drawer
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        //mDrawer.closeDrawers();
    }

    public void fragmentReplace(Class fragmentClass){

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
    }

}
