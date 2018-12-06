package com.kinfo.thuttu.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kinfo.thuttu.R;

public class AboutUsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtWebsite, txtEmail, txtFacebook, txtTwitter;
    private LinearLayout linearShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtWebsite = findViewById(R.id.txtWebsite);
        txtEmail = findViewById(R.id.txtEmail);
        txtFacebook = findViewById(R.id.txtFacebook);
        txtTwitter = findViewById(R.id.txtTwitter);

        linearShare = findViewById(R.id.linearShare);

        txtWebsite.setOnClickListener(this);
        txtEmail.setOnClickListener(this);
        txtFacebook.setOnClickListener(this);
        txtTwitter.setOnClickListener(this);
        linearShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtWebsite:
                Uri uri = Uri.parse("https://thuttu.com/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.txtEmail:
                Intent intent1 = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "service@thuttu.com", null));
                startActivity(Intent.createChooser(intent1, "Choose an Email client :"));
                break;
            case R.id.txtFacebook:
                Uri uri1 = Uri.parse("https://www.facebook.com/"); // missing 'http://' will cause crashed
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri1);
                startActivity(intent2);
                break;
            case R.id.txtTwitter:
                Uri uri3 = Uri.parse("https://twitter.com/login"); // missing 'http://' will cause crashed
                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
                startActivity(intent3);
                break;
            case R.id.linearShare:
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
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


}
