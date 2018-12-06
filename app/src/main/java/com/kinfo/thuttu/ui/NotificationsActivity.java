package com.kinfo.thuttu.ui;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.kinfo.thuttu.R;

public class NotificationsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtLatestDeals, txtGetDeals,txtFeaturedDeals,txtFeaturedupd,txtComments,txtGetCom;
    private CheckBox checkLatest, checkBoxComments,checkBoxFeaturedDeals;
    private Switch notifyDealsSwitch;
    private RelativeLayout relativeOne, layoutLatestDeals, relativeComments,relativeFeaturedDeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtLatestDeals = findViewById(R.id.txtLatestDeals);
        txtGetDeals = findViewById(R.id.txtGetDeals);
        txtFeaturedDeals = findViewById(R.id.txtFeaturedDeals);
        txtFeaturedupd = findViewById(R.id.txtFeaturedupd);
        txtComments = findViewById(R.id.txtComments);
        txtGetCom = findViewById(R.id.txtGetCom);

        checkLatest = findViewById(R.id.checkLatest);
        checkBoxComments = findViewById(R.id.checkBoxComments);
        checkBoxFeaturedDeals = findViewById(R.id.checkBoxFeaturedDeals);
        notifyDealsSwitch = findViewById(R.id.notifyDealsSwitch);


        relativeOne = findViewById(R.id.relativeOne);
        layoutLatestDeals = findViewById(R.id.layoutLatestDeals);
        relativeComments = findViewById(R.id.relativeComments);
        relativeFeaturedDeals = findViewById(R.id.relativeFeaturedDeals);

        relativeComments.setOnClickListener(this);
        relativeFeaturedDeals.setOnClickListener(this);
        layoutLatestDeals.setOnClickListener(this);
        relativeOne.setOnClickListener(this);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.relativeComments:
                if (checkBoxComments.isChecked()) {
                    checkBoxComments.setChecked(false);
                } else {
                    checkBoxComments.setChecked(true);
                }
                break;
            case R.id.relativeFeaturedDeals:
                if (checkBoxFeaturedDeals.isChecked()) {
                    checkBoxFeaturedDeals.setChecked(false);
                } else {
                    checkBoxFeaturedDeals.setChecked(true);
                }
                break;
            case R.id.layoutLatestDeals:
                if (checkLatest.isChecked()) {
                    checkLatest.setChecked(false);

                } else {
                    checkLatest.setChecked(true);
                }
                break;
            case R.id.relativeOne:
                if (notifyDealsSwitch.isChecked()) {
                    notifyDealsSwitch.setChecked(false);
                    txtLatestDeals.setTextColor(getResources().getColor(R.color.lightgrey));
                    txtGetDeals.setTextColor(getResources().getColor(R.color.lightgrey));

                    txtFeaturedDeals.setTextColor(getResources().getColor(R.color.lightgrey));
                    txtFeaturedupd.setTextColor(getResources().getColor(R.color.lightgrey));
                    txtComments.setTextColor(getResources().getColor(R.color.lightgrey));
                    txtGetCom.setTextColor(getResources().getColor(R.color.lightgrey));

                    relativeComments.setEnabled(false);
                    relativeFeaturedDeals.setEnabled(false);
                    layoutLatestDeals.setEnabled(false);

                } else {
                    notifyDealsSwitch.setChecked(true);
                    txtLatestDeals.setTextColor(getResources().getColor(R.color.black));
                    txtGetDeals.setTextColor(getResources().getColor(R.color.darkgrey));

                    txtFeaturedDeals.setTextColor(getResources().getColor(R.color.black));
                    txtFeaturedupd.setTextColor(getResources().getColor(R.color.darkgrey));

                    txtComments.setTextColor(getResources().getColor(R.color.black));
                    txtGetCom.setTextColor(getResources().getColor(R.color.darkgrey));

                    relativeComments.setEnabled(true);
                    relativeFeaturedDeals.setEnabled(true);
                    layoutLatestDeals.setEnabled(true);
                }
                break;

        }
    }
}
