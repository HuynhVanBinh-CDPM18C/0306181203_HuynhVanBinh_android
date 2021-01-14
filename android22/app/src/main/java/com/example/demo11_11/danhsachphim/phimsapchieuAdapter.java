package com.example.demo11_11.danhsachphim;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.demo11_11.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class phimsapchieuAdapter extends RecyclerView.Adapter< phimsapchieuAdapter.UserItemViewHolder> {
    private List<phimsapchieu> users;
    private Context context;

    public  phimsapchieuAdapter(List<phimsapchieu> users, Context c) {
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
                .inflate(R.layout.danhsachphim_item, parent, false);

        return new UserItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserItemViewHolder holder, int position) {
        phimsapchieu u = users.get(position);
        Picasso.with(context)
                .load(u.hinhanh)
                .into(holder.hinhanh);
        holder.tenphim.setText(u.tenphim);
        holder.theloai.setText(u.theloai);
        holder.dotuoi.setText(u.dotuoi);
        holder.sodiem.setText(u.sodiem);
    }

    public static class UserItemViewHolder extends RecyclerView.ViewHolder {
        public ImageButton hinhanh;
        public TextView tenphim;
        public TextView theloai;
        public TextView dotuoi;
        public TextView sodiem;


        public UserItemViewHolder(View itemView) {
            super(itemView);
            hinhanh = (ImageButton) itemView.findViewById(R.id.ibHinhAnh);
            tenphim = (TextView) itemView.findViewById(R.id.tvTenPhim);
            theloai = (TextView) itemView.findViewById(R.id.tvTheLoai);
            dotuoi  = (TextView) itemView.findViewById(R.id.tvDoTuoi);
            sodiem  = (TextView) itemView.findViewById(R.id.tvSoDiem);
        }
    }
}
