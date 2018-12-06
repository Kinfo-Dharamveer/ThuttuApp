package com.kinfo.thuttu;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;


import com.kinfo.thuttu.di.modules.SharedPrefHelper;
import com.kinfo.thuttu.network.GitApiInterface;

import javax.inject.Inject;

import butterknife.Unbinder;

public class BaseFragment extends Fragment {

    @Inject
    public GitApiInterface apiInterface;

    protected ProgressDialog pDialog;

    protected AlertDialog alertDialog;

    @Inject
    public SharedPrefHelper sharedPrefHelper;

    protected Unbinder unbinder;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppController) getActivity().getApplication()).getComponent().inject(this);
    }


    public void alertLoading() {

        pDialog =new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(true);


        android.app.AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder =new android.app.AlertDialog.Builder(getActivity());

        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setPositiveButton(
                "Ok",
                (dialog,id)->dialog.cancel());
        alertDialog =alertDialogBuilder.create();

    }

    public void showAlertDialog(String action,String message){

        android.app.AlertDialog.Builder builder1 = new android.app.AlertDialog.Builder(getActivity());
        builder1.setMessage(message);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                action,


                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                    }
                });


        android.app.AlertDialog alert11 = builder1.create();
        alert11.show();


    }

}
