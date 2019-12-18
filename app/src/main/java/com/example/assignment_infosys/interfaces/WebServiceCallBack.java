package com.example.assignment_infosys.interfaces;

import com.example.assignment_infosys.utills.ExceptionType;

import okhttp3.Headers;

public interface WebServiceCallBack {

    void onResponse(WebServiceRequest requestType, String response, ExceptionType responseStatus,
                    Headers headers);
}
