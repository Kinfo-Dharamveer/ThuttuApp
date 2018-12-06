package com.kinfo.thuttu.fragments;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.kinfo.thuttu.BaseFragment;
import com.kinfo.thuttu.AppController;
import com.kinfo.thuttu.R;
import com.kinfo.thuttu.events.RowClickEvent;
import com.kinfo.thuttu.ui.ProductDetailsActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class InfoFragment extends BaseFragment {

    private Button btnGetDeal,btnShare,btnSaveDeal;
    private ImageView imgProduct,imgStore;
    private TextView txtStore,txtProTitle,txtDateTime,txtOffPrice,txtOriPrice,txDis;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private NestedScrollView nestedScrollView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        btnGetDeal = view.findViewById(R.id.btnGetDeal);
        btnShare = view.findViewById(R.id.btnShare);
        btnSaveDeal = view.findViewById(R.id.btnSaveDeal);

        nestedScrollView = view.findViewById(R.id.main_snack);

        imgProduct = view.findViewById(R.id.imgProduct);
        imgStore = view.findViewById(R.id.imgStore);

        txtStore = view.findViewById(R.id.txtStore);
        txtProTitle = view.findViewById(R.id.txtProTitle);
        txtDateTime = view.findViewById(R.id.txtDateTime);
        txtOffPrice = view.findViewById(R.id.txtOffPrice);
        txtOriPrice = view.findViewById(R.id.txtOriPrice);
        txDis = view.findViewById(R.id.txDis);

        txtOffPrice.setText("\u20B9 "+"409");
        txtOriPrice.setText("\u20B9 "+"489");
        txDis.setText("40"+"%");


        disposables.add(((ProductDetailsActivity) getContext())
                .bus()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object object) throws Exception {
                        if (object instanceof RowClickEvent){
                            String title = ((RowClickEvent) object).getAllLatestData();
                            txtProTitle.setText(title);
                        }
                    }
                }));


      /*  ((AppController)  getActivity().getApplication()).bus().toObservable().subscribe(new Consumer<Object>()
        {
            @Override
            public void accept(Object o) throws Exception {
                if (o instanceof RowClickEvent) {

                    String title = ((RowClickEvent) o).getAllLatestData();
                    txtProTitle.setText(title);

                }
            }
        });*/





        strikeThroughText(txtOriPrice);

        btnGetDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri3 = Uri.parse("https://www.amazon.in/"); // missing 'http://' will cause crashed
                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
                startActivity(intent3);

            }
        });


        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

            }
        });

        btnSaveDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Snackbar snackbar = Snackbar.make(nestedScrollView,"Deal Saved",Snackbar.LENGTH_LONG);
               snackbar.show();
            }
        });
        return view;
    }


   /* @Override
    public void onDestroy() {
        super.onDestroy();
        disposables.clear(); // do not send event after activity has been destroyed

    }*/

    private void strikeThroughText(TextView price){
        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

}
