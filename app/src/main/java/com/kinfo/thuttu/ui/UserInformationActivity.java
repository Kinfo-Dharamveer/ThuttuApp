package com.kinfo.thuttu.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.kinfo.thuttu.R;
import com.kinfo.thuttu.adapters.ProfileImagesAdapters;
import com.kinfo.thuttu.fragments.allStores_frag.AllStoresAdapter;
import com.kinfo.thuttu.models.ProfileImagesList;
import com.kinfo.thuttu.utils.SimpleDividerItemDecoration;
import com.kinfo.thuttu.utils.ToggleButtonGroupTableLayout;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserInformationActivity extends AppCompatActivity implements
        View.OnClickListener, RadioGroup.OnCheckedChangeListener, ProfileImagesAdapters.OnImageClick {

    private EditText edName;
    private CircleImageView imgProfile;
    private RadioGroup radiodGroup;
    private RadioButton radioMan, radioWoman, radioSymbol, radioGeneral;
    private RecyclerView profileImagesRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edName = findViewById(R.id.edName);
        imgProfile = findViewById(R.id.imgProfile);
        profileImagesRecyclerView = findViewById(R.id.profileImagesRecyclerView);

        radiodGroup = findViewById(R.id.rdGroup);


        radioMan = findViewById(R.id.radioMan);
        radioWoman = findViewById(R.id.radioWoman);
        radioSymbol = findViewById(R.id.radioSymbol);
        radioGeneral = findViewById(R.id.radioGeneral);

        radiodGroup.setOnCheckedChangeListener(this);

        profileImagesRecyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 5);
        profileImagesRecyclerView.setLayoutManager(layoutManager);

        profileImagesRecyclerView.setAdapter(new ProfileImagesAdapters(getImagesList(), this, this));


    }

    private ArrayList<ProfileImagesList> getImagesList() {

        ArrayList<ProfileImagesList> profileImagesListArrayList = new ArrayList<>();

        ProfileImagesList profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.star);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.ancient);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.checked);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.crown);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.electric);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.eyes);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.face_mask);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.flag);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.flower);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.hydrangea);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.mipmap.woman);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.woma);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.employee);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.call_center);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.farmer);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.girl);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.woman);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.brid);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.bride);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.educator);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.farmer);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.nurse);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.customer);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.diver);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.doctor);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.educator);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.em);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.emp);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.employee);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.engineer);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.far);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.employee);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.farmer);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.m);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.ma);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.man);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.n);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.nv);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.player);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.po);
        profileImagesListArrayList.add(profileImagesList);

        return profileImagesListArrayList;
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.radioMan:

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {

            case R.id.radioMan:
                Toast.makeText(this, "Man", Toast.LENGTH_SHORT).show();
                profileImagesRecyclerView.setAdapter(new ProfileImagesAdapters(getMensList(), this, this));
                break;

            case R.id.radioWoman:
                Toast.makeText(this, "Woman", Toast.LENGTH_SHORT).show();
                profileImagesRecyclerView.setAdapter(new ProfileImagesAdapters(getWomansList(), this, this));
                break;

            case R.id.radioSymbol:
                Toast.makeText(this, "Symbol", Toast.LENGTH_SHORT).show();
                profileImagesRecyclerView.setAdapter(new ProfileImagesAdapters(getSymbolList(), this, this));
                break;

            case R.id.radioGeneral:
                Toast.makeText(this, "General", Toast.LENGTH_SHORT).show();
                profileImagesRecyclerView.setAdapter(new ProfileImagesAdapters(getMensList(), this, this));
                break;

        }

    }

    private ArrayList<ProfileImagesList> getSymbolList() {

        ArrayList<ProfileImagesList> profileImagesListArrayList = new ArrayList<>();

        ProfileImagesList profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.aids);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.ancient);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.checked);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.crown);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.electric);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.eyes);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.face_mask);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.flag);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.flower);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.hydrangea);
        profileImagesListArrayList.add(profileImagesList);

        //////////////////////
        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.internet);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.invention);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.laptop);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.lightnings);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.mailing);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.maps_flags);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.money_bag);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.phone);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.settings);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.silver_medal);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.sound);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.sta);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.sun);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.translation);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.star);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.sunny);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.visibility);
        profileImagesListArrayList.add(profileImagesList);

        return profileImagesListArrayList;

    }

    private ArrayList<ProfileImagesList> getWomansList() {

        ArrayList<ProfileImagesList> profileImagesListArrayList = new ArrayList<>();

        ProfileImagesList profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.mipmap.ic_woman);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.mipmap.woman);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.woma);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.employee);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.call_center);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.farmer);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.girl);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.woman);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.brid);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.bride);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.educator);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.farmer);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.nurse);
        profileImagesListArrayList.add(profileImagesList);

        return profileImagesListArrayList;

    }

    private ArrayList<ProfileImagesList> getMensList() {

        ArrayList<ProfileImagesList> profileImagesListArrayList = new ArrayList<>();

        ProfileImagesList profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.boss);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.customer);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.diver);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.doctor);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.educator);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.em);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.emp);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.employee);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.engineer);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.far);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.employee);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.farmer);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.m);
        profileImagesListArrayList.add(profileImagesList);


        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.ma);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.man);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.n);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.nv);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.player);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.po);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.policeman);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.professor);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.programmer);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.showman);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.welder);
        profileImagesListArrayList.add(profileImagesList);

        profileImagesList = new ProfileImagesList();
        profileImagesList.setProfileImage(R.drawable.worker);
        profileImagesListArrayList.add(profileImagesList);

        return profileImagesListArrayList;

    }

    @Override
    public void onClick(Drawable drawable) {
        imgProfile.setImageDrawable(drawable);
    }
}
