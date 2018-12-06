package com.kinfo.thuttu.fragments.latest_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kinfo.thuttu.AppController;
import com.kinfo.thuttu.BaseFragment;
import com.kinfo.thuttu.R;
import com.kinfo.thuttu.events.RowClickEvent;
import com.kinfo.thuttu.rxbus.RxBus;
import com.kinfo.thuttu.ui.MainActivity;
import com.kinfo.thuttu.ui.ProductDetailsActivity;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;


public class LatestItemsFragment extends BaseFragment implements LatestRecyclerViewAdapter.OnRowClickInterface {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters

    public LatestItemsFragment() {
    }
    private CompositeDisposable _disposables;
    private RxBus _rxBus;
    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static LatestItemsFragment newInstance(int columnCount) {
        LatestItemsFragment fragment = new LatestItemsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private RecyclerView latestRecyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);


        latestRecyclerView = view.findViewById(R.id.latestRecyclerView);

        latestRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        latestRecyclerView.setLayoutManager(layoutManager);

        latestRecyclerView.setAdapter(new LatestRecyclerViewAdapter(getLatestStores(),getContext(),this));


        return view;
    }

    private ArrayList<LatestItems> getLatestStores() {

        ArrayList<LatestItems> latestItemsArrayList = new ArrayList<>();


        LatestItems latestItems = new LatestItems();
        latestItems.setImageLatest(R.drawable.axe);
        latestItems.setTxtTitleLatest("Maharaja WhiteLine Gala JX-117 450");
        latestItems.setTxtdiscountLatest("455");
        latestItems.setTxtOriginalPrice("1699");
        latestItems.setTxtOffPrice("56");
        latestItems.setTxtInfo("0");
        latestItems.setTxtTime("24");
        latestItems.setTxtPaytm("AMAZON");
        latestItemsArrayList.add(latestItems);


        latestItems = new LatestItems();
        latestItems.setImageLatest(R.drawable.axe);
        latestItems.setTxtTitleLatest("Maharaja WhiteLine Gala JX-117 450");
        latestItems.setTxtdiscountLatest("455");
        latestItems.setTxtOriginalPrice("1699");
        latestItems.setTxtOffPrice("56");
        latestItems.setTxtInfo("0");
        latestItems.setTxtTime("24");
        latestItems.setTxtPaytm("AMAZON");
        latestItemsArrayList.add(latestItems);

        latestItems.setImageLatest(R.drawable.axe);
        latestItems.setTxtTitleLatest("Maharaja WhiteLine Gala JX-117 450");
        latestItems.setTxtdiscountLatest("455");
        latestItems.setTxtOriginalPrice("1699");
        latestItems.setTxtOffPrice("56");
        latestItems.setTxtInfo("0");
        latestItems.setTxtTime("24");
        latestItems.setTxtPaytm("AMAZON");
        latestItemsArrayList.add(latestItems);

        latestItems.setImageLatest(R.drawable.axe);
        latestItems.setTxtTitleLatest("Maharaja WhiteLine Gala JX-117 450");
        latestItems.setTxtdiscountLatest("455");
        latestItems.setTxtOriginalPrice("1699");
        latestItems.setTxtOffPrice("56");
        latestItems.setTxtInfo("0");
        latestItems.setTxtTime("24");
        latestItems.setTxtPaytm("AMAZON");
        latestItemsArrayList.add(latestItems);

        latestItems.setImageLatest(R.drawable.axe);
        latestItems.setTxtTitleLatest("Maharaja WhiteLine Gala JX-117 450");
        latestItems.setTxtdiscountLatest("455");
        latestItems.setTxtOriginalPrice("1699");
        latestItems.setTxtOffPrice("56");
        latestItems.setTxtInfo("0");
        latestItems.setTxtTime("24");
        latestItems.setTxtPaytm("AMAZON");
        latestItemsArrayList.add(latestItems);

        return latestItemsArrayList;
    }




    @Override
    public void rowClick(String imagePath, String title, String originalPrice,
                         String offPrice, String disPrice, String time, String storeName) {

        ((MainActivity) getContext()).bus().send(new RowClickEvent(title));


        Intent intent = new Intent(getContext(), ProductDetailsActivity.class);
        intent.putExtra("imagePath",imagePath);
        intent.putExtra("title",title);
        intent.putExtra("originalPrice",originalPrice);
        intent.putExtra("offPrice",offPrice);
        intent.putExtra("disPrice",disPrice);
        intent.putExtra("time",time);
        intent.putExtra("storeName",storeName);

        startActivity(intent);
    }
}
