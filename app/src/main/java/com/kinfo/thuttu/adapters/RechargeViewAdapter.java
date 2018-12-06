package com.kinfo.thuttu.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
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
import com.kinfo.thuttu.models.RechargeList;

import java.util.ArrayList;

public class RechargeViewAdapter extends RecyclerView.Adapter<RechargeViewAdapter.ViewHolder> {

    private ArrayList<RechargeList> rechargeListArrayList;
    private Context context;

    public RechargeViewAdapter(ArrayList<RechargeList> rechargeListArrayList, Context context) {
        this.rechargeListArrayList = rechargeListArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recharge_row,parent,false);
        return new ViewHolder(view);
    }

    private void strikeThroughText(TextView price){
        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RechargeList rechargeList = rechargeListArrayList.get(position);

        holder.itemImage.setImageResource(rechargeList.getImage());
        holder.txtCoupen.setText(rechargeList.getImageName());
        holder.txtTitle.setText(rechargeList.getRechargeTitle());
        holder.txtDiscountPrice.setText("\u20B9 "+rechargeList.getDiscountPrice());
        holder.txtComments.setText(rechargeList.getComments());
        holder.txtMallType.setText(rechargeList.getPaytm());
        holder.txtOrigPrice.setText("\u20B9 "+rechargeList.getOriginalPrice());
        holder.txtOffPrice.setText(rechargeList.getOffPercentage()+"% Off");
        holder.txtTime.setText(rechargeList.getTime());

        strikeThroughText(holder.txtOrigPrice);


        holder.textViewOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating a pop up menu
                PopupMenu popupMenu = new PopupMenu(context,holder.textViewOptions);

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

    @Override
    public int getItemCount() {
        return rechargeListArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtCoupen,txtTitle,textViewOptions,txtOrigPrice,txtDiscountPrice,txtOffPrice,txtComments,
                txtTime,txtMallType;
        private ImageView itemImage;

        public ViewHolder(View itemView) {
            super(itemView);

            txtCoupen = itemView.findViewById(R.id.txtCoupen);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            textViewOptions = itemView.findViewById(R.id.textViewOptions);
            txtOrigPrice = itemView.findViewById(R.id.txtOrigPrice);
            txtDiscountPrice = itemView.findViewById(R.id.txtDiscountPrice);
            txtOffPrice = itemView.findViewById(R.id.txtOffPrice);
            txtComments = itemView.findViewById(R.id.txtComments);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtMallType = itemView.findViewById(R.id.txtMallType);

            itemImage = itemView.findViewById(R.id.itemImage);
        }
    }
}
