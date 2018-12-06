package com.kinfo.thuttu.fragments.allStores_frag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kinfo.thuttu.R;
import com.kinfo.thuttu.utils.SimpleDividerItemDecoration;

import java.util.ArrayList;


public class AllStoresFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AllStoresFragment() {
    }

    private RecyclerView listAllStores;

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static AllStoresFragment newInstance(int columnCount) {
        AllStoresFragment fragment = new AllStoresFragment();
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
        View view = inflater.inflate(R.layout.fragment_allstores, container, false);

        listAllStores = view.findViewById(R.id.listAllStores);

        listAllStores.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        listAllStores.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        listAllStores.setLayoutManager(layoutManager);

        listAllStores.setAdapter(new AllStoresAdapter(getStoreNames(),getContext()));

        return view;
    }


    public ArrayList<AllStoresContent> getStoreNames(){

        ArrayList<AllStoresContent> mostlyStoresContentArrayList = new ArrayList<>();

        AllStoresContent mostlyStoresContent = new AllStoresContent();
        mostlyStoresContent.setImage(R.drawable.amazon_icon);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new AllStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Flipkart");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new AllStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Flipkart");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new AllStoresContent();
        mostlyStoresContent.setImage(R.drawable.amazon_icon);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new AllStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Flipkart");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new AllStoresContent();
        mostlyStoresContent.setImage(R.drawable.amazon_icon);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new AllStoresContent();
        mostlyStoresContent.setImage(R.drawable.amazon_icon);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new AllStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Flipkart");
        mostlyStoresContentArrayList.add(mostlyStoresContent);


        mostlyStoresContent = new AllStoresContent();
        mostlyStoresContent.setImage(R.drawable.flipkart_logo);
        mostlyStoresContent.setStroreName("Flipkart");
        mostlyStoresContentArrayList.add(mostlyStoresContent);

        mostlyStoresContent = new AllStoresContent();
        mostlyStoresContent.setImage(R.drawable.amazon_icon);
        mostlyStoresContent.setStroreName("Amazon");
        mostlyStoresContentArrayList.add(mostlyStoresContent);


        return mostlyStoresContentArrayList;

    }

}
