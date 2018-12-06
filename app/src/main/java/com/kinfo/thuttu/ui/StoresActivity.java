package com.kinfo.thuttu.ui;


import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import com.kinfo.thuttu.BaseActivity;
import com.kinfo.thuttu.R;
import com.kinfo.thuttu.adapters.ViewPagerAdapterStores;

public class StoresActivity extends BaseActivity {

    private ImageView imgStoreOpenDrawer;
    private SearchView searchView;
    private TabLayout tabStores;
    private ViewPager viewPagerStores;
    private TextView storeText;
    private ViewPagerAdapterStores viewPagerAdapterStores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_stores, frameLayout);

        imgStoreOpenDrawer = findViewById(R.id.imgStoreOpenDrawer);
        searchView = findViewById(R.id.searchView);
        storeText = findViewById(R.id.storeText);
        tabStores = findViewById(R.id.tabStores);
        viewPagerStores = findViewById(R.id.viewPagerStores);
        tabStores = findViewById(R.id.tabStores);


        viewPagerAdapterStores = new ViewPagerAdapterStores(getSupportFragmentManager());
        viewPagerStores.setAdapter(viewPagerAdapterStores);

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeText.setVisibility(View.GONE);
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                storeText.setVisibility(View.VISIBLE);
                return false;
            }
        });

        tabStores.setupWithViewPager(viewPagerStores);

        imgStoreOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });


    }
}
