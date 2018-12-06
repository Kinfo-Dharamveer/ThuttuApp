package com.kinfo.thuttu.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kinfo.thuttu.fragments.CommentsFragmentProducts;
import com.kinfo.thuttu.fragments.InfoFragment;
import com.kinfo.thuttu.fragments.comments_fragment.CommentsFragment;
import com.kinfo.thuttu.fragments.most_search_frag.MostSearchFragment;
import com.kinfo.thuttu.fragments.recent_frag.RecentFragment;

public class ViewPagerAdapterProducts extends FragmentPagerAdapter {

    public ViewPagerAdapterProducts(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        if (position == 0){
            fragment = new InfoFragment();
        }
        else if (position == 1){
            fragment = new CommentsFragmentProducts();
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
            title = "INFO";
        }
        else if (position == 1){
            title = "COMMENTS";
        }

        return title;
    }
}



