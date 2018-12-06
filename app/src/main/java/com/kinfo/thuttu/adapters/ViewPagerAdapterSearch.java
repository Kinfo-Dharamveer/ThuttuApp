package com.kinfo.thuttu.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kinfo.thuttu.fragments.allStores_frag.AllStoresFragment;
import com.kinfo.thuttu.fragments.most_search_frag.MostSearchFragment;
import com.kinfo.thuttu.fragments.mostly_fragment.MostlyFragment;
import com.kinfo.thuttu.fragments.recent_frag.RecentFragment;

public class ViewPagerAdapterSearch extends FragmentPagerAdapter {

    public ViewPagerAdapterSearch(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        if (position == 0){
            fragment = new RecentFragment();
        }
        else if (position == 1){
            fragment = new MostSearchFragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0){
            title = "RECENT";
        }
        else if (position == 1){
            title = "MOSTLY";
        }

        return title;
    }
}


