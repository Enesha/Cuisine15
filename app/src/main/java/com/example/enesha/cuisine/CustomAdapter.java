package com.example.enesha.cuisine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyHolder> {
    private Context context;
    private ArrayList <Model> models;

    public CustomAdapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }
    //hello

    @Override
    public MyHolder onCreateViewHolder( ViewGroup parent,
                                        int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder( final MyHolder holder, final int position) {
        final Model model=models.get(position);
        holder.imageView.setImageResource(models.get(position).getImage());
        holder.textViewName.setText(models.get(position).getTextName());
        holder.textViewDesc.setText(models.get(position).getTextDesc());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    public static class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName ;
        TextView textViewDesc;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewShortDesc);

        }
    }
}
