package com.kinfo.thuttu.fragments.fragment_featured;

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
import com.kinfo.thuttu.fragments.fragment_featured.dummy.DummyContent.DummyItem;

import java.util.List;


public class FeaturedRecyclerViewAdapter extends RecyclerView.Adapter<FeaturedRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    public Context context;

    public FeaturedRecyclerViewAdapter(List<DummyItem> items,Context context) {
        mValues = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_row_featured, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.txtDisPriceFeat.setText("\u20B9 "+100);
        holder.txtOriginalPriceFeat.setText("\u20B9 "+100);

        strikeThroughText(holder.txtOriginalPriceFeat);

        holder.textViewOptionsFeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating a pop up menu
                PopupMenu popupMenu = new PopupMenu(context,holder.textViewOptionsFeat);

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
    /*    holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    private void strikeThroughText(TextView price){
        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtDisPriceFeat;
        public final TextView txtOriginalPriceFeat;
        public TextView textViewOptionsFeat;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtDisPriceFeat = (TextView) view.findViewById(R.id.txtDisPriceFeat);
            txtOriginalPriceFeat = (TextView) view.findViewById(R.id.txtOriginalPriceFeat);
            textViewOptionsFeat = (TextView) view.findViewById(R.id.textViewOptionsFeat);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
