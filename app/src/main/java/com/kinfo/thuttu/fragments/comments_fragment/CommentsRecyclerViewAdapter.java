package com.kinfo.thuttu.fragments.comments_fragment;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.kinfo.thuttu.R;
import java.util.ArrayList;


public class CommentsRecyclerViewAdapter extends RecyclerView.Adapter<CommentsRecyclerViewAdapter.ViewHolder> {

    private  ArrayList<CommentData> commentDataArrayList;
    private Context mContext;

    LinearLayout.LayoutParams layoutParams;
    LinearLayout ll;

    public CommentsRecyclerViewAdapter(ArrayList<CommentData> commentDataArrayList, Context context) {
        this.commentDataArrayList = commentDataArrayList;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_row_comments, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        CommentData commentData = commentDataArrayList.get(position);

        holder.imageItem.setImageResource(commentData.getImage());
        holder.txtTitle.setText(commentData.getTitle());
        holder.txtdiscount.setText("\u20B9 "+commentData.getDiscountPrice());
        holder.txtOriginalPr.setText("\u20B9 "+commentData.getOrigiPrice());
        holder.txtOff.setText(commentData.getOffPrice()+"% Off");
        holder.txtInfo.setText(commentData.getInfo());
        holder.txtTime.setText(commentData.getTime());
        holder.txtPaytm.setText(commentData.getPaytm());

        strikeThroughText(holder.txtdiscount);

        holder.imgSendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Comment Sending....", Toast.LENGTH_SHORT).show();
            }
        });
        holder.optionsComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating a pop up menu
                PopupMenu popupMenu = new PopupMenu(mContext,holder.optionsComments);

                popupMenu.inflate(R.menu.menu_options);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.getDeal:
                                Toast.makeText(mContext, "Get Deal", Toast.LENGTH_SHORT).show();
                            case R.id.comment:
                                Toast.makeText(mContext, "Comment", Toast.LENGTH_SHORT).show();
                            case R.id.Save:
                                Toast.makeText(mContext, "Save", Toast.LENGTH_SHORT).show();
                            case R.id.share:
                                Toast.makeText(mContext, "Share", Toast.LENGTH_SHORT).show();
                            default:
                                return false;
                        }

                    }
                });
                popupMenu.show();
            }
        });


        holder.imgSendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = vi.inflate(R.layout.comment_section, null);

                // fill in any details dynamically here
                TextView username =  view.findViewById(R.id.txtUserName);
                TextView comment =  view.findViewById(R.id.txtText);
                TextView time =  view.findViewById(R.id.txtTime);
                username.setText("A Khan");
                comment.setText(holder.edComment.getText());
                time.setText("12 min");

                // insert into main view
                holder.linearSectionComment.addView(view, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));


            }
        });

    }

    private void strikeThroughText(TextView price){
        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return commentDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        private ImageView imageItem,imgSendComment;
        private TextView txtTitle,optionsComments,txtdiscount,txtOriginalPr,txtOff,txtInfo,txtTime,txtPaytm;
        private EditText edComment;
        private FrameLayout linearSectionComment;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            imageItem = mView.findViewById(R.id.imageItem);
            imgSendComment = mView.findViewById(R.id.imgSendComment);

            txtTitle = mView.findViewById(R.id.txtTitle);
            optionsComments = mView.findViewById(R.id.optionsComments);
            txtdiscount = mView.findViewById(R.id.txtdiscount);
            txtOriginalPr = mView.findViewById(R.id.txtOriginalPr);
            txtOff = mView.findViewById(R.id.txtOff);
            txtInfo = mView.findViewById(R.id.txtInfo);
            txtTime = mView.findViewById(R.id.txtTime);
            txtPaytm = mView.findViewById(R.id.txtPaytm);

            edComment = mView.findViewById(R.id.edComment);
            linearSectionComment = mView.findViewById(R.id.linearSectionComment);


        }


    }
}
