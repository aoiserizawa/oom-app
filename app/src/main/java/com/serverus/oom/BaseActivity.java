package com.serverus.oom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by alvinvaldez on 6/28/15.
 */
public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String SELECTED_ITEM_ID = "selected_id";
    public DrawerLayout mDrawerLayout;
    public Toolbar mToolBar;
    public NavigationView mDrawer;
    public ActionBarDrawerToggle mdrawerToggle;

    public int mSelectedId;

    public MenuItem mymenu;

//    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
//    SharedPreferences.Editor editor = pref.edit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            mSelectedId = savedInstanceState.getInt(SELECTED_ITEM_ID);
        }

        Log.d("aoi", "save instance "+String.valueOf(mSelectedId));

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Intent intent = null;
        mymenu = menuItem;
        mSelectedId =  menuItem.getItemId();



        Log.d("aoi", "menu item"+mymenu);

        Log.d("aoi", "selected item "+String.valueOf(mSelectedId));

        mDrawerLayout.closeDrawer(GravityCompat.START);
        switch (menuItem.getItemId()) {
            case R.id.agency_menu_item:
                intent = new Intent(this, AgencyActivity.class);

                intent.putExtra("menuItemDisb", mSelectedId);
                startActivity(intent);
                break;
        }

        return false;
    }




}
