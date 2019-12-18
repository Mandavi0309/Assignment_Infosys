package com.example.assignment_infosys.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.assignment_infosys.R;
import com.example.assignment_infosys.networkcommunication.APIManager;
import com.example.assignment_infosys.utills.DialogUtills;
import com.example.assignment_infosys.utills.Generic;
import com.example.assignment_infosys.view.activity.HomeActivity;

import static com.example.assignment_infosys.utills.Constants.GET;
import static com.example.assignment_infosys.utills.DialogUtills.showToast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (Generic.isNetworkAvailable(context)) {

            showToast(context, context.getResources().getString(R.string.internet_connectioned));

        }

    }


}
