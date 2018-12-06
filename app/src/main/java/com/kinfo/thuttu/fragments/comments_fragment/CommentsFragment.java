package com.kinfo.thuttu.fragments.comments_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kinfo.thuttu.R;


import java.util.ArrayList;
import java.util.List;

public class CommentsFragment extends Fragment {

    private RecyclerView recyclerComments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list3, container, false);

        recyclerComments = view.findViewById(R.id.recyclerComments);

        recyclerComments.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerComments.setLayoutManager(layoutManager);

        recyclerComments.setAdapter(new CommentsRecyclerViewAdapter(getAllComments(),getContext()));

        return view;
    }


    public ArrayList<CommentData> getAllComments(){

        ArrayList<CommentData> commentDataArrayList = new ArrayList<>();

        CommentData commentData = new CommentData();
        commentData.setImage(R.drawable.axe);
        commentData.setTitle("Upto Rs.3000 Cashback on Flight Ticket Booking: Paytm Flyday Fina");
        commentData.setDiscountPrice("149");
        commentData.setOrigiPrice("48");
        commentData.setOffPrice("68");
        commentData.setInfo("1");
        commentData.setTime("1");
        commentData.setPaytm("PAYTM");
        commentDataArrayList.add(commentData);

        commentData = new CommentData();
        commentData.setImage(R.drawable.axe);
        commentData.setTitle("SkyAsia Designer Rakhi Set(1 Rakhi With Box");
        commentData.setDiscountPrice("149");
        commentData.setOrigiPrice("48");
        commentData.setOffPrice("28");
        commentData.setInfo("2");
        commentData.setTime("1");
        commentData.setPaytm("FLIPKART");
        commentDataArrayList.add(commentData);


        return commentDataArrayList;

    }

}
