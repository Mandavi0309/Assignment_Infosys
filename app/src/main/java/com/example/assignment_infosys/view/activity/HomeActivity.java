package com.example.assignment_infosys.view.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.assignment_infosys.R;
import com.example.assignment_infosys.interfaces.WebServiceCallBack;
import com.example.assignment_infosys.interfaces.WebServiceRequest;
import com.example.assignment_infosys.model.UserModel;
import com.example.assignment_infosys.networkcommunication.APIManager;
import com.example.assignment_infosys.receivers.NetworkChangeReceiver;
import com.example.assignment_infosys.utills.DialogUtills;
import com.example.assignment_infosys.utills.ExceptionType;
import com.example.assignment_infosys.utills.Generic;
import com.example.assignment_infosys.view.adapter.HomeActivityAdapter;


import java.util.ArrayList;

import okhttp3.Headers;

import static com.example.assignment_infosys.utills.Constants.GET;
import static com.example.assignment_infosys.utills.Convert.dataListResponseConvert;
import static com.example.assignment_infosys.utills.DialogUtills.showToast;
import static com.example.assignment_infosys.utills.DialogUtills.stopProgressDialog;

public class HomeActivity extends AppCompatActivity implements WebServiceCallBack {



    private HomeActivityAdapter homeActivityAdapter;
    private RecyclerView recyclerView;
    private ArrayList<UserModel.ListData> dataModelsList;
    private static final String TAG = HomeActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.news_list);

        registerNetworkBroadcast();
        if (Generic.isNetworkAvailable(this)) {

            getListData();
        }
        else {
            showToast(this, getResources().getString(R.string.internet_connection));
        }

    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (Generic.isNetworkAvailable(context)) {

                showToast(context, context.getResources().getString(R.string.internet_connectioned));
                getListData();
            }
            else {
                showToast(context, context.getResources().getString(R.string.internet_connection));
            }
        }
    };
    private void registerNetworkBroadcast() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        }

    }

    protected void unregisterNetworkChanges() {
        try {
            unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterNetworkChanges();
    }



    private void setRecyclerDataToAdapter() {
        homeActivityAdapter = new HomeActivityAdapter(dataModelsList, this);
       recyclerView.setAdapter(homeActivityAdapter);
    }

    public  void getListData(){
        DialogUtills.startProgressDialog(this, getResources().getString(R.string.please_wait));
        APIManager.getInstance().getListData(HomeActivity.this, this,
                GET, null);
    }

    @Override
    public void onResponse(WebServiceRequest requestType, String response, ExceptionType responseStatus, Headers headers) {
        stopProgressDialog();
        switch (requestType) {
            case LISTDATA:
                if (response != null ) {
                    try {

                        dataModelsList = new ArrayList<>();
                        UserModel dataListModel = dataListResponseConvert(response);
                        if (dataListModel != null) {
                            dataModelsList.addAll(dataListModel.getListData());
                            if (dataModelsList.size() > 0) {
                                setRecyclerDataToAdapter();
                            }

                        } else {
                            showToast(this, getString(R.string.error));
                        }


                   }
                catch (Exception e) {
                        e.printStackTrace();
                        showToast(this, getResources().getString(R.string.error));
                    }
                    break;
                }
        }
    }
}
