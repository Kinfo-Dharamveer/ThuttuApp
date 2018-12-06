package com.kinfo.thuttu.fragments.latest_fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.kinfo.thuttu.R;

import java.util.ArrayList;


public class LatestRecyclerViewAdapter extends RecyclerView.Adapter<LatestRecyclerViewAdapter.ViewHolder> {

    private  ArrayList<LatestItems> latestItemsArrayList;
    public Context context;
    private OnRowClickInterface onCardClick;

    public LatestRecyclerViewAdapter(ArrayList<LatestItems> latestItemsArrayList, Context context, OnRowClickInterface onCardClick) {
        this.latestItemsArrayList = latestItemsArrayList;
        this.context = context;
        this.onCardClick = onCardClick;
    }

    public interface OnRowClickInterface{
        void rowClick(String imagePath,String title, String originalPrice,String offPrice, String disPrice,String time,String storeName);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_latest_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        LatestItems latestItems = latestItemsArrayList.get(position);

        holder.imageLatest.setImageResource(latestItems.getImageLatest());
        holder.txtTitleLatest.setText(latestItems.getTxtTitleLatest());
        holder.txtdiscountLatest.setText("\u20B9 "+latestItems.getTxtdiscountLatest());
        holder.txtOriginalPrice.setText("\u20B9 "+latestItems.getTxtOriginalPrice());
        holder.txtOffPrice.setText(latestItems.getTxtOffPrice()+"% Off");
        holder.txtInfo.setText(latestItems.getTxtInfo());
        holder.txtTime.setText(latestItems.getTxtTime());
        holder.txtPaytm.setText(latestItems.getTxtPaytm());

        strikeThroughText(holder.txtdiscountLatest);

        Uri path = Uri.parse("android.resource://your.package.name/" + holder.imageLatest);
        String imgPath = path.toString();


        String title = holder.txtTitleLatest.getText().toString();
        String disPrice = holder.txtdiscountLatest.getText().toString();
        String origPrice = holder.txtOriginalPrice.getText().toString();
        String offPrice = holder.txtOffPrice.getText().toString();
        String storeName = holder.txtPaytm.getText().toString();
        String time = holder.txtTime.getText().toString();

        holder.cardViewLatest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCardClick.rowClick(imgPath,title,origPrice,offPrice,disPrice,time,storeName);
            }
        });

        holder.optionsComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating a pop up menu
                PopupMenu popupMenu = new PopupMenu(context,holder.optionsComments);

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

       // holder.mIdView.setText(mValues.get(position).id);
       // holder.mContentView.setText(mValues.get(position).content);

     /*   holder.mView.setOnClickListener(new View.OnClickListener() {
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

    private void strikeThroughText(TextView price){
        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return latestItemsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageLatest;
        private final TextView txtTitleLatest,optionsComments,txtdiscountLatest,txtOriginalPrice,txtOffPrice,
                txtInfo,txtTime,txtPaytm;
        private CardView cardViewLatest;



        public ViewHolder(View view) {
            super(view);
            cardViewLatest =  view.findViewById(R.id.cardViewLatest);

            imageLatest =  view.findViewById(R.id.imageLatest);
            txtTitleLatest = view.findViewById(R.id.txtTitleLatest);
            optionsComments = view.findViewById(R.id.optionsComments);

            txtdiscountLatest = view.findViewById(R.id.txtdiscountLatest);
            txtOriginalPrice = view.findViewById(R.id.txtOriginalPrice);
            txtOffPrice = view.findViewById(R.id.txtOffPrice);
            txtInfo = view.findViewById(R.id.txtInfo);
            txtTime = view.findViewById(R.id.txtTime);
            txtPaytm = view.findViewById(R.id.txtPaytm);

        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
