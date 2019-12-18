package com.example.assignment_infosys.model;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;

public class UserModel  {

    @SerializedName("title")
    String title;


    @SerializedName("rows")
    ArrayList <ListData> listData;



    public class ListData{


        @SerializedName("title")
        String title;

        @SerializedName("description")
        String description;

        @SerializedName("imageHref")
        String image;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ListData> getListData() {
        return listData;
    }

    public void setListData(ArrayList<ListData> listData) {
        this.listData = listData;
    }
}
