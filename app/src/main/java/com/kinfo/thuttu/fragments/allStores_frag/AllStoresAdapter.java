package com.kinfo.thuttu.fragments.allStores_frag;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kinfo.thuttu.R;

import java.util.ArrayList;


public class AllStoresAdapter extends RecyclerView.Adapter<AllStoresAdapter.ViewHolder> {

    private final ArrayList<AllStoresContent> mostlyStoresContentList;
    public Context context;

    AllStoresAdapter(ArrayList<AllStoresContent> mostlyStoresContentList, Context context) {
        this.mostlyStoresContentList = mostlyStoresContentList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_allstores_frag, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        AllStoresContent mostlyStoresContent  = mostlyStoresContentList.get(position);

        holder.storeImageAll.setImageResource(mostlyStoresContent.getImage());
        holder.storeNameAll.setText(mostlyStoresContent.getStroreName());

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView storeImageAll;
        private TextView storeNameAll;

        public ViewHolder(View view) {
            super(view);

            storeImageAll =view.findViewById(R.id.storeImageAll);
            storeNameAll =view.findViewById(R.id.storeNameAll);
        }

    }

    @Override
    public int getItemCount() {
        return mostlyStoresContentList.size();
    }


}
