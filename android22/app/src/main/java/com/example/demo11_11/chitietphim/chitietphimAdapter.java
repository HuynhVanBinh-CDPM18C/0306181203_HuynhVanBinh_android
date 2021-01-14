package com.example.demo11_11.chitietphim;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo11_11.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class chitietphimAdapter extends RecyclerView.Adapter<chitietphimAdapter.UserItemViewHolder>  {
    private List<chitietphim> users;
    private Context context;


    public chitietphimAdapter(List<chitietphim> users, Context c) {
        this.users = users;
        this.context = c;
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_chitietphim, parent, false);

        return new UserItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserItemViewHolder holder, int position) {
        chitietphim u = users.get(position);
        Picasso.with(context)
                .load(u.hinhanh)
                .into(holder.hinhanh);
        Picasso.with(context)
                .load(u.anhbia)
                .into(holder.anhbia);
        holder.tenphim.setText(u.tenphim);
        holder.dotuoi.setText(u.dotuoi);
        holder.sodiem.setText(u.sodiem);
        holder.noidung.setText(u.noidung);
        holder.thoiluong.setText(u.thoiluong);
    }

    public static class UserItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView hinhanh;
        public TextView tenphim;
        public TextView dotuoi;
        public TextView sodiem;
        public ImageView anhbia;
        public TextView noidung;
        public TextView thoiluong;


        public UserItemViewHolder(View itemView) {
            super(itemView);
            hinhanh = (ImageView) itemView.findViewById(R.id.ibHinh);
            tenphim = (TextView) itemView.findViewById(R.id.txtTenPhim);
            dotuoi  = (TextView) itemView.findViewById(R.id.txtDoTuoi);
            sodiem  = (TextView) itemView.findViewById(R.id.txtDiem);
            anhbia=(ImageView)itemView.findViewById(R.id.ivAnhBia);
            noidung  = (TextView) itemView.findViewById(R.id.txtNoiDung);
            thoiluong=(TextView) itemView.findViewById(R.id.txtThoiLuong);
        }
    }
}
