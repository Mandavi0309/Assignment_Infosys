package com.example.assignment_infosys.view.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.assignment_infosys.R;
import com.example.assignment_infosys.model.UserModel;


import java.util.ArrayList;


public class HomeActivityAdapter extends RecyclerView.Adapter<HomeActivityAdapter.ViewHolder>{

    private ArrayList<UserModel.ListData> userModelList;
    private Context context;


    public HomeActivityAdapter(ArrayList<UserModel.ListData> userModelList,Context context) {
        this.userModelList = userModelList;
        this.context=context;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.data_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

       holder.tvDesc.setText(userModelList.get(position).getDescription());

       holder.tvTitle.setText(userModelList.get(position).getTitle());


       if(userModelList.get(position).getImage()!=null){

           Glide.with(context)
                   .load(userModelList.get(position).getImage()).error(R.mipmap.imageplaceholder).placeholder(R.mipmap.imageplaceholder)
                   .into(holder.ivNewsImage);

        }
        else{
           Glide.with(context)
                   .load(R.mipmap.imageplaceholder)
                   .into(holder.ivNewsImage);
        }





    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }





    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView tvTitle, tvDesc;
        final ImageView ivNewsImage;
        final View mView;
        final LinearLayout mainLayout;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvTitle = view.findViewById(R.id.tv_title);
            tvDesc = view.findViewById(R.id.tv_description);
            ivNewsImage = view.findViewById(R.id.image);
            mainLayout = view.findViewById(R.id.main_rl);

        }
    }


}
