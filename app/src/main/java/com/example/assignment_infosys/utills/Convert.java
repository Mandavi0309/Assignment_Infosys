package com.example.assignment_infosys.utills;

import com.example.assignment_infosys.model.UserModel;
import com.google.gson.Gson;

public class Convert {


    public static UserModel dataListResponseConvert(String json) {

        Gson gsonObj = new Gson();
        return gsonObj.fromJson(json, UserModel.class);
    }
}
