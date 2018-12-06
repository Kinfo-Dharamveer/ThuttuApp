package com.kinfo.thuttu.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.kinfo.thuttu.BaseActivity;
import com.kinfo.thuttu.R;
import com.kinfo.thuttu.adapters.ViewPagerAdapterSearch;
import com.kinfo.thuttu.adapters.ViewPagerAdapterStores;

public class SearchActivity extends BaseActivity {

    private ImageView imgSearchOpenDrawer;
    private SearchView searchView;
    private TextView txtSearch;
    private TabLayout tabSearch;
    private ViewPager viewPagerSearch;
    private ViewPagerAdapterSearch viewPagerAdapterSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_search, frameLayout);

        imgSearchOpenDrawer = findViewById(R.id.imgSearchOpenDrawer);
        searchView = findViewById(R.id.searchView);
        txtSearch = findViewById(R.id.txtSearch);

        tabSearch = findViewById(R.id.tabSearch);
        viewPagerSearch = findViewById(R.id.viewPagerSearch);


        viewPagerAdapterSearch = new ViewPagerAdapterSearch(getSupportFragmentManager());
        viewPagerSearch.setAdapter(viewPagerAdapterSearch);


        searchView.setIconifiedByDefault(false);
        txtSearch.setVisibility(View.GONE);



        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSearch.setVisibility(View.GONE);
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                txtSearch.setVisibility(View.VISIBLE);
                return false;
            }
        });

        tabSearch.setupWithViewPager(viewPagerSearch);


        imgSearchOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }
}
