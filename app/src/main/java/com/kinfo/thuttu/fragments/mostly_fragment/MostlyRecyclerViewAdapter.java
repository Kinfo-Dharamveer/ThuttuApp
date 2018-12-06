package com.kinfo.thuttu.fragments.mostly_fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kinfo.thuttu.R;
import java.util.ArrayList;


public class MostlyRecyclerViewAdapter extends RecyclerView.Adapter<MostlyRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<MostlyStoresContent> mostlyStoresContentList;
    public Context context;

    MostlyRecyclerViewAdapter(ArrayList<MostlyStoresContent> mostlyStoresContentList, Context context) {
        this.mostlyStoresContentList = mostlyStoresContentList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_mostly_frag, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        MostlyStoresContent mostlyStoresContent  = mostlyStoresContentList.get(position);

        holder.imgstoreImage.setImageResource(mostlyStoresContent.getImage());
        holder.txtstoreName.setText(mostlyStoresContent.getStroreName());

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgstoreImage;
        private TextView txtstoreName;

        public ViewHolder(View view) {
            super(view);

            imgstoreImage =view.findViewById(R.id.storeImage);
            txtstoreName =view.findViewById(R.id.storeName);
        }

    }

    @Override
    public int getItemCount() {
        return mostlyStoresContentList.size();
    }


}
