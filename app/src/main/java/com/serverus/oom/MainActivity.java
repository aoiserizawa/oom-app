package com.serverus.oom;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.parse.ParseUser;
import com.serverus.oom.fragments.FragmentAgency;
import com.serverus.oom.fragments.FragmentContactUs;
import com.serverus.oom.fragments.FragmentLogin;
import com.serverus.oom.fragments.FragmentServices2;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    private NavigationView mDrawer;
    private ActionBarDrawerToggle mdrawerToggle;
    private DrawerLayout mDrawerLayout;
    private LinearLayout innerParent;

    private String fragClassName;
    private String passedFragment;
    private String fragmentTitle;
    private static String RUN_ONCE;

    private final String FRAGMENT_TAG = "myfragmenttag";

    public Fragment fragment = null;
    public Class fragmentClass = null;

    private Menu mMenu;
    private MenuItem menuItemReserve = null;
    private MenuItem loginMenu;
    public  MenuItem logoutMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();

        passedFragment = this.getIntent().getExtras().getString("fragmentClass");

            switch (passedFragment){
                case "com.serverus.oom.fragments.FragmentAgency":
                    fragmentClass = FragmentAgency.class;

                    menuItemReserve = mMenu.findItem(R.id.agency_menu_item);
                    break;
                case "com.serverus.oom.fragments.FragmentServices2":
                    fragmentClass = FragmentServices2.class;
                    menuItemReserve = mMenu.findItem(R.id.services_menu_item);
                    break;
                case "com.serverus.oom.fragments.FragmentContactUs":
                    fragmentClass = FragmentContactUs.class;
                    menuItemReserve = mMenu.findItem(R.id.contact_menu_item);
                    break;
                default:
                    fragmentClass = FragmentAgency.class;
                    break;
            }

        if(savedInstanceState == null){
            fragmentReplace(fragmentClass);

        }else{
            getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
            fragmentTitle = savedInstanceState.getString("title");
            setTitle(fragmentTitle);
        }


        // check if user is loged in
        ParseUser currentUser = ParseUser.getCurrentUser();
        if(currentUser != null){
            enableUserLogedin(true);
        }

        // this will determine if we are using the BackStack
        // we need this to change the title when we go back from previous fragments
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment f = getSupportFragmentManager().findFragmentById(R.id.flContent);
                if (f != null) {
                    updateTitleAndDrawer(f);
                }

                int backCount = getSupportFragmentManager().getBackStackEntryCount();

                if (backCount == 0) {
                    finish();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
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
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mdrawerToggle.syncState();
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
        innerParent = (LinearLayout) findViewById(R.id.inner_parent);
        setupDrawerContent(mDrawer);

        mMenu = mDrawer.getMenu();

        loginMenu =  mMenu.findItem(R.id.login_menu_item);
        logoutMenu = mMenu.findItem(R.id.logout_menu_item);
        //mDrawer.setNavigationItemSelectedListener(this);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return false;
                    }

                });
    }

    public boolean selectDrawerItem(MenuItem menuItem) {

            // Create a new fragment and specify the planet to show based on
            // position
            switch(menuItem.getItemId()) {
                case R.id.agency_menu_item:
                    fragmentClass = FragmentAgency.class;
                    break;
                case R.id.services_menu_item:
                    fragmentClass = FragmentServices2.class;
                    break;
                case R.id.contact_menu_item:
                    fragmentClass = FragmentContactUs.class;
                    break;
                case R.id.login_menu_item:
                    fragmentClass = FragmentLogin.class;
                    break;
                case R.id.logout_menu_item:
                    logout();
                    break;
                case R.id.support_menu_item:
                    final Intent userList = new Intent(this, ListUserActivity.class);
                    final Intent serviceIntent = new Intent(getApplicationContext(), MessageService.class);
                    startActivity(userList);
                    startService(serviceIntent);
                    break;
                default:
                    break;
            }

            // this is to determine if what fragment is currently showing
            // if the user tap on the same menu item that shows that fragment
            // we will return it false to avoid redundancy
            if(fragClassName == fragmentClass.getName() || menuItemReserve == menuItem){
                mDrawerLayout.closeDrawers();
                return false;
            }

            menuItemReserve = menuItem;
            fragmentReplace(fragmentClass);

            Log.d("aoi", String.valueOf(menuItem));
            // Highlight the selected item, update the title, and close the drawer
            //menuItemReserve.setChecked(true);
            //setTitle(menuItem.getTitle());
            mDrawerLayout.closeDrawers();
            return true;

    }

    private void logout() {
        ParseUser.logOut();
        loginMenu.setVisible(true);
        logoutMenu.setVisible(false);
        stopService(new Intent(this, MessageService.class));
    }

    public void fragmentReplace(Class fragmentClass) {

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

//        if (getFragmentManager().getBackStackEntryCount() == 0) {
//            ft.replace(R.id.flContent, fragment);
//        } else {
            // the FRAGMENT_TAG constant is used for
            // saveInstatanceState when the user change orientation
            // the fragment will still remain
            // **********
            // addToBackStack is used to have a reference from the previous fragments
            // so you can go back to them when the user tap on the back hardware button
            ft.replace(R.id.flContent, fragment, FRAGMENT_TAG).addToBackStack(null);
        //}
        // setTransition is to add some animation when opening a fragment
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();

    }

    // handle the back button when the user
    // tap on the back hardware button
    @Override
    public void onBackPressed() {

        // this will determine if the backstack is zero
        // and will make the menuItemReserve back to null
        // to empty from previous selected item
        if(getFragmentManager().getBackStackEntryCount() == 0){
            menuItemReserve = null;
        }

        // this is on how to go back to previous fragment
        // with the user of addToBackStack()
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    private void updateTitleAndDrawer (Fragment fragment){
        fragClassName = fragment.getClass().getName();

        Log.d("aoi", "fragment name "+fragClassName);
        if (fragClassName.equals(FragmentAgency.class.getName())){
            // set the app bar title
            fragmentTitle = "Agency";

            setTitle(fragmentTitle);
            mMenu.findItem(R.id.agency_menu_item).setChecked(true);
        }
        else if (fragClassName.equals(FragmentServices2.class.getName())){
            fragmentTitle = "Services";
            setTitle(fragmentTitle);
            mMenu.findItem(R.id.services_menu_item).setChecked(true);
        }
        else if (fragClassName.equals(FragmentContactUs.class.getName())){
            fragmentTitle = "Contact Us";
            setTitle(fragmentTitle);
            mMenu.findItem(R.id.contact_menu_item).setChecked(true);
        }else if (fragClassName.equals(FragmentLogin.class.getName())){
            fragmentTitle = "Login";
            setTitle(fragmentTitle);
            mMenu.findItem(R.id.login_menu_item).setChecked(true);
        }else{
            setTitle ("OOm");
        }
    }

    public void enableUserLogedin(boolean logedin){
        if(logedin == true){
            loginMenu.setVisible(false);
            logoutMenu.setVisible(true);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(RUN_ONCE, true);
        outState.putString("title", fragmentTitle);
    }
}
