package com.kinfo.thuttu.fragments.most_search_frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kinfo.thuttu.R;
import com.kinfo.thuttu.fragments.recent_frag.RecentRecyclerViewAdapter;

import java.util.ArrayList;

public class MostSearchFragment extends Fragment {

    private RecyclerView recyclerViewMostSearch;
    private MostSearchRecyclerViewAdapter mostSearchRecyclerViewAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mostsearch, container, false);

        recyclerViewMostSearch = view.findViewById(R.id.recyclerViewMostSearch);

        recyclerViewMostSearch.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerViewMostSearch.setLayoutManager(layoutManager);

        recyclerViewMostSearch.setAdapter(new MostSearchRecyclerViewAdapter(getStoreNames(),getContext()));


        return view;

    }

    private ArrayList<MostSearchContent> getStoreNames() {

        ArrayList<MostSearchContent> mostSearchContentArrayList = new ArrayList<>();

        return mostSearchContentArrayList;

    }
}
