package com.kinfo.thuttu.fragments.recent_frag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kinfo.thuttu.R;

import java.util.ArrayList;

public class RecentFragment extends Fragment {

    private TextView txtClearSearch;
    private RecyclerView recyclerViewSearch;
    private RecentRecyclerViewAdapter recentRecyclerViewAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recent, container, false);

        txtClearSearch = view.findViewById(R.id.txtClearSearch);
        recyclerViewSearch = view.findViewById(R.id.recyclerViewSearch);

        recyclerViewSearch.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerViewSearch.setLayoutManager(layoutManager);

        recyclerViewSearch.setAdapter(new RecentRecyclerViewAdapter(getStoreNames(),getContext()));


        return view;
    }

    private ArrayList<RecentSearchContent> getStoreNames() {

        ArrayList<RecentSearchContent> recentSearchContentArrayList = new ArrayList<>();

        return recentSearchContentArrayList;
    }

}
