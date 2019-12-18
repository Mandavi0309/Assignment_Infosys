package com.example.assignment_infosys.interfaces;

public enum WebServiceRequest {


    LISTDATA(1);

    private int requestID;
    WebServiceRequest(int requestID ) {
        this.requestID = requestID;
    }

    public int getRequestID() {
        return requestID;
    }
}
