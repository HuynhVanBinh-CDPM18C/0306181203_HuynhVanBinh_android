package com.example.demo11_11;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BinhLuanAdapter extends RecyclerView.Adapter<BinhLuanAdapter.ViewHolder> {

    ArrayList<ListBinhLuan> dsBinhLuan;
    Context context;

    BinhLuanAdapter(Context context, ArrayList<ListBinhLuan> ds){
        this.context = context;
        this.dsBinhLuan = ds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_binhluan, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ListBinhLuan listBinhLuan = dsBinhLuan.get(i);
        viewHolder.nd.setText(listBinhLuan.getNoi_dung_binhluan());
        viewHolder.dg.setText(listBinhLuan.getDanh_gia_phim());
    }

    @Override
    public int getItemCount() {
        return dsBinhLuan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nd, dg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nd = itemView.findViewById(R.id.tv_formBinhLuan_ND);
            dg = itemView.findViewById(R.id.tv_formBinhLuan_DiemSo);
        }
    }
}
