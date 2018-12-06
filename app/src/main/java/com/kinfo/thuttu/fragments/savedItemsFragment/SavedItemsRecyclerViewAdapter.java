package com.kinfo.thuttu.fragments.savedItemsFragment;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.kinfo.thuttu.R;
import com.kinfo.thuttu.fragments.savedItemsFragment.dummy.DummyContent.DummyItem;

import java.util.List;


public class SavedItemsRecyclerViewAdapter extends RecyclerView.Adapter<SavedItemsRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private Context context;

    public SavedItemsRecyclerViewAdapter(List<DummyItem> items,Context context) {
        mValues = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_row_saved, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.txtDisPriceSaved.setText("\u20B9 "+100);
        holder.txtOriginalPriceSaved.setText("\u20B9 "+100);

        strikeThroughText(holder.txtOriginalPriceSaved);

        holder.textViewOptionsSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating a pop up menu
                PopupMenu popupMenu = new PopupMenu(context,holder.textViewOptionsSaved);

                popupMenu.inflate(R.menu.menu_options);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.getDeal:
                                Toast.makeText(context, "Get Deal", Toast.LENGTH_SHORT).show();
                            case R.id.comment:
                                Toast.makeText(context, "Comment", Toast.LENGTH_SHORT).show();
                            case R.id.Save:
                                Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show();
                            case R.id.share:
                                Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show();
                            default:
                                return false;
                        }

                    }
                });
                popupMenu.show();
            }
        });

    }

    private void strikeThroughText(TextView price){
        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }
    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtDisPriceSaved;
        public final TextView txtOriginalPriceSaved;
        public final TextView textViewOptionsSaved;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtDisPriceSaved =  view.findViewById(R.id.txtDisPriceSaved);
            txtOriginalPriceSaved =  view.findViewById(R.id.txtOriginalPriceSaved);
            textViewOptionsSaved =  view.findViewById(R.id.textViewOptionsSaved);
        }

    }
}
