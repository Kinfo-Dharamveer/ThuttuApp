package com.kinfo.thuttu.fragments.most_search_frag;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kinfo.thuttu.R;

import java.util.ArrayList;

public class MostSearchRecyclerViewAdapter extends RecyclerView.Adapter<MostSearchRecyclerViewAdapter.ViewHolder> {

    private ArrayList<MostSearchContent> mostSearchContentArrayList;
    private Context context;

    public MostSearchRecyclerViewAdapter(ArrayList<MostSearchContent> mostSearchContentArrayList, Context context) {
        this.mostSearchContentArrayList = mostSearchContentArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_search,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        MostSearchContent mostSearchContent = mostSearchContentArrayList.get(position);

    }

    @Override
    public int getItemCount() {
        return mostSearchContentArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
