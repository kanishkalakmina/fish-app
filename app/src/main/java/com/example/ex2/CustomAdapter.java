package com.example.ex2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    ListActivity listActivity;
    List<Model>modelList;
    Context context;

    public CustomAdapter(ListActivity listActivity, List<Model> modelList) {
        this.listActivity = listActivity;
        this.modelList = modelList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_layout,parent,false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        //handle click item here
       viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
           @Override
           public void onItemClick(View view, int position) {
               //this will be called when user click item

               //show data toaste on clicking
               String title = modelList.get(position).getTitle();
               String descr = modelList.get(position).getDescription();
               Toast.makeText(listActivity,title+"\n"+descr,Toast.LENGTH_SHORT).show();

           }

           @Override
           public void onItemLongClick(View view, int position) {
               //this will be called when user long click item

           }
       });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            //bind views / set data
        holder.mTitleTv.setText(modelList.get(position).getTitle());
        holder.mDescriptionTv.setText(modelList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
