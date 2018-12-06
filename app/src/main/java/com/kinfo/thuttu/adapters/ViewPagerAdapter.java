package com.kinfo.thuttu.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kinfo.thuttu.fragments.comments_fragment.CommentsFragment;
import com.kinfo.thuttu.fragments.latest_fragment.LatestItemsFragment;
import com.kinfo.thuttu.fragments.fragment_featured.FeaturedFragment;
import com.kinfo.thuttu.fragments.savedItemsFragment.SavedItemsFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        if (position == 0){
            fragment = new LatestItemsFragment();
        }
        else if (position == 1){
            fragment = new FeaturedFragment();
        }

        else if (position == 2){
            fragment = new CommentsFragment();
        }

        else if (position == 3){
            fragment = new SavedItemsFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0){
            title = "LATEST";
        }
        else if (position == 1){
            title = "FEATURED";
        }
        else if (position == 2){
            title = "COMMENTS";
        }
        else if (position == 3){
            title = "SAVED";
        }
        return title;
    }
}
