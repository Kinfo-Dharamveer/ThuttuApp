package com.kinfo.thuttu.fragments.mostly_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kinfo.thuttu.R;

import java.util.ArrayList;


public class MostlyFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MostlyFragment() {
    }

    private TextView txtClear;
    private RecyclerView recyclerView;

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MostlyFragment newInstance(int columnCount) {
        MostlyFragment fragment = new MostlyFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mostly, container, false);

        txtClear = view.findViewById(R.id.txtClear);
        recyclerView = view.findViewById(R.id.listMostlyStores);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new MostlyRecyclerViewAdapter(getStoreNames(),getContext()));


        return view;
    }


    public ArrayList<MostlyStoresContent> getStoreNames(){

        ArrayList<MostlyStoresContent> mostlyStoresContentArrayList = new ArrayList<>();

        MostlyStoresContent mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.amazon_icon);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new MostlyStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);


        return mostlyStoresContentArrayList;

    }

}
