package com.kinfo.thuttu.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kinfo.thuttu.fragments.allStores_frag.AllStoresFragment;
import com.kinfo.thuttu.fragments.fragment_featured.FeaturedFragment;
import com.kinfo.thuttu.fragments.mostly_fragment.MostlyFragment;

public class ViewPagerAdapterStores extends FragmentPagerAdapter {

    public ViewPagerAdapterStores(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        if (position == 0){
            fragment = new MostlyFragment();
        }
        else if (position == 1){
            fragment = new AllStoresFragment();
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
            title = "MOSTLY";
        }
        else if (position == 1){
            title = "A-Z STORIES";
        }

        return title;
    }
}

