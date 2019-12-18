package com.example.assignment_infosys.networkcommunication;

import android.content.Context;

import com.example.assignment_infosys.interfaces.WebServiceCallBack;
import com.example.assignment_infosys.interfaces.WebServiceRequest;

import org.json.JSONObject;

public class APIManager {


    private static APIManager apiManager;

    private APIManager() {

    }

    public static APIManager getInstance() {
        if (apiManager == null) {
            apiManager = new APIManager();
        }
        return apiManager;
    }

    public void getListData(Context context, WebServiceCallBack webServiceCallBack,
                            String requestType, JSONObject request) {
        new OkHttpWebCallAsyncTask(context, webServiceCallBack, WebServiceConstants.LIST_URL,
                WebServiceRequest.LISTDATA, requestType, request).execute();

    }
}
