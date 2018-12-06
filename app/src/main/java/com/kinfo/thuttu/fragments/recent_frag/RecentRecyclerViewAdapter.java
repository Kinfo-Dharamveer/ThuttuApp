package com.kinfo.thuttu.fragments.recent_frag;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kinfo.thuttu.R;

import java.util.ArrayList;

public class RecentRecyclerViewAdapter extends RecyclerView.Adapter<RecentRecyclerViewAdapter.ViewHolder> {

    private ArrayList<RecentSearchContent> recentSearchContentArrayList;
    private Context context;

    public RecentRecyclerViewAdapter(ArrayList<RecentSearchContent> recentSearchContentArrayList, Context context) {
        this.recentSearchContentArrayList = recentSearchContentArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recentsearch,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RecentSearchContent recentSearchContent = recentSearchContentArrayList.get(position);

    }

    @Override
    public int getItemCount() {
        return recentSearchContentArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
