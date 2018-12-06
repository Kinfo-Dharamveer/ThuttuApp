package com.kinfo.thuttu.ui;


import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.kinfo.thuttu.BaseActivity;
import com.kinfo.thuttu.R;
import com.kinfo.thuttu.adapters.ViewPagerAdapterProducts;
import com.kinfo.thuttu.rxbus.RxBus;

public class ProductDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tabProductsDetail;
    private ViewPager viewPagerProductDetail;
    private ViewPagerAdapterProducts viewPagerAdapterProducts;
    private RxBus bus;
    private CoordinatorLayout coordinatorLayout;
    private ImageView imgShare,imgBackArrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_details);

        bus = new RxBus();

        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        imgShare = findViewById(R.id.imgShare);
        imgBackArrow = findViewById(R.id.imgBackArrow);

        tabProductsDetail = findViewById(R.id.tabProductsDetail);
        viewPagerProductDetail = findViewById(R.id.viewPagerProductDetail);

        imgShare.setOnClickListener(this);
        imgBackArrow.setOnClickListener(this);
        viewPagerAdapterProducts = new ViewPagerAdapterProducts(getSupportFragmentManager());
        viewPagerProductDetail.setAdapter(viewPagerAdapterProducts);

        tabProductsDetail.setupWithViewPager(viewPagerProductDetail);


    }

    public RxBus bus() {
        return bus;

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgShare:{
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "ThuttuApp");
                    String sAux = "\nLet me recommend you this application\n\n";
                    sAux = sAux + "https://play.google.com/store/apps/details?id=the.package.id \n\n";
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "choose one"));
                } catch (Exception e) {
                    //e.toString();
                }
                break;
            }

            case R.id.imgBackArrow:{
                finish();
            }


        }
    }
}
