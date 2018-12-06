package com.kinfo.thuttu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.kinfo.thuttu.di.modules.SharedPrefHelper;
import com.kinfo.thuttu.network.GitApiInterface;
import com.kinfo.thuttu.ui.AboutUsActivity;
import com.kinfo.thuttu.ui.MainActivity;
import com.kinfo.thuttu.ui.NotificationsActivity;
import com.kinfo.thuttu.ui.PrivacyPolicyActivity;
import com.kinfo.thuttu.ui.RechargeActivity;
import com.kinfo.thuttu.ui.SearchActivity;
import com.kinfo.thuttu.ui.SettingsActivity;
import com.kinfo.thuttu.ui.StoresActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Inject
    public GitApiInterface apiInterface;

    @Inject
    public SharedPrefHelper sharedPrefHelper;

    protected Unbinder unbinder;
    protected FrameLayout frameLayout;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private static boolean isLaunch = true;
    protected static int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((AppController) getApplication()).getComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer_base_layout);

        frameLayout = findViewById(R.id.content_frame);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);


        // ActionBarDrawerToggle ties together the the proper interactions between the sliding drawer and the action bar app icon
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,                        /* host Activity */
                mDrawerLayout,                /* DrawerLayout object */
                R.string.open_drawer,       /* "open drawer" description for accessibility */
                R.string.close_drawer)    /* "close drawer" description for accessibility */ {
            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }
        };
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);

        // enable ActionBar app icon to behave as action to toggle nav drawer
        //
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setHomeButtonEnabled(true);

        /**
         * As we are calling BaseActivity from manifest file and this base activity is intended just to add navigation drawer in our app.
         * We have to open some activity with layout on launch. So we are checking if this BaseActivity is called first time then we are opening our first activity.
         * */
        if (isLaunch) {
            /**
             *Setting this flag false so that next time it will not open our first activity.
             *We have to use this flag because we are using this BaseActivity as parent activity to our other activity.
             *In this case this base activity will always be call when any child activity will launch.
             */
            isLaunch = false;
            openActivity(0);
        }
        ;

        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    private void openActivity(int position) {
        BaseActivity.position = position; //Setting currently selected position in this field so that it will be available in our child activities.

        switch (position) {
            case 0:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {

            case R.id.search_button:
                startActivity(new Intent(this,SearchActivity.class));
                break;
            case R.id.refresh_button:
                break;


        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ((AppController) getApplication()).getComponent().inject(this);
        unbinder = ButterKnife.bind(this);
    }


    public void navigateToNextActivity(Class cla) {
        startActivity(new Intent(BaseActivity.this, cla));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    /* We can override onBackPressed method to toggle navigation drawer*/
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void showAlertDialog(String action, String message) {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(message);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                action,


                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {



        switch (item.getItemId()) {
            case R.id.nav_latestdeals:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.nav_featureddeals:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.nav_recentcomments:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.nav_saveddeals:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.nav_rechargedeals:
                startActivity(new Intent(this,RechargeActivity.class));
                break;
            case R.id.nav_stores:
                startActivity(new Intent(this,StoresActivity.class));
                break;

            case R.id.nav_search:
                startActivity(new Intent(this,SearchActivity.class));
                break;

            case R.id.nav_settings:
                startActivity(new Intent(this,SettingsActivity.class));
                break;

            case R.id.nav_notifications:
                startActivity(new Intent(this,NotificationsActivity.class));
                break;

            case R.id.nav_aboutus:
                startActivity(new Intent(this,AboutUsActivity.class));
                break;

            case R.id.nav_privacypolicy:
                startActivity(new Intent(this,PrivacyPolicyActivity.class));
                break;


        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
