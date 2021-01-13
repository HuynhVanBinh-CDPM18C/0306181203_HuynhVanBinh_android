package com.example.demo11_11;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class RecyclerImageMovie extends RecyclerView.Adapter<RecyclerImageMovie.ViewHolder>{
    private ArrayList<ImageMovie> dsAnh;
    private LayoutInflater mInflater;
    RecyclerImageMovie(Context context, ArrayList<ImageMovie> ds){
        this.dsAnh = ds;
        this.mInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = mInflater.inflate(R.layout.image_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ImageMovie image = dsAnh.get(i);
        viewHolder.anh.setImageResource(image.getImage());
    }

    @Override
    public int getItemCount() {
        return dsAnh.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView anh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            anh = itemView.findViewById(R.id.imageView);
        }
    }
}
