package com.kinfo.thuttu.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kinfo.thuttu.BaseActivity;
import com.kinfo.thuttu.R;
import com.kinfo.thuttu.adapters.RechargeViewAdapter;
import com.kinfo.thuttu.models.RechargeList;

import java.util.ArrayList;

public class RechargeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RechargeViewAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerViewRecharge);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RechargeViewAdapter(addRechargeItem(),this));

    }

    public ArrayList<RechargeList> addRechargeItem(){

        ArrayList<RechargeList> rechargeListArrayList = new ArrayList<>();

        RechargeList rechargeList = new RechargeList();
        rechargeList.setImage(R.drawable.axe);
        rechargeList.setComments("4");
        rechargeList.setDiscountPrice("120");
        rechargeList.setImageName("Coupen");
        rechargeList.setOffPercentage("52");
        rechargeList.setTime("6");
        rechargeList.setOriginalPrice("92");
        rechargeList.setPaytm("PAYTMMALL");
        rechargeList.setRechargeTitle("Axe Recharge Deodorant, 150 ml");
        rechargeListArrayList.add(rechargeList);

         rechargeList = new RechargeList();
        rechargeList.setImage(R.drawable.chocos);
        rechargeList.setComments("10");
        rechargeList.setDiscountPrice("100");
        rechargeList.setImageName("Get Deal..");
        rechargeList.setOffPercentage("51");
        rechargeList.setTime("2");
        rechargeList.setOriginalPrice("42");
        rechargeList.setPaytm("AMAZON");
        rechargeList.setRechargeTitle("Get 25% (Max Rs.30) Cashback on Mobile Prepaid Recharge");
        rechargeListArrayList.add(rechargeList);

         rechargeList = new RechargeList();
        rechargeList.setImage(R.drawable.axe);
        rechargeList.setComments("4");
        rechargeList.setImageName("Coupen");
        rechargeList.setTime("6");
        rechargeList.setOffPercentage("");
        rechargeList.setOriginalPrice("");
        rechargeList.setPaytm("PAYTMMALL");
        rechargeList.setRechargeTitle("Axe Recharge Deodorant, 150 ml");
        rechargeListArrayList.add(rechargeList);

        rechargeList.setImage(R.drawable.axe);
        rechargeList.setComments("4");
        rechargeList.setDiscountPrice("120");
        rechargeList.setImageName("Coupen");
        rechargeList.setOffPercentage("52");
        rechargeList.setTime("6");
        rechargeList.setOriginalPrice("92");
        rechargeList.setPaytm("PAYTMMALL");
        rechargeList.setRechargeTitle("Axe Recharge Deodorant, 150 ml");
        rechargeListArrayList.add(rechargeList);

        rechargeList = new RechargeList();
        rechargeList.setImage(R.drawable.chocos);
        rechargeList.setComments("10");
        rechargeList.setDiscountPrice("100");
        rechargeList.setImageName("Get Deal..");
        rechargeList.setOffPercentage("51");
        rechargeList.setTime("2");
        rechargeList.setOriginalPrice("42");
        rechargeList.setPaytm("AMAZON");
        rechargeList.setRechargeTitle("Get 25% (Max Rs.30) Cashback on Mobile Prepaid Recharge");
        rechargeListArrayList.add(rechargeList);

        rechargeList = new RechargeList();
        rechargeList.setImage(R.drawable.axe);
        rechargeList.setComments("4");
        rechargeList.setImageName("Coupen");
        rechargeList.setTime("6");
        rechargeList.setOffPercentage("");
        rechargeList.setOriginalPrice("");
        rechargeList.setPaytm("PAYTMMALL");
        rechargeList.setRechargeTitle("Axe Recharge Deodorant, 150 ml");
        rechargeListArrayList.add(rechargeList);

        return rechargeListArrayList;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
