package com.kinfo.thuttu.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kinfo.thuttu.R;
import com.kinfo.thuttu.models.ProfileImagesList;

import java.util.ArrayList;

import butterknife.OnItemClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileImagesAdapters extends RecyclerView.Adapter<ProfileImagesAdapters.ViewHolder> {

    private ArrayList<ProfileImagesList> profileImagesListArrayList;
    private Context mContex;
    private OnImageClick mCallback;

    public ProfileImagesAdapters( ArrayList<ProfileImagesList> profileImagesListArrayList,Context context,OnImageClick onImageClick) {
        this.profileImagesListArrayList = profileImagesListArrayList;
        this.mContex = context;
        this.mCallback = onImageClick;
    }

    public interface OnImageClick{
        void onClick(Drawable dr);
    }

    @Override
    public ProfileImagesAdapters.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_profile_grid,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileImagesAdapters.ViewHolder holder, int position) {

        ProfileImagesList profileImagesList = profileImagesListArrayList.get(position);

        holder.imageRow.setImageResource(profileImagesList.getProfileImage());

        holder.relativeImageClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCallback.onClick(holder.imageRow.getDrawable());
            }
        });

    }



    @Override
    public int getItemCount() {
        return profileImagesListArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout relativeImageClick;
        private ImageView imageRow;

        public ViewHolder(View itemView) {
            super(itemView);

            relativeImageClick = itemView.findViewById(R.id.relativeImageClick);
            imageRow = itemView.findViewById(R.id.imageRow);

        }
    }
}
